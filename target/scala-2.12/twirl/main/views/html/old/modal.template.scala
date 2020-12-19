
package views.html.old

import _root_.play.twirl.api.TwirlFeatureImports._
import _root_.play.twirl.api.TwirlHelperImports._
import _root_.play.twirl.api.Html
import _root_.play.twirl.api.JavaScript
import _root_.play.twirl.api.Txt
import _root_.play.twirl.api.Xml
import models._
import controllers._
import play.api.i18n._
import views.html._
import play.api.templates.PlayMagic._
import play.api.mvc._
import play.api.data._

object modal extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.1*/("""<!--Modal: Login with Avatar Form-->
<div class="modal fade" id="idModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
  aria-hidden="true">
  <div class="modal-dialog cascading-modal modal-avatar modal-sm" role="document">
    <!--Content-->
    <div class="modal-content">

      <!--Header-->
      <div class="modal-header">
        <div class="avatar"></div>
      </div>
      <!--Body-->
      <div class="modal-body text-center mb-1">

        <h5 id="idModalHeader" class="mt-1 mb-2">Player 1</h5>

        <div class="md-form ml-0 mr-0">
          <input type="text" id="idModalInput" class="form-control form-control-sm validate ml-0">
          <label id="idInputLabel" data-error="wrong" data-success="right" for="form29" class="ml-0">Enter name</label>
        </div>

        <div class="text-center mt-4">
          <button onclick="onSubmitModal()" class="btn btn-success">CONNECT<i class="fas fa-sign-in ml-1"></i></button>
        </div>
      </div>

    </div>
    <!--/.Content-->
  </div>
</div>"""))
      }
    }
  }

  def render(): play.twirl.api.HtmlFormat.Appendable = apply()

  def f:(() => play.twirl.api.HtmlFormat.Appendable) = () => apply()

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: 2020-12-19T14:10:53.501433
                  SOURCE: /home/sascha/FH/Web-Technologien/de.htwg.wt.gladiators/app/views/old/modal.scala.html
                  HASH: d47b5815e0602298528ef092d5c708bbe5181788
                  MATRIX: 815->0
                  LINES: 26->1
                  -- GENERATED --
              */
          