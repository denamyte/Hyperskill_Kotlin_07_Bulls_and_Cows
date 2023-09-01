package bullscows

private const val code = "9305"

fun main() {
    val grader = Grader(code)
    val sample = readln()
    val barnyard = grader.grade(sample)
    buildMessage(barnyard).run(::println)
}

fun buildMessage(res: Pair<Int, Int>): String {
    val sb = StringBuilder("Grade: ")
    val first = res.first > 0
    val second = res.second > 0
    if (first) sb.append("${res.first} bull(s)")
    if (first && second) sb.append(" and ")
    if (second) sb.append("${res.second} cow(s)")
    if (!first && !second) sb.append("None")
    sb.append(". The secret code is $code.")
    return sb.toString()
}

