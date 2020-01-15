package data

import java.util.Date
import payment.PaymentSystem

case class Invoice(id: Int, due: Date, payment: PaymentSystem, customer: Customer, productList: List[Item]) {
  def price: Double = productList.foldLeft(0.0){(acc, el) => acc + el.price}
  def finalPrice: Double = price + price * payment.fee
}
