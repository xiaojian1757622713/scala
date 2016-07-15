package Test

import java.io.File
import java.util.{Calendar, Scanner}
import scala.collection.mutable
import scala.collection.JavaConversions.propertiesAsScalaMap
/**
  * Created by XNorth on 16/7/3.
  */
object chapter4_map {

  def main(args: Array[String]) {

    println("chapter4 test1")
    val equip_immutable =Map("刀"->10,"剑"->20,"匕首"->5);
    val equip_mutable = new scala.collection.mutable.HashMap[String,Double]
    val equip_mutable_2 = for((k,v) <- equip_immutable)yield{
      equip_mutable += (k -> v*0.9)
    }
    equip_immutable.foreach(print)
    println()
    equip_mutable_2.foreach(print)

    println("\nchapter4 test2")
    val words0 = test2()
    words0.foreach(print)

    println("\nchapter4 test3")
    val words1 = test3()
    words1.foreach(print)

    println("\nchapter4 test4")
    val words2 = test4()
    words2.foreach(print)

    println("\nchapter4 test5")
    val words3 = test5()
    words3.foreach(print)

    println("\nchapter4 test6")
    test6()
    println("\nchapter4 test7")
    val words4 = "hello".zip("World").toMap
    words4.foreach(print)
  }

  def Iteqgt(values:Array[Int],v:Int) = {
    (values.count(_<v),values.count(_==v),values.count(_>v))
  }

  def minmax(values:Array[Int]) ={
    (values.min,values.max)
  }

  def test6(){
    val props : scala.collection.Map[String,String] = System.getProperties
    val keys = props.keySet
    val keyLength = for(key <- keys)yield key.length
    val maxKeyLength = keyLength.max

    for(key <- keys){
      print(key)
      print(" " * (maxKeyLength - key.length))
      print(" | ")
      print(props(key))
    }
  }

  def test5():scala.collection.mutable.LinkedHashMap[String,Int] = {
    val map = new scala.collection.mutable.LinkedHashMap[String,Int]
    map += ("Monday"->Calendar.MONDAY)
    map += ("Tuesday"->Calendar.TUESDAY)
    map += ("Wednesday"->Calendar.WEDNESDAY)
    map += ("Thursday"->Calendar.THURSDAY)
    map += ("Friday"->Calendar.FRIDAY)
    map += ("Saturday"->Calendar.SATURDAY)
    map += ("Sunday"->Calendar.SUNDAY)
    map
  }

  def test4(): scala.collection.SortedMap[String,Int] ={
    val in = new Scanner(new File("/Users/XNorth/IdeaProjects/scala/src/test/java/chapter4_1_myfile.txt"))
    var words = scala.collection.SortedMap[String,Int]()
    while (in.hasNext){
      val w = in.next()
      words += (w -> (words.getOrElse(w,0)+1))
    }
    words
  }

  def test3(): Map[String,Int] ={
    val in = new Scanner(new File("/Users/XNorth/IdeaProjects/scala/src/test/java/chapter4_1_myfile.txt"))
    var words = Map[String,Int]()
    while (in.hasNext){
      val w = in.next()
      words += (w -> (words.getOrElse(w,0)+1))
    }
    words
  }


  def test2(): mutable.HashMap[String, Int] ={
    val in = new Scanner(new File("/Users/XNorth/IdeaProjects/scala/src/test/java/chapter4_1_myfile.txt"))
    val words = new scala.collection.mutable.HashMap[String,Int]
    while (in.hasNext){
      val w = in.next()
      words(w) = words.getOrElse(w,0)+1
    }
    words
  }



}
