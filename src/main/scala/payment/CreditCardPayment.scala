package payment

class CreditCardPayment extends AnyRef with PaymentSystem {
  def name = "Credit Card"
  def fee = 0.05
}
