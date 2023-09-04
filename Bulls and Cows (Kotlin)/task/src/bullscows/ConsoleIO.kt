package bullscows

import kotlin.math.min

class ConsoleIO {
    fun inputCodeLength(): Int {
        while (true) {
            println("Please, enter the secret code's length:")
            val length = readln().toInt()
            if (length > 36)
                println("Error: bla-bla...")
            else return length
        }
    }

    fun inputSymbolsNumber(): Int {
        println("Input the number of possible symbols in the code:")
        return readln().toInt()
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