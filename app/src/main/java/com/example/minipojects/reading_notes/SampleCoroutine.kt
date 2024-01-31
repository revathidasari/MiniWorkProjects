package com.example.minipojects.reading_notes

import android.content.Intent
import android.provider.Settings.Global
import android.util.Log
import androidx.core.content.ContextCompat.startActivity
import kotlinx.coroutines.*
import kotlin.system.measureTimeMillis

/*
* if we use multiple suspend fun on same coroutine the delay in 1 function can hold the other function execution and later it updates both
* delay - also an suspend function can be used in coroutines
* GlobalScope.launch(Dispatchers.Main){ } - will executes the coroutine without blocking the main thread
* runBlocking { } - will executes coroutine on the main thread by blocking it
* several suspend functions execute them on same coroutines then they are synchronintial by default
* lifecycleScope.launch{  - executes as long as activity's lifecycle exists to avoid memory leaks
* viewmodelScope.launch{ -executes as long as viewmodel lifecycle exists
* CoroutineScope - to create our own scope of coroutines
*                - used to cancel all coroutines when 1 coroutine fails
* Supervisor - used to work independently of coroutines results on the scope
* viemodelScope - is an supervisor scope
* */
class SampleCoroutine {


    init {

    }

    fun globalScope() {
        //works as long as app runs
        GlobalScope.launch {
            //coroutines here are run in an different new thread
            delay(2000L) // to stop our coroutine in the middle of the execution but it wont block the whole thread
            Log.d("revathi", "coroutines-globalscope thread name is ${Thread.currentThread().name}")
        }
        Log.d("revathi", "coroutines-globalscope out of coroutine thread${Thread.currentThread().name}")
    }

    fun contextCoroutines() {
        GlobalScope.launch(//type pf contexts as main, io, default & unconfined
        //newSingleThreadContext("My Thread")
        Dispatchers.IO
        ) {
            Log.d("revathi","coroutines-context thread name is ${Thread.currentThread().name}")
            val networkCall = doNetworkCall()
            withContext(Dispatchers.Main) {
                Log.d("revathi", "coroutines-context network calls"+networkCall)
              //  tvDummy.text = networkCall
            }
        }
    }

    fun runByBlockingMain() {
        //used to call suspend functions from main thread
        //if we have 2 launches in runblocking with same delay it will execute simultaneously
        Log.d("revathi","coroutines-runBlocking")
        runBlocking {
            launch(Dispatchers.IO) { delay(100L)}
            launch(Dispatchers.IO) { delay(100L)}
            //above both will executes at same time as their delay timing is same

            Log.d("revathi","coroutines-runBlocking started")
            delay(1000L)
            Log.d("revathi","coroutines-runBlocking ended")
        }
        Log.d("revathi","coroutines-runBlocking out of it")

    }

    fun jobUsages() {
        val job = GlobalScope.launch(Dispatchers.Default) {
            Log.d("revathi", "coroutines-job started")
/*            repeat(5) {
                delay(1000L)
            }*/
            //start a coroutine & delaying and cancelling the job based on the time
            withTimeout(3000L) {
                for (i in 30..40) {
                    if (isActive) {
                        Log.d("revathi", "coroutines-job Result for i is $i : ${fib(i)}")
                    }
                }
            }
            Log.d("revathi", "coroutines-job ended")

        }

        runBlocking {
           // job.join()
            //replace the manual job cancel with withTimeout section
            job.cancel()
            delay(2000L)
            Log.d("revathi","coroutines-job Main thread is continuing as job is cancelled")
        }
    }

    fun aysncAndAwait() {
        //we can use for returning result as GlobalScope.async(Dispatchers.IO){ }
        GlobalScope.launch(Dispatchers.IO) {
            val time = measureTimeMillis {
//                val job1 = launch { doNetworkCall() }
//                job1.join()

                val answer1 = async { doNetworkCall() }
                val answer2 = async { doNetworkCall() }
                Log.d("revathi","coroutines-aysnc answer1 ${answer1.await()} answer2 ${answer2.await()}")
                //await - block our current coroutine until its result is available
            }
            Log.d("revathi","coroutines-async time taken by request $time")
        }
    }

    fun globalvsLifecycleScopesonActivity() {
        GlobalScope.launch { //executes even if activity destroys as long as app exists
            //lifecycleScope.launch{
            while (true) {
                delay(1000L)
                Log.d("revathi","coroutines-lifecycle is running")
            }
        }
        GlobalScope.launch {
            delay(2000L)
            //Intent(this@SampleCoroutine, MainActivity::class.java).also { startActivity(it) }
            //finish()
        }
    }
/*
    fun responseFromRetrofit() {
        //we actually use enqueue for the response to identify its failure/success
        val api = "retrofit respnse"
        GlobalScope.launch(Dispatchers.IO) {
            val response = api.getComments()
            if (response.isSuccessful) {
                for (comment in response.body()!!){
                    Log.d("revathi","coroutines-retrofit response ${comment.toString}")
                }
            }
        }
    }*/


    fun handleExceptionsOnCoroutine() {
        //CoroutineExceptionHandler - won't be called for cancellation coroutine
        val handler = CoroutineExceptionHandler { _, throwable->
            println("Caught exception $throwable")
        }
        //handler has been used on top/main coroutine scope
        GlobalScope.launch(handler) { //use lifecycleScope
            launch{
                throw Exception("Error")
            }
        }
    }

    fun differentCoroutineScopes() {
        val handler = CoroutineExceptionHandler{ _, throwable->
            println("Caught Exception $throwable")
        }
        //CoroutineScope -Instead of having an exception handler if 1 coroutine fails it cancels all other child cproutines
        //whole scope is cancelled as soon as 1 coroutine fails so second coroutine wont execute to overcome this
        // we use SupervisorScope to make independent 1 coroutine on another coroutine result
        CoroutineScope(Dispatchers.Main + handler).launch {
            supervisorScope {
                launch {
                    delay(300L)
                    throw Exception("Coroutine 1 failed")
                }
                launch {
                    delay(400L)
                    println("coroutine 2 is passed")
                }
            }
        }
    }

    /*
    * prints coroutine 1 finished even after job cancellation to avoid it we use a condition check on catch block*/
    fun executionEvenAfterCancellation() {
        //lifecycleScope
        GlobalScope.launch {
            val job = launch {
                try {
                    delay(500L)
                } catch (e:Exception) {
                    //with these block it wont execute further
                    if (e is CancellationException) {
                        throw e
                    }
                    e.printStackTrace()
                }
                println("Coroutine 1 is finished")
            }
            delay(300L)
            job.cancel()
        }
    }

}

//coroutines are cancelled once main thread stops
//suspend function can be called only on other suspend function or in an coroutine(e.g., delay())
suspend fun doNetworkCall() : String {
    delay(2000L)
    return "do network called"
}

fun fib(n:Int) :Long {
    return if (n==0) 0
    else if (n==1) 1
    else fib(n-1)+ fib(n-2)
}


/*fun dummyFiresStoreAccess() {
    val doc = Firestore.firebase.collection("coroutines") .document("tutorial")
    val peter = Person("Me",26)
    GlobalScope.launch(Dispatchers.IO) {
        delay(3000L)
*//*        doc.set(peter).onSuccessTask{
            val person = doc.get().onSuccessTask{
            }
        }*//*
        doc.set(peter).await()
        val person = doc.get().await.toObject(Person::class.java)
        withContext(Dispatchers.Main) {
            //dummy.text = person.toString
        }
    }
}
*/
data class Person(
    val name : String = "",
    val age : Int = -1
)