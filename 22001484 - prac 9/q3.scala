object StringFormatter {

  def toUpper(str: String): String = str.toUpperCase()
  def toLower(str: String): String = str.toLowerCase()

  def formatNames(name: String)(formatFunc: String => String): String = formatFunc(name)

  def main(args: Array[String]): Unit = {

    println(formatNames("Benny")(toUpper))

    println(formatNames("Niroshan") { name =>
      toUpper(name.substring(0, 2)) + name.substring(2)
    })

    println(formatNames("Saman")(toLower))

    println(formatNames("Kumara") { name =>
      toUpper(name.head.toString) + name.substring(1, name.length - 1) + toUpper(name.last.toString)
    })
  }
}
