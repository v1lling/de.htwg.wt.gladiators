
package views.html

/*1.2*/import play.api.data.Form
/*2.2*/import play.api.i18n.Messages
/*3.2*/import play.api.mvc.RequestHeader
/*4.2*/import org.webjars.play.WebJarsUtil
/*5.2*/import controllers.AssetsFinder

/**/
class forgotPassword @javax.inject.Inject() /*7.6*/()(implicit webJarsUtil: WebJarsUtil, assets: AssetsFinder) extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template3[Form[String],RequestHeader,Messages,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*8.2*/(forgotPasswordForm: Form[String])(implicit request: RequestHeader, messages: Messages):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {

implicit def /*10.2*/implicitFieldConstructor/*10.26*/ = {{ b4.vertical.fieldConstructor() }};
Seq[Any](format.raw/*9.1*/("""
"""),format.raw/*10.64*/("""

"""),_display_(/*12.2*/main(messages("forgot.password.title"))/*12.41*/ {_display_(Seq[Any](format.raw/*12.43*/("""
    """),format.raw/*13.5*/("""<fieldset class="col-md-6 col-md-offset-3">
        <legend>"""),_display_(/*14.18*/messages("forgot.password")),format.raw/*14.45*/("""</legend>
        """),_display_(/*15.10*/helper/*15.16*/.form(action = controllers.routes.ForgotPasswordController.submit(), Symbol("autocomplete") -> "off")/*15.117*/ {_display_(Seq[Any](format.raw/*15.119*/("""
            """),format.raw/*16.13*/("""<p class="info">"""),_display_(/*16.30*/messages("forgot.password.info")),format.raw/*16.62*/("""</p>
            """),_display_(/*17.14*/helper/*17.20*/.CSRF.formField),format.raw/*17.35*/("""
            """),_display_(/*18.14*/b4/*18.16*/.text(forgotPasswordForm("email"), Symbol("_hiddenLabel") -> messages("email"), Symbol("placeholder") -> messages("email"), Symbol("class") -> "form-control input-lg")),format.raw/*18.183*/("""
            """),format.raw/*19.13*/("""<div class="form-group">
                <div>
                    <button id="submit" type="submit" value="submit" class="btn btn-lg btn-primary btn-block">"""),_display_(/*21.112*/messages("send")),format.raw/*21.128*/("""</button>
                </div>
            </div>
        """)))}),format.raw/*24.10*/("""
    """),format.raw/*25.5*/("""</fieldset>
""")))}),format.raw/*26.2*/("""
"""))
      }
    }
  }

  def render(forgotPasswordForm:Form[String],request:RequestHeader,messages:Messages): play.twirl.api.HtmlFormat.Appendable = apply(forgotPasswordForm)(request,messages)

  def f:((Form[String]) => (RequestHeader,Messages) => play.twirl.api.HtmlFormat.Appendable) = (forgotPasswordForm) => (request,messages) => apply(forgotPasswordForm)(request,messages)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: 2021-01-10T10:31:38.500569
                  SOURCE: /home/sascha/FH/Web-Technologien/silhouette-seed/play-silhouette-seed/app/views/forgotPassword.scala.html
                  HASH: 0f3564a87826e328fe403fa53dab82b44dac566a
                  MATRIX: 28->1|61->28|98->59|139->94|182->131|271->169|650->230|825->320|858->344|925->318|954->382|983->385|1031->424|1071->426|1103->431|1191->492|1239->519|1285->538|1300->544|1411->645|1452->647|1493->660|1537->677|1590->709|1635->727|1650->733|1686->748|1727->762|1738->764|1927->931|1968->944|2154->1102|2192->1118|2284->1179|2316->1184|2359->1197
                  LINES: 4->1|5->2|6->3|7->4|8->5|11->7|14->8|18->10|18->10|19->9|20->10|22->12|22->12|22->12|23->13|24->14|24->14|25->15|25->15|25->15|25->15|26->16|26->16|26->16|27->17|27->17|27->17|28->18|28->18|28->18|29->19|31->21|31->21|34->24|35->25|36->26
                  -- GENERATED --
              */
          