package com.example.minipojects.sampleFiles.testing

object Sample {

    /*Returns nth fibonacci number
    * defined like :
    * fib(0) = 0
    * fib(1) = 1
    * fib(n) = fib(n-2) + fib(n-1)
    * */

    fun fib(n: Int) : Long {
        if (n==0 || n==1)
            return n.toLong()
        var a = 0L
        var b = 1L
        var c = 1L
        (1..n-1).forEach { i->
            c = a+b
            a = b
            b = c
        }
        return c
    }

    /*check if the braces are set correctly
    * as "(a * b))" should return false*/
    fun checkBraces(string: String) : Boolean {
        return string.count { it == '('} == string.count { it == ')' }
    }
}