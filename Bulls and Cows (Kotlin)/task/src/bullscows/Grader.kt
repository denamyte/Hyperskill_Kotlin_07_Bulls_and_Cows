package bullscows

class Grader(val code: String) {
    fun grade(sample: String): Pair<Int, Int> {
        var bulls = 0
        var cows = 0
        sample.forEachIndexed{i, c ->
            when {
                code[i] == c -> bulls += 1
                code.contains(c) -> cows += 1
            }}
        return Pair(bulls, cows)
    }
}