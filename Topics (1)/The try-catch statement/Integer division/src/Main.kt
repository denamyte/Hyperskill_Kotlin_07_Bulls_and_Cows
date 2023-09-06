fun main() = try {
    Array(2) { readln().toInt() }.reduce(Int::div)
} catch (e: NumberFormatException) {
    "Read values are not integers.\n0"
} catch (e: ArithmeticException) {
    "Exception: division by zero!\n0"
}.run(::println)