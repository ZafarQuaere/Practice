package com.zafar.kotlinpractice.strings.count_no_of_consistent_string

fun main(){
    val words = arrayOf("ad", "bd", "aaab", "baa", "badab")
    val allowed = "ab"
    val count = countConsistentStrings(allowed, words)
//    val count = myConsistent(allowed, words)
    println("count: $count")
}

fun countConsistentStrings(allowed: String, words: Array<String>): Int {
    var count = 0
    for (word in words) {
        var isConsistent = true
        for (char in word) {
            if (!allowed.contains(char)) {
                isConsistent = false
                break
            }
        }
        if (isConsistent) {
            count++
        }
    }
    return count
}

fun myConsistent(allowed: String, words: Array<String>): Int {
    return words.count { it.all { allowed.contains(it) } }
}

