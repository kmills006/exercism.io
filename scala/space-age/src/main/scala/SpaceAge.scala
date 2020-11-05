object SpaceAge {
  private val SecondsInEarthYear: Int = 31557600

  trait Planet {
    def orbitalPeriodOnEarth: Double = orbitalPeriod(this)
  }

  def orbitalPeriod(planet: Planet): Double =
    planet match {
      case Mercury => 0.2408467
      case Venus   => 0.61519726
      case Mars    => 1.8808158
      case Jupiter => 11.862615
      case Saturn  => 29.447498
      case Uranus  => 84.016846
      case Neptune => 164.79132
      case _       => 0.00
    }

  case object Mercury extends Planet
  case object Venus   extends Planet
  case object Mars    extends Planet
  case object Jupiter extends Planet
  case object Saturn  extends Planet
  case object Uranus  extends Planet
  case object Neptune extends Planet

  def ageOn(planet: Planet): Double => Double =
    (seconds: Double) => {
      onEarth(seconds) / planet.orbitalPeriodOnEarth
    }

  def onEarth(seconds: Double): Double   = seconds / SecondsInEarthYear
  def onMercury(seconds: Double): Double = ageOn(Mercury)(seconds)
  def onVenus(seconds: Double): Double   = ageOn(Venus)(seconds)
  def onMars(seconds: Double): Double    = ageOn(Mars)(seconds)
  def onJupiter(seconds: Double): Double = ageOn(Jupiter)(seconds)
  def onSaturn(seconds: Double): Double  = ageOn(Saturn)(seconds)
  def onUranus(seconds: Double): Double  = ageOn(Uranus)(seconds)
  def onNeptune(seconds: Double): Double = ageOn(Neptune)(seconds)
}
