package Element

/**
  * Created by XNorth on 16/6/16.
  */
object Test {
  def main(args: Array[String]) {
    val e1: Element = new ArrayElement(Array("hello", "world"))
    val ae: ArrayElement = new LineElement("hello")
    val e2: Element = ae
    val e3: Element = new UniformElement('x', 2, 3)
    print(e1)
    print(ae)
    print(e2)
    print(e3)
  }
}
