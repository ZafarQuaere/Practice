package com.zafar.kotlinpractice

/**
 * Functions are of many types in Kotlin,
 * 1. Named arguments (named parameter)
 * 2. Default arguments (default value of param is already provided)
 * 3. Extension functions (add new functionality to existing class)
 * 4. Infix functions
 * 5. Tail recursive functions
 * 6. Local functions
 * 7. Member functions
 * 8. Lambda functions
 * 9. Higher-order functions
 * 10. Function literals
 * 11. Function references
 * 12. Inline functions
 * 13. Operator overloading
 * 14 No inline functions
 * 15. Crossinline functions
 * 16. Suspend functions
 */
fun main() {
    val mul = multiply(20, 40)
    println("multiply: $mul")
}

fun multiply(a: Int, b: Int) = a * b