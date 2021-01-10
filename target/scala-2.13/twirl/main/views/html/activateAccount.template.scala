
package views.html

/*1.2*/import play.api.i18n.Messages
/*2.2*/import play.api.mvc.RequestHeader
/*3.2*/import play.twirl.api.Html
/*4.2*/import org.webjars.play.WebJarsUtil
/*5.2*/import controllers.AssetsFinder

/**/
class activateAccount @javax.inject.Inject() /*7.6*/()(implicit webJarsUtil: WebJarsUtil, assets: AssetsFinder) extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template3[String,RequestHeader,Messages,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*8.2*/(email: String)(implicit request: RequestHeader, messages: Messages):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*9.1*/("""
"""),_display_(/*10.2*/main(messages("activate.account.title"))/*10.42*/ {_display_(Seq[Any](format.raw/*10.44*/("""
    """),format.raw/*11.5*/("""<fieldset class="col-md-6 col-md-offset-3">
        <legend>"""),_display_(/*12.18*/messages("activate.account")),format.raw/*12.46*/("""</legend>
        <div class="info">
            <p>"""),_display_(/*14.17*/messages("activate.account.text1")),format.raw/*14.51*/("""</p>
            <p><b>"""),_display_(/*15.20*/email),format.raw/*15.25*/("""</b></p>
            <p>"""),_display_(/*16.17*/messages("activate.account.text2")),format.raw/*16.51*/("""</p>
            <p>"""),_display_(/*17.17*/Html(messages("activate.account.text3", controllers.routes.ActivateAccountController.send(helper.urlEncode(email))))),format.raw/*17.133*/("""</p>
        </div>
    </fieldset>
""")))}),format.raw/*20.2*/("""
"""))
      }
    }
  }

  def render(email:String,request:RequestHeader,messages:Messages): play.twirl.api.HtmlFormat.Appendable = apply(email)(request,messages)

  def f:((String) => (RequestHeader,Messages) => play.twirl.api.HtmlFormat.Appendable) = (email) => (request,messages) => apply(email)(request,messages)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: 2021-01-10T10:27:59.371926
                  SOURCE: /home/sascha/FH/Web-Technologien/silhouette-seed/play-silhouette-seed/app/views/activateAccount.scala.html
                  HASH: f3ffbf1f0cb9aeebc245325d6a5ec90573a6f96f
                  MATRIX: 28->1|65->32|106->67|140->95|183->132|273->170|646->231|808->300|836->302|885->342|925->344|957->349|1045->410|1094->438|1174->491|1229->525|1280->549|1306->554|1358->579|1413->613|1461->634|1599->750|1666->787
                  LINES: 4->1|5->2|6->3|7->4|8->5|11->7|14->8|19->9|20->10|20->10|20->10|21->11|22->12|22->12|24->14|24->14|25->15|25->15|26->16|26->16|27->17|27->17|30->20
                  -- GENERATED --
              */
          