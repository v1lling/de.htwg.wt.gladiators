package controllers.WebSockets

import scala.util.Failure
import scala.util.Success

import de.htwg.se.gladiators.controller.BaseImplementation.Controller
import de.htwg.se.gladiators.controller.BaseImplementation.ControllerJson._
import de.htwg.se.gladiators.model.Player
import de.htwg.se.gladiators.util.Command
import de.htwg.se.gladiators.util.Command._
import de.htwg.se.gladiators.util.Events
import de.htwg.se.gladiators.util.Events._
import de.htwg.se.gladiators.util.json.CommandJson._
import de.htwg.se.gladiators.util.json.CommandJson._
import de.htwg.se.gladiators.util.json.CoordinateJson._
import de.htwg.se.gladiators.util.json.EventsJson._

import akka.actor.Actor
import akka.actor.ActorRef
import java.util.concurrent.atomic.AtomicReference
import play.api.libs.json._
import play.api.mvc.Results.BadRequest
case class GladiatorWebSocketActor(out: ActorRef, controller: Controller) extends WebSocketsTrait {
    listenTo(controller)
    reactions += { case event: Events => sendJson(controller, event) }

    var player: Option[Player] = None

    override def receive: Actor.Receive = {
        case msg: JsValue => {
            out ! (readCommand(msg) match {
                case Failure(exception) => BadRequest(Json.toJson(ErrorMessage("Could not parse command"): Events))
                case Success(parsedCommand) => (parsedCommand, player) match {
                    case (NamePlayerOne(name), None) => controller.namePlayerOne(name) match {
                        case named: PlayerOneNamed => {
                            player = controller.playerOne
                            Json.toJson(named: Events)
                        }
                        case message: ErrorMessage => BadRequest(Json.toJson(message: Events))
                        case _ => BadRequest(Json.toJson(ErrorMessage("Internal Server Error"): Events))
                    }
                    case (NamePlayerTwo(name), None) => controller.namePlayerTwo(name) match {
                        case named: PlayerTwoNamed => {
                            player = controller.playerTwo
                            Json.toJson(named: Events)
                        }
                        case message: ErrorMessage => BadRequest(Json.toJson(message: Events))
                        case _ => BadRequest(Json.toJson(ErrorMessage("Internal Server Error"): Events))
                    }

                    case (move: Move, player: Option[Player]) if controller.currentPlayer == player => Json.toJson(controller.inputCommand(move))
                    case (Move(_, _), None) => BadRequest(Json.toJson(ErrorMessage("It is not your turn"): Events))

                    case (buyUnit: BuyUnit, player: Option[Player]) if controller.currentPlayer == player => Json.toJson(controller.inputCommand(buyUnit))
                    case (BuyUnit(_, _), None) => BadRequest(Json.toJson(ErrorMessage("It is not your turn"): Events))

                    case (command: Command, _) => Json.toJson(controller.inputCommand(command))
                }
            })
        }
    }
    override def sendJson(controller: Controller, event: Events): Unit = out ! (Json.toJson(controller, event))
}
