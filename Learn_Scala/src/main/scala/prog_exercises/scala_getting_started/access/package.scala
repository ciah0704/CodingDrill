package prog_exercises.scala_getting_started

package society {
  package professional {

    class Executive {
      private[professional] var workDetails = null
      private[society] var friends = null
      private[this] var secrets = null

      def help(another: Executive) {
        println(another.workDetails)
        //    println(another.secrets) //ERROR
      }
    }

  }

}

package p {

  class Super {
    protected def f() {
      println("f")
    }
  }

  class Sub extends Super {
    f()
  }

  class Other {
    // (new Super).f() // Error: f is not accessible
  }

}
