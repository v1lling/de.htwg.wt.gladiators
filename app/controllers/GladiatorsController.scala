package controllers

import javax.inject._
import play.api._
import play.api.mvc._
import de.htwg.se.gladiators.util.Configuration
import de.htwg.se.gladiators.controller.BaseImplementation.Controller
import de.htwg.se.gladiators.controller.BaseImplementation.ControllerJson._
import de.htwg.se.gladiators.aview.Tui
import com.softwaremill.macwire._
import play.api.libs.json.Json

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

    def about = Action {
        Ok(views.html.about())
    }

    def gladiators = Action {
        Ok(views.html.gladiators(controller))
    }

    def processCommand(cmd: String) = Action {
        tui.processInputLine(cmd)
        // FIXME: check if processInputLine was successfull:
        // success: give back Ok
        // error: give back 400code with error output
        Ok(Json.toJson(controller))
    }

    def controllerToJson = Action {
        Ok(Json.toJson(controller))
    }
}
