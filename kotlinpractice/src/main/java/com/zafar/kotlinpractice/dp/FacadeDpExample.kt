package com.zafar.kotlinpractice.dp


fun main(args: Array<String>) {
 val shapeMaker = ShapeMaker()
    shapeMaker.drawCircle()
    shapeMaker.drawRectangle()
    shapeMaker.drawSquare()
}

interface Shape {
    fun draw()
}

class Rectangle : Shape {
    override fun draw() {
        println("drawing rectangle")
    }
}

class Square : Shape {
    override fun draw() {
        println("drawing square")
    }
}

class Circle : Shape {
    override fun draw() {
        println("drawing circle")
    }
}

class ShapeMaker {
    private var rectangle: Shape? = null
    private var circle: Shape? = null
    private var square: Shape? = null

   constructor() {
       rectangle = Rectangle()
       circle = Circle()
       square = Square()
   }

    fun drawCircle() {
        circle?.draw()
    }

    fun drawRectangle() {
        rectangle?.draw()
    }

    fun drawSquare() {
        square?.draw()
    }
}