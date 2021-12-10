package day1

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.io.File

class Day3 {
    companion object {
        fun part1(numbers: List<String>): Int {
            val columns = numbers[0].indices
            val gammaRate = columns
                .map { numbers.countBitsInColumn(it) }
                .joinToString("") { (zeroes, ones) ->
                    if (zeroes > ones) "0" else "1"
                }
            return gammaRate.binaryToDecimal() * gammaRate.invertBinary().binaryToDecimal()
        }

        fun part2(numbers: List<String>): Int {
            fun rating(type: RatingType): String {
                val columns = numbers[0].indices
                var candidates = numbers
                for (column in columns) {
                    val (zeroes, ones) = candidates.countBitsInColumn(column)
                    val mostCommon = if (zeroes > ones) '0' else '1'
                    candidates = candidates.filter {
                        when (type) {
                            RatingType.OXYGEN -> it[column] == mostCommon
                            RatingType.CO2 -> it[column] != mostCommon
                        }
                    }
                    if (candidates.size == 1) break
                }
                return candidates.single()
            }
            return rating(RatingType.OXYGEN).binaryToDecimal() * rating(RatingType.CO2).binaryToDecimal()
        }


        private fun List<String>.countBitsInColumn(column: Int): BitCount {
            var zeroes = 0
            var ones = 0
            for(line in this) {
                if(line[column] == '0') zeroes++ else ones++
            }
            return BitCount(zeroes, ones)
        }

        private data class BitCount(val zeroes: Int, val ones: Int)

        private fun String.invertBinary() = this.map {
            when (it) {
                '1' -> '0'
                else -> '1'
            }
        }.joinToString("")

        private fun String.binaryToDecimal() = this.toInt(2)

        private enum class RatingType {
            OXYGEN,
            CO2
        }

    }

    class Day3Test {
        @Test
        fun testPart1() {
            val numbers =
                File("/home/thomas/dev/learning/adventOfCode2021/src/main/resources/day3/testinput.txt").readLines()
            assertEquals(198, part1(numbers))
        }

        @Test
        fun outPart1() {
            val numbers =
                File("/home/thomas/dev/learning/adventOfCode2021/src/main/resources/day3/puzzleinput.txt").readLines()
            println(part1(numbers))
        }

        @Test
        fun testPart2() {
            val numbers =
                File("/home/thomas/dev/learning/adventOfCode2021/src/main/resources/day3/testinput.txt").readLines()
            assertEquals(230, part2(numbers))
        }

        @Test
        fun outPart2() {
            val numbers =
                File("/home/thomas/dev/learning/adventOfCode2021/src/main/resources/day3/puzzleinput.txt").readLines()
            println(part2(numbers))
        }


    }
}

