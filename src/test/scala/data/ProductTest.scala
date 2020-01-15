package data

import org.scalatest.{FunSuite, Matchers}

class ProductTest extends FunSuite with Matchers{
  test("price test")
  {
    val product = Product("PC", 1100.0, 2, 0.07)
    product.price shouldBe 2354.0 +- 0.01
  }
}
