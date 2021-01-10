
package views.html

/*1.2*/import play.api.data.Form
/*2.2*/import play.api.i18n.Messages
/*3.2*/import play.api.mvc.RequestHeader
/*4.2*/import org.webjars.play.WebJarsUtil
/*5.2*/import controllers.AssetsFinder
/*6.2*/import b4.inline.fieldConstructor

/**/
class changePassword @javax.inject.Inject() /*8.6*/()(implicit webJarsUtil: WebJarsUtil, assets: AssetsFinder) extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template4[Form[scala.Tuple2[String, String]],models.User,RequestHeader,Messages,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*9.2*/(changePasswordForm: Form[(String, String)], user: models.User)(implicit request: RequestHeader, messages: Messages):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {

implicit def /*11.2*/implicitFieldConstructor/*11.26*/ = {{ b4.vertical.fieldConstructor() }};
Seq[Any](format.raw/*10.1*/("""
"""),format.raw/*11.64*/("""

"""),_display_(/*13.2*/main(messages("change.password.title"), Some(user))/*13.53*/ {_display_(Seq[Any](format.raw/*13.55*/("""
    """),format.raw/*14.5*/("""<fieldset class="col-md-6 col-md-offset-3">
        <legend>"""),_display_(/*15.18*/messages("change.password")),format.raw/*15.45*/("""</legend>
        """),_display_(/*16.10*/helper/*16.16*/.form(action = controllers.routes.ChangePasswordController.submit, Symbol("autocomplete") -> "off")/*16.115*/ {_display_(Seq[Any](format.raw/*16.117*/("""
            """),format.raw/*17.13*/("""<p class="info">"""),_display_(/*17.30*/messages("strong.password.info")),format.raw/*17.62*/("""</p>
            """),_display_(/*18.14*/helper/*18.20*/.CSRF.formField),format.raw/*18.35*/("""
            """),_display_(/*19.14*/b4/*19.16*/.password(changePasswordForm("current-password"), Symbol("_hiddenLabel") -> messages("current.password"), Symbol("placeholder") -> messages("current.password"), Symbol("class") -> "form-control input-lg")),format.raw/*19.220*/("""
            """),_display_(/*20.14*/passwordStrength(changePasswordForm("new-password"), Symbol("_hiddenLabel") -> messages("new.password"), Symbol("placeholder") -> messages("new.password"), Symbol("class") -> "form-control input-lg")),format.raw/*20.213*/("""
            """),format.raw/*21.13*/("""<div class="form-group">
                <div>
                    <button id="submit" type="submit" value="submit" class="btn btn-lg btn-primary btn-block">"""),_display_(/*23.112*/messages("change")),format.raw/*23.130*/("""</button>
                </div>
            </div>
        """)))}),format.raw/*26.10*/("""
    """),format.raw/*27.5*/("""</fieldset>
""")))}),format.raw/*28.2*/("""
"""))
      }
    }
  }

  def render(changePasswordForm:Form[scala.Tuple2[String, String]],user:models.User,request:RequestHeader,messages:Messages): play.twirl.api.HtmlFormat.Appendable = apply(changePasswordForm,user)(request,messages)

  def f:((Form[scala.Tuple2[String, String]],models.User) => (RequestHeader,Messages) => play.twirl.api.HtmlFormat.Appendable) = (changePasswordForm,user) => (request,messages) => apply(changePasswordForm,user)(request,messages)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: 2021-01-10T11:18:33.485049
                  SOURCE: /home/sascha/FH/Web-Technologien/de.htwg.wt.gladiators/app/views/changePassword.scala.html
                  HASH: c0f9e6ccd40e1c1a2466dc046856af746a0b8735
                  MATRIX: 28->1|61->28|98->59|139->94|182->131|221->164|312->204|725->265|929->384|962->408|1030->382|1059->446|1088->449|1148->500|1188->502|1220->507|1308->568|1356->595|1402->614|1417->620|1526->719|1567->721|1608->734|1652->751|1705->783|1750->801|1765->807|1801->822|1842->836|1853->838|2079->1042|2120->1056|2341->1255|2382->1268|2568->1426|2608->1444|2700->1505|2732->1510|2775->1523
                  LINES: 4->1|5->2|6->3|7->4|8->5|9->6|12->8|15->9|19->11|19->11|20->10|21->11|23->13|23->13|23->13|24->14|25->15|25->15|26->16|26->16|26->16|26->16|27->17|27->17|27->17|28->18|28->18|28->18|29->19|29->19|29->19|30->20|30->20|31->21|33->23|33->23|36->26|37->27|38->28
                  -- GENERATED --
              */
          