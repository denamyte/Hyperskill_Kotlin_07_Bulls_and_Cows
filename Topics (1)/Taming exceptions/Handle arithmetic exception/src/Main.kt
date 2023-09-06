fun main() {
    val a = readln().toInt()
    val b = readln().toInt()
    println(
        if (b == 0) "Division by zero, please fix the second argument!"
        else a / b
    )
}