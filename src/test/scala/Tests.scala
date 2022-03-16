import org.scalatest.flatspec.AnyFlatSpec

class Tests extends AnyFlatSpec {

  "repDigit" should "return true if the argument contains repeat digits" in {
    assert(repDigit.repDigit(22))
    assert(!repDigit.repDigit(202))
    assert(!repDigit.repDigit(-12))
    assert(repDigit.repDigit(-22))
    assert(repDigit.repDigit(2133432565))
  }


  "moveToEnd" should "move all elements of one type to the end of the list" in {
    assert(MoveToEnd.moveToEnd(List(7, 8, 9, 1, 2, 3, 4), 9) == List(7, 8, 1, 2, 3, 4, 9) )
    assert(MoveToEnd.moveToEnd(List(1, 3, 2, 4, 4, 1), 1) == List(3, 2, 4, 4, 1, 1) )
    assert(MoveToEnd.moveToEnd(List("a", "a", "a", "b"), "a") == List("b", "a", "a", "a") )
  }
}
