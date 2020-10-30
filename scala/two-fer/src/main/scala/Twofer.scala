object Twofer {
  def twofer(name: String): String = {
    val n = if (name.isEmpty) "you" else name
    s"One for ${n}, one for me."
  }
}
