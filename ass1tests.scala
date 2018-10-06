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



  } /* end main */



}
