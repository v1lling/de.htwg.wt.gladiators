
package views.html

/*1.2*/import play.api.data.Form
/*2.2*/import play.api.i18n.Messages
/*3.2*/import play.api.mvc.RequestHeader
/*4.2*/import org.webjars.play.WebJarsUtil
/*5.2*/import controllers.AssetsFinder
/*6.2*/import forms.TotpForm.Data
/*7.2*/import forms.TotpRecoveryForm
/*8.2*/import java.util.UUID

/**/
class totp @javax.inject.Inject() /*10.6*/()(implicit webJarsUtil: WebJarsUtil, assets: AssetsFinder) extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template3[Form[Data],RequestHeader,Messages,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*11.2*/(totpForm: Form[Data])(implicit request: RequestHeader, messages: Messages):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {

implicit def /*13.2*/implicitFieldConstructor/*13.26*/ = {{ b4.vertical.fieldConstructor() }};
Seq[Any](format.raw/*12.1*/("""
"""),format.raw/*13.64*/("""

"""),_display_(/*15.2*/main(messages("sign.in.title"))/*15.33*/ {_display_(Seq[Any](format.raw/*15.35*/("""
    """),format.raw/*16.5*/("""<fieldset class="col-md-6 col-md-offset-3">
        <legend>"""),_display_(/*17.18*/messages("sign.in.totp")),format.raw/*17.42*/("""</legend>
        """),_display_(/*18.10*/helper/*18.16*/.form(action = controllers.routes.TotpController.submit())/*18.74*/ {_display_(Seq[Any](format.raw/*18.76*/("""
            """),_display_(/*19.14*/helper/*19.20*/.CSRF.formField),format.raw/*19.35*/("""
            """),_display_(/*20.14*/b4/*20.16*/.text(totpForm("verificationCode"), Symbol("_hiddenLabel") -> messages("totp.verification.code"), Symbol("placeholder") -> messages("totp.verification.code"), Symbol("autocomplete") -> "off", Symbol("class") -> "form-control input-lg")),format.raw/*20.251*/("""
            """),_display_(/*21.14*/b4/*21.16*/.hidden(totpForm("userID"))),format.raw/*21.43*/("""
            """),_display_(/*22.14*/b4/*22.16*/.hidden(totpForm("sharedKey"))),format.raw/*22.46*/("""
            """),_display_(/*23.14*/b4/*23.16*/.hidden(totpForm("rememberMe"))),format.raw/*23.47*/("""
            """),format.raw/*24.13*/("""<div class="form-group">
                <div>
                    <button id="submit" type="submit" value="submit" class="btn btn-lg btn-primary btn-block">"""),_display_(/*26.112*/messages("totp.verify")),format.raw/*26.135*/("""</button>
                </div>
            </div>
        """)))}),format.raw/*29.10*/("""

        """),_display_(/*31.10*/messages("totp.open.the.app.for.2fa")),format.raw/*31.47*/("""
        """),format.raw/*32.9*/("""<div>
            <p class="enter-recovery-code">"""),_display_(/*33.45*/messages("totp.dont.have.your.phone")),format.raw/*33.82*/(""" """),format.raw/*33.83*/("""<a href=""""),_display_(/*33.93*/controllers/*33.104*/.routes.TotpRecoveryController.view(UUID.fromString(totpForm("userID").value.get), totpForm("sharedKey").value.get, totpForm("rememberMe").value.get.toBoolean)),format.raw/*33.263*/("""">"""),_display_(/*33.266*/messages("totp.use.recovery.code")),format.raw/*33.300*/("""</a></p>
        </div>
    </fieldset>
""")))}),format.raw/*36.2*/("""
"""))
      }
    }
  }

  def render(totpForm:Form[Data],request:RequestHeader,messages:Messages): play.twirl.api.HtmlFormat.Appendable = apply(totpForm)(request,messages)

  def f:((Form[Data]) => (RequestHeader,Messages) => play.twirl.api.HtmlFormat.Appendable) = (totpForm) => (request,messages) => apply(totpForm)(request,messages)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: 2021-01-10T10:27:59.529529
                  SOURCE: /home/sascha/FH/Web-Technologien/silhouette-seed/play-silhouette-seed/app/views/totp.scala.html
                  HASH: 426f6856c4b0653670a3c63c771b86ab4d6e8eb2
                  MATRIX: 28->1|61->28|98->59|139->94|182->131|221->164|255->192|292->223|362->251|740->312|903->390|936->414|1004->388|1033->452|1062->455|1102->486|1142->488|1174->493|1262->554|1307->578|1353->597|1368->603|1435->661|1475->663|1516->677|1531->683|1567->698|1608->712|1619->714|1876->949|1917->963|1928->965|1976->992|2017->1006|2028->1008|2079->1038|2120->1052|2131->1054|2183->1085|2224->1098|2410->1256|2455->1279|2547->1340|2585->1351|2643->1388|2679->1397|2756->1447|2814->1484|2843->1485|2880->1495|2901->1506|3082->1665|3113->1668|3169->1702|3240->1743
                  LINES: 4->1|5->2|6->3|7->4|8->5|9->6|10->7|11->8|14->10|17->11|21->13|21->13|22->12|23->13|25->15|25->15|25->15|26->16|27->17|27->17|28->18|28->18|28->18|28->18|29->19|29->19|29->19|30->20|30->20|30->20|31->21|31->21|31->21|32->22|32->22|32->22|33->23|33->23|33->23|34->24|36->26|36->26|39->29|41->31|41->31|42->32|43->33|43->33|43->33|43->33|43->33|43->33|43->33|43->33|46->36
                  -- GENERATED --
              */
          