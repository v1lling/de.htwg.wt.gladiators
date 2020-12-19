// @GENERATOR:play-routes-compiler
// @SOURCE:/home/sascha/FH/Web-Technologien/de.htwg.wt.gladiators/conf/routes
// @DATE:Sat Dec 19 14:10:53 CET 2020

import play.api.routing.JavaScriptReverseRoute


import _root_.controllers.Assets.Asset

// @LINE:7
package controllers.javascript {

  // @LINE:7
  class ReverseGladiatorsController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:10
    def processJsonCommand: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.GladiatorsController.processJsonCommand",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "gladiators/api/command"})
        }
      """
    )
  
    // @LINE:9
    def gladiators: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.GladiatorsController.gladiators",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "gladiators"})
        }
      """
    )
  
    // @LINE:8
    def about: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.GladiatorsController.about",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "about"})
        }
      """
    )
  
    // @LINE:13
    def socket: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.GladiatorsController.socket",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "websocket"})
        }
      """
    )
  
    // @LINE:7
    def app: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.GladiatorsController.app",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + """"})
        }
      """
    )
  
    // @LINE:12
    def controllerToJson: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.GladiatorsController.controllerToJson",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "json"})
        }
      """
    )
  
    // @LINE:11
    def gladiatorSelect: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.GladiatorsController.gladiatorSelect",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "gladiators/api/gladiatorSelect"})
        }
      """
    )
  
  }

  // @LINE:17
  class ReverseAssets(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:17
    def versioned: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Assets.versioned",
      """
        function(file1) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "assets/" + (""" + implicitly[play.api.mvc.PathBindable[Asset]].javascriptUnbind + """)("file", file1)})
        }
      """
    )
  
  }


}
