fun calculateBrakingDistance(v1: String, a: String) = try {
    val v = v1.toInt()
    -v * v / (2 * a.toInt())
} catch (e: NumberFormatException) {
    println(e.message)
    -1
} catch (_: ArithmeticException) {
    println("The car does not slow down!")
    -1
}
