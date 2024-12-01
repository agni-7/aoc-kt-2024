import kotlin.math.abs

fun main() {
    fun parseLists(input: List<String>) = input.map {
        val (firstListValue, secondListValue) = it.split("   ").map { n -> n.toInt() }
        firstListValue to secondListValue
    }.unzip()

    fun part1(input: List<String>): Int {
        val (firstList, secondList) = parseLists(input)
        val sortedFirst = firstList.sorted()
        val sortedSecond = secondList.sorted()
        val difference = sortedFirst.zip(sortedSecond).fold(0) {acc, (a, b) -> acc + abs(a - b) }
        return difference
    }

    val testInput = readInput("Day01_test")
    check(part1(testInput) == 11)

    // Read the input from the `src/Day01.txt` file.
    val input = readInput("Day01")
    part1(input).println()
}
