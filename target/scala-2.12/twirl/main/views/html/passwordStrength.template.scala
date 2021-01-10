
package views.html

/*1.2*/import play.api.data.Field
/*2.2*/import play.api.i18n.MessagesProvider

object passwordStrength extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template3[Field,Array[scala.Tuple2[Symbol, Any]],MessagesProvider,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*4.2*/(field: Field, options: (Symbol, Any)*)(implicit messagesProvider: MessagesProvider):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {

implicit def /*6.2*/implicitFieldConstructor/*6.26*/ = {{ b4.vertical.fieldConstructor() }};
Seq[Any](format.raw/*5.1*/("""
"""),format.raw/*6.64*/("""

"""),format.raw/*8.1*/("""<section>
  """),_display_(/*9.4*/b4/*9.6*/.password(field, (Symbol("data-pwd"), "true") +: options:_*)),format.raw/*9.66*/("""

  """),format.raw/*11.3*/("""<meter max="4" id="password-strength-meter"></meter>
  <p id="password-strength-text"></p>
</section>
"""))
      }
    }
  }

  def render(field:Field,options:Array[scala.Tuple2[Symbol, Any]],messagesProvider:MessagesProvider): play.twirl.api.HtmlFormat.Appendable = apply(field,options.toIndexedSeq:_*)(messagesProvider)

  def f:((Field,Array[scala.Tuple2[Symbol, Any]]) => (MessagesProvider) => play.twirl.api.HtmlFormat.Appendable) = (field,options) => (messagesProvider) => apply(field,options.toIndexedSeq:_*)(messagesProvider)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: 2021-01-10T10:31:38.289528
                  SOURCE: /home/sascha/FH/Web-Technologien/silhouette-seed/play-silhouette-seed/app/views/passwordStrength.scala.html
                  HASH: d57de1747e4c5eb8cbfab7657db7062b614382b5
                  MATRIX: 28->1|62->29|464->69|635->156|667->180|734->154|762->218|790->220|828->233|837->235|917->295|948->299
                  LINES: 4->1|5->2|10->4|14->6|14->6|15->5|16->6|18->8|19->9|19->9|19->9|21->11
                  -- GENERATED --
              */
          