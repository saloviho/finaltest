package data

import org.scalatest.{FunSuite, Matchers}

class InvoiceTest extends FunSuite with Matchers {
  val invGen: InvoiceGenerator = new InvoiceGenerator
  val inv: Invoice = invGen.get

  test("price test")
  {
    inv.price shouldBe 3444.75 +- 0.01
  }

  test("final price test")
  {
    inv.finalPrice shouldBe 3616.99 +- 0.01
  }
}
