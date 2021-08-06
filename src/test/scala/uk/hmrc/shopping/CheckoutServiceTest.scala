package uk.hmrc.shopping

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers

class CheckoutServiceTest extends AnyFunSuite with Matchers {

  test("Calculates the cost of a cart with items") {
    CheckoutService.checkout(List(Orange, Apple, Orange)) should be (1.1f)
  }

  test("An empty cart should cost zero") {
    CheckoutService.checkout(List()) should be (0f)
  }

}
