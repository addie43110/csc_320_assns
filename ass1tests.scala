/* A simple program to test the methods in ass1.scala
 *
 * Written by Adeline Jordon 
 * 
 */
import ass1._

object ass1tests {

  def main(args: Array[String]): Unit = {
    println("Running tests...")

    val jan_1_2018 = ass1.Date(1,1,2018)
    val june_1_2018 = ass1.Date(1,6,2018)
    val june_1_2015 = ass1.Date(1,6,2015)
    val jan_1_2016 = ass1.Date(1,1,2016)

    val test1 = ass1.is_older(jan_1_2018, june_1_2018)
    val test2 = ass1.is_older(june_1_2015, jan_1_2016)
    val test3 = ass1.is_older(jan_1_2018, jan_1_2016)
    val test4 = ass1.is_older(june_1_2015, june_1_2015)

    println("\n\ntesting is_older...")
    println(s"test1: ${test1==true}")
    println(s"test2: ${test2==true}")
    println(s"test3: ${test3==false}")
    println(s"test4: ${test4==false}") 

    val jan_array = Array(jan_1_2018, jan_1_2016)
    val june_array = Array(june_1_2018, june_1_2015)
    val jan_and_june = Array(jan_1_2018, june_1_2018, june_1_2015, jan_1_2016)

    println("\n\ntesting number_in_month...")
    println(s"test5: ${ass1.number_in_month(jan_array, 1)==2}")
    println(s"test6: ${ass1.number_in_month(jan_array, 2)==0}")
    println(s"test7: ${ass1.number_in_month(june_array, 1)==0}")
    println(s"test8: ${ass1.number_in_month(june_array, 6)==2}")
    println(s"test9: ${ass1.number_in_month(jan_and_june, 1)==2}")
  }
}
