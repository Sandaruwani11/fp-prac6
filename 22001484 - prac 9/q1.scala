object InterestCalculator {

  def calculateInterest(deposit: Double): Double = {

    val rate1: Double => Double = amount => amount * 0.02
    val rate2: Double => Double = amount => amount * 0.04
    val rate3: Double => Double = amount => amount * 0.035
    val rate4: Double => Double = amount => amount * 0.065

    if (deposit <= 20000) {
      rate1(deposit)
    } else if (deposit <= 200000) {
      rate2(deposit)
    } else if (deposit <= 2000000) {
      rate3(deposit)
    } else {
      rate4(deposit)
    }
  }

  def main(args: Array[String]): Unit = {
    
    val deposits = List(10000.0, 50000.0, 500000.0, 3000000.0)

    deposits.foreach { deposit =>
      println(s"Deposit: Rs. $deposit, Interest Earned: Rs. ${calculateInterest(deposit)}")
    }
  }
}
