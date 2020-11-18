object CollatzConjecture {
  def steps(num: Int, currentStep: Int = 0): Option[Int] = {
    val nextStep = currentStep + 1

    num match {
      case 1             => Option(currentStep)
      case n if (n <= 0) => None
      case n if (n % 2) == 0 => steps((n / 2), nextStep)
      case n => steps((n * 3) + 1, nextStep)
    }
  }
}
