package Test

/**
  * Created by XNorth on 16/6/14.
  */
object Test2 {

  //生成一个乘积字符串
  def makeRowSeq(row : Int) =
    for (col <- 1 to 10) yield {
      val porl = (col*row).toString
      val padding = " "*(4 - porl.length)
      padding + porl
    }

  //以字符串形式返回
  def makeRow(row : Int) = makeRowSeq(row).mkString

  //乘法表
  def multiTable() = {
    val tableSql =
      for(row <- 1 to 10)
        yield makeRow(row)
    tableSql.mkString("\n")
  }

  def main(args: Array[String]) {
    print(multiTable())
  }

}
