package bullscows

fun main() {
    val console = ConsoleIO()
    val gen = Generator(
        console.inputCodeLength(),
        console.inputSymbolsNumber())
    val code = gen.generate()

    console.codeMessage(gen)
    console.start()

    val grader = Grader(code)
    var turns = 0
    var bulls = 0

    while (bulls != gen.codeLength) {
        console.turns(++turns)
        val sample = readln()
        val barnyard = grader.grade(sample)
        console.graderMessage(barnyard)
        bulls = barnyard.first
    }

    console.congrats()
}
