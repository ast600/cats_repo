import cats.Eq
import cats.syntax.eq._
import cats.instances.option._

object Main extends App {
  final case class Cat(name: String, age: Int, color: String)

  implicit val catsEqualizer: Eq[Cat] = {
    Eq.instance[Cat] {(kitty1, kitty2) =>
      (kitty1.name === kitty2.name) &&
      (kitty1.age === kitty2.age) &&
      (kitty1.color === kitty2.color)
    }
  }

  val cat1 = Cat("Chuck", 1, "brown")
  val cat2 = Cat("Susan", 2, "pinky")

  println(cat1 === cat2)
  println(cat1 =!= cat2)

  val catOption1 = Option(cat1)
  val catOption2 = Option.empty[Cat]

  println(catOption1 =!= catOption2)
}