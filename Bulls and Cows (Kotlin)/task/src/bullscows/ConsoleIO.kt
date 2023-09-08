package bullscows

import kotlin.math.min

private const val MAX_LENGTH = 36

class ConsoleIO {
    private var length = 0

    fun inputCodeLength(): Int {
        while (true) {
            println("Please, enter the secret code's length:")
            val raw = readln()
            try {
                length = raw.toInt()
                if (length <= 0) throw TooLittleLengthException()
                if (length > MAX_LENGTH) {
                    println("Error: bla-bla...")
                } else return length
            } catch (e: NumberFormatException) {
                throw NotValidNumberException(raw)
            }
        }
    }

    fun inputSymbolsNumber(): Int {
        println("Input the number of possible symbols in the code:")
        val symbosNumber = readln().toInt().let {
            if (it > MAX_LENGTH) throw TooManySymbolsExceptions()
            if (it < length) throw TooLittleSymbolsExceptions(length, it)
            it
        }
        return symbosNumber
    }

    fun codeMessage(gen: Generator) {
        val asterisks = "*".repeat(gen.codeLength)
        val lastIndex = gen.symbolsNumber - 1
        val brackets1 = "0-${min(lastIndex, 9)}"
        val brackets2 = if (lastIndex < 10) "" else ", a-${gen.chars[lastIndex]}"
        println("The secret is prepared: $asterisks ($brackets1$brackets2).")
    }

    fun graderMessage(res: Pair<Int, Int>) {
        val sb = StringBuilder("Grade: ")
        val first = res.first > 0
        val second = res.second > 0
        if (first) sb.append("${res.first} bull(s)")
        if (first && second) sb.append(" and ")
        if (second) sb.append("${res.second} cow(s)")
        if (!first && !second) sb.append("None")
        println(sb.toString())
    }

    fun start() = println("Okay, let's start a game!")
    fun turns(turns: Int) = println("Turn $turns:")
    fun congrats() = println("Congratulations! You guessed the secret code.")
}

class TooLittleLengthException: Exception("Error: Too little code length")

class TooLittleSymbolsExceptions(length: Int, symbols: Int):
    Exception("Error: it's not possible to generate a code with a length of $length with $symbols unique symbols.")

class NotValidNumberException(nvn: String): Exception("Error: \"$nvn\" isn't a valid number.")

class TooManySymbolsExceptions():
    Exception("Error: maximum number of possible symbols in the code is 36 (0-9, a-z).")
