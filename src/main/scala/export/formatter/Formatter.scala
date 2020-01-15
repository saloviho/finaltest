package `export`.formatter

import data.Invoice

trait Formatter {
  def format(invoice: Invoice): String
}
