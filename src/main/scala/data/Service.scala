package data

case class Service(name: String, hRate: Double, cNum: Int, duration: Int) extends AnyRef with Item {
  val tax = 0.21
  def price: Double = hRate / 60 * duration * cNum * (1 + tax)
}
