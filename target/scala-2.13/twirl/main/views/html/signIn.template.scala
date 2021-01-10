
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
            """),_display_(/*18.14*/helper/*18.20*/.CSRF.formField),format.raw/*18.35*/("""
            """),_display_(/*19.14*/b4/*19.16*/.email(signInForm("email"), Symbol("_hiddenLabel") -> messages("email"), Symbol("placeholder") -> messages("email"), Symbol("class") -> "form-control input-lg")),format.raw/*19.176*/("""
            """),_display_(/*20.14*/b4/*20.16*/.password(signInForm("password"), Symbol("_hiddenLabel") -> messages("password"), Symbol("placeholder") -> messages("password"), Symbol("class") -> "form-control input-lg")),format.raw/*20.188*/("""
            """),_display_(/*21.14*/b4/*21.16*/.checkbox(signInForm("rememberMe"), Symbol("_text") -> messages("remember.me"), Symbol("checked") -> true)),format.raw/*21.122*/("""
            """),format.raw/*22.13*/("""<div class="form-group">
                <div>
                    <button id="submit" type="submit" value="submit" class="btn btn-lg btn-primary btn-block">"""),_display_(/*24.112*/messages("sign.in")),format.raw/*24.131*/("""</button>
                </div>
            </div>
        """)))}),format.raw/*27.10*/("""

        """),format.raw/*29.9*/("""<div>
            <p class="not-a-member">"""),_display_(/*30.38*/messages("not.a.member")),format.raw/*30.62*/(""" """),format.raw/*30.63*/("""<a href=""""),_display_(/*30.73*/controllers/*30.84*/.routes.SignUpController.view),format.raw/*30.113*/("""">"""),_display_(/*30.116*/messages("sign.up.now")),format.raw/*30.139*/("""</a> | <a href=""""),_display_(/*30.156*/controllers/*30.167*/.routes.ForgotPasswordController.view()),format.raw/*30.206*/("""" title=""""),_display_(/*30.216*/messages("forgot.your.password")),format.raw/*30.248*/("""">"""),_display_(/*30.251*/messages("forgot.your.password")),format.raw/*30.283*/("""</a></p>
        </div>

        """),_display_(/*33.10*/if(socialProviders.providers.nonEmpty)/*33.48*/ {_display_(Seq[Any](format.raw/*33.50*/("""
            """),format.raw/*34.13*/("""<div class="social-providers">
                <p>"""),_display_(/*35.21*/messages("or.use.social")),format.raw/*35.46*/("""</p>
                <div>
                """),_display_(/*37.18*/for(p <- socialProviders.providers) yield /*37.53*/ {_display_(Seq[Any](format.raw/*37.55*/("""
                    """),format.raw/*38.21*/("""<a href=""""),_display_(/*38.31*/controllers/*38.42*/.routes.SocialAuthController.authenticate(p.id)),format.raw/*38.89*/("""" class="provider """),_display_(/*38.108*/p/*38.109*/.id),format.raw/*38.112*/("""" title=""""),_display_(/*38.122*/messages(p.id)),format.raw/*38.136*/(""""><img src=""""),_display_(/*38.149*/assets/*38.155*/.path(s"images/providers/${p.id}.png")),format.raw/*38.193*/("""" width="64px" height="64px" alt=""""),_display_(/*38.228*/messages(p.id)),format.raw/*38.242*/(""""></a>
                """)))}),format.raw/*39.18*/("""
                """),format.raw/*40.17*/("""</div>
            </div>
        """)))}),format.raw/*42.10*/("""

    """),format.raw/*44.5*/("""</fieldset>
""")))}),format.raw/*45.2*/("""
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
                  DATE: 2021-01-10T10:27:59.562125
                  SOURCE: /home/sascha/FH/Web-Technologien/silhouette-seed/play-silhouette-seed/app/views/signIn.scala.html
                  HASH: fa42858f2e279f16cc42f2926db68c3eb987a4f8
                  MATRIX: 28->1|61->28|98->59|139->94|182->131|221->164|300->237|378->272|779->333|985->454|1018->478|1086->452|1115->516|1144->519|1184->550|1224->552|1256->557|1344->618|1396->649|1442->668|1457->674|1526->734|1566->736|1607->750|1622->756|1658->771|1699->785|1710->787|1892->947|1933->961|1944->963|2138->1135|2179->1149|2190->1151|2318->1257|2359->1270|2545->1428|2586->1447|2678->1508|2715->1518|2785->1561|2830->1585|2859->1586|2896->1596|2916->1607|2967->1636|2998->1639|3043->1662|3088->1679|3109->1690|3170->1729|3208->1739|3262->1771|3293->1774|3347->1806|3408->1840|3455->1878|3495->1880|3536->1893|3614->1944|3660->1969|3731->2013|3782->2048|3822->2050|3871->2071|3908->2081|3928->2092|3996->2139|4043->2158|4054->2159|4079->2162|4117->2172|4153->2186|4194->2199|4210->2205|4270->2243|4333->2278|4369->2292|4424->2316|4469->2333|4535->2368|4568->2374|4611->2387
                  LINES: 4->1|5->2|6->3|7->4|8->5|9->6|10->7|13->9|16->10|20->12|20->12|21->11|22->12|24->14|24->14|24->14|25->15|26->16|26->16|27->17|27->17|27->17|27->17|28->18|28->18|28->18|29->19|29->19|29->19|30->20|30->20|30->20|31->21|31->21|31->21|32->22|34->24|34->24|37->27|39->29|40->30|40->30|40->30|40->30|40->30|40->30|40->30|40->30|40->30|40->30|40->30|40->30|40->30|40->30|40->30|43->33|43->33|43->33|44->34|45->35|45->35|47->37|47->37|47->37|48->38|48->38|48->38|48->38|48->38|48->38|48->38|48->38|48->38|48->38|48->38|48->38|48->38|48->38|49->39|50->40|52->42|54->44|55->45
                  -- GENERATED --
              */
          