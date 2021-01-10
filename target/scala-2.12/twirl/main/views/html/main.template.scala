
package views.html

/*1.2*/import play.api.i18n.Messages
/*2.2*/import play.api.mvc.RequestHeader
/*3.2*/import play.twirl.api.Html
/*4.2*/import org.webjars.play.WebJarsUtil
/*5.2*/import controllers.AssetsFinder
/*6.2*/import views.html.helper._

object main extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template7[String,Option[models.User],Html,RequestHeader,Messages,AssetsFinder,WebJarsUtil,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*8.2*/(title: String, user: Option[models.User] = None)(content: Html)(implicit request: RequestHeader, messages: Messages, assets: AssetsFinder, webJarsUtil: WebJarsUtil):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*9.1*/("""
"""),format.raw/*10.1*/("""<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="shortcut icon" type="image/png" href=""""),_display_(/*16.59*/assets/*16.65*/.path("images/favicon.png")),format.raw/*16.92*/("""">
        <title>"""),_display_(/*17.17*/title),format.raw/*17.22*/("""</title>
        <link """),_display_(/*18.16*/{CSPNonce.attr}),format.raw/*18.31*/(""" """),format.raw/*18.32*/("""href="//fonts.googleapis.com/css?family=Roboto|Montserrat:400,700|Open+Sans:400,300,600" rel="stylesheet">
        <link """),_display_(/*19.16*/{CSPNonce.attr}),format.raw/*19.31*/(""" """),format.raw/*19.32*/("""href="//cdnjs.cloudflare.com/ajax/libs/ionicons/1.5.2/css/ionicons.min.css" rel="stylesheet">
        """),_display_(/*20.10*/webJarsUtil/*20.21*/.locate("bootstrap.min.css").css(CSPNonce.attrMap)),format.raw/*20.71*/("""
        """),format.raw/*21.9*/("""<link """),_display_(/*21.16*/{CSPNonce.attr}),format.raw/*21.31*/(""" """),format.raw/*21.32*/("""rel="stylesheet" href=""""),_display_(/*21.56*/assets/*21.62*/.path("styles/main.css")),format.raw/*21.86*/("""">
            <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
            <!--[if lt IE 9]>
            <script """),_display_(/*24.22*/{CSPNonce.attr}),format.raw/*24.37*/(""" """),format.raw/*24.38*/("""src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
            <script """),_display_(/*25.22*/{CSPNonce.attr}),format.raw/*25.37*/(""" """),format.raw/*25.38*/("""src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
            <![endif]-->
    </head>
    <body>
        <header>
            <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <a class="navbar-brand" href=""""),_display_(/*34.48*/controllers/*34.59*/.routes.ApplicationController.index),format.raw/*34.94*/("""">Silhouette Seed Template</a>

                <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
                    <div class="navbar-nav">
                        <a class="nav-item nav-link" href=""""),_display_(/*38.61*/controllers/*38.72*/.routes.ApplicationController.index),format.raw/*38.107*/("""">"""),_display_(/*38.110*/messages("home")),format.raw/*38.126*/("""</a>
                        <a class="nav-item nav-link" href="https://github.com/mohiva/play-silhouette-seed">GitHub</a>
                    </div>
                </div>

                <div class="collapse navbar-collapse" id="navbarNavAltMarkup2">
                    <div class="navbar-nav">
                        """),_display_(/*45.26*/user/*45.30*/.map/*45.34*/ { u =>_display_(Seq[Any](format.raw/*45.41*/("""
                        """),format.raw/*46.25*/("""<a class="nav-link" href=""""),_display_(/*46.52*/controllers/*46.63*/.routes.ApplicationController.index),format.raw/*46.98*/("""">"""),_display_(/*46.101*/u/*46.102*/.name),format.raw/*46.107*/("""</a>
                        """),_display_(/*47.26*/if(u.loginInfo.providerID == com.mohiva.play.silhouette.impl.providers.CredentialsProvider.ID)/*47.120*/ {_display_(Seq[Any](format.raw/*47.122*/("""
                        """),format.raw/*48.25*/("""<a class="nav-item nav-link" href=""""),_display_(/*48.61*/controllers/*48.72*/.routes.ChangePasswordController.view),format.raw/*48.109*/("""">"""),_display_(/*48.112*/messages("change.password")),format.raw/*48.139*/("""</a>
                        """)))}),format.raw/*49.26*/("""
                        """),format.raw/*50.25*/("""<a class="nav-item nav-link" href=""""),_display_(/*50.61*/controllers/*50.72*/.routes.ApplicationController.signOut),format.raw/*50.109*/("""">"""),_display_(/*50.112*/messages("sign.out")),format.raw/*50.132*/("""</a>
                        """)))}/*51.26*/.getOrElse/*51.36*/ {_display_(Seq[Any](format.raw/*51.38*/("""
                        """),format.raw/*52.25*/("""<a class="nav-item nav-link" href=""""),_display_(/*52.61*/controllers/*52.72*/.routes.SignInController.view),format.raw/*52.101*/("""">"""),_display_(/*52.104*/messages("sign.in")),format.raw/*52.123*/("""</a>
                        <a class="nav-item nav-link" href=""""),_display_(/*53.61*/controllers/*53.72*/.routes.SignUpController.view),format.raw/*53.101*/("""">"""),_display_(/*53.104*/messages("sign.up")),format.raw/*53.123*/("""</a>
                        """)))}),format.raw/*54.26*/("""
                    """),format.raw/*55.21*/("""</div>
                </div>

            </nav>
        </header>
        <main class="container">
            <div class="starter-template row">
                """),_display_(/*62.18*/request/*62.25*/.flash.get("error").map/*62.48*/ { msg =>_display_(Seq[Any](format.raw/*62.57*/("""
                    """),format.raw/*63.21*/("""<div class="col-md-6 col-md-offset-3 alert alert-danger">
                        <a href="#" class="close" data-dismiss="alert">&times;</a>
                        <strong>"""),_display_(/*65.34*/messages("error")),format.raw/*65.51*/("""</strong> """),_display_(/*65.62*/msg),format.raw/*65.65*/("""
                    """),format.raw/*66.21*/("""</div>
                """)))}),format.raw/*67.18*/("""
                """),_display_(/*68.18*/request/*68.25*/.flash.get("info").map/*68.47*/ { msg =>_display_(Seq[Any](format.raw/*68.56*/("""
                    """),format.raw/*69.21*/("""<div class="col-md-6 col-md-offset-3 alert alert-info">
                        <a href="#" class="close" data-dismiss="alert">&times;</a>
                        <strong>"""),_display_(/*71.34*/messages("info")),format.raw/*71.50*/("""</strong> """),_display_(/*71.61*/msg),format.raw/*71.64*/("""
                    """),format.raw/*72.21*/("""</div>
                """)))}),format.raw/*73.18*/("""
                """),_display_(/*74.18*/request/*74.25*/.flash.get("success").map/*74.50*/ { msg =>_display_(Seq[Any](format.raw/*74.59*/("""
                    """),format.raw/*75.21*/("""<div class="col-md-6 col-md-offset-3 alert alert-success">
                        <a href="#" class="close" data-dismiss="alert">&times;</a>
                        <strong>"""),_display_(/*77.34*/messages("success")),format.raw/*77.53*/("""</strong> """),_display_(/*77.64*/msg),format.raw/*77.67*/("""
                    """),format.raw/*78.21*/("""</div>
                """)))}),format.raw/*79.18*/("""
                """),_display_(/*80.18*/content),format.raw/*80.25*/("""
            """),format.raw/*81.13*/("""</div>
        </main>
        """),_display_(/*83.10*/webJarsUtil/*83.21*/.locate("jquery.min.js").script(CSPNonce.attrMap)),format.raw/*83.70*/("""
        """),_display_(/*84.10*/webJarsUtil/*84.21*/.locate("bootstrap.min.js").script(CSPNonce.attrMap)),format.raw/*84.73*/("""
        """),format.raw/*85.9*/("""<script """),_display_(/*85.18*/{CSPNonce.attr}),format.raw/*85.33*/(""" """),format.raw/*85.34*/("""src="https://cdnjs.cloudflare.com/ajax/libs/zxcvbn/4.2.0/zxcvbn.js"></script>
        <script """),_display_(/*86.18*/{CSPNonce.attr}),format.raw/*86.33*/(""" """),format.raw/*86.34*/("""src=""""),_display_(/*86.40*/assets/*86.46*/.path("javascripts/zxcvbnShim.js")),format.raw/*86.80*/(""""></script>
    </body>
</html>
"""))
      }
    }
  }

  def render(title:String,user:Option[models.User],content:Html,request:RequestHeader,messages:Messages,assets:AssetsFinder,webJarsUtil:WebJarsUtil): play.twirl.api.HtmlFormat.Appendable = apply(title,user)(content)(request,messages,assets,webJarsUtil)

  def f:((String,Option[models.User]) => (Html) => (RequestHeader,Messages,AssetsFinder,WebJarsUtil) => play.twirl.api.HtmlFormat.Appendable) = (title,user) => (content) => (request,messages,assets,webJarsUtil) => apply(title,user)(content)(request,messages,assets,webJarsUtil)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: 2021-01-10T10:31:38.321259
                  SOURCE: /home/sascha/FH/Web-Technologien/silhouette-seed/play-silhouette-seed/app/views/main.scala.html
                  HASH: cfc9c305886992fbc954083ae15b977836707d1b
                  MATRIX: 28->1|65->32|106->67|140->95|183->132|222->165|625->194|884->360|912->361|1211->633|1226->639|1274->666|1320->685|1346->690|1397->714|1433->729|1462->730|1611->852|1647->867|1676->868|1806->971|1826->982|1897->1032|1933->1041|1967->1048|2003->1063|2032->1064|2083->1088|2098->1094|2143->1118|2319->1267|2355->1282|2384->1283|2505->1377|2541->1392|2570->1393|3150->1946|3170->1957|3226->1992|3469->2208|3489->2219|3546->2254|3577->2257|3615->2273|3966->2597|3979->2601|3992->2605|4037->2612|4090->2637|4144->2664|4164->2675|4220->2710|4251->2713|4262->2714|4289->2719|4346->2749|4450->2843|4491->2845|4544->2870|4607->2906|4627->2917|4686->2954|4717->2957|4766->2984|4827->3014|4880->3039|4943->3075|4963->3086|5022->3123|5053->3126|5095->3146|5144->3176|5163->3186|5203->3188|5256->3213|5319->3249|5339->3260|5390->3289|5421->3292|5462->3311|5554->3376|5574->3387|5625->3416|5656->3419|5697->3438|5758->3468|5807->3489|5999->3654|6015->3661|6047->3684|6094->3693|6143->3714|6344->3888|6382->3905|6420->3916|6444->3919|6493->3940|6548->3964|6593->3982|6609->3989|6640->4011|6687->4020|6736->4041|6935->4213|6972->4229|7010->4240|7034->4243|7083->4264|7138->4288|7183->4306|7199->4313|7233->4338|7280->4347|7329->4368|7531->4543|7571->4562|7609->4573|7633->4576|7682->4597|7737->4621|7782->4639|7810->4646|7851->4659|7910->4691|7930->4702|8000->4751|8037->4761|8057->4772|8130->4824|8166->4833|8202->4842|8238->4857|8267->4858|8389->4953|8425->4968|8454->4969|8487->4975|8502->4981|8557->5015
                  LINES: 4->1|5->2|6->3|7->4|8->5|9->6|14->8|19->9|20->10|26->16|26->16|26->16|27->17|27->17|28->18|28->18|28->18|29->19|29->19|29->19|30->20|30->20|30->20|31->21|31->21|31->21|31->21|31->21|31->21|31->21|34->24|34->24|34->24|35->25|35->25|35->25|44->34|44->34|44->34|48->38|48->38|48->38|48->38|48->38|55->45|55->45|55->45|55->45|56->46|56->46|56->46|56->46|56->46|56->46|56->46|57->47|57->47|57->47|58->48|58->48|58->48|58->48|58->48|58->48|59->49|60->50|60->50|60->50|60->50|60->50|60->50|61->51|61->51|61->51|62->52|62->52|62->52|62->52|62->52|62->52|63->53|63->53|63->53|63->53|63->53|64->54|65->55|72->62|72->62|72->62|72->62|73->63|75->65|75->65|75->65|75->65|76->66|77->67|78->68|78->68|78->68|78->68|79->69|81->71|81->71|81->71|81->71|82->72|83->73|84->74|84->74|84->74|84->74|85->75|87->77|87->77|87->77|87->77|88->78|89->79|90->80|90->80|91->81|93->83|93->83|93->83|94->84|94->84|94->84|95->85|95->85|95->85|95->85|96->86|96->86|96->86|96->86|96->86|96->86
                  -- GENERATED --
              */
          