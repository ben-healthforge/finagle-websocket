val libVersion = "19.9.0"

val baseSettings = Defaults.coreDefaultSettings ++ Seq(
  libraryDependencies ++= Seq(
    "com.twitter" %% "finagle-core" % libVersion,
    "com.twitter" %% "finagle-netty4" % libVersion,
    "org.scalatest" %% "scalatest" % "3.0.8" % Test,
    "junit" % "junit" % "4.12" % Test
  )
)

val buildSettings = Seq(
  organization := "com.github.finagle",
  version := libVersion,
  scalaVersion := "2.12.10",
  crossScalaVersions := Seq("2.11.12", "2.12.10"),
  scalacOptions ++= Seq("-deprecation", "-feature", "-Xexperimental")
)

val publishSettings = Seq(
  publishMavenStyle := true,
  publishArtifact := true,
  publishTo := Some(Resolver.file("localDirectory", file(Path.userHome.absolutePath + "/workspace/mvn-repo"))),
  licenses := Seq("Apache 2.0" -> url("http://www.apache.org/licenses/LICENSE-2.0")),
  homepage := Some(url("https://github.com/finagle/finagle-websocket")),
  pomExtra := (
    <scm>
      <url>git://github.com/finagle/finagle-websocket.git</url>
        <connection>scm:git://github.com/finagle/finagle-websocket.git</connection>
        </scm>
      <developers>
      <developer>
      <id>sprsquish</id>
      <name>Jeff Smick</name>
      <url>https://github.com/sprsquish</url>
        </developer>
      </developers>)
)

val finagleWebsocket = (project in file("."))
  .settings(
    Defaults.itSettings ++
      baseSettings ++
      buildSettings ++
      publishSettings
  )
  .configs(IntegrationTest)