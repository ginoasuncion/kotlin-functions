package ginoasuncion.com.kotlinfunctions
import java.util.*

//fun main(args: Array<String>) {
//    println("Hello, world!")
//}

//fun main(args: Array<String>) {
//    println("Hello, ${args[0]}!")
//}

//fun main(args: Array<String>) {
//    val isUnit = println("This is an expression")
//    println(isUnit)
//}

//
//fun main(args: Array<String>) {
//    val temperature = 10
//    val isHot = if (temperature > 50) true else false
//    println(isHot)
//}

//
//fun main(args: Array<String>) {
//    val temperature = 10
//    val message = "The water temperature is ${ if (temperature > 50) "too warm" else "OK" }."
//    println(message)
//}
//
//
//fun feedTheFish() {
//    val day = randomDay()
//    val food = "pellets"
//    println ("Today is $day and the fish eat $food")
//}

//fun randomDay() : String {
//    val week = arrayOf ("Monday", "Tuesday", "Wednesday", "Thursday",
//        "Friday", "Saturday", "Sunday")
//    return week[Random().nextInt(week.size)]
//}
//
//fun main(args: Array<String>) {
//    feedTheFish()
//}

//fun fishFood (day : String) : String {
//    var food = ""
//    when (day) {
//        "Monday" -> food = "flakes"
//        "Tuesday" -> food = "pellets"
//        "Wednesday" -> food = "redworms"
//        "Thursday" -> food = "granules"
//        "Friday" -> food = "mosquitoes"
//        "Saturday" -> food = "lettuce"
//        "Sunday" -> food = "plankton"
//    }
//    return food
//}

//fun fishFood (day : String) : String {
//    return when (day) {
//        "Monday" -> "flakes"
//        "Wednesday" -> "redworms"
//        "Thursday" -> "granules"
//        "Friday" -> "mosquitoes"
//        "Sunday" -> "plankton"
//        else -> "nothing"
//    }
//}
//
//fun randomDay() : String {
//    val week = arrayOf ("Monday", "Tuesday", "Wednesday", "Thursday",
//        "Friday", "Saturday", "Sunday")
//    return week[Random().nextInt(week.size)]
//}
//
//fun feedTheFish() {
//    val day = randomDay()
//    val food = fishFood(day)
//
//    println ("Today is $day and the fish eat $food")
//}
//
//fun main(args: Array<String>) {
//    feedTheFish()
//}

import java.util.*    // required import

fun randomDay() : String {
    val week = arrayOf ("Monday", "Tuesday", "Wednesday", "Thursday",
        "Friday", "Saturday", "Sunday")
    return week[Random().nextInt(week.size)]
}

fun fishFood (day : String) : String {
    return when (day) {
        "Monday" -> "flakes"
        "Wednesday" -> "redworms"
        "Thursday" -> "granules"
        "Friday" -> "mosquitoes"
        "Sunday" -> "plankton"
        else -> "nothing"
    }
}

fun feedTheFish() {
    val day = randomDay()
    val food = fishFood(day)
    println ("Today is $day and the fish eat $food")
    println("Change water: ${shouldChangeWater(day)}")
}

fun shouldChangeWater (day: String, temperature: Int = 22, dirty: Int = 20): Boolean {
    return when {
        isTooHot(temperature) -> true
        isDirty(dirty) -> true
        isSunday(day) -> true
        else  -> false
    }
}

fun isTooHot(temperature: Int) = temperature > 30

fun isDirty(dirty: Int) = dirty > 30

fun isSunday(day: String) = day == "Sunday"

fun swim(speed: String = "fast") {
    println("swimming $speed")
}

//fun main(args: Array<String>) {
//    feedTheFish()
//    swim()   // uses default speed
//    swim("slow")   // positional argument
//    swim(speed="turtle-like")   // named parameter
//}


//fun main() {
//    val decorations = listOf("rock", "pagoda", "plastic plant", "alligator", "flowerpot")
//
//    // eager, creates a new list
//    val eager = decorations.filter { it[0] == 'p' }
//    println("eager: $eager")
//
//    // lazy, will wait until asked to evaluate
//    val filtered = decorations.asSequence().filter { it[0] == 'p' }
//    println("filtered: $filtered")
//
//    // force evaluation of the lazy list
//    val newList = filtered.toList()
//    println("new list: $newList")
//
//    val lazyMap = decorations.asSequence().map {
//        println("access: $it")
//        it
//    }
//
//    println("lazy: $lazyMap")
//    println("-----")
//    println("first: ${lazyMap.first()}")
//    println("-----")
//    println("all: ${lazyMap.toList()}")
//
//    val mysports = listOf("basketball", "fishing", "running")
//    val myplayers = listOf("LeBron James", "Ernest Hemingway", "Usain Bolt")
//    val mycities = listOf("Los Angeles", "Chicago", "Jamaica")
//    val mylist = listOf(mysports, myplayers, mycities)     // list of lists
//    println("-----")
//    println("Flat: ${mylist.flatten()}")
//}

fun updateDirty(dirty: Int, operation: (Int) -> Int): Int {
    return operation(dirty)
}

fun increaseDirty( start: Int ) = start + 1


fun main() {
    var dirtyLevel = 20
//    val waterFilter = { dirty: Int -> dirty / 2 }
//    val waterFilter: (Int) -> Int = { dirty -> dirty / 2 }
//    println(waterFilter(dirtyLevel))


    val waterFilter: (Int) -> Int = { dirty -> dirty / 2 }
    println(updateDirty(30, waterFilter))

    println(updateDirty(15, ::increaseDirty))

//    var dirtyLevel = 19
    dirtyLevel = updateDirty(dirtyLevel) { dirtyLevel -> dirtyLevel + 23}
    println(dirtyLevel)
}