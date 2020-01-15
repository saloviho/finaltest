package `export`.formatter

import data.{Invoice, Item, Product, Service}
import Utils._
class MarkdownFormatter extends AnyRef with Formatter {

  def getItemsAsString(items: List[Item]): String =
  {
    var result = ""
    items.foreach(e => e match {
      case p: Product => {
        result = result + s"- ${p.name} (qty: ${p.quantity}, pu: ${roundAt(1)(p.unitPrice)}, tax: ${(p.tax * 100).toInt}%) ... ${roundAt(2)(p.price)}\n"
      }
      case s: Service => {
        result = result + s"- ${s.name} (duration: ${s.duration}, contractors: ${s.cNum}, rate: ${roundAt(1)(s.hRate)}/hour, tax: ${(s.tax * 100).toInt}%) ... ${roundAt(2)(s.price)}\n"
      }
    })
    result
  }

  def format(invoice: Invoice): String = {
      val customer = invoice.customer
      val items = invoice.productList
      val payment = invoice.payment
      val due = dateFormat(invoice.due)

      val begin =
      s"""|# Invoice (${invoice.id}) due to ${due}
          |
          |## Customer
          |${customer.name} (${customer.taxId})
          |${customer.address}
          |
          |## Items
          |""".stripMargin

    val middle = getItemsAsString(items)

     val end = s"""|
         |## Summary
         |Price for items: ${roundAt(2)(invoice.price)}
         |Total due: ${roundAt(2)(invoice.finalPrice)}
         |Payment type: ${payment.name}""".stripMargin

    begin + middle + end
  }
}
