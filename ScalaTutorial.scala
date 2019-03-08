import scala.io.StdIn.{readLine}
import scala.math._
import scala.collection.mutable.ArrayBuffer
import java.io.PrintWriter
import scala.io.Source

object ScalaTutorial {
  def main(args: Array[String]) {
    // LOOPS

    var i = 0

    while (i <= 10) {
      println(i)
      i += 1
    }

    do {
      println(i)
      i += 1
    } while (i <= 20)

    for (i <- 1 to 10)
      println("hi", i)

    val randLetters = "ABCDEFGHIJKLMNOQRSTUVWXYZ"

    for (i <- randLetters.length) {
      println(randLetters(i))
    }

    val aList = List(1, 2, 3, 4, 5)
    for (i <- aList) {
      println("List items " + i)
    }

    var i = 0
    var evenList = for { i <- 1 to 20 
      if (i % 2) == 0
    } yield i


    // FUNCTIONS

    def printPrimes(){
      val primeList = List(1,2,3,5,7.11)
      for(i <- primeList){
        if(i == 11)
          return
        if (i != 1)
          println(i)
      }
    }

    printPrimes

    var numberGuess = 0

    do{
      print("Guess a number ")
      numberGuess = readLine.toInt
      
    } while (numberGuess != 6)

    printf("You guessed the secret number %d\n", 6)

    val name = "Amber"
    val age = 29
    val weight = 160

    println(s"Hello $name")
    println(f"I am ${age +1} and $weight%.2f")

    printf("'%5d'\n", 5)

    var randSent = "I saw a dragon fly by"
    println("3rd index : " + randSent(3))
    println("string length : " + randSent.length)

    var randArray = randSent.toArray
    for (v <- randArray)
      println(v)

    def getSum(num1 : Int = 1, num2: Int = 1) : Int = {
      num1 + num2
    }
    println("5 + 4 = " + getSum(5,4))
    println("5 + 4 = " + getSum(num2=5,num1=4))

    def sayHi() : Unit = {
      println("Hi cats are great")
    }
    sayHi

    def getSum(args : Int*) : Int = {
      var sum : Int = 0
      for(num <- args)
        sum += num
      sum
    }
    println(getSum(1,2,3,4,5))

    def factorial(num : BigInt) : BigInt = {
      if(num <= 1)
        1
      else
        num * factorial(num -1)
    }

    println("Factorial of 4 = " + factorial(4))


    // ARRAYS

    val favNums = new Array[Int](20)
    val friends = Array("Sahan", "Stella")
    println("Best friends " + friends(0))

    val friends2 = ArrayBuffer[String]()
    friends2.insert(0, "Job")
    friends2 += "Madison"
    friends2 ++= Array("Susie", "Paul")
    friends2.insert(1, "Mike", "Sally", "Sue")
    friends2.remove(1,2)

    var friend : String = ""
    for (friend <- friends2)
      println(friend)

    for (j <- 0 to (favNums.length -1)) {
      favNums(j) = j
      println(favNums(j))
    }

    val favNumsTimes2 = for (num <- favNums) yield 2 * num
    favNumsTimes2.foreach(println)

    var favNumsDiv4 = for(num <- favNums if num % 4 == 0) yield num
    favNumsDiv4.foreach(println)

    var multTable = Array.ofDim[Int](10,10)
    for (i <- 0 to 9) {
      for (j <- 0 to 9) {
        multTable(i)(j) = i * j
      }
    }
    for (i <- 0 to 9) {
      for (j <- 0 to 9) {
        printf("%d : %d = %d\n", i, j, multTable(i)(j))
      }
    }

    println("Sum : " + favNums.sum)
    println("Min : " + favNums.min)
    println("Max : " + favNums.max)

    val sortedNums = favNums.sortWith(_>_)
    println(sortedNums.deep.mkString(", "))


    // MAPS

    val employees = Map("Manager" -> "Sue Brown", "Secretary" -> "Bob Smith")

    if(employees.contains("Manager"))
      printf("Manager : %s\n", employees("Manager"))

    val customers = collection.mutable.Map(100 -> "Paul Smith", 101 -> "Sally Smith")
    printf("Cust 1 : %s\n", customers(100))
    customers(100) = "Tom Marks"
    customers(102) = "Megan Swift"
    printf("Cust 1 : %s\n", customers(100))

    for((k,v) <- customers)
      printf("%d : %s\n", k, v)


    // TUPLES

    var tupleMarge = (103, "Marge Simpson", 10.25)
    printf("%s owes us $%.2f\n", tupleMarge._2, tupleMarge._3)
    tupleMarge.productIterator.foreach{ i => println(i) }
    println(tupleMarge.toString())
    
    val river = new Animal
    river.setName("River")
    river.setSound("meow")
    printf("%s says %s\n", river.getName, river.getSound)

    val barkey = new Animal("Barkey", "woof")
    println(barkey.toString)

    val spike = new Dog("Spike", "woof", "grrrrrr")
    spike.setName("Spikeeeeee")
    println(spike.toString)

    val fang = new Wolf("Fang")
    fang.moveSpeed = 36.0
    println(fang.move)

    val superman = new Superhero("Superman")
    println(superman.fly)
    println(superman.hitByBullet)
    println(superman.ricochet(2500))

    
    // HIGHER ORDER FUNCTIONS

    val log10Func = log10 _
    println(log10Func(1000))

    List(1000.0, 10000.0).map(log10Func).foreach(println)
    List(1,2,3,4,5).map((x : Int) => x * 50).foreach(println)
    List(1,2,3,4,5).filter(_ % 2 == 0).foreach(println)

    def times3(num : Int) = num * 3
    def times4(num : Int) = num * 4

    def multIt(func : (Int) => Double, num : Int) = {
      func(num)
    }

    printf("3 * 100 = %.1f\n", multIt(times3, 100))


    // CLOSURES

    val divisorValue = 5
    val divisor5 = (num : Double) => num / divisorValue
    println("5 / 5 = " + divisor5(5.0))


    // WORKING WITH FILES

    val writer = new PrintWriter("test.txt")
    writer.write("Just some random text wooo\nSome more random text")
    writer.close()

    val textFromFile = Source.fromFile("test.txt", "UTF-8")
    val lineIterator = textFromFile.getLines
    for(line <- lineIterator)
      println(line)
    textFromFile.close()


    // ERROR HANDLING

    def divideNums(num1 : Int, num2: Int) =try
    {
      (num1 / num2)
    } catch {
      case ex : java.lang.ArithmeticException => "Can't divide by 0"
    } finally {
      // clean up after exception
    }

    println("3 / 0 = " + divideNums(3,0))

  } // END OF MAIN


