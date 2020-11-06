object Etl {
  def transform(scores: Map[Int, Seq[String]]): Map[String, Int] =
    /*
     * flatMap() is a blend between map and flatten.
     */
    scores.flatMap {
      case (score, letters) => letters.map(_.toLowerCase -> score)
    }
}
