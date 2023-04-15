import cats.Show
import cats.Eq
import cats.syntax.show._
import cats.syntax.eq._
import cats.instances.int._
import cats.instances.string._
import cats.instances.option._

object Main extends App {
  final case class Cat(name: String, age: Int, color: String)

  implicit val catsShower: Show[Cat] = Show.show[Cat] {kitty =>
    val name = kitty.name.show
    val age = kitty.age.show
    val color = kitty.color.show
    s"$name is a $age year-old $color cat"
  }
  
  implicit val catsEqualizer: Eq[Cat] = {
    Eq.instance[Cat] {(kitty1, kitty2) =>
      (kitty1.name === kitty2.name) &&
      (kitty1.age === kitty2.age) &&
      (kitty1.color === kitty2.color)
    }
  }

  val cat = Cat("Chuck", 1, "brown")

  val catOption1 = Option(cat)
  val catOption2 = Option.empty[Cat]

  println(cat.show)
  println(catOption1 =!= catOption2)
}