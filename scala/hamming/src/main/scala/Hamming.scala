object Hamming {
  def distance(strandA: String, strandB: String): Option[Int] =
    (strandA, strandB) match {
      case (a, b) if (a.length != b.length) => None
      case (a, b)                           => Option(a.zip(b).count(p => p._1 != p._2))
    }
}
