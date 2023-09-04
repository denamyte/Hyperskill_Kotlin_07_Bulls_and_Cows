package bullscows

import kotlin.math.min

class Generator(
    val codeLength: Int,
    val symbolsNumber: Int
) {
    val chars = (('0'..'9') + ('a'..'z'))

    fun generate() = chars
        .subList(0, symbolsNumber)
        .shuffled()
        .subList(0, codeLength)
        .joinToString("")
}