
package views.html.emails

/*1.2*/import play.api.i18n.Messages
/*2.2*/import play.twirl.api.Html

object resetPassword extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template3[models.User,String,Messages,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*4.2*/(user: models.User, url: String)(implicit messages: Messages):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*5.1*/("""
"""),format.raw/*6.1*/("""<html>
    <body>
        <p>"""),_display_(/*8.13*/messages("email.reset.password.hello", user.name.getOrElse("user"))),format.raw/*8.80*/("""</p>
        <p>"""),_display_(/*9.13*/Html(messages("email.reset.password.html.text", url))),format.raw/*9.66*/("""</p>
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
                  DATE: 2021-01-10T10:27:59.496855
                  SOURCE: /home/sascha/FH/Web-Technologien/silhouette-seed/play-silhouette-seed/app/views/emails/resetPassword.scala.html
                  HASH: 81b9291d5fdac7c17a599b4bb3b16ede68dd57bf
                  MATRIX: 35->1|72->32|432->61|587->123|614->124|670->154|757->221|800->238|873->291
                  LINES: 4->1|5->2|10->4|15->5|16->6|18->8|18->8|19->9|19->9
                  -- GENERATED --
              */
          