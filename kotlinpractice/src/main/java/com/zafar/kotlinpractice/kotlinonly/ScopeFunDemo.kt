package com.zafar.kotlinpractice.kotlinonly

fun main() {
   val people = mutableListOf("Zafar", "Ali", "Kamran")
    noSideEffectList(people)
    sideEffectList(people)
    noSideEffectList(people)
    val size:Int = 10
//    multiplicationBoard(size)
    testResult()
}

fun noSideEffectList(name: List<String>){
    println(name)
}

fun sideEffectList(name: MutableList<String>){
    name.add("Danish")
}


fun multiplicationBoard(size: Int) {
    for (number in 1..size) {
        print(" | ")
        for (anotherNumber in 1..size) {
            print(" $number * $anotherNumber = ${number * anotherNumber} | ")
        }
        println()
    }
}

fun testResult() {
    val list = listOf(1,2,3,4,5)
    val result = list.fold(0) { acc, num ->
       if (num%2 == 0) {
           acc + num
       } else {
           acc
       }
    }
    println(result)
}