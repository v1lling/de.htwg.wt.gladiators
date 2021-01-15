
package views.txt.emails

/*1.2*/import play.api.i18n.Messages

object activateAccount extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.TxtFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.TxtFormat.Appendable]](play.twirl.api.TxtFormat) with _root_.play.twirl.api.Template3[models.User,String,Messages,play.twirl.api.TxtFormat.Appendable] {

  /**/
  def apply/*3.2*/(user: models.User, url: String)(implicit messages: Messages):play.twirl.api.TxtFormat.Appendable = {
    _display_ {
      {


Seq[Any](_display_(/*4.2*/messages("email.activate.account.hello", user.name.getOrElse("user"))),format.raw/*4.71*/("""

"""),_display_(/*6.2*/messages("email.activate.account.txt.text", url)),format.raw/*6.50*/("""
"""))
      }
    }
  }

  def render(user:models.User,url:String,messages:Messages): play.twirl.api.TxtFormat.Appendable = apply(user,url)(messages)

  def f:((models.User,String) => (Messages) => play.twirl.api.TxtFormat.Appendable) = (user,url) => (messages) => apply(user,url)(messages)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: 2021-01-15T16:01:28.427316
                  SOURCE: /home/sascha/FH/Web-Technologien/de.htwg.wt.gladiators/app/views/emails/activateAccount.scala.txt
                  HASH: e0eedfa60f45f1c06fd86c261d667b29651aed14
                  MATRIX: 34->1|395->33|549->96|638->165|666->168|734->216
                  LINES: 4->1|9->3|14->4|14->4|16->6|16->6
                  -- GENERATED --
              */
          