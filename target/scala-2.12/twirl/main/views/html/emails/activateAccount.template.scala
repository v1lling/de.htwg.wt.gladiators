
package views.html.emails

/*1.2*/import play.api.i18n.Messages
/*2.2*/import play.twirl.api.Html

object activateAccount extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template3[models.User,String,Messages,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*4.2*/(user: models.User, url: String)(implicit messages: Messages):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*5.1*/("""
"""),format.raw/*6.1*/("""<html>
    <body>
        <p>"""),_display_(/*8.13*/messages("email.activate.account.hello", user.name.getOrElse("user"))),format.raw/*8.82*/("""</p>
        <p>"""),_display_(/*9.13*/Html(messages("email.activate.account.html.text", url))),format.raw/*9.68*/("""</p>
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
                  DATE: 2021-01-15T16:01:28.399562
                  SOURCE: /home/sascha/FH/Web-Technologien/de.htwg.wt.gladiators/app/views/emails/activateAccount.scala.html
                  HASH: 262b54a39d94bdde717d74f5f4932696e772dc30
                  MATRIX: 35->1|72->32|434->61|589->123|616->124|672->154|761->223|804->240|879->295
                  LINES: 4->1|5->2|10->4|15->5|16->6|18->8|18->8|19->9|19->9
                  -- GENERATED --
              */
          