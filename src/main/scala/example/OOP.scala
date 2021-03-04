package example

object OOP extends  App {

  //Exercise 1.
  object comp {
    def square(doubleSquare:Double) = doubleSquare*doubleSquare
    def cube (doubleCube:Double) = square(doubleCube) * doubleCube
  }

  val cubeOf3 = comp.cube(3)
  println(cubeOf3)


  //Exercise 2.
  object comp2 {
    def square(longSquare:Long) = longSquare*longSquare
    def cube (longleCube:Long) = square(longleCube) * longleCube
  }

  //Exercise 3.
  object prueba {
    def x = {
      println("x")
      1
    }
    val y = {
      println("y")
      x+2
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
  class Gato(val nombre:String, val color:String, val comida:String) {

  }

  object IO extends Gato("IO","Fawn","Churrus"){

  }
  println("Exercise 4, name: " + IO.nombre)
  println("Exercise 4, color: " + IO.color)

  object Make extends Gato("Make","Red","Leche"){

  }
  println("Exercise 4, name: " + Make.nombre)
  println("Exercise 4, comida : " + Make.comida)

  object Docker extends Gato("Docker","Blue","cuido"){

  }
  println("Exercise 4, name: " + Docker.nombre)
  println("Exercise 4, comida : " + Docker.comida)



  //Exercise 5.
  object VentaDeChurrus {
    def despachar (gato:Gato):Boolean = if (gato.comida == "Churrus") true else false
  }

  println("Exercise 5, churrus is his favorite food? " + VentaDeChurrus.despachar(IO))
  println("Exercise 5, churrus is his favorite food? " + VentaDeChurrus.despachar(Make))
  println("Exercise 5, churrus is his favorite food? " + VentaDeChurrus.despachar(Docker))


  //Exercise 6.

   class Driver (val name:String,val last_Name:String,val races:Int, val finished_races:Int) {
    def getName():String = this.name
    def getLastName():String = this.last_Name
    def getTotalRaces():Int = this.races
    def getFinishedRaces():Int = this.finished_races
    def getNotFinishedRaces():Int = this.races - this.finished_races
  }

  class Team (name:String,driver:Driver) {
    def getName() = this.name
    def getDriver() = this.driver
  }
  val driver = new Driver("David", "Barrera", 20,15)
  val team = new Team("Ferrari",driver)

  println("Exercise 6 " + team.getDriver())
  println("Exercise 6 " + driver.finished_races)



  //Exercise 7, 8, and 9

  class Adder ( num:Int ) {
    def add (value:Int) = value + num
  }

  class Counter (val counter:Int) {
    def incr(incr:Int=1) = new Counter(counter+incr)
    def decr(decr:Int=1) = new Counter(counter-decr)
    def set(adder:Adder) = new Counter (counter + adder.add(5))

  }

  val counter1 = new Counter(10)
  val adder1 = new Adder(5)
  println("Exercise 7 " + counter1.incr().decr().incr().incr().counter)
  println("Exercise 8 " + counter1.incr(1).decr(1).incr(3).incr(3).counter)
  println("Exercise 9 " + counter1.set(adder1).counter)


 //Exercise 9



}
