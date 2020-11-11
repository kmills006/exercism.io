// 1 = wink
// 10 = double blink
// 100 = close your eyes
// 1000 = jump
// 10000 = Reverse the order of the operations in the secret handshake.

object SecretHandshake {
  private val handshake = Map(
    0x1 -> "wink",
    0x2 -> "double blink",
    0x4 -> "close your eyes",
    0x8 -> "jump"
  )

  private val reverse = 0x10

  def commands(i: Int): List[String] = {
    val binary = i.toBinaryString
    val result = handshake.filterKeys(key => check(i, key)).values.toList

    check(i, reverse) match {
      case true => result.reverse
      case _    => result
    }
  }

  def check(number: Int, hex: Int): Boolean = (number & hex) == hex
}
