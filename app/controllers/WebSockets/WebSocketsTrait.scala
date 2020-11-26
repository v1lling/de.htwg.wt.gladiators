package controllers.WebSockets

import scala.swing.Reactor

import de.htwg.se.gladiators.controller.BaseImplementation.Controller
import de.htwg.se.gladiators.util.Events

import akka.actor.Actor

trait WebSocketsTrait extends Actor with Reactor {
    def sendJson(controller: Controller, event: Events): Unit
}
