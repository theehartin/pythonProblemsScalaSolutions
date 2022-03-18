object MultipleChoiceTests extends App{

  //INSTRUCTIONS: https://edabit.com/challenge/Ld4xBpqBXqygwQ5St

  //NOTE: the takeTest method returns a new student to maintain immutability

  case class SchoolTest(subject: String, testAnswers: Map[Int, String], passingGrade: Double)

  case class Student(name: String, testMap: Map[String, (Boolean, Double)] = Map()) {

    val testsTaken: Object = {
      if (testMap.isEmpty) {
        "No tests taken"
      }
      else {
        testMap.map((entry: (String, (Boolean, Double))) => {
          s"${entry._1} - Passed: ${entry._2._1} (${entry._2._2.formatted("%3.2f")}%)"
        })
      }
    }


    def takeTest(test: SchoolTest, studentAnswers: Map[Int, String]): Student = {

      val studentCorrectAnswers = studentAnswers.values
        .zip(test.testAnswers.values)
        .filter(x => x._1 == x._2)

      val testscore = (studentCorrectAnswers.size.toDouble / test.testAnswers.size.toDouble) * 100
      val passOrFail = testscore >= test.passingGrade

      this.copy(this.name, testMap = this.testMap + (test.subject -> (passOrFail, testscore)))

    }


  }//End of Student Class



//  val chemAnswers = Map(1 -> "A", 2 -> "B", 3 -> "C", 4 -> "D", 5 -> "A", 6 -> "B")
//  val mathAnswers = Map(1 -> "A", 2 -> "B", 3 -> "C", 4 -> "D", 5 -> "A", 6 -> "B")
//  val englishAnswers = Map(1 -> "A", 2 -> "B", 3 -> "C", 4 -> "D", 5 -> "A", 6 -> "B")
//
//  val johnMathAnswers = Map(1 -> "A", 2 -> "C", 3 -> "C", 4 -> "-", 5 -> "A", 6 -> "B")
//
//  val chemTest = SchoolTest("Chemistry", chemAnswers, 100)
//  val mathTest = SchoolTest("Math", mathAnswers, 80)
//  val englishTest = SchoolTest("English", englishAnswers, 85)
//
//  val john = Student("John")
//  val susie = Student("Susie")
//
//  val johnAfterFirstTest = john.takeTest(chemTest, chemAnswers)
//  val johnAfterSecondTest = johnAfterFirstTest.takeTest(mathTest, johnMathAnswers)
//
//  println(johnAfterFirstTest.testsTaken)
//  println(johnAfterSecondTest.testsTaken)
//  println(susie.testsTaken)
















}
