object ScrabbleScore {
  private val possibleScores = Map[Int, List[String]](
    1  -> List("A", "E", "I", "O", "U", "L", "N", "R", "S", "T"),
    2  -> List("D", "G"),
    3  -> List("B", "C", "M", "P"),
    4  -> List("F", "H", "V", "W", "Y"),
    5  -> List("K"),
    8  -> List("J", "X"),
    10 -> List("Q", "Z")
  )

  def score(word: String): Int = {
    word.toList
      .map(letter => {
        possibleScores
          .find(_._2 contains letter.toString.toUpperCase)
          .map(_._1)
          .getOrElse(0)
      })
      .sum
  }
}
