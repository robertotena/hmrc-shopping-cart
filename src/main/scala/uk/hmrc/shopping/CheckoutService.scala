package uk.hmrc.shopping

object CheckoutService {

  def checkout(items: List[Item]): Float = {
    items.map(_.cost).sum
  }

}
