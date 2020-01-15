package `export`.formatter

import java.text.SimpleDateFormat

import data.{Customer, Invoice, InvoiceGenerator, Product, Service}
import org.scalatest.{FunSuite, Matchers, TestSuite}
import payment.CreditCardPayment

import scala.io.Source

class MarkdownFormatterTest extends FunSuite with Matchers{
  val invGen = new InvoiceGenerator
  val inv = invGen.get

  test("test") {
    val correct = Source.fromResource("markdown.txt").getLines.mkString("\n")
    val formatter = new MarkdownFormatter();
    val result = formatter.format(inv)
    result shouldBe correct
  }
}

