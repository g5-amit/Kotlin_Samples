package com.example.kotlin_samples.pojosample


class FunctionMagic(var x: Int, var y: Int){
    var param1 : Int = x
    var param2 : Int = y

    init {
        val sum= calculation(2,3,::sum) //5
        //We can pass function as Lambda Expression and can achieve multiple operation with same arguments
        val multiplication= calculation(2,3){a,b->sum+a*b} //11

        val func = hello()
        val square = func(2)
        println(square)

        val square1: (Int) -> Int = { x -> x*x } // 1
        println(square1(2))

    }


    //Writing function which takes another function as an argument
    // fun f1(operation: (Arguments types)->returnType)
    private fun calculation(x : Int, y : Int, operation: (Int, Int)-> Int  ): Int{
        return operation(x, y)
    }
    private fun sum(x: Int, y: Int)= x+y

    //Writing Function which returns another function
    // fun f2(): (Argument Type)->returnType
    private fun hello():(Int)->Int{
        return ::square
    }
    private fun square(x: Int) = x*x


    //all Lambda Function
    val upperCase1: (String) -> String = { str: String -> str.toUpperCase() } // 1

    val upperCase2: (String) -> String = { str -> str.toUpperCase() }         // 2

    val upperCase3 = { str: String -> str.toUpperCase() }                     // 3

// val upperCase4 = { str -> str.toUpperCase() }   //Wrong one , Need to define type at least at one place

    val upperCase5: (String) -> String = { it.toUpperCase() }                 // 5

    val upperCase6: (String) -> String = String::toUpperCase                  // 6


}



