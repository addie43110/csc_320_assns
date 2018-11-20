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

    val jan_array = List(jan_1_2018, jan_1_2016)
    val june_array = List(june_1_2018, june_1_2015)
    val jan_and_june = List(jan_1_2018, june_1_2018, june_1_2015, jan_1_2016)

    println("\n\ntesting number_in_month...")
    println(s"test5: ${ass1.number_in_month(jan_array, 1)==2}")
    println(s"test6: ${ass1.number_in_month(jan_array, 2)==0}")
    println(s"test7: ${ass1.number_in_month(june_array, 1)==0}")
    println(s"test8: ${ass1.number_in_month(june_array, 6)==2}")
    println(s"test9: ${ass1.number_in_month(jan_and_june, 1)==2}")


    println("\n\ntesting number_in_months...")
    println(s"test10: ${ass1.number_in_months(jan_and_june, List(1)) == List(2)}")
    println(s"test11: ${ass1.number_in_months(jan_and_june, List(1,6)) == List(2,2)}")  
    println(s"test12: ${ass1.number_in_months(jan_and_june, List(1,2)) == List(2,0)}")


    println("\n\ntesting dates_in_month...")
    println(s"test13: ${ass1.dates_in_month(jan_and_june, 1) == List(ass1.Date(1,1,2018),ass1.Date(1,1,2016))}")
    println(s"test14: ${ass1.dates_in_month(jan_and_june, 3) == List[ass1.Date]()}")


    println("\n\ntesting dates_in_months...")
    println(s"test15: ${ass1.dates_in_months(jan_and_june, List(1)) == List(ass1.Date(1,1,2018),ass1.Date(1,1,2016))}")
    println(s"test16: ${ass1.dates_in_months(jan_and_june, List(2,3)) == List[ass1.Date]()}")
    println(s"test17: ${ass1.dates_in_months(jan_and_june, List(1,6)) == List(ass1.Date(1,1,2018),ass1.Date(1,1,2016),ass1.Date(1,6,2018),ass1.Date(1,6,2015))}")


    val sl1 = List("Hello", "Hi", "Howdy", "Bonjour", "Terve", "Moi")
    val sl2 = List("No", "Non", "Nope", "Nah")
    val sl3 = List("Addie", "Adeline", "Ade")
    val sl4 = List("Washua", "Joshua", "Josh", "Jash", "Seabroo", "Seabro")

    println("\n\ntesting get_nth...")
    println(s"test18: ${try{ass1.get_nth(sl1, 2)=="Hi"}catch{case e: Exception => "False"}}")
    println(s"test19: ${try{ass1.get_nth(sl2, 0)}catch{case e: Exception => "True"}}")
    println(s"test20: ${try{ass1.get_nth(List[String](), 1)}catch{case e: Exception => "True"}}")
    println(s"test21: ${try{ass1.get_nth(sl4, 20)}catch{case e: Exception =>"True"}}")
    println(s"test22: ${try{ass1.get_nth(sl4, 4)=="Jash"}catch{case e: Exception => "False"}}")


    println("\n\ntesting date_to_string...")
    println(s"test23: ${ass1.date_to_string(jan_1_2018)=="January 1, 2018"}")
    println(s"test24: ${ass1.date_to_string(june_1_2015)=="June 1, 2015"}")


    println("\n\ntesting number_before_reaching_sum...")
    val lst1 = List(1, 2, 3, 4, 5, 6);
    println(s"test25: ${ass1.number_before_reaching_sum(6, lst1)==3}")
    println(s"test26: ${ass1.number_before_reaching_sum(0, lst1)==0}")


    val jday1 = 183 /* july 1st */
    val jday2 = 265 /* september 21st */
    println("\n\ntesting what_month...")
    println(s"test27: ${ass1.what_month(jday1)==7}")
    println(s"test28: ${ass1.what_month(jday2)==9}")

    val jday3 = 90 /* march 31st */
    val jday4 = 94 /* april 4th */
    println("\n\ntesting month_range...")
    println(s"test29: ${ass1.month_range(jday3, jday4)==List(3,4,4,4,4)}")



    println("\n\ntesting oldest...")
    println(s"test30: ${ass1.oldest(jan_array)==Some(ass1.Date(1,1,2018))}")
    println(s"test31: ${ass1.oldest(june_array)==Some(ass1.Date(1,6,2018))}")
    println(s"test32: ${ass1.oldest(List[ass1.Date]())==None}")


    val real_date1 = ass1.Date(28,2,2018)
    val real_date2 = ass1.Date(30, 9, 2)
    val real_date3 = ass1.Date(29, 2, 2020)
    val fake_date1 = ass1.Date(3, -1, 2014)
    val fake_date2 = ass1.Date(90, 4, 2003)
    val fake_date3 = ass1.Date(29, 2, 2019)
    println("\n\ntesting reasonable_date...")
    println(s"test33: ${ass1.reasonable_date(real_date1)}")
    println(s"test34: ${ass1.reasonable_date(real_date2)}")
    println(s"test35: ${ass1.reasonable_date(real_date3)}")
    println(s"test36: ${!ass1.reasonable_date(fake_date1)}")
    println(s"test37: ${!ass1.reasonable_date(fake_date2)}")
    println(s"test38: ${!ass1.reasonable_date(fake_date3)}")


  } /* end main */


}
