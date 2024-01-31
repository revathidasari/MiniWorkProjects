package com.example.minipojects

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.minipojects.basics.*
import kotlin.math.PI
import kotlin.math.pow

class MainActivity : AppCompatActivity() {

    var totalVolume = 0.0F

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val textView = findViewById<TextView>(R.id.textView)
        sphereVolume(5.5F)
        textView?.append(totalVolume.toString().plus(isPalindrome("racecar")))

        val rectangle = Rectangle(4.0, 7.0)
        println("Rectangle area is ${rectangle.area()}")
        println("Rectangle perimeter is ${rectangle.perimeter()}")
        println("${rectangle.name} is an square ${rectangle.isSquare()}")

        val rectangleSquare = Rectangle(4.0)
        println("is square ${rectangleSquare.isSquare()}")

        val circle = Circle(5.0)
        circle.changeName("MyCircle")
        println("change circle name ${circle.name}")
        Circle.randomCircle()

        val triangle = Triangle(3.0, 4.0, 5.0)

        val maxAreaRectCircle = maxArea(rectangle, circle)
        val maxAreaRectCircleTriangle = maxArea(rectangle, circle, triangle)
        println("Max area of Rectangle & Circle is $maxAreaRectCircle")
        println("Max area of Rectangle, Circle & Triangle is $maxAreaRectCircleTriangle")
        customShape()
        useOfLamdaFunctions()


        countFrom10To0()
        println("sum is ${sumOfTheArray()}")
        averageOfTheNumbers()
        println("a^b is ${printPower(2,6)}")
        reverseList()
        fibonicciSeriesDigits(18)
        indexOfNumberOnList(44)
        getMaxOnArray()
        searchFor("Android Programming")
        searchFor("Android Program for searching string", "Bing")
        alternateSum(5,3,12,7,8,2,7) //5-3+12-7+8-2+7 = 20
        println("Number is prime ${997.isPrime()}")
        println("Number is prime ${10.isPrime()}")
        println("product of an list is ${listOf(1,4,77,8,9,34).product()}")

        val x = 20
        val y = 10
        println("x plus y ${x.plus(y)}")

        val alternateList = listOf(1,2,3,4,5)
        val alternateArray = arrayOf(1,2,3,4,5,6)
        firstAndLastElementOfList(alternateList)
        firstAndLastElementOfList(alternateArray.asList())

        defaultOnException()
    }

    fun maxArea(shape1: Shape, shape2: Shape) :Double {
        val areaShape1 = shape1.area()
        val areaShape2 = shape2.area()
        return if (areaShape1 > areaShape2) areaShape1 else areaShape2
    }

    fun maxArea(shape1: Shape, shape2: Shape, shape3: Shape) :Double {
        val maxAreaShape1Shape2 = maxArea(shape1, shape2)
        val areaShape3 = shape3.area()
        return if (maxAreaShape1Shape2 > areaShape3) maxAreaShape1Shape2 else areaShape3
    }


    private fun sphereVolume (radius:Float) {
        totalVolume = (0.75 * PI * radius.pow(3)).toFloat()
    }

    private fun isPalindrome(name:String) : Boolean {
        return name.reversed() == name
    }

    /*not preferred to include onCreate use in kotlin file main function*/
    fun readFromConsole() {
        val readString = readLine()
        println("Entered string is $readString")
    }

    fun countFrom10To0() {
        var i = 10
        println("counts down to 0 from 10 as ")
        while (i>=0) {
            println(i)
            i--
        }
        /*or*/
        for (i in 0..6)
            println(i)
        for (j in 9 downTo 4 step 2)
            println(j)
    }

    fun printPower(base : Int , exponent : Int) : Int {
        var result = 1
        var i = 0
        while (base!=null && exponent!=null && i<exponent) {
            result *=base
            i++
        }
        return result
    }

    fun sumOfTheArray() : Int {
        val items = arrayOf(2,1,4,7,77,6)
        var sum = 0
        for (item in items) {
            sum +=item
        }
        return sum
    }

    fun averageOfTheNumbers()  {
        val items = arrayOf(2,1,4,7,77,6)
        var avg = 0
        for (item in items)
            avg += item
        avg = (avg/items.size)
        println("average is $avg")
    }

    /*list is immutable which is unchangeable where as array is changeable
    * can be overcomed by making list as mutablelistof()*/
    fun reverseList() {
        val list = mutableListOf(1,2,3,4,5,6)
        println("Reversed list is ${list.reversed()}")
        for (i in list.size-1 downTo 0)
            println("reversed by using for ${list[i]}")
    }

    fun fibonicciSeriesDigits(i : Int) {
        val list = mutableListOf(0,1)
        if (i>1) {
            for (item in 2..i-1) {
                val a = list[item -2]
                val b = list[item -1]
                list.add(a+b)
            }
            println("List of 2 numbers is $list")
        }
    }

    fun indexOfNumberOnList(num:Int) : Int{
        val list = listOf(2,4,5,23,20,44,6,7,9)
        for (i in 0..list.size-1) {
            if (list[i]==num) {
                println("Index of $num is $i")
                return i
            }
        }
        return -1
    }
    fun getMaxOnArray() {
        val array = intArrayOf(22,33,44)
        val maxOnList = getMax(3,4,6,8,16,14, *array,12,21)
        println("Max on list is $maxOnList")
    }

    /*vararg means we can have a variable number of elements or parameters*/
    fun getMax(vararg numbers:Int) : Int {
        var max = numbers[0]
        for (number in numbers) {
            if (number > max)
                max = number
        }
        return max
    }

    /*default declaration for an parameter*/
    fun searchFor(search:String, searchEngine:String = "Google") {
        println("Searching for $search on $searchEngine")
    }

    fun alternateSum(vararg numbers:Int) {
        var even = 0
        var odd = 0
        for (index in 0..numbers.size-1) {
            if (index%2  == 0) {
                even += numbers[index]
            } else {
                odd +=numbers[index]
            }
        }
        println("alternate sum is ${even-odd}")
    }
}

