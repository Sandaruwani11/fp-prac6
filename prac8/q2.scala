object NumberCategorizer {

  def main(args: Array[String]): Unit = {

    print("Enter an integer: ")
    
    val inputStr = scala.io.StdIn.readLine()

    try {
      val input = inputStr.toInt

      val isMultipleOfThree = (n: Int) => n % 3 == 0
      val isMultipleOfFive = (n: Int) => n % 5 == 0

      val message = (isMultipleOfThree(input), isMultipleOfFive(input)) match {
        case (true, true) => "Multiple of Both Three and Five"
        case (true, false) => "Multiple of Three"
        case (false, true) => "Multiple of Five"
        case _ => "Not a Multiple of Three or Five"
      }

      println(message)

    } catch {
      case _: NumberFormatException =>
        println("Not an Integer. provide an integer as input.")
    }
  }
}
