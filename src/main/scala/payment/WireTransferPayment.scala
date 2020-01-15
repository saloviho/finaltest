package payment

class WireTransferPayment extends AnyRef with PaymentSystem {
  def name = "Wire Transfer"
  def fee = 0
}
