package com.zafar.kotlinpractice.leetcode

fun main() {
    val accountsArray = arrayOf(intArrayOf(1, 5,6), intArrayOf(7, 3,1), intArrayOf(3, 5,9))
    val richestMan = findMaximumWealth(accountsArray)
    val richestMan1 = findMaximumWealthApproach2(accountsArray)
    println("Maximum Wealth = $richestMan1")
}

fun findMaximumWealth(accountsArray: Array<IntArray>): Int {
    return accountsArray.maxByOrNull { it.sum() } ?.sum() ?: 0
}

fun findMaximumWealthApproach2(accountsArray: Array<IntArray>): Int {
//    return accountsArray.maxOfOrNull { it.sum() } ?: 0
    return accountsArray.maxOfOrNull { it.sum() } ?: 0
}
