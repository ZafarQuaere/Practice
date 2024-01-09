package com.zafar.kotlinpractice.leetcode

/*
Type : Easy
Problem: Running sum of 1D array
 */
fun main(args: Array<String>) {
    val numbs = intArrayOf(2, 7, 11, 15)
    val runningSumOfArray: IntArray = runningSum(numbs)
    val runningSumOfArray1: IntArray = runningSumApproach2(numbs)
    val runningSumOfArray3: IntArray = runningSumApproach4(numbs)
    println("Running sum = ${runningSumOfArray.toList()}")
    println("Running sum = ${runningSumOfArray1.toList()}")
    println("Running sum = ${runningSumOfArray3.toList()}")
}

fun runningSum(nums: IntArray): IntArray {
    val runningSum: IntArray = IntArray(nums.size)
    if (nums.size > 1) {
        var sum = 0
        for (index in nums.indices) {
            sum += nums[index]
            runningSum[index] = sum
        }
        return runningSum
    } else {
        return nums
    }
}

//second approach using lambda
fun runningSumApproach2(nums: IntArray): IntArray = IntArray(nums.size).apply {
    var sum = 0
    nums.forEachIndexed { index, value ->
        sum += value
        this[index] = sum
    }
}


fun runningSumApproach4(nums: IntArray): IntArray = nums.also { (1 .. nums.lastIndex).forEach { nums[it] += nums[it - 1] } }
