package com.example.minipojects.basics

import androidx.annotation.Dimension

//abstract is used instead of open as
// abstract is to defined for class refers that other classes can inherit from it and can't be able
// to create instance of this class
abstract class Shape(
    var name:String//protected modifier can be usable in child classes not on MainActivity
) {

    //custom shape
    constructor(name: String, vararg dimension: Double) : this(name)

    init {
        println("I am the super classeee !!")
    }

    //just defining not implementing as properties are unknown as it varies from circle/rectangle/triangle
    abstract fun area() : Double

    abstract fun perimeter() : Double

    fun changeName(newName : String) {
        name = newName
    }
}