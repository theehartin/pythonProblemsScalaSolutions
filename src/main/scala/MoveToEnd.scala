object MoveToEnd extends App {

//  Moving to the End
//    Write a function that moves all elements of one type to the end of the list.
//
//    Examples
//  move_to_end([1, 3, 2, 4, 4, 1], 1) ➞ [3, 2, 4, 4, 1, 1]
//  # Move all the 1s to the end of the array.
//
//  move_to_end([7, 8, 9, 1, 2, 3, 4], 9) ➞ [7, 8, 1, 2, 3, 4, 9]
//
//  move_to_end(["a", "a", "a", "b"], "a") ➞ ["b", "a", "a", "a"]
//  Notes
//  Keep the order of the un-moved items the same.
    def moveToEnd[A](xs: List[A], selector: A) = {
    if (xs.contains(selector)) {
      def moveToEndRec(remainingList: List[A], selectList: List[A], rejectList: List[A]): List[A] = {
        if (remainingList.isEmpty) rejectList.reverse ::: selectList
        else remainingList.head match {
          case `selector` => moveToEndRec(remainingList.tail, remainingList.head +: selectList, rejectList)
          case _ => moveToEndRec(remainingList.tail, selectList, remainingList.head +: rejectList)
        }
      }
      moveToEndRec(xs, List(), List())
    }
    else xs
  }//End of moveToEnd()
}
