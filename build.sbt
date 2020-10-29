name := """de.htwg.wt.Gladiators"""
organization := "de.htwg"

version := "0.1"

bloopAggregateSourceDependencies in Global := true

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

scalaVersion := "2.12.12"


// Adds additional packages into Twirl
//TwirlKeys.templateImports += "com.example.controllers._"

// Adds additional packages into conf/routes
// play.sbt.routes.RoutesKeys.routesImport += "com.example.binders._"
