import scala.math.pow

object DifferenceOfSquares {
  private val FACTOR = 2

  def sumOfSquares(n: Int): Int        = getRange(n).map(pow(_, FACTOR)).sum.toInt
  def squareOfSum(n: Int): Int         = pow(getRange(n).sum, FACTOR).toInt
  def differenceOfSquares(n: Int): Int = squareOfSum(n) - sumOfSquares(n)

  private def getRange(n: Int): Range = (1 to n)
}
