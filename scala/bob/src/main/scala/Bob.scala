object Bob {
  trait Teenager {
    def blanketStatment: String  = "Whatever."
    def forcefulQuestion: String = "Calm down, I know what I'm doing!"
    def question: String         = "Sure."
    def shouting: String         = "Whoa, chill out!"
    def silence: String          = "Fine. Be that way!"
  }

  case object Bob extends Teenager

  def response(statement: String): String = {
    statement.trim match {
      case s if s.isEmpty                     => Bob.silence
      case s if shouting(s) && questioning(s) => Bob.forcefulQuestion
      case s if shouting(s)                   => Bob.shouting
      case s if questioning(s)                => Bob.question
      case _                                  => Bob.blanketStatment
    }
  }

  def shouting(statement: String): Boolean = {
    statement.forall(!_.isLower) && statement.exists(_.isLetter)
  }

  def questioning(statement: String): Boolean =
    statement.endsWith("?")
}
