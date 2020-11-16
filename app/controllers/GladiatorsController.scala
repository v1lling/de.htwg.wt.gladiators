package controllers

import scala.util.Failure
import scala.util.Success
import scala.util.Try

import de.htwg.se.gladiators.aview.Tui
import de.htwg.se.gladiators.controller.BaseImplementation.Controller
import de.htwg.se.gladiators.controller.BaseImplementation.ControllerJson._
import de.htwg.se.gladiators.util.Configuration
import de.htwg.se.gladiators.util.Events
import de.htwg.se.gladiators.util.Events.ErrorMessage
import de.htwg.se.gladiators.util.json.CommandJson._
import de.htwg.se.gladiators.util.json.EventsJson._

import akka.http.scaladsl.model.HttpHeader
import akka.http.scaladsl.model.HttpResponse
import akka.http.scaladsl.model.ResponseEntity
import akka.http.scaladsl.model.StatusCode
import akka.http.scaladsl.model.headers.RawHeader
import com.softwaremill.macwire._
import javax.inject._
import play.api._
import play.api.libs.json.JsValue
import play.api.libs.json.Json
import play.api.mvc._

/**
 * This controller creates an `Action` to handle HTTP requests to the
 * application's home page.
 */
@Singleton
class GladiatorsController @Inject()(val controllerComponents: ControllerComponents) extends BaseController {
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

    def processCommand(cmd: String) = Action {
        var errormessage = tui.processInputLine(cmd)
        // FIXME: check if processInputLine was successfull in SE repository
        if (errormessage) {
            Ok(Json.toJson(controller))
        } else {
            BadRequest(errormessage.toString);
        }
    }

    def controllerToJson = Action {
        Ok(Json.toJson(controller))
    }

    def processJsonCommand = Action(parse.json) { request: Request[JsValue] => {
            readCommand(request.body) match {
                case Failure(exception) => BadRequest(Json.toJson(jsonNotACommandError))
                case Success(command) => controller.inputCommand(command) match {
                    case ErrorMessage(message) => {
                        val event: Events = ErrorMessage(message)
                        BadRequest(Json.toJson(event))
                    }
                    //case event: Events => Ok(Json.toJson(event))
                    case event: Events => Ok(Json.toJson(controller))
                }
            }
        }
    }
}
