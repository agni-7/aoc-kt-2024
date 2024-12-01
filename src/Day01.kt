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
        return sortedFirst.zip(sortedSecond).fold(0) {acc, (a, b) -> acc + abs(a - b) }
    }

    fun part2(input: List<String>): Int {
        val (firstList, secondList) = parseLists(input)
        return firstList.fold(0) { acc, a -> acc + (a * secondList.count { it == a })}
    }

    val testInput = readInput("Day01_test")
    check(part1(testInput) == 11)

    val input = readInput("Day01")
    part1(input).println()
    part2(input).println()
}
