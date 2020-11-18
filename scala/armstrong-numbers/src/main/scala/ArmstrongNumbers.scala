import scala.math.pow

object ArmstrongNumbers {
  def isArmstrongNumber(num: Int): Boolean = {
    num.toString
      .map(_.asDigit)
      .map(n => pow(n, num.toString.length).toInt)
      .sum == num
  }
}
