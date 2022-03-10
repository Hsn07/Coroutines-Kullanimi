package com.hbacakk.coroutines

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

fun main(){
    runBlocking {
        delay(2000)
        println("Run Blocking")
        myFunction()
    }
}
suspend fun myFunction(){
    coroutineScope {
        delay(4000)
        println("suspend Function ")
    }
}