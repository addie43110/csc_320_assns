/* Assignment 1 in CSC 330 (Programming Languages) at Uvic, taken with Daniel German.
 *
 * Implemented in Scala for practice by Adeline Jordon.
 */
package ass1

object ass1 {
  case class Date(day: Int, month: Int, year: Int)
  final case class InvalidParameterException(private val msg: String="",
      private val cause: Throwable = None.orNull) extends Exception(msg, cause)      

/* 1.  Write a function is_older that takes two dates and evaluates to true or false.
      It evaluates to true if the first argument is a date that comes before the second argument.
      (If the two dates are the same, the result is false.)

  2.  Write a function number_in_month that takes a list of dates and a month (i.e., an int)
      and returns how many dates in the list are in the given month.


  3.  Write a function number_in_months that takes a list of dates and a list of months (i.e., an
      int list) and returns the number of dates in the list of dates that are 
      in any of the months in the list of months. Assume the list of months has no number
      repeated.  Hint:  Use your answer to the previous problem.


  4.  Write a function dates_in_month that takes a list of dates and a month (i.e., an int)
      and returns a list holding the dates from the argument list of dates that are 
      in the month.  The returned list should contain dates in the order they were originally given.


  5.  Write a function dates_in_months that takes a list of dates and a list of months (i.e., an
      int list) and returns a list holding the dates from the argument list of dates
      that are in any of the months in the list of months.  Assume the list of
      months has no number repeated.  Hint:  Use your answer to the previous problem and 
      ML’s list-append operator (@).


  6.  Write a function get_nth that takes a list of strings and an int n and returns 
      the n-th element of the list where the head of the list is 1st .  Raise the exception
      InvalidParameter if n is zero or larger than the length of the list.


  7.  Write  a  function date_to_string that  takes  a  date  and  returns  a  string  of  the  form
      January 20, 2013 (for  example).   Use  the  operator ˆ for  concatenating  strings 
      and  the  library  function Int.toString for converting an int to a string.
      For producing the month part, do not use a bunch of conditionals.  Instead, use a list
      holding 12 strings and your answer to the previous problem.   For  consistency,
      put  a  comma  following  the  day  and  use  capitalized  English  month  names:
      January, February, March, April, May, June, July, August, September, October, November, December.


  8.  Write a function number_before_reaching_sum
      that takes an int called sum, which you can
      assume is positive,  and an int list,
      which you can assume contains all positive numbers,
      and returns an int. You should return an int n
      such that the first n elements of the list add to less than
      sum, but the first n + 1 elements of the list add to
      sum or more.  Assume the entire list sums to more
      than the passed in value; it is okay for an exception
      to occur if this is not the case.


  9.  Write a function what_month
      that takes a day of year (i.e., an
      int between 1 and 365) and returns
      what month that day is in (1 for January,
      2 for February, etc.). Use a list
      holding 12 integers and your
      answer to the previous problem.


  10. Write a function month_range
      that takes two days of the year
      day1 and day2 and returns an
      int list [m1,m2,...,mn]
      where m1 is the month of
      day1, m2 is the month of
      day1+1 , ..., and mn is
      the month of day day2.
      Note the result will have length
      day2−day1 + 1 or length 0 if
      day1> day2.


  11. Write a function oldest
      that takes a list of dates and
      evaluates to a DATE option.  It evaluates to
      NONE if the list has no dates and
      SOME d if the date d is the oldest date
      in the list.


  12. Write a function reasonable_date
      that takes a date and determines if
      it describes a real date in
      the common era.  A “real date” has a
      positive year (year 0 did not exist),
      a month between 1 and 12, and a day
      appropriate for the month.  Solutions
      should properly handle leap years. 
      Leap years are years that are either
      divisible by 400 or divisible by 4 but
      not divisible by 100.  (Do not worry about
      days possibly lost in the conversion to
      the Gregorian calendar in the Late 1500s.)

*/

  /* 1 */
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

  /* 2 */
  def number_in_month(dt_lst: List[Date], month: Int): Int = {
    dt_lst.foldLeft(0)((a: Int, b: Date) => if (b.month==month) 1+a else a)
  }



  /* 3 */
  def number_in_months(dt_lst: List[Date], month_lst: List[Int]): List[Int] = {
    month_lst.foldLeft(List[Int]())((a: List[Int], b: Int) => a:::List(number_in_month(dt_lst, b)))
  }



  /* 4 */
  def dates_in_month(dt_list: List[Date], month: Int): List[Date] = {
    dt_list.foldLeft(List[Date]())((acc: List[Date], x: Date) => if (x.month==month) acc:::List(x) else acc)
  }


  /* 5 */
  def dates_in_months(dt_list: List[Date], month_list: List[Int]): List[Date] = {
    month_list.foldLeft(List[Date]())((acc: List[Date], m: Int) => acc:::dates_in_month(dt_list, m))
  }


  /* 6 */
  def get_nth(s_list: List[String], n: Int): String = {
    if (n<1 || n>s_list.length)
      throw InvalidParameterException("get_nth given invalid index")    
    else
      s_list(n-1)
  }


  /* 7 */
  def date_to_string(d: Date): String = {
    val months = List("January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December")
  
    get_nth(months, d.month) + " " + d.day + ", " + d.year
  }


  /* 8 */
  def number_before_reaching_sum(sum: Int, lst: List[Int]): Int = {
    def helper(sum: Int, curr_sum: Int, acc: Int, lst: List[Int]): Int = {
      if(curr_sum >= sum) acc
      else
        helper(sum, curr_sum+lst.head, acc+1, lst.tail)
    }

    helper(sum, 0, 0, lst)
  }


  /* 9 */
  def what_month(day: Int): Int = {
    val months = List(31, 28, 31, 30, 31, 31, 30, 31, 30, 31)
    number_before_reaching_sum(day, months)
  }


  /* 10 */
  def month_range(day1: Int, day2: Int): List[Int] = {
    if(day1>day2) List[Int]()
    else
      what_month(day1)::month_range(day1+1, day2)
  }


  /* 11 */
  def oldest(dates: List[Date]): Option[Date] = dates match {
    case x::xs  => oldest(xs) match {
                     case Some(i) => if (is_older(x, i)) Some(i)
                                     else Some(x)
                     case None => Some(x)
                   }
    case _ => None
  }


  /* 12 */
  def reasonable_date(dt: Date): Boolean = {
    val days_in_months = List(31, 28, 31, 30, 31, 31, 30, 31, 30, 31)
    if(dt.year < 0 ) 
      false;
    else if (dt.month < 1 || dt.month > 12) { 
      false;
    } else if (dt.year % 400 != 0 && dt.month==2 && dt.day==29) { 
      if(dt.year % 4 == 0 && dt.year % 100 != 0) true
      else {
        false
      }
    } else if (dt.day<0 || dt.day > days_in_months(dt.month)) {
      false
    } else true
  }
}
