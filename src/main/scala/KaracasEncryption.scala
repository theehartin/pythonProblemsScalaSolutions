import scala.annotation.tailrec

object KaracasEncryption extends App{
//  Make a function that encrypts a given input with these steps:
//
//    Input: "apple"
//
//  Step 1: Reverse the input: "elppa"
//
//  Step 2: Replace all vowels using the following chart:
//
//  a => 0
//  e => 1
//  i => 2
//  o => 2
//  u => 3
//
//  # "1lpp0"


  def karacasEncryption(input: String) = {
    val inputToList = input.toLowerCase.split("").toList

    val vowelMap = Map("a" -> "0", "e" -> "1", "i" -> "2", "o" -> "3", "u" -> "4")

    @tailrec
    def karacasEncryptionRec(inList: List[String], outList: List[String]): List[String] = {
      if (inList.isEmpty) {
        outList
      }
      else {
        inList.head match {
          case "a" | "e" | "i" | "o" | "u" =>
            karacasEncryptionRec(inList.tail, vowelMap(inList.head) +: outList)

          case _ => karacasEncryptionRec(inList.tail, inList.head +: outList)
        }
      }
    }//End of karacasEncryptionRec()

    karacasEncryptionRec(inputToList, List()).mkString("") + "aca"
  }

  println(karacasEncryption("apple"))


}
