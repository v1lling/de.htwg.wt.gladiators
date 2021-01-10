
package views.html

/*1.2*/import play.api.data.Form
/*2.2*/import play.api.i18n.Messages
/*3.2*/import play.api.mvc.RequestHeader
/*4.2*/import org.webjars.play.WebJarsUtil
/*5.2*/import controllers.AssetsFinder
/*6.2*/import java.util.UUID

/**/
class resetPassword @javax.inject.Inject() /*8.6*/()(implicit webJarsUtil: WebJarsUtil, assets: AssetsFinder) extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template4[Form[String],UUID,RequestHeader,Messages,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*9.2*/(form: Form[String], token: UUID)(implicit request: RequestHeader, messages: Messages):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*10.1*/("""
"""),_display_(/*11.2*/main(messages("reset.password.title"))/*11.40*/ {_display_(Seq[Any](format.raw/*11.42*/("""
    """),format.raw/*12.5*/("""<fieldset class="col-md-6 col-md-offset-3">
        <legend>"""),_display_(/*13.18*/messages("reset.password")),format.raw/*13.44*/("""</legend>
        """),_display_(/*14.10*/helper/*14.16*/.form(action = controllers.routes.ResetPasswordController.submit(token), Symbol("autocomplete") -> "off")/*14.121*/ {_display_(Seq[Any](format.raw/*14.123*/("""
            """),format.raw/*15.13*/("""<p class="info">"""),_display_(/*15.30*/messages("strong.password.info")),format.raw/*15.62*/("""</p>
            """),_display_(/*16.14*/helper/*16.20*/.CSRF.formField),format.raw/*16.35*/("""
            """),_display_(/*17.14*/passwordStrength(form("password"), Symbol("_hiddenLabel") -> messages("password"), Symbol("placeholder") -> messages("password"), Symbol("class") -> "form-control input-lg")),format.raw/*17.187*/("""
            """),format.raw/*18.13*/("""<div class="form-group">
                <div>
                    <button id="submit" type="submit" value="submit" class="btn btn-lg btn-primary btn-block">"""),_display_(/*20.112*/messages("reset")),format.raw/*20.129*/("""</button>
                </div>
            </div>
        """)))}),format.raw/*23.10*/("""
    """),format.raw/*24.5*/("""</fieldset>
""")))}),format.raw/*25.2*/("""
"""))
      }
    }
  }

  def render(form:Form[String],token:UUID,request:RequestHeader,messages:Messages): play.twirl.api.HtmlFormat.Appendable = apply(form,token)(request,messages)

  def f:((Form[String],UUID) => (RequestHeader,Messages) => play.twirl.api.HtmlFormat.Appendable) = (form,token) => (request,messages) => apply(form,token)(request,messages)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: 2021-01-10T10:31:38.457426
                  SOURCE: /home/sascha/FH/Web-Technologien/silhouette-seed/play-silhouette-seed/app/views/resetPassword.scala.html
                  HASH: 4dfb26dd2430b28e6fa5c6629fd91424150f463a
                  MATRIX: 28->1|61->28|98->59|139->94|182->131|221->164|299->192|683->253|864->340|892->342|939->380|979->382|1011->387|1099->448|1146->474|1192->493|1207->499|1322->604|1363->606|1404->619|1448->636|1501->668|1546->686|1561->692|1597->707|1638->721|1833->894|1874->907|2060->1065|2099->1082|2191->1143|2223->1148|2266->1161
                  LINES: 4->1|5->2|6->3|7->4|8->5|9->6|12->8|15->9|20->10|21->11|21->11|21->11|22->12|23->13|23->13|24->14|24->14|24->14|24->14|25->15|25->15|25->15|26->16|26->16|26->16|27->17|27->17|28->18|30->20|30->20|33->23|34->24|35->25
                  -- GENERATED --
              */
          