// @GENERATOR:play-routes-compiler
// @SOURCE:/home/sascha/FH/Web-Technologien/silhouette-seed/play-silhouette-seed/conf/routes
// @DATE:Sun Jan 10 10:37:27 CET 2021


package router {
  object RoutesPrefix {
    private var _prefix: String = "/"
    def setPrefix(p: String): Unit = {
      _prefix = p
    }
    def prefix: String = _prefix
    val byNamePrefix: Function0[String] = { () => prefix }
  }
}
