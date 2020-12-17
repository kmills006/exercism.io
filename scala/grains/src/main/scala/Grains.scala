object Grains {
  private val squares = 1 to 64
  private val ratio   = BigInt(2)

  def square(num: Int): Option[BigInt] = {
    num match {
      case n if squares contains n => Some(sq(n))
      case _                       => None
    }
  }

  def total: BigInt = squares.map(sq).sum

  private def sq(n: Int): BigInt = ratio.pow(n - 1)
}
