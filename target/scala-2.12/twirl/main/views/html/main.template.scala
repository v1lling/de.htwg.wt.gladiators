
package views.html

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

object main extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template2[String,Html,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(title: String)(content: Html):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*2.1*/("""<!DOCTYPE html>
<html lang="en">
    <head>
        <title>"""),_display_(/*5.17*/title),format.raw/*5.22*/("""</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=yes">
        <link rel="shortcut icon" type="image/png" href=""""),_display_(/*8.59*/routes/*8.65*/.Assets.versioned("images/logo.png")),format.raw/*8.101*/("""">

        <!-- Gladiators CSS -->
        <link rel="stylesheet" media="screen" href=""""),_display_(/*11.54*/routes/*11.60*/.Assets.versioned("less/main.css")),format.raw/*11.94*/(""""> 
        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
        
        <!-- JQuery -->
        <script src=""""),_display_(/*16.23*/routes/*16.29*/.Assets.versioned("javascripts/jquery-3.2.1.min.js")),format.raw/*16.81*/("""" type="text/javascript"></script>
        <!-- Bootstrap JS -->
        <script src=""""),_display_(/*18.23*/routes/*18.29*/.Assets.versioned("javascripts/popper.js")),format.raw/*18.71*/("""" type="text/javascript"></script>
        <script src=""""),_display_(/*19.23*/routes/*19.29*/.Assets.versioned("javascripts/bootstrap.min.js")),format.raw/*19.78*/("""" ></script>
        <!-- Vue JS and Vue Router JS -->
        <script src=""""),_display_(/*21.23*/{"https://cdn.jsdelivr.net/npm/vue"}),format.raw/*21.59*/("""" type="application/javascript"></script>
        <script src=""""),_display_(/*22.23*/{"https://unpkg.com/vue-router"}),format.raw/*22.55*/("""" type="application/javascript"></script>
        <script src=""""),_display_(/*23.23*/{"https://unpkg.com/vuex"}),format.raw/*23.49*/("""" type="application/javascript"></script>
        <!-- Bootstrap MessageBox Library -->
        <script src=""""),_display_(/*25.23*/routes/*25.29*/.Assets.versioned("javascripts/bootstrap-msg.min.js")),format.raw/*25.82*/("""" ></script>
        <!-- Vue App Initialization JS -->
        <script src=""""),_display_(/*27.23*/routes/*27.29*/.Assets.versioned("vue/main.js")),format.raw/*27.61*/("""" type="module"></script>
        <!-- Gladiators JS-->
        <script src=""""),_display_(/*29.23*/routes/*29.29*/.Assets.versioned("javascripts/gladiators.js")),format.raw/*29.75*/("""" ></script>
    </head>

    <body>
        """),_display_(/*33.10*/content),format.raw/*33.17*/("""
    """),format.raw/*34.5*/("""</body>
</html>"""))
      }
    }
  }

  def render(title:String,content:Html): play.twirl.api.HtmlFormat.Appendable = apply(title)(content)

  def f:((String) => (Html) => play.twirl.api.HtmlFormat.Appendable) = (title) => (content) => apply(title)(content)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: 2021-01-12T10:24:11.248079
                  SOURCE: /home/sascha/FH/Web-Technologien/de.htwg.wt.gladiators/app/views/main.scala.html
                  HASH: 9c61ef4e85ad4d83b9f78a55bbf510f71380ea49
                  MATRIX: 733->1|857->32|943->92|968->97|1188->291|1202->297|1259->333|1375->422|1390->428|1445->462|1782->772|1797->778|1870->830|1984->917|1999->923|2062->965|2146->1022|2161->1028|2231->1077|2335->1154|2392->1190|2483->1254|2536->1286|2627->1350|2674->1376|2811->1486|2826->1492|2900->1545|3005->1623|3020->1629|3073->1661|3178->1739|3193->1745|3260->1791|3333->1837|3361->1844|3393->1849
                  LINES: 21->1|26->2|29->5|29->5|32->8|32->8|32->8|35->11|35->11|35->11|40->16|40->16|40->16|42->18|42->18|42->18|43->19|43->19|43->19|45->21|45->21|46->22|46->22|47->23|47->23|49->25|49->25|49->25|51->27|51->27|51->27|53->29|53->29|53->29|57->33|57->33|58->34
                  -- GENERATED --
              */
          