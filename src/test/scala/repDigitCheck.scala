import org.scalacheck.Gen.posNum
import org.scalacheck.Properties
import org.scalacheck.Prop.{forAll, propBoolean}

object repDigitCheck extends Properties("PropertyChecks") {
  property("repDigit") = forAll(posNum[Int]) { n =>
    val truth = (x: Int) =>
          x.toString.contains("11") |
          x.toString.contains("22") |
          x.toString.contains("33") |
          x.toString.contains("44") |
          x.toString.contains("55") |
          x.toString.contains("66") |
          x.toString.contains("77") |
          x.toString.contains("88") |
          x.toString.contains("99")

    repDigit.repDigit(n) == truth(n)
  }
}
