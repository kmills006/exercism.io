object Pangrams {
  private val LETTERS = ('a' to 'z')

  def isPangram(input: String): Boolean = {
    // original solution
    input.toList
      .map(_.toLower)
      .distinct
      .filter(LETTERS contains _)
      .length == LETTERS.length
  }

  def betterSolution(sentence: String): Boolean = {
    def isCharInSentence(char: Char) = sentence.toLowerCase contains char

    LETTERS forall isCharInSentence
  }
}
