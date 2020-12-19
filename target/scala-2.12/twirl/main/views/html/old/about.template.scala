
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

object about extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*2.1*/("""
"""),_display_(/*3.2*/main("Gladiators")/*3.20*/ {_display_(Seq[Any](format.raw/*3.22*/("""
  """),format.raw/*4.3*/("""<div class="container about my-container">
    <h1>Gladiators - The Game</h1>
    <h2>Now available for Browsers</h2>

    <p>
      Gladiators is a turn-based strategy game for 2 Players.
      Players can buy different Gladiators (such as Knights, Archer or Tanks) 
      for a certain amount of money (credits). One way to earn money is to attack 
      the gold mine that is randomly positioned on the board. Another way to get money
      is to kill Gladiators of your opponent.
      Gladiators various attributes that specify their skills. Attributes are:
    </p>
      <ul>
        <li>Movement Points (the amount of tiles a Gladiator can walk per turn)</li>
        <li>Health Points (the damage a Gladiator can take until he dies)</li>
        <li>Attach Points (the damage a Gladiator does per attack)</li>
      </ul>
    <p>
      The shop generates random gladiators and provides them to the players.
      Each Gladiator-type has a intervals of possible values for each attribute.
    </p>
    <table>
      <tr>
        <th>Gladiator-Type</th>
        <th>Movement-Points</th>
        <th>Health-Points</th>
        <th>Attach-Points</th>
      </tr>
      <tr>
        <th>Knight</th>
        <th>3 - 4</th>
        <th>50 - 80</th>
        <th>50 - 80</th>
      </tr>
      <tr>
        <th>Archer</th>
        <th>2 - 3</th>
        <th>30 - 50</th>
        <th>40 - 70</th>
      </tr>
      <tr>
        <th>Tank</th>
        <th>1 - 2</th>
        <th>80 - 100</th>
        <th>30 - 50</th>
      </tr>
      
    </table>
    </br>
    <p>
      The goal of the game is to destroy the enemy's base by attacking it.
      At the start of the game the base has 200 Health-Points.
    </p>
    </br></br>
    <img src=""""),_display_(/*58.16*/routes/*58.22*/.Assets.versioned("images/gladiators.gif")),format.raw/*58.64*/(""""/>
  </div>
""")))}))
      }
    }
  }

  def render(): play.twirl.api.HtmlFormat.Appendable = apply()

  def f:(() => play.twirl.api.HtmlFormat.Appendable) = () => apply()

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: 2020-12-19T14:10:53.497458
                  SOURCE: /home/sascha/FH/Web-Technologien/de.htwg.wt.gladiators/app/views/old/about.scala.html
                  HASH: 0141e0fb29fd915437270e8cbde69e899b34010b
                  MATRIX: 726->1|822->4|849->6|875->24|914->26|943->29|2712->1771|2727->1777|2790->1819
                  LINES: 21->1|26->2|27->3|27->3|27->3|28->4|82->58|82->58|82->58
                  -- GENERATED --
              */
          