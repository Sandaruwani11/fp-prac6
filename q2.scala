import scala.io.StdIn

object StudentRecord {

  def getStudentInfo(): (String, Int, Int) = {
    println("Enter student's name:")
    val name = StdIn.readLine()

    println("Enter student's marks:")
    val marks = StdIn.readInt()

    println("Enter total possible marks:")
    val totalMarks = StdIn.readInt()

    (name, marks, totalMarks)
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
    var studentInfo: (String, Int, Int) = ("", 0, 0)

    while (!validInput) {
      studentInfo = getStudentInfo()
      val (name, marks, totalMarks) = studentInfo
      val (isValid, errorMessage) = validateInput(name, marks, totalMarks)
      if (isValid) {
        validInput = true
      } else {
        println(errorMessage.getOrElse("Invalid input. Please try again."))
      }
    }

    val (name, marks, totalMarks) = studentInfo
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

  def main(args: Array[String]): Unit = {
    val studentRecord = getStudentInfoWithRetry()
    printStudentRecord(studentRecord)
  }
}
