fun printIfPrime(number: Int) {
    var flag = false
    for (i in 2..number / 2) {
        if (number % i == 0) {
            flag = true
            break
        }
    }
    println("$number is ${if (flag) "not " else ""}a prime number.")
}

fun main(args: Array<String>) {
    val number = readln().toInt()
    printIfPrime(number)
}