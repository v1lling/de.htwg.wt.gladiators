package utils.route

import play.api.mvc.Call

/**
 * Defines some common redirect calls used in authentication flow.
 */
object Calls {
  /** @return The URL to redirect to when an authentication succeeds. */
  def home: Call = controllers.routes.GladiatorsFrontendController.frontend()

  /** @return The URL to redirect to when an authentication fails. */
  def signin: Call = controllers.routes.SignInController.view()
}
