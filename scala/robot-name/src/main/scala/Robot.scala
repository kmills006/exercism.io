class Robot {
  private var _name: String = RobotName.generate.next()

  def name: String = _name
  def reset()      = _name = RobotName.generate.next()
}
