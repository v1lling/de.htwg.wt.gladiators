
package views.txt.emails

/*1.2*/import play.api.i18n.Messages

object resetPassword extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.TxtFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.TxtFormat.Appendable]](play.twirl.api.TxtFormat) with _root_.play.twirl.api.Template3[models.User,String,Messages,play.twirl.api.TxtFormat.Appendable] {

  /**/
  def apply/*3.2*/(user: models.User, url: String)(implicit messages: Messages):play.twirl.api.TxtFormat.Appendable = {
    _display_ {
      {


Seq[Any](_display_(/*4.2*/messages("email.reset.password.hello", user.name.getOrElse("user"))),format.raw/*4.69*/("""

"""),_display_(/*6.2*/messages("email.reset.password.txt.text", url)),format.raw/*6.48*/("""
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
                  DATE: 2021-01-10T10:27:59.467122
                  SOURCE: /home/sascha/FH/Web-Technologien/silhouette-seed/play-silhouette-seed/app/views/emails/resetPassword.scala.txt
                  HASH: 20e040ce32e5d1d63dcf02402aef41c710d1b8db
                  MATRIX: 34->1|393->33|547->96|634->163|662->166|728->212
                  LINES: 4->1|9->3|14->4|14->4|16->6|16->6
                  -- GENERATED --
              */
          