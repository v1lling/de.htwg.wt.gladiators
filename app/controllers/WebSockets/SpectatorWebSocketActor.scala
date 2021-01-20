package controllers.WebSockets

import de.htwg.se.gladiators.controller.BaseImplementation.Controller
import de.htwg.se.gladiators.controller.BaseImplementation.ControllerJson._
import de.htwg.se.gladiators.util.Events
import de.htwg.se.gladiators.util.Events.ErrorMessage
import de.htwg.se.gladiators.util.json.EventsJson._

import akka.actor.Actor
import akka.actor.ActorRef
import play.api.libs.json.Json

case class SpectatorWebSocketActor(out: ActorRef, controller: Controller) extends WebSocketsTrait {
  listenTo(controller)
  reactions += { case event: Events => sendJson(controller, event) }

  //override def receive: Actor.Receive = { case _ => out ! Json.toJson(controller, ErrorMessage("Spectators cannot enter commands"): Events) }
  //Workaround for Idle Timeout -> We get Pings from FE, so don't send back error
  override def receive: Actor.Receive = { case _ => out ! Json.toJson(controller, None) }
  override def sendJson(controller: Controller, event: Events): Unit = out ! Json.toJson(controller, event)
}
