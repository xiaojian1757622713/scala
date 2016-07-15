package Test

import scala.collection.mutable.ArrayBuffer

/**
  * Created by XNorth on 16/7/3.
  */
object chapter3_array {

  def main(args: Array[String]) {
    println("chapter test1")
    val arr0 = randIntArr(10).foreach(print)
    var arr1 = Array(1,2,3,4,5)
    println("\nchapter test2")
    revert(arr1)
    arr1.foreach(print)
    println("\nchapter test3")
    revertYeild(arr1).foreach(print)
    println("\nchapter test4")
    var arr2 = Array(1,-2,3,0,5,-6,8,-4)
    sigNumArr(arr2).foreach(print)
    println("\nchapter test5")
    var arr3 = Array(2.1,3.4,-3.2,-5,7)
    print(arr3.sum/arr3.length)
    println("\nchapter test6")
    arr3.reverse.foreach(print)
    var arr4 = ArrayBuffer(2.1,3.4,-3.2,-5,7)
    println()
    arr4.reverse.foreach(print)
    println("\nchapter test7")
    var arr5 = ArrayBuffer(2.1,3.4,-3.2,-5,7,3.4,-3.2)
    arr5.distinct.foreach(print)
    println("\nchapter test8")
    val arr6 = Array(1,-2,0,-3,0,4,5);
    val arr7 = deleteUnFirstF(arr6)
    arr7.foreach(print)
    println("\nchapter test9")
    timeZoneName().foreach(print)
  }

  def timeZoneName()={
    val time = java.util.TimeZone.getAvailableIDs
    val tmp = for(t <- time if t.startsWith("America/"))yield{t.drop("America/".length)}
    scala.util.Sorting.quickSort(tmp)
    tmp
  }

  def deleteUnFirstF(arr : Array[Int])={
    val indexes = for (i <- 0 until arr.length if arr(i) < 0)yield i
    val right = indexes.reverse.dropRight(1)
    val  tmp = arr.toBuffer
    for (i <- right) tmp.remove(i)
    tmp
  }

  def sigNumArr(arr : Array[Int]): Array[Int] ={
    val buff = new ArrayBuffer[Int]()
    buff ++= (for(i <- arr if i > 0) yield i)
    buff ++= (for(i <- arr if i == 0) yield i)
    buff ++= (for(i <- arr if i < 0) yield i)
    buff.toArray
  }

  def revertYeild(arr : Array[Int])={
      for(i <- 0 until arr.length)yield{
        if (i % 2 == 0 && i < arr.length - 1){
          val tmp = arr(i)
          arr(i) = arr(i+1)
          arr(i+1) = tmp
        }
        arr(i)
      }
  }

  def revert(arr : Array[Int])={
    for(i <- 0 until (arr.length-1,2)){
      val tmp = arr(i)
      arr(i) = arr(i+1)
      arr(i+1) = tmp
    }
  }

  def randIntArr(n:Int): Array[Int] ={
    val arr = new Array[Int](n)
    val rand = new scala.util.Random
    for(i <- arr) yield rand.nextInt(n)
  }
}
