package Element

/**
  * Created by XNorth on 16/6/16.
  */
abstract class Element {
  val contents: Array[String]
  val height = contents.length
  val width = if (height == 0) 0 else contents(0).length
}

class ArrayElement(conts: Array[String]) extends Element {
  val contents: Array[String] = conts
}

class LineElement(s: String) extends ArrayElement(Array(s)) {
  override val width = s.length
  override val height = 1
}

class UniformElement(ch: Char, override val width: Int, override val height: Int) extends Element {
  private val line = ch.toString * width
  override val contents = Array("hello", "world")
  print(contents.mkString("\t"))
}