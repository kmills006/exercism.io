case class Matrix(s: String) {
  // Split by new line character
  // Convert to Vector
  // Map over Vector, split by space char, and return Vector[Int]
  val matrix: Vector[Vector[Int]] = s
    .split("\n")
    .toVector
    .map(
      _.split(" ").toVector.map(_.toInt)
    )

  // Select an element by its index in the Vector
  def row(r: Int): Vector[Int] = matrix(r)

  // Map over The Matrix and select and return a new Vector with the elements
  // at its index
  def column(c: Int): Vector[Int] = matrix.map(v => v(c))
}
