ThisBuild / scalaVersion := "2.13.8"
ThisBuild / version := "1.0.0"

lazy val rootProject = (project in file("."))
    .settings{
        name := "cats-sandbox";
        libraryDependencies ++= Seq("org.typelevel" %% "cats-core" % "2.8.0")
    }
    .aggregate(helloCats)

lazy val helloCats = (project in file("helloCats"))
    .settings{
        name := "helloCats";
        libraryDependencies ++= Seq("org.typelevel" %% "cats-core" % "2.8.0")
    }