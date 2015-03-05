package prog_exercises.scala_getting_started.functions

object Arguments {
  def main(args: Array[String]) {
    iHaveNamedArguments(b="xxxx", a=123);

    iHaveVariableArguments("xxxx", "qqq", "ccc");

  }

  /**
   * Named arguments allow you to pass arguments to a function
   * in a arbitrary order.
   * The syntax is simply that each argument is preceded by a parameter
   * name and an equals sign.
   */
  def iHaveNamedArguments(a:Int, b:String) = {
    println("My args: a="+a+", b="+b)
  }

  /**
   * Scala allows you to indicate that the last parameter to a function
   * may be repeated.
   * This allows clients to pass variable length argument lists to the function.
   */
  def iHaveVariableArguments(args:String*) = {
    var i : Int = 0;
    for( arg <- args ){
      println("Arg value[" + i + "] = " + arg );
      i = i + 1;
    }
  }
}
