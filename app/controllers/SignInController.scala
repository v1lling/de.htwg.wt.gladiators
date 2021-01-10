package controllers

import com.mohiva.play.silhouette.api.exceptions.ProviderException
import com.mohiva.play.silhouette.api.util.Credentials
import com.mohiva.play.silhouette.impl.exceptions.IdentityNotFoundException
import com.mohiva.play.silhouette.impl.providers._
import forms.{ SignInForm, TotpForm }
import javax.inject.Inject
import play.api.i18n.Messages
import play.api.mvc.{ AnyContent, Request }
import utils.route.Calls
import play.api.libs.json._
import scala.concurrent.{ ExecutionContext, Future }

/**
 * The `Sign In` controller.
 */
class SignInController @Inject() (
  scc: SilhouetteControllerComponents,
  signIn: views.html.signIn,
  activateAccount: views.html.activateAccount,
  totp: views.html.totp
)(implicit ex: ExecutionContext) extends AbstractAuthController(scc) {

  /**
   * Views the `Sign In` page.
   *
   * @return The result to display.
   */
  def view = UnsecuredAction.async { implicit request: Request[AnyContent] =>
    Future.successful(Ok(signIn(SignInForm.form, socialProviderRegistry)))
  }

  /**
   * Handles the submitted form.
   *
   * @return The result to display.
   */
  def submit = UnsecuredAction.async { implicit request: Request[AnyContent] =>
    SignInForm.form.bindFromRequest.fold(
      form => Future.successful(BadRequest(signIn(form, socialProviderRegistry))),
      data => {
        val credentials = Credentials(data.email, data.password)
        println("Trying to authenticate")
        credentialsProvider.authenticate(credentials).flatMap { loginInfo =>
          {
            println("see if there is a user")
            userService.retrieve(loginInfo).flatMap {
              case Some(user) if !user.activated =>
                println("needs to be activated")
                Future.successful(Ok(activateAccount(data.email)))
              case Some(user) =>
                println("User exists")
                authInfoRepository.find[GoogleTotpInfo](user.loginInfo).flatMap {
                  case Some(totfInfo) => {
                    print(user.userID)
                    Future.successful(Ok(Json.toJson(user)))
                  }
                  // case Some(totpInfo) => Future.successful(Ok(totp(TotpForm.form.fill(TotpForm.Data(
                  // user.userID, totpInfo.sharedKey, data.rememberMe)))))
                  case _ => {
                    println(user)
                    authenticateUser(user, data.rememberMe)
                    authTokenService.create(user.userID).map { authToken =>
                      Ok(Json.obj(
                        "token" -> authToken.id
                      ))
                    }
                  }
                }
              case None => Future.failed(new IdentityNotFoundException("Couldn't find user"))
            }
          }
        }.recover {
          case _: ProviderException =>
            println("eror")
            Redirect(Calls.signin).flashing("error" -> Messages("invalid.credentials"))
        }
      }
    )
  }
}
