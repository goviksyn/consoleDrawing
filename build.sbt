name := "consoleDrawing"

version := "1.0"

scalaVersion := "2.12.8"


crossPaths := false
autoScalaLibrary := false

val springVersion = "4.1.6.RELEASE"

javacOptions in(Compile, compile) ++= Seq("-source", "1.8", "-target", "1.8", "-g:lines")

libraryDependencies ++= Seq(
  "junit" % "junit" % "4.12" % Test,
  "org.scalatest" %% "scalatest" % "3.0.5" % "test",
  "com.novocode" % "junit-interface" % "0.11" % "test"
)

testOptions in Test := Seq(Tests.Argument(TestFrameworks.JUnit, "-a"))