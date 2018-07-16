import java.util.*

fun main(args: Array<String>) {

    // if(args[0].toInt() < 12) println("Good Morning Kotlin")
    // else println("Good Night Kotlin")

    // println("${if(args[0].toInt() < 12) "Good Morning Kotlin" else "Good Night Kotlin"}")

    // feedTheFish()

/*    for (i in 1..10) {
        println("Enter your birthday")
        val fortune: String = getFortune()
        println("Your fortune is: $fortune")
        if (fortune.contains("Take it easy")) break
    }*/

    // swim(50, speed = "slow")

    // tempQuiz1()
    println(whatShouldIDoToday("sad"))
}

fun tempQuiz1() {
    fitMoreFish(10.0, listOf(3, 3, 3))
    fitMoreFish(8.0, listOf(2, 2, 2), hasDecorations = false)
    fitMoreFish(9.0, listOf(1, 1, 3), 3)
    fitMoreFish(10.0, listOf(), 7, true)
}

fun fitMoreFish(
        tankSize: Double,
        currentFish: List<Int>,
        fishSize: Int = 2,
        hasDecorations: Boolean = true): Boolean {

    val exitingTotalLength = getTotalLengthOfExistingFishes(currentFish)

    if (hasDecorations) {
        if (exitingTotalLength + fishSize <= tankSize * 0.8) {
            return true
        }
    } else {
        if (exitingTotalLength + fishSize <= tankSize) {
            return true
        }
    }

    return false
}

fun whatShouldIDoToday(mood: String,
                       weather: String = "sunny",
                       temperature: Int = 24): String {
    when (mood) {
        "happy" -> when (weather) {
            "Sunny" -> return "go for a walk"
        }
        else -> return "Stay at home and read"
    }

    return "Stay at home and read"
}

fun whatShouldIDoTodaySolution(mood: String,
                               weather: String = "sunny",
                               temperature: Int = 24): String {
    return when {
        mood == "happy" && weather == "Sunny" -> "go for a walk"
        else -> "Stay at home and read"
    }
}

fun fitMoreFishSolution(tankSize: Double,
                        currentFish: List<Int>,
                        fishSize: Int = 2,
                        hasDecoratins: Boolean = true): Boolean {
    return (tankSize * if (hasDecoratins) 0.8 else 1.0) >= (currentFish.sum() + fishSize)
}

fun canAddFish(tankSize: Double, currentFish: List<Int>, fishSize: Int = 2, hasDecorations: Boolean = true): Boolean {
    return (tankSize * if (hasDecorations) 0.8 else 1.0) >= (currentFish.sum() + fishSize)
}

fun getTotalLengthOfExistingFishes(currentFish: List<Int>): Int {
    var totalLength = 0

    for (fish in currentFish) {
        totalLength += fish
    }

    return totalLength
}

fun shouldChangeWater(
        day: String,
        temperature: Int = 22,
        dirty: Int = 20
): Boolean {

    val isTooHot = temperature > 30
    val isDirty = dirty > 30
    val isSunday = day == "Sunday"

    return when {
        temperature > 30 -> true
        dirty > 30 -> true
        day == "Sunday" -> true
        else -> false
    }
}

fun isTooHot(temperature: Int): Boolean = temperature > 30

fun isDirty(dirty: Int): Boolean = dirty > 30

fun isSunday(day: String): Boolean = day == "Sunday"

fun swim(time: Int, speed: String = "fast") {

    println("swimming $speed")
}

fun fishFood(day: String): String {

    return when (day) {
        "Monday" -> "flakes"
        "Tuesday" -> "pellets"
        "Wednesday" -> "redworms"
        "Thursday" -> "granules"
        "Friday" -> "mosquitoes"
        "Saturday" -> "lettuce"
        "Sunday" -> "plankton"
        else -> "fastings"
    }
}

fun getBirthday(birthday: Int): Int {
    println("\nEnter your birthday")
    return readLine()?.toIntOrNull() ?: 1
}

fun getFortune(birthday: Int): String {
    val fortunes = listOf(
            "You will have a great day!",
            "Things will go well for you today.",
            "Enjoy a wonderful day of success.",
            "Be humble and all will turn out well.",
            "Today is a good day for exercising restraint.",
            "Take it easy and enjoy life!",
            "Treasure your friends because they are your greatest fortune.")

    val index = when (birthday) {
        in 1..7 -> 4
        28, 31 -> 2
        else -> birthday.rem(fortunes.size)
    }

    return fortunes[index]
}

fun getFortune(): String {
    val fortunes = listOf("You will have a great day!",
            "Things will go well for you today.", "Enjoy a wonderful day of success.",
            "Be humble and all will turn out well.",
            "Today is a good day for exercising restraint.",
            "Take it easy and enjoy life!",
            "Treasure your friends because they are your greatest fortune.")

    val birthday = readLine()?.toIntOrNull() ?: 1
    return fortunes[birthday.rem(fortunes.size)]
}

fun feedTheFish() {
    val day = randomDay()
    val food = fishFood(day)
    println("Today is $day, and the fish eat $food")

    shouldChangeWater(day, 20, 50)
    shouldChangeWater(day)
    shouldChangeWater(day, dirty = 50)
    // best practice: put parameters without default values first
    shouldChangeWater(day = "Monday")

    if (shouldChangeWater(day)) {
        println("Change the water today")
    }
}

fun randomDay(): String {
    val week = listOf("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday")
    return week[Random().nextInt(7)]
}