package example

import example.OOP._
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class OPPSpec extends AnyFlatSpec with Matchers {

  //Exercise 1.

  "Implementing the cube method in val cubeOf3 = comp.cube(3)" should "return 27" in {
    val cubeOf3 = OOP.comp.cube(3) shouldEqual 27
  }


  //Exercise 2.
  "Implementing the cube method in  val cubeOf3 = comp2.cube(3L)" should "return 27L" in {
    val cubeOf3 = OOP.comp2.cube(3L) shouldEqual 27L
  }

  //Exercise 3. Verification on the REPL and the return values are specified in the OPP.scala file


  //Exercise 4. Creation of Gato class, and different objects that extends from Gato
  "Implementing the object Docker Docker.comida" should "return cuido" in{
    OOP.Docker.comida shouldEqual "cuido"
  }

  "Implementing the object IO IO.color" should "return Fawn" in{
    OOP.IO.color shouldEqual "Fawn"
  }


  //Exercise 5 and verification of Exercise 4.
  "Implementing the despachar method from ventaDeChurrus object  " +
    "VentaDeChurrus.despachar(IO)" should "return true" in{
    OOP.VentaDeChurrus.despachar(IO) shouldEqual true
  }

  "Implementing the despachar method from ventaDeChurrus object  " +
    "VentaDeChurrus.despachar(Make)" should "return false" in{
    OOP.VentaDeChurrus.despachar(Make) shouldEqual false
  }


  //Exercise 6
  "Implementing the Driver class, val driver = new Driver('David', 'Barrera', 20, 15) " +
    "driver.finished_races" should "return " in{
    val driver = new OOP.Driver("David", "Barrera", 20, 15)
    driver.finished_races shouldEqual 15
  }

  "Implementing the Team class, val team = new Team('Ferrari', driver) " +
    "driver.finished_races" should "return " in{
    val team = new OOP.Team("Ferrari", driver)
    team.getDriver().name shouldEqual "David"
  }


  //Exercise 7.

  "Implementig the counter class, val counter1 = new Counter(10)" +
    "and using the incr and decr(with default parameter values) methods on this counter1 val" +
    "counter1.incr().decr().incr().incr().counter " should "return 12" in{

    val counter1 = new OOP.Counter(10)

    counter1.incr().decr().incr().incr().counter shouldEqual 12
  }


  //Exercise 8.
  "Implementig the counter class, val counter1 = new Counter(10)" +
    "and using the incr and decr (without the default parameters values) methods on this counter1 val" +
    "counter1.incr(1).decr(1).incr(3).incr(3).counter " should "return 16" in{

    val counter1 = new OOP.Counter(10)

    counter1.incr(1).decr(1).incr(3).incr(3).counter shouldEqual 16
  }


  //Exercise 9.
  "Implementig the Adder class, val adder1 = new Adder(5) and the counter class" +
    " val counter1 = new Counter(10). Then using the counter1.set(adder1).counter" should "return" +
    "20" in {

    val counter1 = new OOP.Counter(10)
    val adder1 = new OOP.Adder(5)

    counter1.set(adder1).counter shouldEqual 20
  }


  //Exercise 10.
  "Implementig the companion object Persona as Persona('JuanCardona')" should "return Juan" in{
    OOP.Persona("JuanCardona") shouldEqual "Juan"
  }

  "Implementig the companion object Persona as Persona('DavidBarrera')" should "return David" in{
    OOP.Persona("DavidBarrera") shouldEqual "David"
  }


  //Exercise 11.
  "Implementing the object Director, creating two vals of type Director" +
    "val director1 = Director('director1','apellido',1950) " +
    "val director2 = Director('director2','apellido2',1960)" +
    "and using the esMayor method Director.esMayor(director1,director2)" should "return director1" in{

    val director1 = OOP.Director("director1","apellido1",1950)
    val director2 = OOP.Director("director2","apellido2",1960)

    Director.esMayor(director1,director2) shouldEqual "director1"
  }


  "Implementing the object Pelicula, creating two vals of type Pelicula" +
    "val pelicula1 = Pelicula('Pelicula1',2000,7.5,director1)" +
    "val pelicula2 = Pelicula('Pelicula2',2010,7,director2)" +
    "and using the mejorCalificada method Pelicula.mejorCalificada(pelicula1,pelicula2)" should "return Pelicula1" in{

    val pelicula1 = OOP.Pelicula("Pelicula1",2000,7.5,director1)
    val pelicula2 = OOP.Pelicula("Pelicula2",2010,7,director2)

    Pelicula.mejorCalificada(pelicula1,pelicula2) shouldEqual "Pelicula1"
  }



  "Implementing the object Pelicula, creating two vals of type Pelicula" +
    "val pelicula1 = Pelicula('Pelicula1',2000,7.5,director1)" +
    "val pelicula2 = Pelicula('Pelicula2',2010,7,director2)" +
    "and using the mayorDirectorEnElTiempo method Pelicula.mayorDirectorEnElTiempo(pelicula2,pelicula1)" +
    "" should "return director1" in{

    val pelicula1 = OOP.Pelicula("Pelicula1",2000,7.5,director1)
    val pelicula2 = OOP.Pelicula("Pelicula2",2010,7,director2)

    Pelicula.mayorDirectorEnElTiempo(pelicula2,pelicula1) shouldEqual "director1"
  }

}
