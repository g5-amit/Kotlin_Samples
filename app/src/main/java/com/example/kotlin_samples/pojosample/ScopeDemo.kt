package com.example.kotlin_samples.pojosample

import java.io.File

//run method uses this object like T.f(), so it can be accessed from this keyword
fun printData2(str: String?){
    str?.run {
        println(this.length)
    }
}

private const val x: String = "abc"
val y= run {
    val x = "bcd"
    if (x=="abc") "show Toast" else "show snackbar"
}

//with(webview.settings) {
//    this?.javaScriptEnabled = true
//    this?.databaseEnabled = true
//}
//// Nice.
//webview.settings?.run {
//    javaScriptEnabled = true
//    databaseEnabled = true
//}

val isEmpty = "abc".let {
    it.isEmpty()
}

// let method uses object as argument like f(T), so it use it as argument value
fun printData(str: String?){
    str?.let {
        println(it)
    }

}

val original = "abc"
// Evolve the value and send to the next chain
val result =original.let {
    println("The original String is $it") // "abc"
    it.reversed() // evolve it as parameter to send to next let
}.let {
    println("The reverse String is $it") // "cba"
    it.length  // can be evolve to other type
}.let {
    println("The length of the String is $it") // 3
}
// Wrong
// Same value is sent in the chain (printed answer is wrong)
val res= original.also {
    println("The original String is $it") // "abc"
    it.reversed() // even if we evolve it, it is useless
}.also {
    println("The reverse String is ${it}") // "abc"
    it.length  // even if we evolve it, it is useless
}.also {
    println("The length of the String is ${it}") // "abc"
}
// Corrected for also (i.e. manipulate as original string
// Same value is sent in the chain
val res2= original.also {
    println("The original String is $it") // "abc"
}.also {
    println("The reverse String is ${it.reversed()}") // "cba"
}.also {
    println("The length of the String is ${it.length}") // 3
}



fun makeDir(path: String) = path.let{ File(it) }.also{ it.mkdirs() }

class PersonDemo{
    var name: String =""
    var age: Int = 0
}

// apply override the current object properties and return object with new props
val amit = PersonDemo().apply {
    name = "Amit"
    age = 32
}









