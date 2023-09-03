import java.math.BigInteger.TWO

fun main() {
    val (a, b) = Array(2) { readln().toBigInteger() }
    ((a + b + (a - b).abs()) / TWO)
        .let(::println)
}