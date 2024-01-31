package com.example.minipojects.basics

/*on create of every object we only have one single instance as it is singleton
* and we can't create instances of it */
object ReusedVariables {
    val PI = 3.141592

    fun methodCallWithoutInstance() {
        //called as ReusedVariables.methodCallWithoutInstance() without instance as it is singleton
    }
}