
package views.html

/*1.2*/import play.api.data.Form
/*2.2*/import play.api.i18n.Messages
/*3.2*/import play.api.mvc.RequestHeader
/*4.2*/import org.webjars.play.WebJarsUtil
/*5.2*/import controllers.AssetsFinder
/*6.2*/import com.mohiva.play.silhouette.impl.providers.SocialProviderRegistry
/*7.2*/import forms.SignInForm.Data

/**/
class signIn @javax.inject.Inject() /*9.6*/()(implicit webJarsUtil: WebJarsUtil, assets: AssetsFinder) extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template4[Form[Data],SocialProviderRegistry,RequestHeader,Messages,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*10.2*/(signInForm: Form[Data], socialProviders: SocialProviderRegistry)(implicit request: RequestHeader, messages: Messages):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {

implicit def /*12.2*/implicitFieldConstructor/*12.26*/ = {{ b4.vertical.fieldConstructor() }};
Seq[Any](format.raw/*11.1*/("""
"""),format.raw/*12.64*/("""

"""),_display_(/*14.2*/main(messages("sign.in.title"))/*14.33*/ {_display_(Seq[Any](format.raw/*14.35*/("""
    """),format.raw/*15.5*/("""<fieldset class="col-md-6 col-md-offset-3">
        <legend>"""),_display_(/*16.18*/messages("sign.in.credentials")),format.raw/*16.49*/("""</legend>
        """),_display_(/*17.10*/helper/*17.16*/.form(action = controllers.routes.SignInController.submit())/*17.76*/ {_display_(Seq[Any](format.raw/*17.78*/("""
            """),_display_(/*18.14*/b4/*18.16*/.email(signInForm("email"), Symbol("_hiddenLabel") -> messages("email"), Symbol("placeholder") -> messages("email"), Symbol("class") -> "form-control input-lg")),format.raw/*18.176*/("""
            """),_display_(/*19.14*/b4/*19.16*/.password(signInForm("password"), Symbol("_hiddenLabel") -> messages("password"), Symbol("placeholder") -> messages("password"), Symbol("class") -> "form-control input-lg")),format.raw/*19.188*/("""
            """),_display_(/*20.14*/b4/*20.16*/.checkbox(signInForm("rememberMe"), Symbol("_text") -> messages("remember.me"), Symbol("checked") -> true)),format.raw/*20.122*/("""
            """),format.raw/*21.13*/("""<div class="form-group">
                <div>
                    <button id="submit" type="submit" value="submit" class="btn btn-lg btn-primary btn-block">"""),_display_(/*23.112*/messages("sign.in")),format.raw/*23.131*/("""</button>
                </div>
            </div>
        """)))}),format.raw/*26.10*/("""

        """),format.raw/*28.9*/("""<div>
            <p class="not-a-member">"""),_display_(/*29.38*/messages("not.a.member")),format.raw/*29.62*/(""" """),format.raw/*29.63*/("""<a href=""""),_display_(/*29.73*/controllers/*29.84*/.routes.SignUpController.view),format.raw/*29.113*/("""">"""),_display_(/*29.116*/messages("sign.up.now")),format.raw/*29.139*/("""</a> | <a href=""""),_display_(/*29.156*/controllers/*29.167*/.routes.ForgotPasswordController.view()),format.raw/*29.206*/("""" title=""""),_display_(/*29.216*/messages("forgot.your.password")),format.raw/*29.248*/("""">"""),_display_(/*29.251*/messages("forgot.your.password")),format.raw/*29.283*/("""</a></p>
        </div>

        """),_display_(/*32.10*/if(socialProviders.providers.nonEmpty)/*32.48*/ {_display_(Seq[Any](format.raw/*32.50*/("""
            """),format.raw/*33.13*/("""<div class="social-providers">
                <p>"""),_display_(/*34.21*/messages("or.use.social")),format.raw/*34.46*/("""</p>
                <div>
                """),_display_(/*36.18*/for(p <- socialProviders.providers) yield /*36.53*/ {_display_(Seq[Any](format.raw/*36.55*/("""
                    """),format.raw/*37.21*/("""<a href=""""),_display_(/*37.31*/controllers/*37.42*/.routes.SocialAuthController.authenticate(p.id)),format.raw/*37.89*/("""" class="provider """),_display_(/*37.108*/p/*37.109*/.id),format.raw/*37.112*/("""" title=""""),_display_(/*37.122*/messages(p.id)),format.raw/*37.136*/(""""><img src=""""),_display_(/*37.149*/assets/*37.155*/.path(s"images/providers/${p.id}.png")),format.raw/*37.193*/("""" width="64px" height="64px" alt=""""),_display_(/*37.228*/messages(p.id)),format.raw/*37.242*/(""""></a>
                """)))}),format.raw/*38.18*/("""
                """),format.raw/*39.17*/("""</div>
            </div>
        """)))}),format.raw/*41.10*/("""

    """),format.raw/*43.5*/("""</fieldset>
""")))}),format.raw/*44.2*/("""
"""))
      }
    }
  }

  def render(signInForm:Form[Data],socialProviders:SocialProviderRegistry,request:RequestHeader,messages:Messages): play.twirl.api.HtmlFormat.Appendable = apply(signInForm,socialProviders)(request,messages)

  def f:((Form[Data],SocialProviderRegistry) => (RequestHeader,Messages) => play.twirl.api.HtmlFormat.Appendable) = (signInForm,socialProviders) => (request,messages) => apply(signInForm,socialProviders)(request,messages)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: 2021-01-15T16:01:28.475137
                  SOURCE: /home/sascha/FH/Web-Technologien/de.htwg.wt.gladiators/app/views/signIn.scala.html
                  HASH: 44080519f55bcc7bac7805296dfe350a203d5cce
                  MATRIX: 28->1|61->28|98->59|139->94|182->131|221->164|300->237|378->272|779->333|985->454|1018->478|1086->452|1115->516|1144->519|1184->550|1224->552|1256->557|1344->618|1396->649|1442->668|1457->674|1526->734|1566->736|1607->750|1618->752|1800->912|1841->926|1852->928|2046->1100|2087->1114|2098->1116|2226->1222|2267->1235|2453->1393|2494->1412|2586->1473|2623->1483|2693->1526|2738->1550|2767->1551|2804->1561|2824->1572|2875->1601|2906->1604|2951->1627|2996->1644|3017->1655|3078->1694|3116->1704|3170->1736|3201->1739|3255->1771|3316->1805|3363->1843|3403->1845|3444->1858|3522->1909|3568->1934|3639->1978|3690->2013|3730->2015|3779->2036|3816->2046|3836->2057|3904->2104|3951->2123|3962->2124|3987->2127|4025->2137|4061->2151|4102->2164|4118->2170|4178->2208|4241->2243|4277->2257|4332->2281|4377->2298|4443->2333|4476->2339|4519->2352
                  LINES: 4->1|5->2|6->3|7->4|8->5|9->6|10->7|13->9|16->10|20->12|20->12|21->11|22->12|24->14|24->14|24->14|25->15|26->16|26->16|27->17|27->17|27->17|27->17|28->18|28->18|28->18|29->19|29->19|29->19|30->20|30->20|30->20|31->21|33->23|33->23|36->26|38->28|39->29|39->29|39->29|39->29|39->29|39->29|39->29|39->29|39->29|39->29|39->29|39->29|39->29|39->29|39->29|42->32|42->32|42->32|43->33|44->34|44->34|46->36|46->36|46->36|47->37|47->37|47->37|47->37|47->37|47->37|47->37|47->37|47->37|47->37|47->37|47->37|47->37|47->37|48->38|49->39|51->41|53->43|54->44
                  -- GENERATED --
              */
          