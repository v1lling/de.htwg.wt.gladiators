// @GENERATOR:play-routes-compiler
// @SOURCE:/home/sascha/FH/Web-Technologien/silhouette-seed/play-silhouette-seed/conf/routes
// @DATE:Sun Jan 10 10:37:27 CET 2021

package router

import play.core.routing._
import play.core.routing.HandlerInvokerFactory._

import play.api.mvc._

import _root_.controllers.Assets.Asset
import _root_.utils.route.Binders._

class Routes(
  override val errorHandler: play.api.http.HttpErrorHandler, 
  // @LINE:6
  ApplicationController_8: controllers.ApplicationController,
  // @LINE:8
  SocialAuthController_0: controllers.SocialAuthController,
  // @LINE:10
  SignUpController_9: controllers.SignUpController,
  // @LINE:13
  SignInController_1: controllers.SignInController,
  // @LINE:16
  TotpController_2: controllers.TotpController,
  // @LINE:22
  TotpRecoveryController_7: controllers.TotpRecoveryController,
  // @LINE:25
  ForgotPasswordController_4: controllers.ForgotPasswordController,
  // @LINE:27
  ResetPasswordController_6: controllers.ResetPasswordController,
  // @LINE:29
  ChangePasswordController_3: controllers.ChangePasswordController,
  // @LINE:32
  ActivateAccountController_10: controllers.ActivateAccountController,
  // @LINE:35
  GladiatorsController_5: controllers.GladiatorsController,
  // @LINE:43
  Assets_11: controllers.Assets,
  // @LINE:44
  webjars_Routes_0: webjars.Routes,
  val prefix: String
) extends GeneratedRouter {

   @javax.inject.Inject()
   def this(errorHandler: play.api.http.HttpErrorHandler,
    // @LINE:6
    ApplicationController_8: controllers.ApplicationController,
    // @LINE:8
    SocialAuthController_0: controllers.SocialAuthController,
    // @LINE:10
    SignUpController_9: controllers.SignUpController,
    // @LINE:13
    SignInController_1: controllers.SignInController,
    // @LINE:16
    TotpController_2: controllers.TotpController,
    // @LINE:22
    TotpRecoveryController_7: controllers.TotpRecoveryController,
    // @LINE:25
    ForgotPasswordController_4: controllers.ForgotPasswordController,
    // @LINE:27
    ResetPasswordController_6: controllers.ResetPasswordController,
    // @LINE:29
    ChangePasswordController_3: controllers.ChangePasswordController,
    // @LINE:32
    ActivateAccountController_10: controllers.ActivateAccountController,
    // @LINE:35
    GladiatorsController_5: controllers.GladiatorsController,
    // @LINE:43
    Assets_11: controllers.Assets,
    // @LINE:44
    webjars_Routes_0: webjars.Routes
  ) = this(errorHandler, ApplicationController_8, SocialAuthController_0, SignUpController_9, SignInController_1, TotpController_2, TotpRecoveryController_7, ForgotPasswordController_4, ResetPasswordController_6, ChangePasswordController_3, ActivateAccountController_10, GladiatorsController_5, Assets_11, webjars_Routes_0, "/")

  def withPrefix(addPrefix: String): Routes = {
    val prefix = play.api.routing.Router.concatPrefix(addPrefix, this.prefix)
    router.RoutesPrefix.setPrefix(prefix)
    new Routes(errorHandler, ApplicationController_8, SocialAuthController_0, SignUpController_9, SignInController_1, TotpController_2, TotpRecoveryController_7, ForgotPasswordController_4, ResetPasswordController_6, ChangePasswordController_3, ActivateAccountController_10, GladiatorsController_5, Assets_11, webjars_Routes_0, prefix)
  }

  private[this] val defaultPrefix: String = {
    if (this.prefix.endsWith("/")) "" else "/"
  }

  def documentation = List(
    ("""GET""", this.prefix, """controllers.ApplicationController.index"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """signOut""", """controllers.ApplicationController.signOut"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """authenticate/""" + "$" + """provider<[^/]+>""", """controllers.SocialAuthController.authenticate(provider:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """signUp""", """controllers.SignUpController.view"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """signUp""", """controllers.SignUpController.submit"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """signIn""", """controllers.SignInController.view"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """signIn""", """controllers.SignInController.submit"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """totp""", """controllers.TotpController.view(userId:java.util.UUID, sharedKey:String, rememberMe:Boolean)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """enableTotp""", """controllers.TotpController.enableTotp"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """disableTotp""", """controllers.TotpController.disableTotp"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """totpSubmit""", """controllers.TotpController.submit"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """enableTotpSubmit""", """controllers.TotpController.enableTotpSubmit"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """totpRecovery""", """controllers.TotpRecoveryController.view(userID:java.util.UUID, sharedKey:String, rememberMe:Boolean)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """totpRecoverySubmit""", """controllers.TotpRecoveryController.submit"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """password/forgot""", """controllers.ForgotPasswordController.view"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """password/forgot""", """controllers.ForgotPasswordController.submit"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """password/reset/""" + "$" + """token<[^/]+>""", """controllers.ResetPasswordController.view(token:java.util.UUID)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """password/reset/""" + "$" + """token<[^/]+>""", """controllers.ResetPasswordController.submit(token:java.util.UUID)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """password/change""", """controllers.ChangePasswordController.view"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """password/change""", """controllers.ChangePasswordController.submit"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """account/email/""" + "$" + """email<[^/]+>""", """controllers.ActivateAccountController.send(email:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """account/activate/""" + "$" + """token<[^/]+>""", """controllers.ActivateAccountController.activate(token:java.util.UUID)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """gladiators/api/command""", """controllers.GladiatorsController.processJsonCommand"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """gladiators/api/gladiatorSelect""", """controllers.GladiatorsController.gladiatorSelect"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """json""", """controllers.GladiatorsController.controllerToJson"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """websocket""", """controllers.GladiatorsController.socket"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """assets/""" + "$" + """file<.+>""", """controllers.Assets.versioned(file:String)"""),
    prefixed_webjars_Routes_0_27.router.documentation,
    Nil
  ).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
    case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
    case l => s ++ l.asInstanceOf[List[(String,String,String)]]
  }}


  // @LINE:6
  private[this] lazy val controllers_ApplicationController_index0_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix)))
  )
  private[this] lazy val controllers_ApplicationController_index0_invoker = createInvoker(
    ApplicationController_8.index,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.ApplicationController",
      "index",
      Nil,
      "GET",
      this.prefix + """""",
      """ Home page""",
      Seq()
    )
  )

  // @LINE:7
  private[this] lazy val controllers_ApplicationController_signOut1_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("signOut")))
  )
  private[this] lazy val controllers_ApplicationController_signOut1_invoker = createInvoker(
    ApplicationController_8.signOut,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.ApplicationController",
      "signOut",
      Nil,
      "GET",
      this.prefix + """signOut""",
      """""",
      Seq()
    )
  )

  // @LINE:8
  private[this] lazy val controllers_SocialAuthController_authenticate2_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("authenticate/"), DynamicPart("provider", """[^/]+""",true)))
  )
  private[this] lazy val controllers_SocialAuthController_authenticate2_invoker = createInvoker(
    SocialAuthController_0.authenticate(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.SocialAuthController",
      "authenticate",
      Seq(classOf[String]),
      "GET",
      this.prefix + """authenticate/""" + "$" + """provider<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:10
  private[this] lazy val controllers_SignUpController_view3_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("signUp")))
  )
  private[this] lazy val controllers_SignUpController_view3_invoker = createInvoker(
    SignUpController_9.view,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.SignUpController",
      "view",
      Nil,
      "GET",
      this.prefix + """signUp""",
      """""",
      Seq()
    )
  )

  // @LINE:11
  private[this] lazy val controllers_SignUpController_submit4_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("signUp")))
  )
  private[this] lazy val controllers_SignUpController_submit4_invoker = createInvoker(
    SignUpController_9.submit,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.SignUpController",
      "submit",
      Nil,
      "POST",
      this.prefix + """signUp""",
      """""",
      Seq()
    )
  )

  // @LINE:13
  private[this] lazy val controllers_SignInController_view5_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("signIn")))
  )
  private[this] lazy val controllers_SignInController_view5_invoker = createInvoker(
    SignInController_1.view,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.SignInController",
      "view",
      Nil,
      "GET",
      this.prefix + """signIn""",
      """""",
      Seq()
    )
  )

  // @LINE:14
  private[this] lazy val controllers_SignInController_submit6_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("signIn")))
  )
  private[this] lazy val controllers_SignInController_submit6_invoker = createInvoker(
    SignInController_1.submit,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.SignInController",
      "submit",
      Nil,
      "POST",
      this.prefix + """signIn""",
      """""",
      Seq()
    )
  )

  // @LINE:16
  private[this] lazy val controllers_TotpController_view7_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("totp")))
  )
  private[this] lazy val controllers_TotpController_view7_invoker = createInvoker(
    TotpController_2.view(fakeValue[java.util.UUID], fakeValue[String], fakeValue[Boolean]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.TotpController",
      "view",
      Seq(classOf[java.util.UUID], classOf[String], classOf[Boolean]),
      "GET",
      this.prefix + """totp""",
      """""",
      Seq()
    )
  )

  // @LINE:17
  private[this] lazy val controllers_TotpController_enableTotp8_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("enableTotp")))
  )
  private[this] lazy val controllers_TotpController_enableTotp8_invoker = createInvoker(
    TotpController_2.enableTotp,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.TotpController",
      "enableTotp",
      Nil,
      "GET",
      this.prefix + """enableTotp""",
      """""",
      Seq()
    )
  )

  // @LINE:18
  private[this] lazy val controllers_TotpController_disableTotp9_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("disableTotp")))
  )
  private[this] lazy val controllers_TotpController_disableTotp9_invoker = createInvoker(
    TotpController_2.disableTotp,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.TotpController",
      "disableTotp",
      Nil,
      "GET",
      this.prefix + """disableTotp""",
      """""",
      Seq()
    )
  )

  // @LINE:19
  private[this] lazy val controllers_TotpController_submit10_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("totpSubmit")))
  )
  private[this] lazy val controllers_TotpController_submit10_invoker = createInvoker(
    TotpController_2.submit,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.TotpController",
      "submit",
      Nil,
      "POST",
      this.prefix + """totpSubmit""",
      """""",
      Seq()
    )
  )

  // @LINE:20
  private[this] lazy val controllers_TotpController_enableTotpSubmit11_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("enableTotpSubmit")))
  )
  private[this] lazy val controllers_TotpController_enableTotpSubmit11_invoker = createInvoker(
    TotpController_2.enableTotpSubmit,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.TotpController",
      "enableTotpSubmit",
      Nil,
      "POST",
      this.prefix + """enableTotpSubmit""",
      """""",
      Seq()
    )
  )

  // @LINE:22
  private[this] lazy val controllers_TotpRecoveryController_view12_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("totpRecovery")))
  )
  private[this] lazy val controllers_TotpRecoveryController_view12_invoker = createInvoker(
    TotpRecoveryController_7.view(fakeValue[java.util.UUID], fakeValue[String], fakeValue[Boolean]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.TotpRecoveryController",
      "view",
      Seq(classOf[java.util.UUID], classOf[String], classOf[Boolean]),
      "GET",
      this.prefix + """totpRecovery""",
      """""",
      Seq()
    )
  )

  // @LINE:23
  private[this] lazy val controllers_TotpRecoveryController_submit13_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("totpRecoverySubmit")))
  )
  private[this] lazy val controllers_TotpRecoveryController_submit13_invoker = createInvoker(
    TotpRecoveryController_7.submit,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.TotpRecoveryController",
      "submit",
      Nil,
      "POST",
      this.prefix + """totpRecoverySubmit""",
      """""",
      Seq()
    )
  )

  // @LINE:25
  private[this] lazy val controllers_ForgotPasswordController_view14_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("password/forgot")))
  )
  private[this] lazy val controllers_ForgotPasswordController_view14_invoker = createInvoker(
    ForgotPasswordController_4.view,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.ForgotPasswordController",
      "view",
      Nil,
      "GET",
      this.prefix + """password/forgot""",
      """""",
      Seq()
    )
  )

  // @LINE:26
  private[this] lazy val controllers_ForgotPasswordController_submit15_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("password/forgot")))
  )
  private[this] lazy val controllers_ForgotPasswordController_submit15_invoker = createInvoker(
    ForgotPasswordController_4.submit,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.ForgotPasswordController",
      "submit",
      Nil,
      "POST",
      this.prefix + """password/forgot""",
      """""",
      Seq()
    )
  )

  // @LINE:27
  private[this] lazy val controllers_ResetPasswordController_view16_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("password/reset/"), DynamicPart("token", """[^/]+""",true)))
  )
  private[this] lazy val controllers_ResetPasswordController_view16_invoker = createInvoker(
    ResetPasswordController_6.view(fakeValue[java.util.UUID]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.ResetPasswordController",
      "view",
      Seq(classOf[java.util.UUID]),
      "GET",
      this.prefix + """password/reset/""" + "$" + """token<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:28
  private[this] lazy val controllers_ResetPasswordController_submit17_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("password/reset/"), DynamicPart("token", """[^/]+""",true)))
  )
  private[this] lazy val controllers_ResetPasswordController_submit17_invoker = createInvoker(
    ResetPasswordController_6.submit(fakeValue[java.util.UUID]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.ResetPasswordController",
      "submit",
      Seq(classOf[java.util.UUID]),
      "POST",
      this.prefix + """password/reset/""" + "$" + """token<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:29
  private[this] lazy val controllers_ChangePasswordController_view18_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("password/change")))
  )
  private[this] lazy val controllers_ChangePasswordController_view18_invoker = createInvoker(
    ChangePasswordController_3.view,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.ChangePasswordController",
      "view",
      Nil,
      "GET",
      this.prefix + """password/change""",
      """""",
      Seq()
    )
  )

  // @LINE:30
  private[this] lazy val controllers_ChangePasswordController_submit19_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("password/change")))
  )
  private[this] lazy val controllers_ChangePasswordController_submit19_invoker = createInvoker(
    ChangePasswordController_3.submit,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.ChangePasswordController",
      "submit",
      Nil,
      "POST",
      this.prefix + """password/change""",
      """""",
      Seq()
    )
  )

  // @LINE:32
  private[this] lazy val controllers_ActivateAccountController_send20_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("account/email/"), DynamicPart("email", """[^/]+""",true)))
  )
  private[this] lazy val controllers_ActivateAccountController_send20_invoker = createInvoker(
    ActivateAccountController_10.send(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.ActivateAccountController",
      "send",
      Seq(classOf[String]),
      "GET",
      this.prefix + """account/email/""" + "$" + """email<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:33
  private[this] lazy val controllers_ActivateAccountController_activate21_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("account/activate/"), DynamicPart("token", """[^/]+""",true)))
  )
  private[this] lazy val controllers_ActivateAccountController_activate21_invoker = createInvoker(
    ActivateAccountController_10.activate(fakeValue[java.util.UUID]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.ActivateAccountController",
      "activate",
      Seq(classOf[java.util.UUID]),
      "GET",
      this.prefix + """account/activate/""" + "$" + """token<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:35
  private[this] lazy val controllers_GladiatorsController_processJsonCommand22_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("gladiators/api/command")))
  )
  private[this] lazy val controllers_GladiatorsController_processJsonCommand22_invoker = createInvoker(
    GladiatorsController_5.processJsonCommand,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.GladiatorsController",
      "processJsonCommand",
      Nil,
      "POST",
      this.prefix + """gladiators/api/command""",
      """""",
      Seq()
    )
  )

  // @LINE:36
  private[this] lazy val controllers_GladiatorsController_gladiatorSelect23_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("gladiators/api/gladiatorSelect")))
  )
  private[this] lazy val controllers_GladiatorsController_gladiatorSelect23_invoker = createInvoker(
    GladiatorsController_5.gladiatorSelect,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.GladiatorsController",
      "gladiatorSelect",
      Nil,
      "POST",
      this.prefix + """gladiators/api/gladiatorSelect""",
      """""",
      Seq()
    )
  )

  // @LINE:37
  private[this] lazy val controllers_GladiatorsController_controllerToJson24_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("json")))
  )
  private[this] lazy val controllers_GladiatorsController_controllerToJson24_invoker = createInvoker(
    GladiatorsController_5.controllerToJson,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.GladiatorsController",
      "controllerToJson",
      Nil,
      "GET",
      this.prefix + """json""",
      """""",
      Seq()
    )
  )

  // @LINE:38
  private[this] lazy val controllers_GladiatorsController_socket25_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("websocket")))
  )
  private[this] lazy val controllers_GladiatorsController_socket25_invoker = createInvoker(
    GladiatorsController_5.socket,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.GladiatorsController",
      "socket",
      Nil,
      "GET",
      this.prefix + """websocket""",
      """""",
      Seq()
    )
  )

  // @LINE:43
  private[this] lazy val controllers_Assets_versioned26_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("assets/"), DynamicPart("file", """.+""",false)))
  )
  private[this] lazy val controllers_Assets_versioned26_invoker = createInvoker(
    Assets_11.versioned(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Assets",
      "versioned",
      Seq(classOf[String]),
      "GET",
      this.prefix + """assets/""" + "$" + """file<.+>""",
      """ Map static resources from the /public folder to the /assets URL path""",
      Seq()
    )
  )

  // @LINE:44
  private[this] val prefixed_webjars_Routes_0_27 = Include(webjars_Routes_0.withPrefix(this.prefix + (if (this.prefix.endsWith("/")) "" else "/") + "webjars"))


  def routes: PartialFunction[RequestHeader, Handler] = {
  
    // @LINE:6
    case controllers_ApplicationController_index0_route(params@_) =>
      call { 
        controllers_ApplicationController_index0_invoker.call(ApplicationController_8.index)
      }
  
    // @LINE:7
    case controllers_ApplicationController_signOut1_route(params@_) =>
      call { 
        controllers_ApplicationController_signOut1_invoker.call(ApplicationController_8.signOut)
      }
  
    // @LINE:8
    case controllers_SocialAuthController_authenticate2_route(params@_) =>
      call(params.fromPath[String]("provider", None)) { (provider) =>
        controllers_SocialAuthController_authenticate2_invoker.call(SocialAuthController_0.authenticate(provider))
      }
  
    // @LINE:10
    case controllers_SignUpController_view3_route(params@_) =>
      call { 
        controllers_SignUpController_view3_invoker.call(SignUpController_9.view)
      }
  
    // @LINE:11
    case controllers_SignUpController_submit4_route(params@_) =>
      call { 
        controllers_SignUpController_submit4_invoker.call(SignUpController_9.submit)
      }
  
    // @LINE:13
    case controllers_SignInController_view5_route(params@_) =>
      call { 
        controllers_SignInController_view5_invoker.call(SignInController_1.view)
      }
  
    // @LINE:14
    case controllers_SignInController_submit6_route(params@_) =>
      call { 
        controllers_SignInController_submit6_invoker.call(SignInController_1.submit)
      }
  
    // @LINE:16
    case controllers_TotpController_view7_route(params@_) =>
      call(params.fromQuery[java.util.UUID]("userId", None), params.fromQuery[String]("sharedKey", None), params.fromQuery[Boolean]("rememberMe", None)) { (userId, sharedKey, rememberMe) =>
        controllers_TotpController_view7_invoker.call(TotpController_2.view(userId, sharedKey, rememberMe))
      }
  
    // @LINE:17
    case controllers_TotpController_enableTotp8_route(params@_) =>
      call { 
        controllers_TotpController_enableTotp8_invoker.call(TotpController_2.enableTotp)
      }
  
    // @LINE:18
    case controllers_TotpController_disableTotp9_route(params@_) =>
      call { 
        controllers_TotpController_disableTotp9_invoker.call(TotpController_2.disableTotp)
      }
  
    // @LINE:19
    case controllers_TotpController_submit10_route(params@_) =>
      call { 
        controllers_TotpController_submit10_invoker.call(TotpController_2.submit)
      }
  
    // @LINE:20
    case controllers_TotpController_enableTotpSubmit11_route(params@_) =>
      call { 
        controllers_TotpController_enableTotpSubmit11_invoker.call(TotpController_2.enableTotpSubmit)
      }
  
    // @LINE:22
    case controllers_TotpRecoveryController_view12_route(params@_) =>
      call(params.fromQuery[java.util.UUID]("userID", None), params.fromQuery[String]("sharedKey", None), params.fromQuery[Boolean]("rememberMe", None)) { (userID, sharedKey, rememberMe) =>
        controllers_TotpRecoveryController_view12_invoker.call(TotpRecoveryController_7.view(userID, sharedKey, rememberMe))
      }
  
    // @LINE:23
    case controllers_TotpRecoveryController_submit13_route(params@_) =>
      call { 
        controllers_TotpRecoveryController_submit13_invoker.call(TotpRecoveryController_7.submit)
      }
  
    // @LINE:25
    case controllers_ForgotPasswordController_view14_route(params@_) =>
      call { 
        controllers_ForgotPasswordController_view14_invoker.call(ForgotPasswordController_4.view)
      }
  
    // @LINE:26
    case controllers_ForgotPasswordController_submit15_route(params@_) =>
      call { 
        controllers_ForgotPasswordController_submit15_invoker.call(ForgotPasswordController_4.submit)
      }
  
    // @LINE:27
    case controllers_ResetPasswordController_view16_route(params@_) =>
      call(params.fromPath[java.util.UUID]("token", None)) { (token) =>
        controllers_ResetPasswordController_view16_invoker.call(ResetPasswordController_6.view(token))
      }
  
    // @LINE:28
    case controllers_ResetPasswordController_submit17_route(params@_) =>
      call(params.fromPath[java.util.UUID]("token", None)) { (token) =>
        controllers_ResetPasswordController_submit17_invoker.call(ResetPasswordController_6.submit(token))
      }
  
    // @LINE:29
    case controllers_ChangePasswordController_view18_route(params@_) =>
      call { 
        controllers_ChangePasswordController_view18_invoker.call(ChangePasswordController_3.view)
      }
  
    // @LINE:30
    case controllers_ChangePasswordController_submit19_route(params@_) =>
      call { 
        controllers_ChangePasswordController_submit19_invoker.call(ChangePasswordController_3.submit)
      }
  
    // @LINE:32
    case controllers_ActivateAccountController_send20_route(params@_) =>
      call(params.fromPath[String]("email", None)) { (email) =>
        controllers_ActivateAccountController_send20_invoker.call(ActivateAccountController_10.send(email))
      }
  
    // @LINE:33
    case controllers_ActivateAccountController_activate21_route(params@_) =>
      call(params.fromPath[java.util.UUID]("token", None)) { (token) =>
        controllers_ActivateAccountController_activate21_invoker.call(ActivateAccountController_10.activate(token))
      }
  
    // @LINE:35
    case controllers_GladiatorsController_processJsonCommand22_route(params@_) =>
      call { 
        controllers_GladiatorsController_processJsonCommand22_invoker.call(GladiatorsController_5.processJsonCommand)
      }
  
    // @LINE:36
    case controllers_GladiatorsController_gladiatorSelect23_route(params@_) =>
      call { 
        controllers_GladiatorsController_gladiatorSelect23_invoker.call(GladiatorsController_5.gladiatorSelect)
      }
  
    // @LINE:37
    case controllers_GladiatorsController_controllerToJson24_route(params@_) =>
      call { 
        controllers_GladiatorsController_controllerToJson24_invoker.call(GladiatorsController_5.controllerToJson)
      }
  
    // @LINE:38
    case controllers_GladiatorsController_socket25_route(params@_) =>
      call { 
        controllers_GladiatorsController_socket25_invoker.call(GladiatorsController_5.socket)
      }
  
    // @LINE:43
    case controllers_Assets_versioned26_route(params@_) =>
      call(params.fromPath[String]("file", None)) { (file) =>
        controllers_Assets_versioned26_invoker.call(Assets_11.versioned(file))
      }
  
    // @LINE:44
    case prefixed_webjars_Routes_0_27(handler) => handler
  }
}
