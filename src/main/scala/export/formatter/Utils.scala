package `export`.formatter

import java.util.Date

object Utils {
  /* Solution from stackoverflow */
  def roundAt(p: Int)(n: Double): String = {val format = "%." + p.toString + "f"; format.format(n)}

  def dateFormat(d: Date): String = {
    val format = new java.text.SimpleDateFormat("d.M.yyyy")
    format.format(d)
  }
}
