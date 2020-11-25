package controllers.WebSockets

import de.htwg.se.gladiators.controller.BaseImplementation.Controller
import de.htwg.se.gladiators.controller.BaseImplementation.ControllerJson._
import de.htwg.se.gladiators.util.Events
import de.htwg.se.gladiators.util.json.CommandJson._
import de.htwg.se.gladiators.util.json.CoordinateJson._
import de.htwg.se.gladiators.util.json.EventsJson._
import de.htwg.se.gladiators.util.json.CommandJson._

import akka.actor.Actor
import akka.actor.ActorRef
import play.api.libs.json._
import scala.util.Failure
import de.htwg.se.gladiators.util.Events
import de.htwg.se.gladiators.util.Events._
import scala.util.Success
import de.htwg.se.gladiators.util.Command._
import de.htwg.se.gladiators.util.Command
import de.htwg.se.gladiators.model.Player
import java.util.concurrent.atomic.AtomicReference

case class GladiatorWebSocketActor(out: ActorRef, controller: Controller) extends WebSocketsTrait {
    listenTo(controller)
    reactions += { case event: Events => sendJson(controller, event) }

    var player: Option[Player] = None

    override def receive: Actor.Receive = {
        case msg: JsValue => {
            out ! (readCommand(msg) match {
                case Failure(exception) => Json.toJson(ErrorMessage("Could not parse command"): Events)
                case Success(parsedCommand) => (parsedCommand, player) match {
                    case (NamePlayerOne(name), None) => controller.namePlayerOne(name) match {
                        case named: PlayerOneNamed => {
                            player = controller.playerOne
                            Json.toJson(named: Events)
                        }
                        case message: ErrorMessage => Json.toJson(message: Events)
                        case _ => Json.toJson(ErrorMessage("Internal Server Error"): Events)
                    }
                    case (NamePlayerTwo(name), None) => controller.namePlayerTwo(name) match {
                        case named: PlayerTwoNamed => {
                            player = controller.playerTwo
                            Json.toJson(named: Events)
                        }
                        case message: ErrorMessage => Json.toJson(message: Events)
                        case _ => Json.toJson(ErrorMessage("Internal Server Error"): Events)
                    }

                    case (move: Move, player: Option[Player]) if controller.currentPlayer == player => Json.toJson(controller.inputCommand(move))
                    case (Move(_, _), None) => Json.toJson(ErrorMessage("It is not your turn"): Events)

                    case (buyUnit: BuyUnit, player: Option[Player]) if controller.currentPlayer == player => Json.toJson(controller.inputCommand(buyUnit))
                    case (BuyUnit(_, _), None) => Json.toJson(ErrorMessage("It is not your turn"): Events)

                    case (command: Command, _) => Json.toJson(controller.inputCommand(command))
                }
            })
        }
    }
    override def sendJson(controller: Controller, event: Events): Unit = out ! (Json.toJson(controller, event))
}
