object Raindrops {
  private val sounds: Map[Int, String] = Map(
    3 -> "Pling",
    5 -> "Plang",
    7 -> "Plong"
  )

  def convert(n: Int): String = {
    sounds.collect {
      case (key, sound) if (n % key) == 0 => sound
    } match {
      case Nil => n.toString
      case s   => s.mkString
    }
  }
}
