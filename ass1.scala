/* Assignment 1 in CSC 330 (Programming Languages) at Uvic, taken with Daniel German.
 *
 * Implemented in Scala for practice by Adeline Jordon.
 */
package ass1

object ass1 {
  case class Date(day: Int, month: Int, year: Int)

  def is_older(d1: Date, d2: Date): Boolean = {
    if (d1.year < d2.year)
      true
    else if (d1.month < d2.month)
      true
    else if (d1.day < d2.day)
      true
    else
      false
  }


  def number_in_month(dt_lst: Array[Date], month: Int): Int = {
    dt_lst.foldLeft(0)((a: Int, b: Date) => if (b.month==month) 1+a else a)
  }

}
