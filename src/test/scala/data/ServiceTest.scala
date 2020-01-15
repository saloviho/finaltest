package data

import org.scalatest.{FunSuite, Matchers}

class ServiceTest extends FunSuite with Matchers {
  test("price test")
  {
    val service = Service("Installation", 25, 2, 90)
    service.price shouldBe 90.75 +- 0.01
  }
}
