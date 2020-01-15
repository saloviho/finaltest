package payment

import org.scalatest.{FunSuite, Matchers}


class WireTransferPaymentTest extends FunSuite with Matchers{

  test("fee test")
  {
    val wireTransferPayment = new WireTransferPayment
    wireTransferPayment.fee shouldBe 0.0
  }
}
