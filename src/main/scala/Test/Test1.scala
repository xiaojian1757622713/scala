package Test

import scala.io.Source

/**
  * Created by XNorth on 16/6/12.
  */
object Test1 {

  def widthOfLength(s : String) = s.length.toString.length

  def main(args: Array[String]): Unit = {
//      val list = List("xiaojian","XNorth","Sheep")
//      println(widthOfLength(list(1))
        val arg = "src/main/scala/Test1.scala"
        if (arg.length>0){
          val lines = Source.fromFile(arg).getLines().toList
          val longestLine = lines.reduceLeft(
            (a,b) => if (a.length > b.length) a else b
          )
          val maxWidth = widthOfLength(longestLine)
          for (line <- lines){
            val numSpaces = maxWidth - widthOfLength(line)
            val padding = " " * numSpaces
            print( padding + line.length + "|" + line + "\n")
          }
        }else{
          Console.err.println("Please enter filename")
        }
  }
}
