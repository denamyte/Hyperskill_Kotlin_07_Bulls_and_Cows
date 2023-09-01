package bullscows

private const val digits = "0123456789"

fun main() {
//    val grader = Grader(code)
//    val sample = readln()
//    val barnyard = grader.grade(sample)
//    buildMessage(barnyard).run(::println)

    val number = readln().toInt()
    println(
        when {
            number > 10 -> "Error: bla-bla..."
            else -> "The random secret number is ${generateCode(number)}"
        }
    )
}

fun generateCode(number: Int): String {
    var dList = digits.toList()
    while (dList.first() == '0') dList = dList.shuffled()
    return dList.subList(0, number).joinToString("")
}

//fun buildMessage(res: Pair<Int, Int>): String {
//    val sb = StringBuilder("Grade: ")
//    val first = res.first > 0
//    val second = res.second > 0
//    if (first) sb.append("${res.first} bull(s)")
//    if (first && second) sb.append(" and ")
//    if (second) sb.append("${res.second} cow(s)")
//    if (!first && !second) sb.append("None")
//    sb.append(". The secret code is $code.")
//    return sb.toString()
//}

