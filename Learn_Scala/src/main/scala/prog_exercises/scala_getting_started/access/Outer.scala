package prog_exercises.scala_getting_started.access

class Outer {
  class Inner {
    private def f() = println("f")
    class InnerMost {
      f() //ok
    }
  }
//  (new Inner).f() // error f is inaccessible

}
