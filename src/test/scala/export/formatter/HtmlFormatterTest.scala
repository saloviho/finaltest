package `export`.formatter

import java.text.SimpleDateFormat

import data.{Customer, Invoice, InvoiceGenerator, Product, Service}
import org.scalatest.{FunSuite, Matchers, TestSuite}
import payment.CreditCardPayment

import scala.io.Source

class HtmlFormatterTest extends FunSuite with Matchers {
  val invGen = new InvoiceGenerator
  val inv = invGen.get

  test("without css") {
    val correct = Source.fromResource("htmlReportNoCss.txt").getLines.mkString("\n")
    val formatter = new HtmlFormatter(None);
    val result = formatter.format(inv)
    result shouldBe correct
  }


  test("with css") {
    val correct = Source.fromResource("htmlReportWithCss.txt").getLines.mkString("\n")
    val formatter = new HtmlFormatter(Some("styles.css"));
    val result = formatter.format(inv)
    result shouldBe correct
  }
}
