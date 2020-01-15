package data

case class Product(name: String, unitPrice: Double, quantity: Int, tax: Double) extends AnyRef with Item {
  def price: Double = unitPrice * quantity * (1 + tax)
}