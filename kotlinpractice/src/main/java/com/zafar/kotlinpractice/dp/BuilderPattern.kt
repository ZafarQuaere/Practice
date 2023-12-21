package com.zafar.kotlinpractice.dp

class Hamburger private constructor(
    val cheese : Boolean,
    val lettuce : Boolean,
    val onion : Boolean
) {
    class Builder {
        private var cheese = false
        private var lettuce = false
        private var onion = false

        fun addCheese(value : Boolean) = apply { cheese = value }
        fun addLettuce(value : Boolean) = apply { lettuce = value }
        fun addOnion(value : Boolean) = apply { onion = value }

        fun build() = Hamburger(cheese, lettuce, onion)

    }

    //instance
    var hamburger = Hamburger.Builder()
        .addCheese(true)
        .addLettuce(true)
        .addOnion(false)
        .build()
}