object PhoneNumber {
  private val invalidRange = '0' to '1'

  def clean(input: String): Option[String] = {
    val phone = input.filter(_.isDigit)

    phone.length match {
      case 11 => {
        if (phone.startsWith("1")) Some(phone.tail)
        else None
      }

      case 10 => {
        if (isInvalid(phone(0)) || isInvalid(phone(3))) None
        else Some(phone)
      }

      case _ => None
    }
  }

  def isInvalid(c: Char): Boolean = invalidRange contains (c)
}
