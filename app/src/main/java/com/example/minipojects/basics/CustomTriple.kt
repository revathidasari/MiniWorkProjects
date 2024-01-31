package com.example.minipojects.basics

class CustomTriple<A:Any, B:Any, C:Any>(
    var first : A,
    var second : B,
    var third : C
){
    fun printTypes() {
        println("The first type is ${first::class}")//without Any type it shows error as nullable type
        println("The first type is ${second::class}")
        println("The first type is ${third::class}")
    }
}