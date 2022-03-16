import org.scalacheck.Gen.{alphaChar, choose, listOf, posNum}
import org.scalacheck.Properties
import org.scalacheck.Prop.{AnyOperators, forAll, propBoolean}


object MoveToEndCheck extends Properties("PropertyChecks") {
  def rejectListCheck[A](xs: List[A], n: A) = {
    val resultList = MoveToEnd.moveToEnd(xs, n)
    val rejectList = resultList.take(resultList.indexOf(n))
    !rejectList.contains(n)
  }

  def successListCheck[A](xs: List[A], n: A) = {
    val resultList = MoveToEnd.moveToEnd(xs, n)
    val selectList = resultList.drop(resultList.indexOf(n))

    //List.forall does not work as expected in this file
    def containsOnly[A](xs: List[A], validator: A): Boolean = xs match {
      case List() => true
      case List(x, _*) if x != validator => false
      case List(x, _*) if x == validator => containsOnly(xs.tail, validator)
    }

    containsOnly(selectList, n)
  }//End of successListCheck()


  property("moveToEnd.rejectList.num") = forAll(listOf(Int), choose(0, 20)) { (xs, n) =>
    rejectListCheck(xs, n)
  }

  property("moveToEnd.rejectList.char") = forAll(listOf(alphaChar), alphaChar) { (xs, n) =>
    rejectListCheck(xs, n)
  }

  property("moveToEnd.selectList.num") = forAll { (xs: List[Int], n: Int) =>
    (0 <= n && n <= 9 && xs.contains(n)) ==> {
      successListCheck(xs, n)
    }
  }

  property("moveToEnd.selectList.char") = forAll(listOf(alphaChar), alphaChar) { (xs, n) =>
    (xs.contains(n)) ==> {
      successListCheck(xs, n)
    }
  }
}
