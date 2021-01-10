
package views.html.emails

/*1.2*/import play.api.i18n.Messages
/*2.2*/import play.twirl.api.Html

object signUp extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template3[models.User,String,Messages,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*4.2*/(user: models.User, url: String)(implicit messages: Messages):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*5.1*/("""
"""),format.raw/*6.1*/("""<html>
    <body>
        <p>"""),_display_(/*8.13*/messages("email.sign.up.hello", user.name.getOrElse("user"))),format.raw/*8.73*/("""</p>
        <p>"""),_display_(/*9.13*/Html(messages("email.sign.up.html.text", url))),format.raw/*9.59*/("""</p>
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
                  DATE: 2021-01-10T11:18:33.521793
                  SOURCE: /home/sascha/FH/Web-Technologien/de.htwg.wt.gladiators/app/views/emails/signUp.scala.html
                  HASH: 819cb42731ca75a8966c25b1d27e9ee9013c4663
                  MATRIX: 35->1|72->32|425->61|580->123|607->124|663->154|743->214|786->231|852->277
                  LINES: 4->1|5->2|10->4|15->5|16->6|18->8|18->8|19->9|19->9
                  -- GENERATED --
              */
          