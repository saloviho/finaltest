package `export`

import java.io.{Writer}

import formatter.Formatter
import data.Invoice

class Exporter(formatter: Formatter, writer: Writer) {
  def export(invoice: Invoice): Writer =
  {
    val formatted = formatter.format(invoice)
    writer.write(formatted)
    writer
  }
}
