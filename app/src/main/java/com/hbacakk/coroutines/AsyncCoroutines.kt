package com.hbacakk.coroutines

import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main(){
    //Async Coroutines
    var userName=""
    var age=0
    runBlocking {

        /*launch {
            val downloadedName= downloadName()
            println("${downloadedName}")
        }
        launch {
            val downloadedAge= downloadAge()
            println("${downloadedAge}")
        }*/
        val downloadedName=async {
            downloadName()
        }
        val downloadedAge=async {
            downloadAge()
        }
        userName= downloadedName.await()
        age= downloadedAge.await()

        println("${userName} ${age}")
    }
}
suspend fun downloadName():String{
    delay(2000)
    val userName="Hasan "
    println("user Name download")
    return userName
}
suspend fun downloadAge():Int{
    delay(4000)
    val userAge=30
    println("user Age download")
    return userAge
}