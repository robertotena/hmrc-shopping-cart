package uk.hmrc.shopping

import scala.annotation.tailrec

trait Offer {
  def calculateOffer(cart: List[Item]): (List[Item], Float)
}

class PackOffer(val requiredItems: List[Item], val discount: Float) extends Offer {

  def calculateOffer(cart: List[Item]): (List[Item], Float) = {
    calculateOfferRec(cart, 0f)
  }

  @tailrec
  private def calculateOfferRec(cart: List[Item], totalDiscount: Float): (List[Item], Float) = {
    val remainingCart = cart.diff(requiredItems)
    if (remainingCart.equals(cart)) {
      (remainingCart, totalDiscount)
    }
    else {
      calculateOfferRec(remainingCart, totalDiscount + discount)
    }
  }

}
