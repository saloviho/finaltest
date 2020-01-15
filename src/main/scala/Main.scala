import java.io.StringWriter
import java.text.SimpleDateFormat
import java.util.Date

import data.{Customer, Invoice, Product, Service}
import payment.CreditCardPayment
import `export`.Exporter
import `export`.formatter.{Formatter, MarkdownFormatter}

object Main {
  def main(args: Array[String]): Unit = {
    val p1 = Product("PC", 1100, 2, 0.07)
    val p2 = Product("Monitor", 500, 2, 0.00)
    val s1 = Service("Installation", 25, 2, 90)
    val items = List(p1, p2, s1)
    val date = new SimpleDateFormat("dd.MM.yyyy").parse("1.2.2020")
    val invoice = Invoice(1, date, new CreditCardPayment,
      Customer("John Doe", 12345678, "360 Huntington Ave, Boston, MA 02115"), items)

    val exporter = new Exporter(new MarkdownFormatter, new StringWriter())
    val exported = exporter.`export`(invoice)
    print(exported.toString)
  }
}
