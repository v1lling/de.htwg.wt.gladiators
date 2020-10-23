name := """de.htwg.wt.Gladiators"""
organization := "com.example"

version := "1.0-SNAPSHOT"

lazy val root = (project in file("."))
    .enablePlugins(PlayScala)
    .dependsOn(ProjectRef(uri("git://github.com/VoigtSebastian/de.htwg.se.Gladiators.git#master"), "root"))
    .settings(
        libraryDependencies ++= Seq(
            guice,
            "org.scalatestplus.play" %% "scalatestplus-play" % "5.0.0" % Test
    ))

scalaVersion := "2.12.12"


// Adds additional packages into Twirl
//TwirlKeys.templateImports += "com.example.controllers._"

// Adds additional packages into conf/routes
// play.sbt.routes.RoutesKeys.routesImport += "com.example.binders._"
