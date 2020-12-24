package com.example.kotlin_samples.pojosample

/**
 * Main Purpose of Data class is to hold Data
* Data class in kotlin requires one parameter minimum in the constructor
 * Compiler automatically  generates equals(), hashCode()
 * toString() of the form "User(name="amit", age=32, id=1)" using properties of parameterized constructor
 * Data classes cannot be abstract, open, sealed or inner;
 * If there are explicit implementations of equals(), hashCode() or toString() in the data class body
 * or final implementations in a superclass, then these functions are not generated, and the existing implementations are used;
 * Deriving a data class from a type that already has a copy(...) function with a matching signature
 * is prohibited in Kotlin 1.3.
 **/
//1.)Basic Pojo
data class User1(val name: String, var age : Int, val id: Int)
//ex:
val user1 = User1("Amit", 32, 1);


//2.) if the generated class needs to have a parameterless constructor,
// default values for all properties have to be specified
data class User2(val name: String = "", val age: Int = 0)
//ex:
val user2 = User2()

//3.) If Light weight Equality required on data class instead of all properties
// Not including all properties for automatic generated object
// name instance variable will contribute for all default functions like hashCode() and equals()
// means if 2 object having different age with same name will be treated as same object
data class User3(val name: String){
    val age : Int = 0

    fun copy(name: String = this.name, age: Int = this.age)= User3("amit")

}
//ex:
/*val user31 = User3("amit")
val user32 = User3("amit")
user31.age = 32
user32.age = 33
Here user31 is equals to user32 since age property is not part of default constructor
*/

//4.) overriding copy() function
val copyUser = User2("gupta", 32)
val copyUser2 = copyUser.copy(age=30);
