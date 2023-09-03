val oneH = 100.toBigInteger()

fun main() {
    val ab = Array(2) { readln().toBigInteger() }
    val s = ab.sumOf { it }
    ab.map { it * oneH / s }
        .joinToString(" ") { "$it%" }
        .run(::println)
}