  // TRAITS

  trait Flyable{
    def fly : String
  }

  trait BulletProof{
    def hitByBullet: String

    def ricochet(startSpeed : Double) : String = {
      "The bullet ricochets at a speed of %.1f ft/sec".format(startSpeed * .75)
    }
  }

  class Superhero(val name: String) extends Flyable with BulletProof{
    def fly = "%s flies through the air".format(this.name)

    def hitByBullet = "The bullet bounces off of %s".format(this.name)
  }


  // ABSTRACT CLASSES
  
  abstract class Mammal(val name : String){
    var moveSpeed : Double

    def move : String
  }

  class Wolf(name : String) extends Mammal(name){
    var moveSpeed = 35.0

    def move = "The wolf %s runs %.2f mph".format(this.name, this.moveSpeed)
  }


  // CLASSES

  class Animal(var name: String, var sound: String) {
    this.setName(name)

    val id = Animal.newIdNum

    def getName() : String = name
    def getSound() : String = sound

    def setName(name : String){
      if(!(name.matches(".*\\d+.*")))
        this.name = name
      else
        this.name = "No Name"
    }

    def setSound(sound: String){
      this.sound = sound
    }

    def this(name : String){
      this("No Name", "No Sound")   
      this.setName(name)
    }

    def this(){
      this("No Name", "No Sound")
    }

    override def toString() : String = {
      return "%s with the id %d says %s".format(this.name, this.id, this.sound)
    }
  } // END OF Animal


  // STATIC FUNCTIONS ON CLASSES

  object Animal {
    private var idNumber = 0
    private def newIdNum = { idNumber + 1; idNumber }
  }


  // INHERITANCE

  class Dog(name: String, sound: String, growl: String) extends Animal(name, sound){
    def this(name: String, sound: String){
      this("No Name", sound, "No Growl")
      this.setName(name)
    }

    def this(name: String){
      this("No Name", "No Sound", "No Growl")
      this.setName(name)
    }

    def this(){
      this("No Name", "No Sound", "No Growl")
    }

    override def toString() : String = {
      return "%s with the id %d says %s or %s".format(this.name, this.id, this.sound, this.growl)
    }
  }
}
