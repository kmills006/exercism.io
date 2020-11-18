object FlattenArray {
  def flatten(ls: List[Any]): List[Any] = {
    ls.flatMap(e => {
      e match {
        case i: List[_] => flatten(i)
        case a: Any     => List(a)
        case _          => Option(null)
      }
    })
  }
}
