//in Kotlin all things are public by default
// If variables are having getter and setter , these need not to make private as per kotlin
// Kotlin class are final by default
// class method are also final by default
class Person(name: String, age: Int){
    var name: String
    private var age: Int = 0
    private val likedPerson = mutableListOf<Person>()
    init {
        this.age = age
        this.name = name
        printObj(name , age = 23)

        println(2 times "magic")// o/p = magic magic

        val Amit = Person("Amit", 32)
        val Shubham = Person("Shubham", 31)
        Amit likes Shubham

        val myPair = "Hello" onto "World"
        println(myPair)// Hello World

        printAll("amit", "adit", "anvay", prefix="shubham")

        val stack = getMutableStack(1,2,3,3,3,4)
        println(stack)

        val family: Family = BigFamily(5)
        family.sayHello()

        val cakes = listOf("Strawberry", "apple", "pineapple")
        for(cake in cakes){
            print("it's a $cake cake")
        }

        val zoo = Zoo(listOf(Animal("lion"), Animal("monkey")))
        for (animal in zoo){
            println(animal)
        }

        for(i in 0..3) {             // 0123
            print(i)
        }

        for(i in 2..8 step 2) {      // 2468
            print(i)
        }

        for (i in 3 downTo 0) {      // 3210
            print(i)
        }

        for (c in 'z' downTo 's' step 2) { // zxvt
            print(c)
        }

        for (c in 'a'..'d') {        // abcd
            print(c)
        }

        val i:Int = 7
        if (i !in 6..10) {          // 2
            print("x is not in range from 6 to 10")
        }

        val authors = setOf("Shakespeare", "Hemingway", "Twain")
        val writers = setOf("Twain", "Shakespeare", "Hemingway")
        println(authors == writers)   // true since equals method called
        println(authors === writers)  // false since object references are checked


        // for Data class
        val user = DataClass(1,"Amit")

        println(user.copy())                                   // 5
        println(user.copy(3))                              // 6
        println(user.copy(name = "hello"))                             // 7

        println("name = ${user.component1()}")
        // componentN returns value in order of arguments
        println("id = ${user.component2()}")

        CarFactory.makeCar()

        Car.makeCar()
        Car.Demo.makeCar()

        start(object : Vehicle {
            override fun drive() = print("hi I am driving")

        })


    }

    private fun start(vehicle: Vehicle)= vehicle.drive()

    fun max(a: Int, b:Int)= if (a>b) a else b






    // passing argument with initialization value
    private fun printObj(name: String = "am", age: Int) : Unit{

    }

    //Member functions and extensions with a single parameter can be turned into infix functions.
    infix fun Int.times(str: String)= str.repeat(2)

    //Added Person Object in List
    private infix fun Person.likes(person: Person)= likedPerson.add(person)

    private infix fun String.onto(other: String) = Pair(this, other)   // 4

    private fun printAll(vararg messages : String, prefix: String){
        for(m in messages) println(prefix+m)
    }

    fun log(vararg logs: String){
        printAll(*logs, prefix="abc")
    }

    private fun <E> getMutableStack(vararg elements:E): Employee<E> {
        return Employee(*elements)
    }

    //switch case handling
    fun checkWhen(obj: Any): Any{
        return when(obj){
            1-> "one"
            "hello"-> 1
            is Long -> "Long Number"
            !is String -> "unknown type"
            else ->false
        }
    }



}

class Employee<E>(vararg elements: E){

    private val items = elements.toMutableList()

    fun peek(): E{
        return items.last()
    }

    fun push(element: E)= items.add(element)

    override fun toString(): String {
        return "Employee(${items.joinToString()})"
    }

}

open class Family(val member: Int, val owner: String){
    open fun sayHello(){
        println("Hello $member members of $owner 's family")
    }

}

class SmallFamily :Family(5, "Bhagwan"){
    override fun sayHello(){
        println("Hello Small family")
    }
}

class BigFamily(members:Int) : Family(members, "Bhagwan"){
    fun bigSay(){
        print("bigFamily")
    }

}
class Animal(val name: String)

class Zoo(val animals: List<Animal>){

    // We can create operator for iterator instead of implementing Iterator interface
    //operator are predefined internally for known operators like for + -> plus operator
    operator fun iterator(): Iterator<Animal>{
        return animals.iterator()
    }

}

val data1 = DataClass(1,"Amit")
val data2 = DataClass(1, "Amit")
//data1, data2 are equals , hashcode are equals, all getter , setter, toString(), hashCode, equals method are overridden
// copy() function creates copy of object and having hashcode and equals method treat it same object
// these classes are final classes and can't be inherited
data class DataClass(val id: Int, val name: String)


// Sealed Classes can't be inherited outside of this file, it act as Enum
sealed class Mammal(name: String)
class Cat(name: String) : Mammal(name)
class Dog(name:String, age: Int): Mammal(name)
fun greetMammal(obj: Mammal) : String{
    return when(obj){
        is Cat-> "is cat"
        is Dog -> "is Dog"
    }
}

//Singleton class
object CarFactory{
    fun makeCar(): Int{
        return 1
    }
}

class Car(){
    companion object Demo{
        fun makeCar(): Int{
            return 1
        }
    }
}

interface Vehicle{
    fun drive()
}





