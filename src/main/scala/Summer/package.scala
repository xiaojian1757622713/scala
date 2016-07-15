/**
  * Created by XNorth on 16/6/13.
  */
import Summer.ChecksumAccumulator.calculate

package object Summer {
  def main(args: Array[String]) {
    val args = List("xiaojian","XNorth","Sheep","XNorth")
    for(arg <- args){
      println(arg + ": " + calculate(arg))
    }
  }
}
