
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
/*1.2*/import de.htwg.se.gladiators.util.Coordinate

object gladiators extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template1[de.htwg.se.gladiators.controller.BaseImplementation.Controller,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*2.2*/(controller:de.htwg.se.gladiators.controller.BaseImplementation.Controller):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {

def /*3.2*/gladiators/*3.12*/ = {{ controller.playerOne.get.gladiators ++ controller.playerTwo.get.gladiators}};def /*4.2*/shop/*4.6*/ = {{controller.shop}};
Seq[Any](format.raw/*3.93*/("""
"""),format.raw/*4.27*/("""

"""),_display_(/*6.2*/main("Gladiators")/*6.20*/ {_display_(Seq[Any](format.raw/*6.22*/("""
    """),_display_(/*7.6*/modal()),format.raw/*7.13*/("""
    """),format.raw/*8.5*/("""<div class="container my-container game">
        <div class="row">
            <div class="col-xs-12 col-sm-12 col-lg-2 panel">
                <div class="panel-player">
                    Player 2
                    <div class="playerinfo player2">
                        <div class="playerinfo-row">
                            <div>Name:</div>
                            <div id="idPlayer2Name">
                                """),_display_(/*17.34*/{if (controller.playerTwo) {
                                    controller.playerTwo.get.name
                                } else {
                                    "-"
                                }
                            }),format.raw/*22.30*/("""</div>
                        </div>
                        <div class="playerinfo-row">
                            <div>Base:</div>
                            <div id="idPlayer2Health">
                                """),_display_(/*27.34*/{if (controller.playerTwo) {
                                    controller.playerTwo.get.health
                                } else {
                                    "-"
                                }
                            }),format.raw/*32.30*/("""</div>
                        </div>
                        <div class="playerinfo-row">
                            <div>Credits:</div>
                            <div id="idPlayer2Credits">
                                """),_display_(/*37.34*/{if (controller.playerTwo) {
                                    controller.playerTwo.get.credits
                                } else {
                                    "-"
                                }
                            }),format.raw/*42.30*/("""</div>
                        </div> 
                    </div>
                </div>

                <div class="panel-buttons">
                    <button disabled id="idTurnButton" type="button" class="btn btn-rounded turnbutton" onclick="onClickEndTurn()">
                        Lobby
                        <span class="turnbutton-png"></span>
                    </button>
                </div>

                <div class="panel-player">
                    Player 1
                    <div class="playerinfo player1">
                        <div class="playerinfo-row">
                            <div>Name:</div>
                            <div id="idPlayer1Name">
                                """),_display_(/*60.34*/{if (controller.playerOne) {
                                    controller.playerOne.get.name
                                } else {
                                    "-"
                                }
                            }),format.raw/*65.30*/("""</div>
                        </div>
                        <div class="playerinfo-row">
                            <div>Base:</div>
                            <div id="idPlayer1Health">
                                """),_display_(/*70.34*/{if (controller.playerOne) {
                                    controller.playerOne.get.health
                                } else {
                                    "-"
                                }
                            }),format.raw/*75.30*/("""</div>
                        </div>
                        <div class="playerinfo-row">
                            <div>Credits:</div>
                            <div id="idPlayer1Credits">
                                """),_display_(/*80.34*/{if (controller.playerOne) {
                                    controller.playerOne.get.credits
                                } else {
                                    "-"
                                }
                            }),format.raw/*85.30*/("""</div>
                        </div>   
                    </div>
                </div>
            </div>
            <div id="idBoard" class="col-xs-12 col-sm-12 col-lg-8 board">
                """),_display_(/*91.18*/for(y <- 0 until controller.board.tiles.size) yield /*91.63*/ {_display_(Seq[Any](format.raw/*91.65*/("""
                    """),format.raw/*92.21*/("""<div class="board-row">
                    """),_display_(/*93.22*/for(x <- 0 until controller.board.tiles.size) yield /*93.67*/ {_display_(Seq[Any](format.raw/*93.69*/("""
                        """),format.raw/*94.25*/("""<div class="board-tile"
                            id="idTileX"""),_display_(/*95.41*/{x}),format.raw/*95.44*/("""Y"""),_display_(/*95.46*/{y}),format.raw/*95.49*/(""""
                            x="""),_display_(/*96.32*/{x}),format.raw/*96.35*/("""
                            """),format.raw/*97.29*/("""y="""),_display_(/*97.32*/{y}),format.raw/*97.35*/("""
                            """),format.raw/*98.29*/("""onclick="onClickTile(this)">
                        </div>
                    """)))}),format.raw/*100.22*/("""
                    """),format.raw/*101.21*/("""</div>
                """)))}),format.raw/*102.18*/("""
            """),format.raw/*103.13*/("""</div>
            <div class="col-xs-12 col-sm-12 col-lg-2 panel">
                <div class="panel-gladiator">
                    Gladiator
                    <div class="gladiatorinfo">
                        <div class="gladiatorinfo-image"></div>
                        <div>AP: <span id="idGladiatorAP">-</span></div>
                        <div>HP: <span id="idGladiatorHP">-</span></div>
                        <div>MP: <span id="idGladiatorMP">-</span></div>
                    </div>
                </div>
                <div class="panel-shop">
                    Shop
                    """),_display_(/*116.22*/for(i <- 0 until shop.stock.length) yield /*116.57*/ {_display_(Seq[Any](format.raw/*116.59*/("""
                        """),format.raw/*117.25*/("""<button class="btn btn-outline-dark shop-item"
                            onmouseenter="showGladiatorStats(event)"
                            onclick="onClickShopItem(this)"
                            index="""),_display_(/*120.36*/{i}),format.raw/*120.39*/(""">
                            <span></span>
                            <div class="layer"></div>
                        </button>
                    """)))}),format.raw/*124.22*/("""
                """),format.raw/*125.17*/("""</div>
            </div>
        </div>
    </div>
""")))}),format.raw/*129.2*/("""
"""))
      }
    }
  }

  def render(controller:de.htwg.se.gladiators.controller.BaseImplementation.Controller): play.twirl.api.HtmlFormat.Appendable = apply(controller)

  def f:((de.htwg.se.gladiators.controller.BaseImplementation.Controller) => play.twirl.api.HtmlFormat.Appendable) = (controller) => apply(controller)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: 2021-01-12T10:24:11.203003
                  SOURCE: /home/sascha/FH/Web-Technologien/de.htwg.wt.gladiators/app/views/old/gladiators.scala.html
                  HASH: 2c237bbfbcd88d44b7ccff85c32a7a5645648fc1
                  MATRIX: 436->1|846->47|999->124|1017->134|1111->217|1122->221|1173->215|1201->242|1229->245|1255->263|1294->265|1325->271|1352->278|1383->283|1848->721|2108->960|2359->1184|2621->1425|2876->1653|3139->1895|3886->2615|4146->2854|4397->3078|4659->3319|4914->3547|5177->3789|5405->3990|5466->4035|5506->4037|5555->4058|5627->4103|5688->4148|5728->4150|5781->4175|5872->4239|5896->4242|5925->4244|5949->4247|6009->4280|6033->4283|6090->4312|6120->4315|6144->4318|6201->4347|6314->4428|6364->4449|6420->4473|6462->4486|7102->5098|7154->5133|7195->5135|7249->5160|7488->5371|7513->5374|7698->5527|7744->5544|7828->5597
                  LINES: 17->1|22->2|26->3|26->3|26->4|26->4|27->3|28->4|30->6|30->6|30->6|31->7|31->7|32->8|41->17|46->22|51->27|56->32|61->37|66->42|84->60|89->65|94->70|99->75|104->80|109->85|115->91|115->91|115->91|116->92|117->93|117->93|117->93|118->94|119->95|119->95|119->95|119->95|120->96|120->96|121->97|121->97|121->97|122->98|124->100|125->101|126->102|127->103|140->116|140->116|140->116|141->117|144->120|144->120|148->124|149->125|153->129
                  -- GENERATED --
              */
          