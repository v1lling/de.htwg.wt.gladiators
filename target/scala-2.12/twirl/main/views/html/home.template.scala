
package views.html

/*1.2*/import play.api.i18n.Messages
/*2.2*/import play.api.mvc.RequestHeader
/*3.2*/import org.webjars.play.WebJarsUtil
/*4.2*/import controllers.AssetsFinder
/*5.2*/import play.api.data._
/*6.2*/import forms.TotpSetupForm.Data
/*7.2*/import com.mohiva.play.silhouette.impl.providers.GoogleTotpCredentials
/*8.2*/import com.mohiva.play.silhouette.impl.providers.GoogleTotpInfo

/**/
class home @javax.inject.Inject() /*10.6*/()(implicit webJarsUtil: WebJarsUtil, assets: AssetsFinder) extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template5[models.User,Option[GoogleTotpInfo],Option[scala.Tuple2[Form[Data], GoogleTotpCredentials]],RequestHeader,Messages,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*11.2*/(user: models.User, totpInfoOpt: Option[GoogleTotpInfo], totpDataOpt: Option[(Form[Data], GoogleTotpCredentials)] = None)(implicit request: RequestHeader, messages: Messages):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {

implicit def /*13.2*/implicitFieldConstructor/*13.26*/ = {{
    b4.vertical.fieldConstructor()
}};
Seq[Any](format.raw/*12.1*/("""
"""),format.raw/*15.2*/("""

"""),_display_(/*17.2*/main(messages("home.title"), Some(user))/*17.42*/ {_display_(Seq[Any](format.raw/*17.44*/("""
    """),format.raw/*18.5*/("""<div class="user col-md-6 col-md-offset-3">
        <div class="row">
            <hr class="col-md-12" />
            <h4 class="col-md-8">"""),_display_(/*21.35*/messages("welcome.signed.in")),format.raw/*21.64*/("""</h4>
            <div class="col-md-4 text-right">
                <img src=""""),_display_(/*23.28*/user/*23.32*/.avatarURL.getOrElse(assets.path("images/silhouette.png"))),format.raw/*23.90*/("""" height="40px" />
            </div>
            <hr class="col-md-12" />
        </div>
        <div class="row data">
            <div class="col-md-12">
                <div class="row">
                    <p class="col-md-6"><strong>"""),_display_(/*30.50*/messages("first.name")),format.raw/*30.72*/("""
                        """),format.raw/*31.25*/(""":</strong></p><p class="col-md-6">"""),_display_(/*31.60*/user/*31.64*/.firstName.getOrElse("None")),format.raw/*31.92*/("""</p>
                </div>
                <div class="row">
                    <p class="col-md-6"><strong>"""),_display_(/*34.50*/messages("last.name")),format.raw/*34.71*/("""
                        """),format.raw/*35.25*/(""":</strong></p><p class="col-md-6">"""),_display_(/*35.60*/user/*35.64*/.lastName.getOrElse("None")),format.raw/*35.91*/("""</p>
                </div>
                <div class="row">
                    <p class="col-md-6"><strong>"""),_display_(/*38.50*/messages("full.name")),format.raw/*38.71*/("""
                        """),format.raw/*39.25*/(""":</strong></p><p class="col-md-6">"""),_display_(/*39.60*/user/*39.64*/.fullName.getOrElse("None")),format.raw/*39.91*/("""</p>
                </div>
                <div class="row">
                    <p class="col-md-6"><strong>"""),_display_(/*42.50*/messages("email")),format.raw/*42.67*/("""
                        """),format.raw/*43.25*/(""":</strong></p><p class="col-md-6">"""),_display_(/*43.60*/user/*43.64*/.email.getOrElse("None")),format.raw/*43.88*/("""</p>
                </div>
            </div>
        </div>
        <div class="row data">
        """),_display_(/*48.10*/if(totpInfoOpt.nonEmpty)/*48.34*/ {_display_(Seq[Any](format.raw/*48.36*/("""
            """),format.raw/*49.13*/("""<h2>"""),_display_(/*49.18*/messages("totp.enabled.title")),format.raw/*49.48*/("""</h2>
            <a href=""""),_display_(/*50.23*/controllers/*50.34*/.routes.TotpController.disableTotp),format.raw/*50.68*/("""">
                <input type="button" class="btn btn-primary" value='"""),_display_(/*51.70*/messages("totp.disable")),format.raw/*51.94*/("""'/>
            </a>
        """)))}/*53.11*/else/*53.16*/{_display_(Seq[Any](format.raw/*53.17*/("""
            """),_display_(/*54.14*/totpDataOpt/*54.25*/ match/*54.31*/ {/*55.17*/case Some((totpForm, credentials)) =>/*55.54*/ {_display_(Seq[Any](format.raw/*55.56*/("""
                    """),format.raw/*56.21*/("""<h2>"""),_display_(/*56.26*/messages("totp.enabling.title")),format.raw/*56.57*/("""</h2>
                    <h2>"""),_display_(/*57.26*/messages("totp.shared.key.title")),format.raw/*57.59*/("""</h2>
                    <img src=""""),_display_(/*58.32*/credentials/*58.43*/.qrUrl),format.raw/*58.49*/(""""/>
                    <h2>"""),_display_(/*59.26*/messages("totp.recovery.tokens.title")),format.raw/*59.64*/("""</h2>
                    <ul>
                    """),_display_(/*61.22*/for(scratchCodePlain <- credentials.scratchCodesPlain) yield /*61.76*/ {_display_(Seq[Any](format.raw/*61.78*/("""
                        """),format.raw/*62.25*/("""<li>"""),_display_(/*62.30*/{
                            scratchCodePlain
                        }),format.raw/*64.26*/("""</li>
                    """)))}),format.raw/*65.22*/("""
                    """),format.raw/*66.21*/("""</ul>
                    """),_display_(/*67.22*/helper/*67.28*/.form(action = controllers.routes.TotpController.enableTotpSubmit())/*67.96*/ {_display_(Seq[Any](format.raw/*67.98*/("""
                        """),_display_(/*68.26*/helper/*68.32*/.CSRF.formField),format.raw/*68.47*/("""
                        """),_display_(/*69.26*/b4/*69.28*/.text(totpForm("verificationCode"), Symbol("_hiddenLabel") -> messages("totp.verification.code    "), Symbol("placeholder") -> messages("totp.verification.code"), Symbol("autocomplete") -> "off", Symbol("class") -> "form-control input-lg")),format.raw/*69.267*/("""
                        """),_display_(/*70.26*/b4/*70.28*/.hidden(totpForm("sharedKey"))),format.raw/*70.58*/("""
                        """),_display_(/*71.26*/helper/*71.32*/.repeat(totpForm("scratchCodes"), min = 1)/*71.74*/ { scratchCodeField =>_display_(Seq[Any](format.raw/*71.96*/("""
                            """),_display_(/*72.30*/b4/*72.32*/.hidden(scratchCodeField("hasher"))),format.raw/*72.67*/("""
                            """),_display_(/*73.30*/b4/*73.32*/.hidden(scratchCodeField("password"))),format.raw/*73.69*/("""
                            """),_display_(/*74.30*/b4/*74.32*/.hidden(scratchCodeField("salt"))),format.raw/*74.65*/("""
                        """)))}),format.raw/*75.26*/("""
                        """),format.raw/*76.25*/("""<div class="form-group">
                            <div>
                                <button id="submit" type="submit" value="submit" class="btn btn-lg btn-primary btn-block">"""),_display_(/*78.124*/messages("totp.verify")),format.raw/*78.147*/("""</button>
                            </div>
                        </div>
                    """)))}),format.raw/*81.22*/("""
                """)))}/*83.17*/case None =>/*83.29*/ {_display_(Seq[Any](format.raw/*83.31*/("""
                    """),format.raw/*84.21*/("""<h2>"""),_display_(/*84.26*/messages("totp.disabled.title")),format.raw/*84.57*/("""</h2>
                    <a href=""""),_display_(/*85.31*/controllers/*85.42*/.routes.TotpController.enableTotp),format.raw/*85.75*/("""">
                        <input type="button" class="btn btn-primary" value='"""),_display_(/*86.78*/messages("totp.enable")),format.raw/*86.101*/("""'/>
                    </a>
                """)))}}),format.raw/*89.14*/("""
        """)))}),format.raw/*90.10*/("""
        """),format.raw/*91.9*/("""</div>
    </div>
""")))}),format.raw/*93.2*/("""
"""))
      }
    }
  }

  def render(user:models.User,totpInfoOpt:Option[GoogleTotpInfo],totpDataOpt:Option[scala.Tuple2[Form[Data], GoogleTotpCredentials]],request:RequestHeader,messages:Messages): play.twirl.api.HtmlFormat.Appendable = apply(user,totpInfoOpt,totpDataOpt)(request,messages)

  def f:((models.User,Option[GoogleTotpInfo],Option[scala.Tuple2[Form[Data], GoogleTotpCredentials]]) => (RequestHeader,Messages) => play.twirl.api.HtmlFormat.Appendable) = (user,totpInfoOpt,totpDataOpt) => (request,messages) => apply(user,totpInfoOpt,totpDataOpt)(request,messages)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: 2021-01-15T16:01:28.462185
                  SOURCE: /home/sascha/FH/Web-Technologien/de.htwg.wt.gladiators/app/views/home.scala.html
                  HASH: 5f1c0a19d8db68b32eb270a969139598f8235efe
                  MATRIX: 28->1|65->32|106->67|149->104|188->137|218->161|257->194|335->266|447->336|905->397|1167->574|1200->598|1272->572|1300->640|1329->643|1378->683|1418->685|1450->690|1618->831|1668->860|1774->939|1787->943|1866->1001|2133->1241|2176->1263|2229->1288|2291->1323|2304->1327|2353->1355|2491->1466|2533->1487|2586->1512|2648->1547|2661->1551|2709->1578|2847->1689|2889->1710|2942->1735|3004->1770|3017->1774|3065->1801|3203->1912|3241->1929|3294->1954|3356->1989|3369->1993|3414->2017|3543->2119|3576->2143|3616->2145|3657->2158|3689->2163|3740->2193|3795->2221|3815->2232|3870->2266|3969->2338|4014->2362|4063->2393|4076->2398|4115->2399|4156->2413|4176->2424|4191->2430|4202->2449|4248->2486|4288->2488|4337->2509|4369->2514|4421->2545|4479->2576|4533->2609|4597->2646|4617->2657|4644->2663|4700->2692|4759->2730|4838->2782|4908->2836|4948->2838|5001->2863|5033->2868|5126->2940|5184->2967|5233->2988|5287->3015|5302->3021|5379->3089|5419->3091|5472->3117|5487->3123|5523->3138|5576->3164|5587->3166|5848->3405|5901->3431|5912->3433|5963->3463|6016->3489|6031->3495|6082->3537|6142->3559|6199->3589|6210->3591|6266->3626|6323->3656|6334->3658|6392->3695|6449->3725|6460->3727|6514->3760|6571->3786|6624->3811|6834->3993|6879->4016|7007->4113|7044->4148|7065->4160|7105->4162|7154->4183|7186->4188|7238->4219|7301->4255|7321->4266|7375->4299|7482->4379|7527->4402|7605->4462|7646->4472|7682->4481|7731->4500
                  LINES: 4->1|5->2|6->3|7->4|8->5|9->6|10->7|11->8|14->10|17->11|21->13|21->13|24->12|25->15|27->17|27->17|27->17|28->18|31->21|31->21|33->23|33->23|33->23|40->30|40->30|41->31|41->31|41->31|41->31|44->34|44->34|45->35|45->35|45->35|45->35|48->38|48->38|49->39|49->39|49->39|49->39|52->42|52->42|53->43|53->43|53->43|53->43|58->48|58->48|58->48|59->49|59->49|59->49|60->50|60->50|60->50|61->51|61->51|63->53|63->53|63->53|64->54|64->54|64->54|64->55|64->55|64->55|65->56|65->56|65->56|66->57|66->57|67->58|67->58|67->58|68->59|68->59|70->61|70->61|70->61|71->62|71->62|73->64|74->65|75->66|76->67|76->67|76->67|76->67|77->68|77->68|77->68|78->69|78->69|78->69|79->70|79->70|79->70|80->71|80->71|80->71|80->71|81->72|81->72|81->72|82->73|82->73|82->73|83->74|83->74|83->74|84->75|85->76|87->78|87->78|90->81|91->83|91->83|91->83|92->84|92->84|92->84|93->85|93->85|93->85|94->86|94->86|96->89|97->90|98->91|100->93
                  -- GENERATED --
              */
          