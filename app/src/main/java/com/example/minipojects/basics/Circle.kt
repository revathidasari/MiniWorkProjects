package com.example.minipojects.basics

import kotlin.math.PI
import kotlin.random.Random

class Circle(
    val radius : Double
) : Shape("Circle") {

    //it is used to execute the data in it without class instance as Circle.randomCircle()
    // but can't be accessed as circle.randomCircle() as it works as singleton
    companion object {
        fun randomCircle() : Circle {
            val randomRadius = Random.nextDouble(1.0, 10.0)
            println("Random circle is called with radius as $randomRadius")
            return Circle(randomRadius)
        }
    }

    init {
        if (radius < 0) {
            throw NegativeRadiusException()
        }
        println("$name created with radius $radius")
        println("$name Area ${area()}")
        println("$name Perimeter ${perimeter()}")
    }

    override fun area() = radius * radius * ReusedVariables.PI

    override fun perimeter() = 2 * radius * PI
}
class NegativeRadiusException : Exception("Radius can't be negative")
