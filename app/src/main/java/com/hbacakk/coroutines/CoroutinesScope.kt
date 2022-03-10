package com.hbacakk.coroutines

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking


fun main(){
    //Coroutines Scope
    runBlocking {
        launch {
            delay(5000)
            println("run Blocking ")
        }
        coroutineScope {
            launch {
                delay(3000)
                println("coroutine Scope")
            }
        }
    }
}