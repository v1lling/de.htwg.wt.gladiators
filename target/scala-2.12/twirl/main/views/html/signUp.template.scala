
package views.html

/*1.2*/import play.api.data.Form
/*2.2*/import play.api.i18n.Messages
/*3.2*/import play.api.mvc.RequestHeader
/*4.2*/import org.webjars.play.WebJarsUtil
/*5.2*/import controllers.AssetsFinder
/*6.2*/import forms.SignUpForm.Data

/**/
class signUp @javax.inject.Inject() /*8.6*/()(implicit webJarsUtil: WebJarsUtil, assets: AssetsFinder) extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template3[Form[Data],RequestHeader,Messages,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*9.2*/(signUpForm: Form[Data])(implicit request: RequestHeader, messages: Messages):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {

implicit def /*11.2*/implicitFieldConstructor/*11.26*/ = {{ b4.vertical.fieldConstructor() }};
Seq[Any](format.raw/*10.1*/("""
"""),format.raw/*11.64*/("""

"""),_display_(/*13.2*/main(messages("sign.up.title"))/*13.33*/ {_display_(Seq[Any](format.raw/*13.35*/("""
    """),format.raw/*14.5*/("""<fieldset class="col-md-6 col-md-offset-3">
        <legend>"""),_display_(/*15.18*/messages("sign.up.account")),format.raw/*15.45*/("""</legend>
        """),_display_(/*16.10*/helper/*16.16*/.form(action = controllers.routes.SignUpController.submit())/*16.76*/ {_display_(Seq[Any](format.raw/*16.78*/("""
            """),_display_(/*17.14*/helper/*17.20*/.CSRF.formField),format.raw/*17.35*/("""
            """),_display_(/*18.14*/b4/*18.16*/.text(signUpForm("firstName"), Symbol("_hiddenLabel") -> messages("first.name"), Symbol("placeholder") -> messages("first.name"), Symbol("class") -> "form-control input-lg")),format.raw/*18.189*/("""
            """),_display_(/*19.14*/b4/*19.16*/.text(signUpForm("lastName"), Symbol("_hiddenLabel") -> messages("last.name"), Symbol("placeholder") -> messages("last.name"), Symbol("class") -> "form-control input-lg")),format.raw/*19.186*/("""
            """),_display_(/*20.14*/b4/*20.16*/.text(signUpForm("email"), Symbol("_hiddenLabel") -> messages("email"), Symbol("placeholder") -> messages("email"), Symbol("class") -> "form-control input-lg")),format.raw/*20.175*/("""
            """),_display_(/*21.14*/passwordStrength(signUpForm("password"), Symbol("_hiddenLabel") -> messages("password"), Symbol("placeholder") -> messages("password"), Symbol("class") -> "form-control input-lg")),format.raw/*21.193*/("""
            """),format.raw/*22.13*/("""<div class="form-group">
                <div>
                    <button id="submit" type="submit" value="submit" class="btn btn-lg btn-primary btn-block">"""),_display_(/*24.112*/messages("sign.up")),format.raw/*24.131*/("""</button>
                </div>
            </div>
            <div class="sign-in-now">
                <p>"""),_display_(/*28.21*/messages("already.a.member")),format.raw/*28.49*/(""" """),format.raw/*28.50*/("""<a href=""""),_display_(/*28.60*/controllers/*28.71*/.routes.SignInController.view),format.raw/*28.100*/("""">"""),_display_(/*28.103*/messages("sign.in.now")),format.raw/*28.126*/("""</a></p>
            </div>
        """)))}),format.raw/*30.10*/("""
    """),format.raw/*31.5*/("""</fieldset>
""")))}),format.raw/*32.2*/("""
"""))
      }
    }
  }

  def render(signUpForm:Form[Data],request:RequestHeader,messages:Messages): play.twirl.api.HtmlFormat.Appendable = apply(signUpForm)(request,messages)

  def f:((Form[Data]) => (RequestHeader,Messages) => play.twirl.api.HtmlFormat.Appendable) = (signUpForm) => (request,messages) => apply(signUpForm)(request,messages)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: 2021-01-10T10:31:38.271230
                  SOURCE: /home/sascha/FH/Web-Technologien/silhouette-seed/play-silhouette-seed/app/views/signUp.scala.html
                  HASH: db264a567d6f9a6221266439851c7a66192997b8
                  MATRIX: 28->1|61->28|98->59|139->94|182->131|221->164|299->199|676->260|841->340|874->364|942->338|971->402|1000->405|1040->436|1080->438|1112->443|1200->504|1248->531|1294->550|1309->556|1378->616|1418->618|1459->632|1474->638|1510->653|1551->667|1562->669|1757->842|1798->856|1809->858|2001->1028|2042->1042|2053->1044|2234->1203|2275->1217|2476->1396|2517->1409|2703->1567|2744->1586|2881->1696|2930->1724|2959->1725|2996->1735|3016->1746|3067->1775|3098->1778|3143->1801|3211->1838|3243->1843|3286->1856
                  LINES: 4->1|5->2|6->3|7->4|8->5|9->6|12->8|15->9|19->11|19->11|20->10|21->11|23->13|23->13|23->13|24->14|25->15|25->15|26->16|26->16|26->16|26->16|27->17|27->17|27->17|28->18|28->18|28->18|29->19|29->19|29->19|30->20|30->20|30->20|31->21|31->21|32->22|34->24|34->24|38->28|38->28|38->28|38->28|38->28|38->28|38->28|38->28|40->30|41->31|42->32
                  -- GENERATED --
              */
          