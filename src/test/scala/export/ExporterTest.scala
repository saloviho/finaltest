package `export`

import java.io.{File, FileWriter, PrintWriter, StringWriter}
import java.text.SimpleDateFormat

import `export`.Exporter
import `export`.formatter.{HtmlFormatter, MarkdownFormatter}
import data.{Customer, Invoice, InvoiceGenerator, Product, Service}
import org.scalatest.{FunSuite, Matchers}
import payment.CreditCardPayment

import scala.io.Source

class ExporterTest extends FunSuite with Matchers{
  val invGen: InvoiceGenerator = new InvoiceGenerator
  val inv: Invoice = invGen.get

  test("html + console") {
    val exporter = new Exporter(new HtmlFormatter(None), new PrintWriter(System.out))
    val writer = exporter.`export`(inv)
    writer.flush()
  }

  test("markdown + string") {
    val correct = Source.fromResource("markdown.txt").getLines.mkString("\n")
    val exporter = new Exporter(new MarkdownFormatter(), new StringWriter())
    val writer = exporter.`export`(inv)

    writer.toString shouldBe correct
  }


  test("markdown + file") {
    val correct = Source.fromResource("markdown.txt").getLines.mkString("\n")
    val path = getClass.getResource("/markdownFileWriterResult.txt").getPath
    val exporter = new Exporter(new MarkdownFormatter(), new FileWriter(path))
    val writer = exporter.`export`(inv)
    writer.flush()

    val result = Source.fromResource("markdownFileWriterResult.txt").getLines.mkString("\n")
    result shouldBe correct
  }
}