private fun List<Int>.product() : Int {
    var res = 1
    for (i in this) {
        res *= i
    }
    return res
}

private fun Int.isPrime() : Boolean {
    for (i in 2 until this-1) { // this = Int from Int.isPrime()
        if (this % i == 0) {
            return false
        }
    }
    return true
}

private fun firstAndLastElementOfList(list: List<Int>) {
    var i = 0
    var j = list.size-1
    while (i <= j) {
        println("i $i .. ${list[i]}")
        if (i!=j) {
            println("j $j .......${list[j]}")
            j--
        }
        i++
    }
}

private fun customShape() {
    val a = 3.0
    val b = 4.0
    val height = 2.0
    //Anonymous class allows to create new functions where an object inherits its super class
    val parallelogram = object : Shape("Parallelogram", a, b, height) {
        init {
            println("Parallelogram with a $a, b $b and height $height")
            println("Parallelogram area is ${area()}")
            println("Parallelogram perimeter is ${perimeter()}")
        }
        override fun area(): Double {
            return a * height
        }

        override fun perimeter(): Double {
            return 2 * a + 2 * b
        }

        fun isRectangle() : Boolean = height == b
    }

    println("Created object is rectangle ${parallelogram.isRectangle()}")
}

private fun defaultOnException() {
    val a = 5//"hello"
    val res = try {
        a?.toInt()
    } catch (e:NumberFormatException) {
        0
    } finally {
        println("Finally block")
    }
    println("res is $res")
    val division = try {
        divide(2.0,0.0)
    } catch (e:DivisionByZeroException) {
        0.0
    }
    println("Result of division $division")
}

class DivisionByZeroException : Exception("Can't be divided by zero, please do by another number")

fun divide(a:Double, b:Double) : Double {
    if (b==0.0)
        throw DivisionByZeroException()
    return a / b
}

private fun useOfLamdaFunctions() {
    val circle1 = Circle(5.0)
    val circle2 = Circle(3.5)
    val rectangle1 = Rectangle(6.0)
    val rectangle2 = Rectangle(4.0, 3.0)
    val triangle1 = Triangle(4.0,4.0,4.0)
    val triangle2 = Triangle(3.0,3.0,3.0)

    var shapes = listOf(circle1, circle2, rectangle1, rectangle2, triangle1, triangle2)
    //in built function
    // shapes = shapes.filter { it.area() > 20.0 }.sortedBy { it.area() }
    //custom function
    shapes = shapes.customFilter{ it.area() > 20.0 }
    for (shape in shapes) {
        println("${shape.name} : Area is ${shape.area()}")
    }

    val list = (1..10).toList()
    val oddSum = list.customFilter { it % 2 == 1 } // (or)
    val oddCustomSum = list.customSumofOdd { it%2 ==1 }
    println("sum of odd $oddSum")

    var triple = Triple<Int, String, Boolean> (4,"hi", true)
    var customTriple = CustomTriple<Int, String, Boolean>(2, "hello", false)
    customTriple.printTypes()
}

//generalized by T instead of shape
//<T: Number> number is super class of int, double,...
fun <T> List<T>.customFilter(filterFunction:(T) -> Boolean) :List<T> {
    val resultList = mutableListOf<T>()
    for (item in this) {
        if (filterFunction(item)) {
            resultList.add(item)
        }
    }
    return resultList
}

//replace T with Int
fun <T> List<T>.customSumofOdd(filterFunction : (T) -> Boolean) : List<T> {
    val result = mutableListOf<T>()
    for (i in this) {
        if (filterFunction(i)) {
            result.add(i)
        }
    }
    return result
}