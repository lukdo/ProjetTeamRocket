name := "TeamRocket"

version := "0.1"

scalaVersion := "2.12.8"

// https://mvnrepository.com/artifact/org.apache.spark/spark-core
libraryDependencies += "org.apache.spark" %% "spark-core" % "2.4.0"



libraryDependencies ++= Seq(
  "org.apache.spark" %% "spark-core" % "2.4.0",
  "org.apache.spark" %% "spark-sql" % "2.4.0",
  "org.apache.spark" %% "spark-mllib" % "2.4.0",
  "org.apache.spark" %% "spark-streaming" % "2.4.0",
  "org.apache.spark" %% "spark-hive" % "2.4.0",
  "mysql" % "mysql-connector-java" % "5.1.6"
)

/*

libraryDependencies ++= Seq("org.apache.spark" % "spark-sql_2.11" % "2.2.0",

  "org.apache.spark" % "spark-sql-kafka-0-10_2.11" % "2.2.0",

  "org.apache.kafka" % "kafka-clients" % "0.11.0.1")
 */