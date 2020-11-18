import scala.math.sqrt

import NumberType.NumberType

// The Greek mathematician Nicomachus devised a classification scheme for
// natural numbers, identifying each as belonging uniquely to the categories
// of perfect, abundant, or deficient based on their aliquot sum. The aliquot
// sum is defined as the sum of the factors of a number not including the
// number itself. For example, the aliquot sum of 15 is (1 + 3 + 5) = 9
object PerfectNumbers {
  def classify(num: Int): Either[String, NumberType] = {
    if (num < 1) Left("Classification is only possible for natural numbers.")
    else
      factors(num).sum match {
        case n if (isPrimeNumber(n) || n < num) => {
          Right(NumberType.Deficient)
        }
        case n if (n == num) => Right(NumberType.Perfect)
        case n if (n > num)  => Right(NumberType.Abundant)
      }
  }

  private def isPrimeNumber(num: Int): Boolean = {
    !((2 to num - 1) exists (num % _ == 0))
  }

  private def factors(num: Int): Seq[Int] = {
    (1 to num / 2).filter(divisor => ((num % divisor) == 0))
  }
}
