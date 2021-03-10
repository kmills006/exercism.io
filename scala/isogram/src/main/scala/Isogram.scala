object Isogram {
  // An isogram (also known as a "nonpattern word") is a word or phrase
  // without a repeating letter, however spaces and hyphens are allowed
  // to appear multiple times.
  def isIsogram(str: String): Boolean = {
    val letters = str
      .replaceAll("[^A-Za-z0-9]", "")
      .toLowerCase
      .toList

    // Cooler approach
    // val letters = str
    //   .filter(_.isLetter)
    //   .map(_.toLower)

    letters.toSet.size == letters.size
  }
}
