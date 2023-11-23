package com.zafar.kotlinpractice.dp

fun main() {
    val shapeMaker = ShapeFactory()
    val circle = shapeMaker.getShape("circle")
    circle?.drawn()

    val rectangle = shapeMaker.getShape("Triangle")
    rectangle?.drawn()

    val square = shapeMaker.getShape("Quadrangle")
    square?.drawn()
}

interface Shade {
    fun drawn()
}

class Triangle : Shade {
    override fun drawn() {
        println("drawing Triangle")
    }
}

class Quadrangle : Shade {
    override fun drawn() {
        println("drawing quadrangle")
    }
}

class Round : Shade {
    override fun drawn() {
        println("drawing circle")
    }
}

class ShapeFactory{
    fun getShape(shapeType: String): Shade? {

        return when (shapeType) {
            "circle" -> Round()
            "Quadrangle" -> Quadrangle()
            "Triangle" -> Triangle()
            else -> {
                return null
            }
        }
    }
}