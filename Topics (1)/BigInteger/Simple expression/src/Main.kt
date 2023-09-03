fun main() = Array(4) { readln().toBigInteger() }
    .let {(-it[0]) * it[1] + it[2] - it[3] }
    .let(::println)