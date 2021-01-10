
package views.html.emails

/*1.2*/import play.api.i18n.Messages
/*2.2*/import play.twirl.api.Html

object alreadySignedUp extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template3[models.User,String,Messages,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*4.2*/(user: models.User, url: String)(implicit messages: Messages):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*5.1*/("""
"""),format.raw/*6.1*/("""<html>
    <body>
        <p>"""),_display_(/*8.13*/messages("email.already.signed.up.hello", user.name.getOrElse("user"))),format.raw/*8.83*/("""</p>
        <p>"""),_display_(/*9.13*/Html(messages("email.already.signed.up.html.text", url))),format.raw/*9.69*/("""</p>
    </body>
</html>
"""))
      }
    }
  }

  def render(user:models.User,url:String,messages:Messages): play.twirl.api.HtmlFormat.Appendable = apply(user,url)(messages)

  def f:((models.User,String) => (Messages) => play.twirl.api.HtmlFormat.Appendable) = (user,url) => (messages) => apply(user,url)(messages)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: 2021-01-10T10:31:38.331739
                  SOURCE: /home/sascha/FH/Web-Technologien/silhouette-seed/play-silhouette-seed/app/views/emails/alreadySignedUp.scala.html
                  HASH: 76ab06ca8f7747af1078b668401996f9aecb3240
                  MATRIX: 35->1|72->32|434->61|589->123|616->124|672->154|762->224|805->241|881->297
                  LINES: 4->1|5->2|10->4|15->5|16->6|18->8|18->8|19->9|19->9
                  -- GENERATED --
              */
          