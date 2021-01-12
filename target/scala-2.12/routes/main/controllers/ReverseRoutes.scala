// @GENERATOR:play-routes-compiler
// @SOURCE:/home/sascha/FH/Web-Technologien/de.htwg.wt.gladiators/conf/routes
// @DATE:Tue Jan 12 10:24:11 CET 2021

import play.api.mvc.Call


import _root_.controllers.Assets.Asset

// @LINE:7
package controllers {

  // @LINE:7
  class ReverseGladiatorsController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:10
    def processJsonCommand(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "gladiators/api/command")
    }
  
    // @LINE:9
    def gladiators(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "gladiators")
    }
  
    // @LINE:8
    def about(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "about")
    }
  
    // @LINE:13
    def socket(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "websocket")
    }
  
    // @LINE:7
    def app(): Call = {
      
      Call("GET", _prefix)
    }
  
    // @LINE:12
    def controllerToJson(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "json")
    }
  
    // @LINE:11
    def gladiatorSelect(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "gladiators/api/gladiatorSelect")
    }
  
  }

  // @LINE:17
  class ReverseAssets(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:17
    def versioned(file:Asset): Call = {
      implicit lazy val _rrc = new play.core.routing.ReverseRouteContext(Map(("path", "/public"))); _rrc
      Call("GET", _prefix + { _defaultPrefix } + "assets/" + implicitly[play.api.mvc.PathBindable[Asset]].unbind("file", file))
    }
  
  }


}
