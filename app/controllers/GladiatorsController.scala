package controllers

import scala.util.Failure
import scala.util.Success
import scala.util.Try

import de.htwg.se.gladiators.aview.Tui
import de.htwg.se.gladiators.controller.BaseImplementation.Controller
import de.htwg.se.gladiators.controller.BaseImplementation.ControllerJson._
import de.htwg.se.gladiators.util.Configuration
import de.htwg.se.gladiators.util.Coordinate
import de.htwg.se.gladiators.util.Events
import de.htwg.se.gladiators.util.Events.ErrorMessage
import de.htwg.se.gladiators.util.json.CommandJson._
import de.htwg.se.gladiators.util.json.CoordinateJson._
import de.htwg.se.gladiators.util.json.EventsJson._

import akka.http.scaladsl.model.HttpHeader
import akka.http.scaladsl.model.HttpResponse
import akka.http.scaladsl.model.ResponseEntity
import akka.http.scaladsl.model.StatusCode
import akka.http.scaladsl.model.headers.RawHeader
import com.softwaremill.macwire._
import javax.inject._
import play.api._
import play.api.libs.json._

import play.api.mvc._

import play.api.libs.streams.ActorFlow
import akka.actor.ActorSystem
import akka.stream.Materializer
import akka.actor._
import scala.swing.Reactor
import play.api.mvc.WebSocket.MessageFlowTransformer

/**
 * This controller creates an `Action` to handle HTTP requests to the
 * application's home page.
 */
@Singleton
class GladiatorsController @Inject() (cc: ControllerComponents) (implicit system: ActorSystem, mat: Materializer) extends AbstractController(cc) {
    // Calling Gladiators.controller does not work because Gladiators extends
    // App don't ask me why ¯\_(ツ)_/¯
    val configuration = Configuration(5, 15)
    val controller = Controller(configuration)
    val tui = wire[Tui]
    // FIXME: We need to initialize players to call boardToString
    controller.namePlayerOne("one")
    controller.namePlayerTwo("two")

    val couldNotParseJsonError: Events = Events.ErrorMessage("Body does not contain valid json")
    val jsonNotACommandError: Events = Events.ErrorMessage("Command could not be parsed")

    def about = Action {
        Ok(views.html.about())
    }

    def gladiators = Action {
        Ok(views.html.gladiators(controller))
    }

    def controllerToJson = Action {
        Ok(Json.toJson(controller, None))
    }

    def processJsonCommand = Action(parse.json) { request: Request[JsValue] => {
            readCommand(request.body) match {
                case Failure(exception) => BadRequest(Json.toJson(jsonNotACommandError))
                case Success(command) => controller.inputCommand(command) match {
                    case ErrorMessage(message) => {
                        val event: Events = ErrorMessage(message)
                        BadRequest(Json.toJson(event))
                    }
                    case event: Events => Ok(Json.toJson(controller, event))
                }
            }
        }
    }

    def gladiatorSelect = Action(parse.json) { position: Request[JsValue] =>
        Try(Coordinate((position.body \ "x").as[Int], (position.body \ "y").as[Int])) match {
            case Success(coordinate) => {
                val gladiatorInfo = Json.obj(
                    "gladiatorAtCoordinate" -> controller.tileOccupiedByCurrentPlayer(coordinate),
                    "tilesAttack" -> controller.attackTiles(coordinate),
                    "tilesMove" -> controller.moveTiles(coordinate)
                )
                Ok(Json.toJson(controller, gladiatorInfo))
            }
            case Failure(_) => {
                val event: Events = jsonNotACommandError
                BadRequest(Json.toJson(event))
            }
        }
    }

  /*  implicit val inEventFormat  = Json.format[InEvent]
    implicit val outEventFormat = Json.format[OutEvent]
    implicit val messageFlowTransformer = MessageFlowTransformer.jsonMessageFlowTransformer[InEvent, OutEvent]
*/
    def socket = WebSocket.accept[JsValue, JsValue] { request =>
        ActorFlow.actorRef { out =>
            println("Connect received")
            GladiatorsWebSocketActorFactory.create(out)
        }
    }

    object GladiatorsWebSocketActorFactory {
        def create(out: ActorRef) = {
            Props(new GladiatorWebSocketActor(out))
        }
    }

    class GladiatorWebSocketActor(out: ActorRef) extends Actor with Reactor{

        def receive = {
            case msg: JsValue =>
                val json: JsValue = Json.toJson(controller)
                out ! (json)
                println("Received message "+ msg)
        }

        // TODO:
    
        // BACKEND:
        // receive json commands, extract them
        // check if controller can handle them
        // send back event and controller json to every open socket

        // FRONTEND
        // send commands to websocket instead of http paths
        // receive websocket messages, read them and act them out
        // block websocket calls for player who is not currentPlayer
        // create a timeout for a turn like 100s (add countdown like a bar), after timeout change currentPlayer
        
    }
}
