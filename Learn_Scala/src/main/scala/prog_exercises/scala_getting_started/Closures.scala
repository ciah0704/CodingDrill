package prog_exercises.scala_getting_started

/**
 * Created by vkroz on 7/9/14.
 */
class Closures {

  // assign anonymous function to variable
  val multiplier = (i:Int) => i * 10;

  var factor = 3
  val multiplier2 = (i:Int) => i * factor

}

object App {
  def main(args: Array[String]) {
    val sample = new Closures
    println(sample.multiplier(2))

    println(sample.multiplier2(2))
    println(sample.multiplier2(3))

    // Move to a new location
    println("ku ku")
  }
}