package Test

import java.io.File
import java.util.{Calendar, Scanner}

import scala.beans.BeanProperty
import scala.collection.JavaConversions.propertiesAsScalaMap
import scala.collection.mutable

/**
  * Created by XNorth on 16/7/3.
  */
object chapter5_class {


  class Count{
    var  value = 0
    var dist = 1
    def increment(){
      if (value+dist  < Int.MaxValue) {
        value = value+dist
      }
      else {
        value
      }
    }
  }

  class BankAccount(val balance : Int){
    def deposit(){}
    def withdraw(){}
  }

  class Time(val hours:Int,val minutes:Int){
    def befor(other:Time)={
      if (hours > other.hours){
        true
      }else if (minutes > other.minutes){
        true
      }else{
        false
      }
    }

    override def toString()={
      hours*60+minutes-1 + ""
    }
  }

  class Student{
    @BeanProperty var name:String = _
    @BeanProperty var id:Long = _
  }

  class Person(var age:Int){
    age = if (age < 0) 0 else age
  }

  class Car(val produce:String,val typeName:String,val year:Int,val carLice :String){

  }

  def main(args: Array[String]): Unit = {

    val t1 = new Time(23,55)
    val t2 = new Time(23,53)
    println(t1.befor(t2))
  }



}
