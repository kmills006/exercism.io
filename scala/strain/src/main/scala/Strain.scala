object Strain {
  def keepFilter[A](ls: Seq[A], predicate: (A) => Boolean): Seq[A] =
    ls.filter(predicate)

  def keepFold[A](ls: Seq[A], predicate: (A) => Boolean): Seq[A] =
    ls.foldRight(Seq[A]()) {
      case (a, seq) => if (predicate(a)) a +: seq else seq
    }

  def keepFor[A](ls: Seq[A], predicate: (A) => Boolean): Seq[A] =
    for { a <- ls if predicate(a) } yield a

  def discardFilter[A](ls: Seq[A], predicate: (A) => Boolean): Seq[A] =
    ls.filter(a => !predicate(a))

  def discardFold[A](ls: Seq[A], predicate: (A) => Boolean): Seq[A] =
    ls.foldRight(Seq[A]()) {
      case (a, seq) => if (predicate(a)) seq else a +: seq
    }

  def discardFor[A](ls: Seq[A], predicate: (A) => Boolean): Seq[A] =
    for { a <- ls if !predicate(a) } yield a
}
