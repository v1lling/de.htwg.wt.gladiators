import com.typesafe.sbt.SbtScalariform._

import scalariform.formatter.preferences._

herokuAppName in Compile := "gladiators-game"
name := "play-silhouette-seed"
organization := "de.htwg"
version := "6.0.0"
scalaVersion := "2.12.12"

bloopAggregateSourceDependencies in Global := true

resolvers += Resolver.jcenterRepo

resolvers += "Sonatype snapshots" at "https://oss.sonatype.org/content/repositories/snapshots/"

libraryDependencies ++= Seq(
  "com.mohiva" %% "play-silhouette" % "6.1.1",
  "com.mohiva" %% "play-silhouette-password-bcrypt" % "6.1.1",
  "com.mohiva" %% "play-silhouette-persistence" % "6.1.1",
  "com.mohiva" %% "play-silhouette-crypto-jca" % "6.1.1",
  "com.mohiva" %% "play-silhouette-totp" % "6.1.1",
  "org.webjars" %% "webjars-play" % "2.8.0",
  "org.webjars" % "bootstrap" % "4.4.1" exclude("org.webjars", "jquery"),
  "org.webjars" % "jquery" % "3.2.1",
  "net.codingwell" %% "scala-guice" % "4.2.6",
  "com.iheart" %% "ficus" % "1.4.7",
  "com.typesafe.play" %% "play-mailer" % "7.0.1",
  "com.typesafe.play" %% "play-mailer-guice" % "7.0.1",
//"com.enragedginger" %% "akka-quartz-scheduler" % "1.8.2-akka-2.6.x",
  "com.enragedginger" %% "akka-quartz-scheduler" % "1.8.3-akka-2.6.x",
  "com.adrianhurt" %% "play-bootstrap" % "1.5.1-P27-B4",
  "com.mohiva" %% "play-silhouette-testkit" % "6.1.1" % "test",
  specs2 % Test,
  ehcache,
  guice,
  filters
)

lazy val gladiatorBase = ProjectRef(uri("git://github.com/VoigtSebastian/de.htwg.se.Gladiators.git#master"), "gladiatorsBase")

lazy val root = (project in file("."))
    .enablePlugins(PlayScala)
    .dependsOn(gladiatorBase)
    .aggregate(gladiatorBase)
    .settings(
        libraryDependencies ++= Seq(
            guice,
            "org.scalatestplus.play" %% "scalatestplus-play" % "5.0.0" % Test,
            "com.softwaremill.macwire" %% "macros" % "2.3.6" % "provided",
            "com.softwaremill.macwire" %% "util" % "2.3.6"
    ))

routesImport += "utils.route.Binders._"

// https://github.com/playframework/twirl/issues/105
TwirlKeys.templateImports := Seq()



//********************************************************
// Scalariform settings
//********************************************************

scalariformAutoformat := true

ScalariformKeys.preferences := ScalariformKeys.preferences.value
  .setPreference(FormatXml, false)
  .setPreference(DoubleIndentConstructorArguments, false)
  .setPreference(DanglingCloseParenthesis, Preserve)
