package payment

trait PaymentSystem {
  def name: String
  def fee: Double
}
