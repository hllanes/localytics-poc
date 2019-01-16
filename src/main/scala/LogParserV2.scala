import java.io.{BufferedInputStream, File, FileInputStream, _}
import java.util.zip.GZIPInputStream

import net.liftweb.json.{DefaultFormats, _}

import scala.io.Source

object LogParserV2 extends App {
  var keySet = scala.collection.mutable.Set[String]()
  var customKeySet = scala.collection.mutable.Set[String]()

  implicit val formats = DefaultFormats

  var pw:PrintWriter = null

  implicit class CSVWrapper(val log: LogRecord) extends AnyVal {
    def toCSV() = log.productIterator.map{
      case Some(value) => value
      case None => ""
      case rest => rest
    }.mkString("\t")
  }

  def recursiveListFiles(f: File): Array[File] = {
    val files = f.listFiles
    files ++ files.filter(_.isDirectory).flatMap(recursiveListFiles)
  }

  def parseLine(line: String, date: String, subdir: String, hour: String): Unit = {
    try {
      val l = parse(line).extract[LogRecord]

      l.file_date = Some(date)
      l.file_subdir = Some(subdir)
      l.file_hour = Some(hour)

      val r = parse(line).asInstanceOf[JObject]
      r.values.foreach{ case(k:String, v:Any) =>
        // Keep track of keys for "custom" element
        if (k == "custom") {
          val attr_pairs = v.asInstanceOf[Map[String, Any]].map(p => p._1 + ":" + p._2.toString
              .replaceAll("[\n\r]","")).mkString("^")
          l.custom_attrs = Some(attr_pairs)
          val ck = v.asInstanceOf[Map[String, Any]].keys
          val cks = ck.mkString("/")
          customKeySet += cks.toString
        }
      }
      pw.write(l.toCSV() + "\n")
      keySet ++= r.values.keys
    } catch {
      case e:Exception => {
        println(line)
        throw e
      }
    }
  }

  val dataDir = "/Users/hubertllanes/Projects/Localytics/data"
  val dirs = new File(dataDir).listFiles.filter(_.isDirectory)
  dirs.filter(d => d.getName > "20161212").foreach { dir =>
    pw = new PrintWriter(new File(s"localytics_${dir.getName}.txt"))
    val files = recursiveListFiles(dir).filter(_.isFile)
    files.foreach { f =>
      val file = Source.fromInputStream(
        new GZIPInputStream(
          new BufferedInputStream(
            new FileInputStream(f)
          )
        )
      )
      val pattern = ".*/data/([0-9]{4})([0-9]{2})([0-9]{2})/([a-z0-9-]+)/([0-9]{2}).log.gz".r
      val pattern(yyyy, mm, dd, subdir, hh) = f.toString
      println(f)
      println(s"${yyyy}-${mm}-${dd} ${subdir} ${hh}")
      val lines = file.getLines()
      lines.foreach { l => parseLine(l, s"${yyyy}-${mm}-${dd}", subdir, hh) }
    }
    pw.close
  }
}
