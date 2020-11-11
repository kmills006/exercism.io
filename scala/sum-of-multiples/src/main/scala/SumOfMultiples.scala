object SumOfMultiples {
  def sum(factors: Set[Int], limit: Int): Int = {
    val result = for {
      number <- factors
      multiples <- {
        (1 to limit)
          .map(multiplyBy(number, _))
          .filterNot(hasReachedLimit(_, limit))
      }
    } yield multiples

    result.sum
  }

  private def multiplyBy(number: Int, index: Int): Int = number * index
  private def hasReachedLimit(number: Int, limit: Int): Boolean =
    number >= limit
}
