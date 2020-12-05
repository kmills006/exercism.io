import scala.collection.mutable.HashSet
import scala.util.Random

class NameHistory {
  private val history: HashSet[String] = HashSet.empty[String]

  def store(name: String): String = {
    history.add(name)
    name
  }
  def unavailable(name: String) = history.contains(name)
}

object RobotName {
  private val history: NameHistory = new NameHistory

  def generate: Iterator[String] =
    Iterator
      .continually(generateName)
      .filterNot(history.unavailable)
      .map(history.store)

  private def generateName: String = letters() + digits

  private def digits: Int = (100 + Random.nextInt(999))

  private def letters(str: String = ""): String = {
    str match {
      case s if s.length == 2 => s.toUpperCase
      case s => {
        letters(s + Random.alphanumeric.filter(_.isLetter).head)
      }
    }
  }
}
