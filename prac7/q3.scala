object FilterPrime {
  def filterPrime(numbers: List[Int]): List[Int] = {
    def isPrime(n: Int): Boolean = {
      if (n <= 1) false
      else if (n == 2) true
      else !(2 to Math.sqrt(n).toInt).exists(i => n % i == 0)
    }

    numbers.filter(num => isPrime(num))
  }

  def main(args: Array[String]): Unit = {
    val input = List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    val output = filterPrime(input)
    println(s"Input: $input")
    println(s"Output: $output")
  }
}
