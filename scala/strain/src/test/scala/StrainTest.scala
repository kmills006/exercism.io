import org.scalatest.{Matchers, FlatSpec}

/** @version created manually * */
class StrainTest extends FlatSpec with Matchers {

  it should "handle empty keep" in {
    val resultFilter = Strain.keepFilter[Int](List(), x => x < 10)
    val resultFold   = Strain.keepFold[Int](List(), x => x < 10)
    val resultFor    = Strain.keepFor[Int](List(), x => x < 10)

    resultFilter should be(List.empty)
    resultFilter should be(List.empty)
    resultFor should be(List.empty)
  }

  it should "keep everything" in {
    val expectedList = List("a", "b", "c")
    val resultFilter = Strain.keepFilter[String](expectedList, _ => true)
    val resultFold   = Strain.keepFold[String](expectedList, _ => true)
    val resultFor    = Strain.keepFor[String](expectedList, _ => true)

    resultFilter should be(expectedList)
    resultFold should be(expectedList)
    resultFor should be(expectedList)
  }

  it should "keep first and last" in {
    val resultFilter = Strain.keepFilter[Int](List(1, 2, 3), x => x % 2 != 0)
    val resultFold   = Strain.keepFold[Int](List(1, 2, 3), x => x % 2 != 0)
    val resultFor    = Strain.keepFor[Int](List(1, 2, 3), x => x % 2 != 0)

    resultFilter should be(List(1, 3))
    resultFold should be(List(1, 3))
    resultFor should be(List(1, 3))
  }

  it should "keep neither first or last" in {
    val resultFilter =
      Strain.keepFilter[Int](List(1, 2, 3, 4, 5), x => x % 2 == 0)
    val resultFold = Strain.keepFold[Int](List(1, 2, 3, 4, 5), x => x % 2 == 0)
    val resultFor  = Strain.keepFor[Int](List(1, 2, 3, 4, 5), x => x % 2 == 0)

    resultFilter should be(List(2, 4))
    resultFold should be(List(2, 4))
    resultFor should be(List(2, 4))
  }

  it should "keep strings" in {
    val words =
      List("apple", "zebra", "banana", "zombies", "cherimoya", "zelot")

    val resultFilter = Strain.keepFilter[String](words, s => s.startsWith("z"))
    val resultFold   = Strain.keepFold[String](words, s => s.startsWith("z"))
    val resultFor    = Strain.keepFor[String](words, s => s.startsWith("z"))

    resultFilter should be(List("zebra", "zombies", "zelot"))
    resultFold should be(List("zebra", "zombies", "zelot"))
    resultFor should be(List("zebra", "zombies", "zelot"))
  }

  it should "keep sequences" in {
    val sequences = Seq(
      Seq(1, 2, 3),
      Seq(5, 5, 5),
      Seq(5, 1, 2),
      Seq(2, 1, 2),
      Seq(1, 5, 2),
      Seq(2, 2, 1),
      Seq(1, 2, 5)
    )
    val expected = Seq(Seq(5, 5, 5), Seq(5, 1, 2), Seq(1, 5, 2), Seq(1, 2, 5))
    val resultFilter =
      Strain.keepFilter[Seq[Int]](sequences, seq => seq.contains(5))
    val resultFold =
      Strain.keepFilter[Seq[Int]](sequences, seq => seq.contains(5))
    val resultFor =
      Strain.keepFor[Seq[Int]](sequences, seq => seq.contains(5))

    resultFilter should be(expected)
    resultFold should be(expected)
    resultFor should be(expected)
  }

  it should "handle empty discard" in {
    val resultFilter = Strain.discardFilter[Int](List(), x => x < 10)
    val resultFold   = Strain.discardFold[Int](List(), x => x < 10)
    val resultFor    = Strain.discardFor[Int](List(), x => x < 10)

    resultFilter should be(List.empty)
    resultFold should be(List.empty)
    resultFor should be(List.empty)
  }

  it should "discard first and last" in {
    val resultFilter = Strain.discardFilter[Int](List(1, 2, 3), x => x % 2 != 0)
    val resultFold   = Strain.discardFold[Int](List(1, 2, 3), x => x % 2 != 0)
    val resultFor    = Strain.discardFor[Int](List(1, 2, 3), x => x % 2 != 0)

    resultFilter should be(List(2))
    resultFold should be(List(2))
    resultFor should be(List(2))
  }

  it should "discard neither first or last" in {
    val resultFilter =
      Strain.discardFilter[Int](List(1, 2, 3, 4, 5), x => x % 2 == 0)
    val resultFold =
      Strain.discardFold[Int](List(1, 2, 3, 4, 5), x => x % 2 == 0)
    val resultFor =
      Strain.discardFor[Int](List(1, 2, 3, 4, 5), x => x % 2 == 0)

    resultFilter should be(List(1, 3, 5))
    resultFold should be(List(1, 3, 5))
    resultFor should be(List(1, 3, 5))
  }

  it should "discard strings" in {
    val words =
      List("apple", "zebra", "banana", "zombies", "cherimoya", "zelot")

    val resultFilter =
      Strain.discardFilter[String](words, s => s.startsWith("z"))
    val resultFold = Strain.discardFold[String](words, s => s.startsWith("z"))
    val resultFor  = Strain.discardFor[String](words, s => s.startsWith("z"))

    resultFilter should be(List("apple", "banana", "cherimoya"))
    resultFold should be(List("apple", "banana", "cherimoya"))
    resultFor should be(List("apple", "banana", "cherimoya"))
  }

  it should "discard sequences" in {
    val sequences = Seq(
      Seq(1, 2, 3),
      Seq(5, 5, 5),
      Seq(5, 1, 2),
      Seq(2, 1, 2),
      Seq(1, 5, 2),
      Seq(2, 2, 1),
      Seq(1, 2, 5)
    )

    val expected = Seq(Seq(1, 2, 3), Seq(2, 1, 2), Seq(2, 2, 1))

    val resultFilter =
      Strain.discardFilter[Seq[Int]](sequences, seq => seq.contains(5))
    val resultFold =
      Strain.discardFold[Seq[Int]](sequences, seq => seq.contains(5))
    val resultFor =
      Strain.discardFor[Seq[Int]](sequences, seq => seq.contains(5))

    resultFilter should be(expected)
    resultFold should be(expected)
    resultFor should be(expected)
  }
}
