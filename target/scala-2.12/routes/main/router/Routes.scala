// @GENERATOR:play-routes-compiler
// @SOURCE:/home/sascha/FH/Web-Technologien/de.htwg.wt.gladiators/conf/routes
// @DATE:Sat Dec 19 14:10:53 CET 2020

package router

import play.core.routing._
import play.core.routing.HandlerInvokerFactory._

import play.api.mvc._

import _root_.controllers.Assets.Asset

class Routes(
  override val errorHandler: play.api.http.HttpErrorHandler, 
  // @LINE:7
  GladiatorsController_1: controllers.GladiatorsController,
  // @LINE:17
  Assets_0: controllers.Assets,
  val prefix: String
) extends GeneratedRouter {

   @javax.inject.Inject()
   def this(errorHandler: play.api.http.HttpErrorHandler,
    // @LINE:7
    GladiatorsController_1: controllers.GladiatorsController,
    // @LINE:17
    Assets_0: controllers.Assets
  ) = this(errorHandler, GladiatorsController_1, Assets_0, "/")

  def withPrefix(addPrefix: String): Routes = {
    val prefix = play.api.routing.Router.concatPrefix(addPrefix, this.prefix)
    router.RoutesPrefix.setPrefix(prefix)
    new Routes(errorHandler, GladiatorsController_1, Assets_0, prefix)
  }

  private[this] val defaultPrefix: String = {
    if (this.prefix.endsWith("/")) "" else "/"
  }

  def documentation = List(
    ("""GET""", this.prefix, """controllers.GladiatorsController.app"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """about""", """controllers.GladiatorsController.about"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """gladiators""", """controllers.GladiatorsController.gladiators"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """gladiators/api/command""", """controllers.GladiatorsController.processJsonCommand"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """gladiators/api/gladiatorSelect""", """controllers.GladiatorsController.gladiatorSelect"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """json""", """controllers.GladiatorsController.controllerToJson"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """websocket""", """controllers.GladiatorsController.socket"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """assets/""" + "$" + """file<.+>""", """controllers.Assets.versioned(path:String = "/public", file:Asset)"""),
    Nil
  ).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
    case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
    case l => s ++ l.asInstanceOf[List[(String,String,String)]]
  }}


  // @LINE:7
  private[this] lazy val controllers_GladiatorsController_app0_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix)))
  )
  private[this] lazy val controllers_GladiatorsController_app0_invoker = createInvoker(
    GladiatorsController_1.app,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.GladiatorsController",
      "app",
      Nil,
      "GET",
      this.prefix + """""",
      """ An example controller showing a sample home page""",
      Seq()
    )
  )

  // @LINE:8
  private[this] lazy val controllers_GladiatorsController_about1_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("about")))
  )
  private[this] lazy val controllers_GladiatorsController_about1_invoker = createInvoker(
    GladiatorsController_1.about,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.GladiatorsController",
      "about",
      Nil,
      "GET",
      this.prefix + """about""",
      """""",
      Seq()
    )
  )

  // @LINE:9
  private[this] lazy val controllers_GladiatorsController_gladiators2_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("gladiators")))
  )
  private[this] lazy val controllers_GladiatorsController_gladiators2_invoker = createInvoker(
    GladiatorsController_1.gladiators,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.GladiatorsController",
      "gladiators",
      Nil,
      "GET",
      this.prefix + """gladiators""",
      """""",
      Seq()
    )
  )

  // @LINE:10
  private[this] lazy val controllers_GladiatorsController_processJsonCommand3_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("gladiators/api/command")))
  )
  private[this] lazy val controllers_GladiatorsController_processJsonCommand3_invoker = createInvoker(
    GladiatorsController_1.processJsonCommand,
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

  // @LINE:11
  private[this] lazy val controllers_GladiatorsController_gladiatorSelect4_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("gladiators/api/gladiatorSelect")))
  )
  private[this] lazy val controllers_GladiatorsController_gladiatorSelect4_invoker = createInvoker(
    GladiatorsController_1.gladiatorSelect,
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

  // @LINE:12
  private[this] lazy val controllers_GladiatorsController_controllerToJson5_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("json")))
  )
  private[this] lazy val controllers_GladiatorsController_controllerToJson5_invoker = createInvoker(
    GladiatorsController_1.controllerToJson,
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

  // @LINE:13
  private[this] lazy val controllers_GladiatorsController_socket6_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("websocket")))
  )
  private[this] lazy val controllers_GladiatorsController_socket6_invoker = createInvoker(
    GladiatorsController_1.socket,
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

  // @LINE:17
  private[this] lazy val controllers_Assets_versioned7_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("assets/"), DynamicPart("file", """.+""",false)))
  )
  private[this] lazy val controllers_Assets_versioned7_invoker = createInvoker(
    Assets_0.versioned(fakeValue[String], fakeValue[Asset]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Assets",
      "versioned",
      Seq(classOf[String], classOf[Asset]),
      "GET",
      this.prefix + """assets/""" + "$" + """file<.+>""",
      """ Map static resources from the /public folder to the /assets URL path""",
      Seq()
    )
  )


  def routes: PartialFunction[RequestHeader, Handler] = {
  
    // @LINE:7
    case controllers_GladiatorsController_app0_route(params@_) =>
      call { 
        controllers_GladiatorsController_app0_invoker.call(GladiatorsController_1.app)
      }
  
    // @LINE:8
    case controllers_GladiatorsController_about1_route(params@_) =>
      call { 
        controllers_GladiatorsController_about1_invoker.call(GladiatorsController_1.about)
      }
  
    // @LINE:9
    case controllers_GladiatorsController_gladiators2_route(params@_) =>
      call { 
        controllers_GladiatorsController_gladiators2_invoker.call(GladiatorsController_1.gladiators)
      }
  
    // @LINE:10
    case controllers_GladiatorsController_processJsonCommand3_route(params@_) =>
      call { 
        controllers_GladiatorsController_processJsonCommand3_invoker.call(GladiatorsController_1.processJsonCommand)
      }
  
    // @LINE:11
    case controllers_GladiatorsController_gladiatorSelect4_route(params@_) =>
      call { 
        controllers_GladiatorsController_gladiatorSelect4_invoker.call(GladiatorsController_1.gladiatorSelect)
      }
  
    // @LINE:12
    case controllers_GladiatorsController_controllerToJson5_route(params@_) =>
      call { 
        controllers_GladiatorsController_controllerToJson5_invoker.call(GladiatorsController_1.controllerToJson)
      }
  
    // @LINE:13
    case controllers_GladiatorsController_socket6_route(params@_) =>
      call { 
        controllers_GladiatorsController_socket6_invoker.call(GladiatorsController_1.socket)
      }
  
    // @LINE:17
    case controllers_Assets_versioned7_route(params@_) =>
      call(Param[String]("path", Right("/public")), params.fromPath[Asset]("file", None)) { (path, file) =>
        controllers_Assets_versioned7_invoker.call(Assets_0.versioned(path, file))
      }
  }
}
