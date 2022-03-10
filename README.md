# Coroutines-Kullanimi

## Kütüphanenin eklenmesi
> Gradle Scripts > build.gradle dosyasında dependencies altına retrofit kütüphanesinin eklenmesi
>```kotlin
>   implementation 'org.jetbrains.kotlinx:kotlinx-coroutines-android:1.3.9'
>   implementation 'org.jetbrains.kotlinx:kotlinx-coroutines-core:1.3.9'
>```
>


```kotlin
println("run Blocking Start")
runBlocking {
    launch {
        delay(2000)
        println("run Blocking ...")
    }
}
println("Blocking End")
```



```kotlin 
//Light Weightness
GlobalScope.launch {
    repeat(1000){
    launch {
        println("Android")
            }
    }
}
```
```kotlin
println("Coroutine Scope Start")

CoroutineScope(Dispatchers.Default).launch {
    delay(5000)
    println("run Coroutine Scope...")
}
println("Coroutine Scope End")
```
```kotlin
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
```
```kotlin
//Coroutines Scope
runBlocking {
    launch {
        elay(5000)
        println("run Blocking ")
    }
    coroutineScope {
        launch {
            delay(3000)
            println("coroutine Scope")
        }
    }
}
```
```kotlin
fun main(){
    ////Async Coroutines
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
```
```kotlin
//Dispatchers Coroutines
//Dispatchers.Default -> CPU Intensive
//Dispatchers.IO -> Input / Output, Networking
//Dispatchers.Main -> UI
//Dispatchers.Unconfined -> Inherited dispatcher

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
```
```kotlin
//Job
runBlocking {
    val myJob=launch {
        delay(2000)
        println("Job ")
    }
    myJob.invokeOnCompletion {
        println("my job end")
    }
    myJob.cancel()
}
```
```kotlin
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
```
```kotlin
runBlocking {
    launch(Dispatchers.Default) {
        println("Context: ${coroutineContext}")
        withContext(Dispatchers.Main){
            println("Context: ${coroutineContext}")
        }
    }
}
```



