import Bearing.Bearing

case class Robot(bearing: Bearing, coordinates: (Int, Int)) {
  def turnRight(): Robot =
    bearing match {
      case Bearing.North => Robot(Bearing.East, coordinates)
      case Bearing.East  => Robot(Bearing.South, coordinates)
      case Bearing.South => Robot(Bearing.West, coordinates)
      case Bearing.West  => Robot(Bearing.North, coordinates)
      case _             => Robot(bearing, coordinates)
    }

  def turnLeft(): Robot =
    bearing match {
      case Bearing.North => Robot(Bearing.West, coordinates)
      case Bearing.East  => Robot(Bearing.North, coordinates)
      case Bearing.South => Robot(Bearing.East, coordinates)
      case Bearing.West  => Robot(Bearing.South, coordinates)
      case _             => Robot(bearing, coordinates)
    }

  def advance(): Robot =
    bearing match {
      case Bearing.North => Robot(bearing, (coordinates._1, coordinates._2 + 1))
      case Bearing.South => Robot(bearing, (coordinates._1, coordinates._2 - 1))
      case Bearing.East  => Robot(bearing, (coordinates._1 + 1, coordinates._2))
      case Bearing.West  => Robot(bearing, (coordinates._1 - 1, coordinates._2))
      case _             => Robot(bearing, (0, 0))
    }

  def simulate(command: String): Robot =
    command.foldLeft(this) { (r, c) =>
      c match {
        case 'L' => r.turnLeft()
        case 'R' => r.turnRight()
        case 'A' => r.advance()
        case _   => this
      }
    }
}
