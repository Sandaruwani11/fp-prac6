import scala.io.StdIn

object StudentRecord {

  def getStudentInfo(): (String, Int, Int, Double, Char) = {
    println("Enter student's name:")
    val name = StdIn.readLine()

    println("Enter student's marks:")
    val marks = StdIn.readInt()

    println("Enter total possible marks:")
    val totalMarks = StdIn.readInt()

    val percentage = (marks.toDouble / totalMarks) * 100
    val grade = if (percentage >= 90) 'A'
                else if (percentage >= 75) 'B'
                else if (percentage >= 50) 'C'
                else 'D'

    (name, marks, totalMarks, percentage, grade)
  }

  def printStudentRecord(record: (String, Int, Int, Double, Char)): Unit = {
    val (name, marks, totalMarks, percentage, grade) = record
    println(s"Name: $name")
    println(s"Marks: $marks")
    println(s"Total Marks: $totalMarks")
    println(s"Percentage: $percentage%")
    println(s"Grade: $grade")
  }

  def validateInput(name: String, marks: Int, totalMarks: Int): (Boolean, Option[String]) = {
    if (name.isEmpty) {
      (false, Some("Name cannot be empty."))
    } else if (marks < 0 || marks > totalMarks) {
      (false, Some("Marks must be positive and not exceed total possible marks."))
    } else {
      (true, None)
    }
  }

  def getStudentInfoWithRetry(): (String, Int, Int, Double, Char) = {
    var validInput = false
    var name = ""
    var marks = 0
    var totalMarks = 0

    while (!validInput) {
      println("Enter student's name:")
      name = StdIn.readLine()

      println("Enter student's marks:")
      marks = StdIn.readInt()

      println("Enter total possible marks:")
      totalMarks = StdIn.readInt()

      val (isValid, errorMessage) = validateInput(name, marks, totalMarks)
      if (isValid) {
        validInput = true
      } else {
        println(errorMessage.getOrElse("Invalid input. Please try again."))
      }
    }

    val percentage = (marks.toDouble / totalMarks) * 100
    val grade = if (percentage >= 90) 'A'
                else if (percentage >= 75) 'B'
                else if (percentage >= 50) 'C'
                else 'D'

    (name, marks, totalMarks, percentage, grade)
  }

  def main(args: Array[String]): Unit = {
    val studentRecord = getStudentInfoWithRetry()
    printStudentRecord(studentRecord)
  }
}
