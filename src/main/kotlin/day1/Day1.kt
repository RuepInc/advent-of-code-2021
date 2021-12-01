package day1

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.io.File

class Day1 {
    companion object {
        fun part1(depth: List<Int>) =
            depth
                .zipWithNext()
                .count { it.second > it.first }

        fun part2(depth: List<Int>) =
            depth
                .windowed(3)
                .map { it.sum() }
                .zipWithNext()
                .count { it.second > it.first }
    }

    class Day1Test {
        @Test
        fun testPart1() {
            val depth =
                File("/home/thomas/dev/learning/adventOfCode2021/src/main/resources/day1/testinput.txt").readLines()
                    .map { it.toInt() }
            assertEquals(7, part1(depth))
        }

        @Test
        fun outPart1() {
            val depth =
                File("/home/thomas/dev/learning/adventOfCode2021/src/main/resources/day1/puzzleinput.txt").readLines()
                    .map { it.toInt() }
            println(part1(depth))
        }

        @Test
        fun testPart2() {
            val depth =
                File("/home/thomas/dev/learning/adventOfCode2021/src/main/resources/day1/testinput.txt").readLines()
                    .map { it.toInt() }
            assertEquals(5, part2(depth))
        }

        @Test
        fun outPart2() {
            val depth =
                File("/home/thomas/dev/learning/adventOfCode2021/src/main/resources/day1/puzzleinput.txt").readLines()
                    .map { it.toInt() }
            println(part2(depth))
        }
    }
}