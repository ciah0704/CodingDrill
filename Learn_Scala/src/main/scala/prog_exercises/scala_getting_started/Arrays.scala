package prog_exercises.scala_getting_started

import Array._

/**
 * Created by vkroz on 7/9/14.
 */
object Arrays {
  def main(args: Array[String]) {
    var arr: Array[String] = Array[String]("one", "two", "three")
    println(arr)


    var myList = Array(1.9, 2.9, 3.4, 3.5)
    myList(0) = 1.0
    println(myList)

    var myMatrix = ofDim[Int](3,3)
    // build a matrix
    for (i <- 0 to 2) {
      for ( j <- 0 to 2) {
        myMatrix(i)(j) = j;
      }
    }
    // Print two dimensional array
    for (i <- 0 to 2) {
      for ( j <- 0 to 2) {
        print(" " + myMatrix(i)(j));
      }
      println();
    }


  }

}
