package controllers

import javax.inject._
import play.api._
import play.api.mvc._
import de.htwg.se.gladiators.Gladiators
import de.htwg.se.gladiators.controller.ControllerInterface
/**
 * This controller creates an `Action` to handle HTTP requests to the
 * application's home page.
 */
@Singleton
class GladiatorsController @Inject()(val controllerComponents: ControllerComponents) extends BaseController {
  val gamecontroller = Gladiators.controller

  def index() = Action { implicit request: Request[AnyContent] =>
    Ok(views.html.index())
  }

  def gladiators = Action {implicit request: Request[AnyContent] =>
    print(gamecontroller.boardToString)
    Ok("ha")
  }
}
