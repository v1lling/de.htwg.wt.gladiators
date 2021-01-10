
package views.html

/*1.2*/import play.api.data.Form
/*2.2*/import play.api.i18n.Messages
/*3.2*/import play.api.mvc.RequestHeader
/*4.2*/import org.webjars.play.WebJarsUtil
/*5.2*/import controllers.AssetsFinder
/*6.2*/import forms.TotpRecoveryForm.Data

/**/
class totpRecovery @javax.inject.Inject() /*8.6*/()(implicit webJarsUtil: WebJarsUtil, assets: AssetsFinder) extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template3[Form[Data],RequestHeader,Messages,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*9.2*/(totpRecoveryForm: Form[Data])(implicit request: RequestHeader, messages: Messages):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {

implicit def /*11.6*/implicitFieldConstructor/*11.30*/ = {{
        b4.vertical.fieldConstructor()
    }};
Seq[Any](format.raw/*10.1*/("""
    """),format.raw/*13.6*/("""

    """),_display_(/*15.6*/main(messages("sign.in.title"))/*15.37*/ {_display_(Seq[Any](format.raw/*15.39*/("""
        """),format.raw/*16.9*/("""<fieldset class="col-md-6 col-md-offset-3">
            <legend>"""),_display_(/*17.22*/messages("sign.in.totp.recovery")),format.raw/*17.55*/("""</legend>
            """),_display_(/*18.14*/helper/*18.20*/.form(action = controllers.routes.TotpRecoveryController.submit())/*18.86*/ {_display_(Seq[Any](format.raw/*18.88*/("""
                """),_display_(/*19.18*/helper/*19.24*/.CSRF.formField),format.raw/*19.39*/("""
                """),_display_(/*20.18*/b4/*20.20*/.text(totpRecoveryForm("recoveryCode"), Symbol("_hiddenLabel") -> messages("totp.recovery.code"), Symbol("placeholder") -> messages("totp.recovery.code"), Symbol("autocomplete") -> "off", Symbol("class") -> "form-control input-lg")),format.raw/*20.251*/("""
                """),_display_(/*21.18*/b4/*21.20*/.hidden(totpRecoveryForm("userID"))),format.raw/*21.55*/("""
                """),_display_(/*22.18*/b4/*22.20*/.hidden(totpRecoveryForm("sharedKey"))),format.raw/*22.58*/("""
                """),_display_(/*23.18*/b4/*23.20*/.hidden(totpRecoveryForm("rememberMe"))),format.raw/*23.59*/("""
                """),format.raw/*24.17*/("""<div class="form-group">
                    <div>
                        <button id="submit" type="submit" value="submit" class="btn btn-lg btn-primary btn-block">"""),_display_(/*26.116*/messages("totp.verify")),format.raw/*26.139*/("""</button>
                    </div>
                </div>
            """)))}),format.raw/*29.14*/("""

            """),format.raw/*31.13*/("""<div>
                <p class="enter-recovery-code">"""),_display_(/*32.49*/messages("totp.lost.your.recovery.codes")),format.raw/*32.90*/(""" """),format.raw/*32.91*/("""<a href="#">"""),_display_(/*32.104*/messages("totp.contact.support")),format.raw/*32.136*/("""</a></p>
            </div>
        </fieldset>
    """)))}),format.raw/*35.6*/("""
"""))
      }
    }
  }

  def render(totpRecoveryForm:Form[Data],request:RequestHeader,messages:Messages): play.twirl.api.HtmlFormat.Appendable = apply(totpRecoveryForm)(request,messages)

  def f:((Form[Data]) => (RequestHeader,Messages) => play.twirl.api.HtmlFormat.Appendable) = (totpRecoveryForm) => (request,messages) => apply(totpRecoveryForm)(request,messages)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: 2021-01-10T10:27:59.408189
                  SOURCE: /home/sascha/FH/Web-Technologien/silhouette-seed/play-silhouette-seed/app/views/totpRecovery.scala.html
                  HASH: adf771ba5cdafb66c3f0f34b903d84e13fa9b9a2
                  MATRIX: 28->1|61->28|98->59|139->94|182->131|221->164|311->205|688->266|859->356|892->380|972->350|1004->430|1037->437|1077->468|1117->470|1153->479|1245->544|1299->577|1349->600|1364->606|1439->672|1479->674|1524->692|1539->698|1575->713|1620->731|1631->733|1884->964|1929->982|1940->984|1996->1019|2041->1037|2052->1039|2111->1077|2156->1095|2167->1097|2227->1136|2272->1153|2466->1319|2511->1342|2615->1415|2657->1429|2738->1483|2800->1524|2829->1525|2870->1538|2924->1570|3007->1623
                  LINES: 4->1|5->2|6->3|7->4|8->5|9->6|12->8|15->9|19->11|19->11|22->10|23->13|25->15|25->15|25->15|26->16|27->17|27->17|28->18|28->18|28->18|28->18|29->19|29->19|29->19|30->20|30->20|30->20|31->21|31->21|31->21|32->22|32->22|32->22|33->23|33->23|33->23|34->24|36->26|36->26|39->29|41->31|42->32|42->32|42->32|42->32|42->32|45->35
                  -- GENERATED --
              */
          