package uk.hmrc.shopping

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers

class PackOfferTest extends AnyFunSuite with Matchers {

  test("calculates a single pack offer once") {
    new PackOffer(List(Apple, Apple), Apple.cost).calculateOffer(List(Apple, Orange, Apple)) should be((List(Orange), Apple.cost))
  }

  test("calculates a single pack offer more than once") {
    new PackOffer(List(Apple, Apple), Apple.cost).calculateOffer(List(Apple, Orange, Apple, Apple, Apple)) should be((List(Orange), Apple.cost * 2))
  }

  test("does not calculate any offer") {
    new PackOffer(List(Apple, Apple), Apple.cost).calculateOffer(List(Orange)) should be((List(Orange), 0))
  }

}