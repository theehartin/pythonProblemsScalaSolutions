
object repDigit {
    //Determine whether or not a number contains repeat digits
    def repDigit(x: Int)= {
        val numToList = x.abs.toString.split("").toList
        def repDigintRec(xs: List[String]): Boolean = {
            xs match {
                case Nil | List(_) => false
                case x :: rest => if(x == rest.head) true else repDigintRec(xs.tail)
            }
        }
        repDigintRec(numToList)
    }
}
