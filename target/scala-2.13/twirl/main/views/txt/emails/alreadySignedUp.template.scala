
package views.txt.emails

/*1.2*/import play.api.i18n.Messages

object alreadySignedUp extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.TxtFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.TxtFormat.Appendable]](play.twirl.api.TxtFormat) with _root_.play.twirl.api.Template3[models.User,String,Messages,play.twirl.api.TxtFormat.Appendable] {

  /**/
  def apply/*3.2*/(user: models.User, url: String)(implicit messages: Messages):play.twirl.api.TxtFormat.Appendable = {
    _display_ {
      {


Seq[Any](_display_(/*4.2*/messages("email.already.signed.up.hello", user.name.getOrElse("user"))),format.raw/*4.72*/("""

"""),_display_(/*6.2*/messages("email.already.signed.up.txt.text", url)),format.raw/*6.51*/("""
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
                  DATE: 2021-01-10T10:27:59.504294
                  SOURCE: /home/sascha/FH/Web-Technologien/silhouette-seed/play-silhouette-seed/app/views/emails/alreadySignedUp.scala.txt
                  HASH: b7b94630a6ecef5fe587c1e2b31f99c9433baf58
                  MATRIX: 34->1|395->33|549->96|639->166|667->169|736->218
                  LINES: 4->1|9->3|14->4|14->4|16->6|16->6
                  -- GENERATED --
              */
          