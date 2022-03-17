import MultipleChoiceTests.{SchoolTest, Student}
import org.scalatest.flatspec.AnyFlatSpec

class MultipleChoiceTestTest extends AnyFlatSpec {

  val answers = Map(1 -> "A", 2 -> "B", 3 -> "C", 4 -> "D", 5 -> "A", 6 -> "B")
  val schoolTest: SchoolTest = SchoolTest("testSubject", answers, 80.0)
  val student: Student = Student("StudentName")
  val studentAfterTest: Student = student.takeTest(schoolTest,answers)

  "takeTest" should "increase the size of student.testMap by 1" in {
    assert((student.testMap.size + 1) == studentAfterTest.testMap.size)

  }

  it should "return a new Student" in {
    assert(studentAfterTest.getClass === student.getClass)
  }

}
