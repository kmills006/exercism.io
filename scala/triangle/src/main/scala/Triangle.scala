case class Triangle(a: Double, b: Double, c: Double) {
  private val sides = List[Double](a, b, c)

  // Sets are Iterables that contain no duplicate elements.
  private val size = sides.toSet.size

  def equilateral: Boolean = isValid && (size == 1)
  def isosceles: Boolean = isValid && (size <= 2)
  def scalene: Boolean = isValid && (size == 3)

  private def isValid: Boolean = allSidesAreNonZero && honorsTriangleInequality

  private def allSidesAreNonZero: Boolean = sides.forall(_ > 0)

  // The triangle inequality states that for any triangle,
  // the sum of the lengths of any two sides must be greater than
  // or equal to the length of the remaining side.
  // a + b > c, b + c > a, c + a > b
  // |a - b| < c < a + b
  // 2max(a, b, c) < a + b + c
  private def honorsTriangleInequality: Boolean = {
    sides.forall(_ * 2 <= sides.sum)
  }
}
