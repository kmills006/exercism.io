import java.time.LocalDate
import java.time.LocalDateTime
import scala.math.pow

object Gigasecond {
  private val gigasecond = pow(10, 9)

  def add(startDate: LocalDate): LocalDateTime = add(startDate.atStartOfDay())

  def add(startDateTime: LocalDateTime): LocalDateTime =
    startDateTime.plusSeconds(gigasecond.toLong)
}
