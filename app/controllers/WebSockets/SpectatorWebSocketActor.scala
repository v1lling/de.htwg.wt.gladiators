package controllers.WebSockets

import de.htwg.se.gladiators.controller.BaseImplementation.Controller
import de.htwg.se.gladiators.controller.BaseImplementation.ControllerJson._
import de.htwg.se.gladiators.util.Events
import de.htwg.se.gladiators.util.Events.ErrorMessage
import de.htwg.se.gladiators.util.json.EventsJson._

import akka.actor.Actor
import play.api.libs.json.Json
import akka.actor.ActorRef

case class SpectatorWebSocketActor(out: ActorRef, controller: Controller) extends WebSocketsTrait {
    listenTo(controller)
    reactions += { case event: Events => sendJson(controller, event) }

    override def receive: Actor.Receive = { case _ => Json.toJson(ErrorMessage("Spectators cannot enter commands"): Events)}
    override def sendJson(controller: Controller, event: Events): Unit = Json.toJson(controller, event)
}
