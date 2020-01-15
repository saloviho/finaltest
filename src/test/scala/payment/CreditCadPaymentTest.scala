package payment

import org.scalatest.{FunSuite, Matchers}

class CreditCadPaymentTest extends FunSuite with Matchers{

  test("fee test")
  {
    val creditCardPayment = new CreditCardPayment
    creditCardPayment.fee shouldBe 0.05
  }
}
