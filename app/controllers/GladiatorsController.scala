package controllers

import scala.collection.mutable.HashSet
import scala.collection.mutable.ListBuffer
import scala.swing.Reactor
import scala.util.Failure
import scala.util.Success
import scala.util.Try

import de.htwg.se.gladiators.aview.Tui
import de.htwg.se.gladiators.controller.BaseImplementation.Controller
import de.htwg.se.gladiators.controller.BaseImplementation.ControllerJson._
import de.htwg.se.gladiators.controller.GameState.NamingPlayerOne
import de.htwg.se.gladiators.controller.GameState.NamingPlayerTwo
import de.htwg.se.gladiators.controller.GameState.TurnPlayerOne
import de.htwg.se.gladiators.controller.GameState.TurnPlayerTwo
import de.htwg.se.gladiators.util.Configuration
import de.htwg.se.gladiators.util.Coordinate
import de.htwg.se.gladiators.util.Events
import de.htwg.se.gladiators.util.Events._
import de.htwg.se.gladiators.util.json.CommandJson._
import de.htwg.se.gladiators.util.json.CoordinateJson._
import de.htwg.se.gladiators.util.json.EventsJson._

import _root_.controllers.WebSockets.GladiatorWebSocketActor
import _root_.controllers.WebSockets.SpectatorWebSocketActor
import akka.actor.ActorSystem
import akka.actor._
import akka.http.scaladsl.model.HttpHeader
import akka.http.scaladsl.model.HttpResponse
import akka.http.scaladsl.model.ResponseEntity
import akka.http.scaladsl.model.StatusCode
import akka.http.scaladsl.model.headers.RawHeader
import akka.stream.Materializer
import javax.inject._
import play.api._
import play.api.libs.json._
import play.api.libs.streams.ActorFlow
import play.api.mvc.WebSocket.MessageFlowTransformer
import play.api.mvc._
import scala.concurrent.{ ExecutionContext, Future }

@Singleton
class GladiatorsController @Inject() (cc: ControllerComponents) (implicit ec: ExecutionContext, system: ActorSystem, mat: Materializer) extends AbstractController(cc) {
    val configuration = Configuration(5, 15)
    val controller = Controller(configuration)

    val jsonNotACommandError: Events = Events.ErrorMessage("Command could not be parsed")

    def app = Action.async {
        Future(Ok(views.html.app("Welcome")))
    }

    def about = Action {
        Ok(views.html.old.about())
    }

    def gladiators = Action {
        Ok(views.html.old.gladiators(controller))
    }

    def controllerToJson = Action {
        Ok(Json.toJson(controller, None))
    }

    def processJsonCommand = Action(parse.json) { request: Request[JsValue] => {
            readCommand(request.body) match {
                case Failure(exception) => BadRequest(Json.toJson(jsonNotACommandError))
                case Success(command) => controller.inputCommand(command) match {
                    case message: ErrorMessage => BadRequest(Json.toJson(message: Events))
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
            case Failure(_) => BadRequest(Json.toJson(jsonNotACommandError))
        }
    }

    def socket = WebSocket.accept[JsValue, JsValue] { request =>
        ActorFlow.actorRef { out =>
            controller.gameState match {
                case NamingPlayerOne | NamingPlayerTwo => {
                    println("connecting player")
                    Props(GladiatorWebSocketActor(out, controller))
                }
                case _ => {
                    println("connecting spectator")
                    Props(SpectatorWebSocketActor(out, controller))
                }
            }
        }
    }
}
