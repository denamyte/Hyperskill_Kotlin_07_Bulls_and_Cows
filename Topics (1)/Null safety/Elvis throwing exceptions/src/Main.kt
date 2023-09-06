    fun main() = readlnOrNull().run {
        println("Elvis says: ${checkNotNull(this)}")
    }