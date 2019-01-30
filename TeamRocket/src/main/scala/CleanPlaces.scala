import org.apache.spark.SparkContext
import org.apache.spark.SparkConf
import org.apache.spark.sql.{DataFrame, SparkSession}
import org.apache.spark.sql.functions.{concat, lit}
// import spark.implicits._
import org.apache.spark.sql.functions.{col, substring, to_date}


object CleanPlaces {

  def main(args: Array[String]) {




    val PATH = "src/main/ressources/FichiersPlaces/" // HDFS_PATH : "/home/fitec/git/projet/" //"hdfs://172.17.0.4:8020/user/cloudera/projet/dataRaw/"
    //val PATH = "hdfs://172.17.0.3:8020/user/cloudera/Projet/"

    //Create a SparkContext to initialize Spark
    val conf = new SparkConf().setMaster("local[*]").setAppName("Concat Places")
    val sc = new SparkContext(conf)
    val spark = SparkSession.builder().getOrCreate()
    // spark.sparkContext.setLogLevel("ERROR")
/*
    val df = spark.read
      .format("csv")
      .option("header", "true") //reading the headers
      .option("mode", "DROPMALFORMED")
      .load("hdfs://172.17.0.3:8020/user/cloudera/Projet/caracteristiques_2015.csv")
*/


    // Load the text into Spark

    def loadfileFromHDFS(flagInf:Boolean,flagHeader:Boolean,fileName: String, fileType: String, delimiter: String): DataFrame = {

      val file_location = PATH + fileName;
      spark.read.format(fileType).option("inferSchema", flagInf).option("header", flagHeader).option("sep", delimiter).load(file_location)
    }
    val textFile05 = loadfileFromHDFS(true, true, "lieux_2005.csv", "csv", ",")
    val textFile06 = loadfileFromHDFS(true, true, "lieux_2006.csv", "csv", ",")
    val textFile07 = loadfileFromHDFS(true, true, "lieux_2007.csv", "csv", ",")
    val textFile08 = loadfileFromHDFS(true, true, "lieux_2008.csv", "csv", ",")
    val textFile09 = loadfileFromHDFS(true, true, "lieux_2009.csv", "csv", ",")
    val textFile10 = loadfileFromHDFS(true, true, "lieux_2010.csv", "csv", ",")
    val textFile11 = loadfileFromHDFS(true, true, "lieux_2011.csv", "csv", ",")
    val textFile12 = loadfileFromHDFS(true, true, "lieux_2012.csv", "csv", ",")
    val textFile13 = loadfileFromHDFS(true, true, "lieux_2013.csv", "csv", ",")
    val textFile14 = loadfileFromHDFS(true, true, "lieux_2014.csv", "csv", ",")
    val textFile15 = loadfileFromHDFS(true, true, "lieux_2015.csv", "csv", ",")
    val textFile16 = loadfileFromHDFS(true, true, "lieux_2016.csv", "csv", ",")
    val textFile17 = loadfileFromHDFS(true, true, "lieux-2017.csv", "csv", ",")
    //val textFile05 = sc.textFile(PATH+"caracteristiques_2005.csv").cache()
    //val textFile06 = sc.textFile(PATH+"caracteristiques_2006.csv").cache()
    /*val textFile07 = sc.textFile(PATH+"caracteristiques_2007.csv")
    val textFile08 = sc.textFile(PATH+"caracteristiques_2008.csv")
    val textFile09 = sc.textFile(PATH+"caracteristiques_2009.csv")
    val textFile10 = sc.textFile(PATH+"caracteristiques_2010.csv")
    val textFile11 = sc.textFile(PATH+"caracteristiques_2011.csv")
    val textFile12 = sc.textFile(PATH+"caracteristiques_2012.csv")
    val textFile13 = sc.textFile(PATH+"caracteristiques_2013.csv")
    val textFile14 = sc.textFile(PATH+"caracteristiques_2014.csv")
    val textFile15 = sc.textFile(PATH+"caracteristiques_2015.csv")
    val textFile16 = sc.textFile(PATH+"caracteristiques_2016.csv")
    val textFile17 = sc.textFile(PATH+"caracteristiques_2017.csv")
*/
    // Caracteristiques = sc.union([textFile05,textFile06,textFile07,textFile08])
    // println(textFile05.collect())
    // textFile05TEST.union(textFile06TEST).saveAsTextFile("src/main/ressources/FichierCarac/caracteristiques.csv")
    // textFile05.union(textFile06).union(textFile07).union(textFile08).union(textFile09).union(textFile10).union(textFile11).union(textFile12).union(textFile13).union(textFile14).union(textFile15).union(textFile16).union(textFile17).write.format("com.databricks.spark.csv").save("src/main/ressources/Output/caracteristiques.csv")
    textFile05.show()
    textFile06.show()
    textFile07.show()
    textFile08.show()
    textFile09.show()
    textFile10.show()
    textFile11.show()
    textFile12.show()
    textFile13.show()
    textFile14.show()
    textFile15.show()
    textFile16.show()
    textFile17.show()

    textFile05.union(textFile06).union(textFile07).union(textFile08).union(textFile09).union(textFile10).union(textFile11).union(textFile12).union(textFile13).union(textFile14).union(textFile15).union(textFile16).union(textFile17).coalesce(1).write.csv("src/main/ressources/output4")
    //textFile05.union(textFile06).union(textFile07).union(textFile08).union(textFile09).union(textFile10).union(textFile11).union(textFile12).union(textFile13).union(textFile14).union(textFile15).union(textFile16).union(textFile17).coalesce(1).write.csv("src/main/ressources/output2")
    // temp.coalesce(1).write.csv("src/main/ressources/output")
    //format("com.databricks.spark.csv").save("src/main/ressources/output")
    //.reduce(_ + _)

/*
    val sc: SparkContext // An existing SparkContext.
    val sqlContext = new org.apache.spark.sql.SQLContext(sc)

    import sqlContext.implicits._
    val df = sqlContext.read.csv("src/main/resources/caracteristiques_2005.csv")

    // Displays the content of the DataFrame to stdout
    df.show()
*/

    // Marche pas ! textFile05.repartition(1).saveAsTextFile("src/main/resources/test1")
    // Use mapReduce for concat

   // textFile05.coalesce(1).write.format("com.databricks.spark.cvs").save("...path...")
    //dbutils.fs.cp("...path...", "..path.. ..csv")

    // counts.saveAsTextFile("/tmp/cho_clean")


  }

}

