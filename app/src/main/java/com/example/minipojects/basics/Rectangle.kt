package com.example.minipojects.basics

import com.example.minipojects.basics.Shape

/*class = blueprint of an object*/
//class Rectangle private constructor( - not accessible in mainactivity as it is private
class Rectangle (
    private val width : Double,
    public val height : Double
) : Shape("Rectangle") {

    //overloading constructor is allowed as number of arguments varies with above
    constructor(a: Double) : this(a, a)

    //overloading constructor is allowed with different parameter types with same number of arguments
    constructor(a:Int , b:Int) : this(a.toDouble(), b.toDouble())

    init {
        println("$name is created with width $width and height $height")
    }

    override fun area() = width * height

    override fun perimeter() = 2 * width + 2 * height

    fun isSquare() = width == height

}