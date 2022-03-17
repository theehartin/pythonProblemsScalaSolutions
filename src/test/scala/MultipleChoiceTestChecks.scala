import org.scalacheck.{Gen, Properties}

object MultipleChoiceTestChecks extends Properties("MultipleChoiceTestCheck"){

  val answerOptions = Gen.oneOf("A", "B", "C", "D", "E")

  val testAnswerGen = Map(
    1 -> answerOptions,
    2 -> answerOptions,
    3 -> answerOptions,
    4 -> answerOptions,
    5 -> answerOptions,
    6 -> answerOptions,
    7 -> answerOptions,
    8 -> answerOptions,
    9 -> answerOptions,
    10 -> answerOptions
  )

  val passingGrade = Gen.frequency(
    (3, 75.0),
    (2, 80.0),
    (1, 85.0)
  )

}
