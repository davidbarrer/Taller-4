package example

import scala.annotation.tailrec

object OOP  {

  //Exercise 1.
  object comp {
    def square(doubleSquare: Double) = doubleSquare * doubleSquare

    //Implements the square function to return the cube value of a given number
    def cube(doubleCube: Double) = square(doubleCube) * doubleCube
  }

  val cubeOf3 = comp.cube(3)



  //Exercise 2.
  object comp2 {
    def square(longSquare: Long) = longSquare * longSquare

    def cube(longleCube: Long) = square(longleCube) * longleCube
  }

  //Exercise 3.
  object prueba {
    def x = {
      println("x")
      1
    }

    val y = {
      println("y")
      x + 2
    }

    def z = {
      println("z")
      x
      x + "c"
    }
  }

  /*  prueba.x -----> returns   (side effect) x   Int = 1
      prueba.y -----> returns      Int = 3
      prueba.z -----> returns (side effect) z x x  String= 1c
   */


  //Exercise 4
  class Gato(val nombre: String, val color: String, val comida: String) {

  }

  object IO extends Gato("IO", "Fawn", "Churrus") {

  }

  println("Exercise 4, name: " + IO.nombre)
  println("Exercise 4, color: " + IO.color)

  object Make extends Gato("Make", "Red", "Leche") {

  }

  println("Exercise 4, name: " + Make.nombre)
  println("Exercise 4, comida : " + Make.comida)

  object Docker extends Gato("Docker", "Blue", "cuido") {

  }

  println("Exercise 4, name: " + Docker.nombre)
  println("Exercise 4, comida : " + Docker.comida)


  //Exercise 5.
  object VentaDeChurrus {
    def despachar(gato: Gato): Boolean = if (gato.comida == "Churrus") true else false
  }

  println("Exercise 5, churrus is his favorite food? " + VentaDeChurrus.despachar(IO))
  println("Exercise 5, churrus is his favorite food? " + VentaDeChurrus.despachar(Make))
  println("Exercise 5, churrus is his favorite food? " + VentaDeChurrus.despachar(Docker))


  //Exercise 6.
  /**
   *
    * @param name
   * @param last_Name
   * @param races
   * @param finished_races
   */
  class Driver(val name: String, val last_Name: String, val races: Int, val finished_races: Int) {
    def getName(): String = this.name

    def getLastName(): String = this.last_Name

    def getTotalRaces(): Int = this.races

    def getFinishedRaces(): Int = this.finished_races

    def getNotFinishedRaces(): Int = this.races - this.finished_races
  }

  /**
   *
   * @param name
   * @param driver
   */
  class Team(name: String, driver: Driver) {
    def getName() = this.name

    def getDriver() = this.driver
  }


  val driver = new Driver("David", "Barrera", 20, 15)
  val team = new Team("Ferrari", driver)

  println("Exercise 6 " + team.getDriver.name)
  println("Exercise 6 " + driver.finished_races)


  //Exercise 7, 8, and 9

  class Adder(num: Int) {
    def add(value: Int) = value + num
  }


  class Counter(val counter: Int) {
    def incr(incr: Int = 1) = new Counter(counter + incr)

    def decr(decr: Int = 1) = new Counter(counter - decr)

    def set(adder: Adder) = new Counter(counter + adder.add(5))

  }

  val counter1 = new Counter(10)
  val adder1 = new Adder(5)

  println("Exercise 7 " + counter1.incr().decr().incr().incr().counter)
  println("Exercise 8 " + counter1.incr(1).decr(1).incr(3).incr(3).counter)
  println("Exercise 9 " + counter1.set(adder1).counter)


  //Exercise 10
  class Persona(val name: String, val last_name: String) {
    def nombre = s"$name $last_name"
  }

  object Persona {
    def apply(nameAndLastName: String): String = {
      @tailrec
      def aux(nameAndLastName: String, counter: Int): String = {
        if (nameAndLastName.charAt(counter).isUpper) //When it finds the change to capital letter in the lastName
            (nameAndLastName.split(nameAndLastName.charAt(counter))(0)) //Creates an array seperated with the capital letter of the las name and takes the first element which is the name
        else aux(nameAndLastName, counter + 1)
      }

      aux(nameAndLastName, 1)//The counter helps to loop through the string
    }
  }


  println(Persona("JuanCardona"))
  println(Persona("DavidBarrera"))


  //Exercise 11.

  /**
   * Class Director parameters
   * @param nombre
   * @param apellido
   * @param nacimiento
   */

  class Director (
                 val nombre: String,
                 val apellido: String,
                 val nacimiento: Int
                 ) {
    // Class Director has two methods (name and copy)
    def name: String = s"$nombre $apellido"


    def copy(nombre: String = this.nombre, apellido: String = this.apellido,
             nacimiento: Int = nacimiento):Director = new Director (nombre, apellido, nacimiento)
  }

  //Companion object of Director class

  object Director {

    //Two methods (Apply and EsMayor).

    def apply(nombre: String,
              apellido: String,
              nacimiento: Int) = new Director(nombre,apellido,nacimiento)


    //Receives two Director objects
    //Returns the oldest Director
    def esMayor(director1:Director,director2:Director) =
      if (director1.nacimiento < director2.nacimiento) director1.nombre
      else director2.nombre
  }


  /**
   * Class Pelicula parameters.
   * @param nombre
   * @param presentacion
   * @param rangoIMDB
   * @param director
   */
  class Pelicula (
                 val nombre: String,
                 val presentacion: Int,
                 val rangoIMDB: Double,
                 val director : Director
                 ) {

    //CLass pelicula has three methods (directorEdad,esDirigidaPor and copy)

    def directorEdad = presentacion - director.nacimiento

    def esDirigidaPor(director: Director) = this.director == director

    def copy (
             nombre: String = this.nombre,
             presentacion:Int = this.presentacion,
             rangoIMDB:Double = this.rangoIMDB,
             director: Director = this.director):
    Pelicula = new Pelicula(nombre,presentacion,rangoIMDB,director)
  }

  //Companion object of Pelicula class
  object Pelicula {

    //object pelicula has three methods (apply, mejorCalificada, and mayorDirectorEnElTiempo)

    def apply( nombre: String,
     presentacion: Int,
     rangoIMDB: Double,
     director : Director) = new Pelicula(nombre,presentacion,rangoIMDB,director)

    def mejorCalificada(pelicula1:Pelicula, pelicula2:Pelicula) =
      if (pelicula1.rangoIMDB> pelicula2.rangoIMDB) pelicula1.nombre
      else pelicula2.nombre

    def mayorDirectorEnElTiempo (pelicula1:Pelicula, pelicula2:Pelicula) =
      if (pelicula1.director.nacimiento<pelicula2.director.nacimiento) pelicula1.director.nombre
      else pelicula2.director.nombre
  }



  val director1 = Director("director1","apellido1",1950)
  val director2 = Director("director2","apellido2",1960)
  val pelicula1 = Pelicula("Pelicula1",2000,7.5,director1)
  val pelicula2 = Pelicula("Pelicula2",2010,7,director2)

  println("Exercise 11 " + Director.esMayor(director1,director2))
  println("Exercise 11 " + Director.esMayor(director2,director1))
  println("Exercise 11 " + Pelicula.mejorCalificada(pelicula1,pelicula2))
  println("Exercise 11 " + Pelicula.mayorDirectorEnElTiempo(pelicula2,pelicula1))



}
