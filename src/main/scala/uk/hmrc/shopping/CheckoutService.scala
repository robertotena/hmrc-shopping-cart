package uk.hmrc.shopping

object CheckoutService {

  def checkout(items: List[Item], offers: List[Offer] = List.empty): Float = {
    val totalValue = items.map(_.cost).sum

    val totalDiscount = offers.foldLeft((items, 0f)) {
      case ((items, totalDiscount), offer)
      => {
        val (remainingItems, discount)  = offer.calculateOffer(items)
        (remainingItems, discount + totalDiscount)
      }
    }._2

    totalValue - totalDiscount
  }

}
