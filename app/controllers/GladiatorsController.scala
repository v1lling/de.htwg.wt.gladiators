package controllers

import javax.inject._
import play.api._
import play.api.mvc._
import de.htwg.se.gladiators.util.Configuration
import de.htwg.se.gladiators.controller.BaseImplementation.Controller
import de.htwg.se.gladiators.aview.Tui
import com.softwaremill.macwire._


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

    def index() = Action { implicit request: Request[AnyContent] =>
        Ok(views.html.index())
    }

    def gladiators = Action {
        Ok(printGame)
    }

    def processCommand(cmd: String) = Action {
        tui.processInputLine(cmd)
        Ok(printGame)
    }

    def printGame: String = {
        val board = controller.boardToString
        val shop = controller.shopToString
        val currentPlayer = controller.currentPlayer
        val currentPlayerOutput = "Player: " + currentPlayer.get.name + "\nCredits: " + currentPlayer.get.credits
        currentPlayerOutput + "\n\n" + board +"\n\n" + shop
    }
}
