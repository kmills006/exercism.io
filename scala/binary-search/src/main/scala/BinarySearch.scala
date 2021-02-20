
/*
 *Binary Search is an algorithm that helps us find an element in a
 sorted array in O(log n) time. Its algorithm works on the principle
 of Divide and Conquer and it works only when the available data is sorted.
 HELP FOUND HERE: https://www.geeksforgeeks.org/binary-search-in-scala/
*/
object BinarySearch {
  def find(ls: List[Int], elementToSearchFor: Int): Option[Int] = {
    def search(low: Int, high: Int): Int = {
      if (low > high) -1
      else {
        val middle = low + (high - low) / 2
        val element = ls.lift(middle)

        element match {
          case Some(e: Int) if e == elementToSearchFor => middle
          case Some(e: Int) if e > elementToSearchFor => search(low, middle - 1)
          case Some(e: Int) if e < elementToSearchFor => search(middle + 1, high)
          case None => -1
        }
      }
    }

    val index = search(0, ls.length)

    if (index == -1) None
    else Some(index)
  }

  // Using var :vomit:
  def findNonRecursive(ls: List[Int], elementToSearchFor: Int): Option[Int] = {
    var low = 0
    var high = ls.length

    while (low <= high) {
      val middle = low + (high - low) / 2
      val element = ls(middle)

      if (element == elementToSearchFor) {
        return Some(middle)
      } else if (element > elementToSearchFor) {
        high = middle - 1
      } else {
        low = middle + 1
      }
    }

    None
  }
}
