object RnaTranscription {
  // private val complements = Map[String, String](
  //   "G" -> "C",
  //   "C" -> "G",
  //   "T" -> "A",
  //   "A" -> "U"
  // );

  def toRna(dna: String): Option[String] = {
    val complement = dna.map {
      case 'G' => 'C'
      case 'C' => 'G'
      case 'T' => 'A'
      case 'A' => 'U'
    }

    Some(complement)
  }

  // def toRna(dna: String): Option[String] = Some(
  //   dna
  //     .toList
  //     .map(c => complements(c.toString))
  //     .mkString
  // )
}
