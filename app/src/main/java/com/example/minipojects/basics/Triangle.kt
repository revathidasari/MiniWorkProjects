package com.example.minipojects.basics

import com.example.minipojects.basics.Shape
import kotlin.math.sqrt

class Triangle(
    val a : Double,
    val b : Double,
    val c : Double
) : Shape("Triangle") {
    init {
        println("$name is created by $a , $b and $c")
        println("$name Area is ${area()}")
        println("$name perimeter is ${perimeter()}")
    }

    /*Area = sqrt( p/2 * p/2 -a  * p/2 -b * p/2 -c) // p = perimeter*/
    override fun area() = sqrt(
        (perimeter()/2) *
                (perimeter()/2 - a) *
                (perimeter()/2 - b) *
                (perimeter()/2 - c)
    )

    override fun perimeter() = a + b + c
}