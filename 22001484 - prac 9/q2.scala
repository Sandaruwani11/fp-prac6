object NumberPatternMatching {

  def main(args: Array[String]): Unit = {
    
    println("Enter an integer:")

    val input = scala.io.StdIn.readInt()

    val negativeOrZero: () => String = () => "Negative/Zero is input"
    val even: () => String = () => "Even number is given"
    val odd: () => String = () => "Odd number is given"

    input match {
      case n if n <= 0 => println(negativeOrZero())
      case n if n % 2 == 0 => println(even())
      case n if n % 2 != 0 => println(odd())
    }
  }
}
