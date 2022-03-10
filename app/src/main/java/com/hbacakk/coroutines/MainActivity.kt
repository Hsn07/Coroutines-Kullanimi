package com.hbacakk.coroutines

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Light Weightness
        /*GlobalScope.launch {
            repeat(1000){
                launch {
                    println("Android")
                }
            }
        }*/

        /*
        println("run Blocking Start")
        runBlocking {
            launch {
                delay(2000)
                println("run Blocking ...")
            }
        }
        println("Blocking End")
        */

        /*
        println("Global Scope Start")

        GlobalScope.launch {
            delay(5000)
            println("run Global Scope...")
        }
        println("Global Scope End")*/


        /*println("Coroutine Scope Start")

        CoroutineScope(Dispatchers.Default).launch {
            delay(5000)
            println("run Coroutine Scope...")
        }
        println("Coroutine Scope End")
        */
        runBlocking {
            launch (Dispatchers.Main){
                println("Main Thread : ${Thread.currentThread().name}")
            }
            launch (Dispatchers.IO){
                println("IO Thread : ${Thread.currentThread().name}")
            }
            launch (Dispatchers.Default){
                println("Default Thread : ${Thread.currentThread().name}")
            }
            launch (Dispatchers.Unconfined){
                println("Unconfined Thread : ${Thread.currentThread().name}")
            }
        }

    }
}