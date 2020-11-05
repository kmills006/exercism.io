class School {
  private var database: DB = Map()

  type DB = Map[Int, Seq[String]]

  def add(name: String, g: Int) =
    database = {
      database + (g -> (grade(g) :+ name))
    }

  def db: DB = database

  def grade(g: Int): Seq[String] = database.getOrElse(g, Seq())

  def sorted: DB = {
    database.mapValues(_.sorted).toSeq.sortBy(_._1).toMap
  }
}
