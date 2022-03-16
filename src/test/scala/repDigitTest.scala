import org.scalatest.flatspec.AnyFlatSpec

class repDigitTest extends AnyFlatSpec {
  "repDigit" should "return true if the argument contains repeat digits" in {
    assert(repDigit.repDigit(22))
    assert(!repDigit.repDigit(202))
    assert(!repDigit.repDigit(-12))
    assert(repDigit.repDigit(-22))
    assert(repDigit.repDigit(2133432565))
  }
}
