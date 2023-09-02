package bullscows

private const val digits = "0123456789"

fun main() {
    val number = inputNumber()
    println("Okay, let's start a game!")
    val code = generateCode(number)
    val grader = Grader(code)
    var turns = 0
    var bulls = 0

    while (bulls != number) {
        turns++
        println("Turn $turns:")
        val sample = readln()
        val barnyard = grader.grade(sample)
        buildMessage(barnyard).run(::println)
        bulls = barnyard.first
    }

    println("Congratulations! You guessed the secret code.")

    println(
        when {
            number > 10 -> "Error: bla-bla..."
            else -> "The random secret number is ${generateCode(number)}"
        }
    )
}

fun inputNumber(): Int {
    while (true) {
        println("Please, enter the secret code's length:")
        val number = readln().toInt()
        if (number > 10)
            println("Error: bla-bla...")
        else return number
    }
}

fun generateCode(number: Int): String {
    var dList = digits.toList()
    while (dList.first() == '0') dList = dList.shuffled()
    return dList.subList(0, number).joinToString("")
}

fun buildMessage(res: Pair<Int, Int>): String {
    val sb = StringBuilder("Grade: ")
    val first = res.first > 0
    val second = res.second > 0
    if (first) sb.append("${res.first} bull(s)")
    if (first && second) sb.append(" and ")
    if (second) sb.append("${res.second} cow(s)")
    if (!first && !second) sb.append("None")
    return sb.toString()
}

