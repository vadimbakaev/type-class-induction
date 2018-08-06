import common.EOL

trait Named[A] {
  val name: String
}

object Named {
  implicit val baseCase: Named[EOL] = new Named[EOL] {
    override val name: String = ""
  }

  implicit val namedInt: Named[Int] = new Named[Int] {
    override val name: String = "int"
  }

  implicit val namedChar: Named[Char] = new Named[Char] {
    override val name: String = "char"
  }

  implicit val namedString: Named[String] = new Named[String] {
    override val name: String = "string"
  }

  implicit def inductionStep[HEAD, TAIL](implicit namedHead: Named[HEAD], namedTail: Named[TAIL]): Named[(HEAD, TAIL)] =
    new Named[(HEAD, TAIL)] {
      override val name: String = Seq(namedHead.name, namedTail.name).filter(_.nonEmpty).mkString(", ")
    }
}
