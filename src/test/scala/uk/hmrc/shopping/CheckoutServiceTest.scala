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

  test("Calculates the cost of a cart with items and pack offers: 2x1 in apples, 3x2 in oranges"){
    val offers = List(
      new PackOffer(List(Apple, Apple), Apple.cost),
      new PackOffer(List(Orange, Orange, Orange), Orange.cost)
    )
    val cart = List(Orange, Apple, Orange, Apple, Orange)
    CheckoutService.checkout(cart, offers) should be (1.1f)
  }

}
