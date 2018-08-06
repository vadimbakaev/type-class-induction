import common._

import Named._

object Main extends App {

  println(implicitly[Named[Int]].name)

  println(implicitly[Named[(Int, (String, (Char, EOL)))]].name)

}
