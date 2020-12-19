// @GENERATOR:play-routes-compiler
// @SOURCE:/home/sascha/FH/Web-Technologien/de.htwg.wt.gladiators/conf/routes
// @DATE:Sat Dec 19 14:10:53 CET 2020

package controllers;

import router.RoutesPrefix;

public class routes {
  
  public static final controllers.ReverseGladiatorsController GladiatorsController = new controllers.ReverseGladiatorsController(RoutesPrefix.byNamePrefix());
  public static final controllers.ReverseAssets Assets = new controllers.ReverseAssets(RoutesPrefix.byNamePrefix());

  public static class javascript {
    
    public static final controllers.javascript.ReverseGladiatorsController GladiatorsController = new controllers.javascript.ReverseGladiatorsController(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReverseAssets Assets = new controllers.javascript.ReverseAssets(RoutesPrefix.byNamePrefix());
  }

}
