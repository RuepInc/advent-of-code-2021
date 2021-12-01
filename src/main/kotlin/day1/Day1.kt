package day1

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.io.File

class Day1 {
    companion object {
        fun part1(depth: List<Int>): Int {
            return depth
                .zipWithNext()
                .count { it.second.minus(it.first) > 0 }
        }

        fun part2(depth: List<Int>): Int {
            return depth
                .windowed(3)
                .map { it.sum() }
                .zipWithNext()
                .count { it.second.minus(it.first) > 0 }
        }
    }
}

class Day1Test {
    @Test
    fun testPart1() {
        val depth = File("/home/thomas/dev/learning/adventOfCode2021/src/main/resources/day1/testinput.txt")
            .readLines()
            .map { it.toInt() }
        assertEquals(7, Day1.part1(depth))
    }

    @Test
    fun outPart1() {
        val depth = File("/home/thomas/dev/learning/adventOfCode2021/src/main/resources/day1/puzzleinput.txt")
            .readLines()
            .map { it.toInt() }
        println(Day1.part1(depth))
    }

    @Test
    fun testPart2() {
        val depth = File("/home/thomas/dev/learning/adventOfCode2021/src/main/resources/day1/testinput.txt")
            .readLines()
            .map { it.toInt() }
        assertEquals(5, Day1.part2(depth))
    }

    @Test
    fun outPart2() {
        val depth = File("/home/thomas/dev/learning/adventOfCode2021/src/main/resources/day1/puzzleinput.txt")
            .readLines()
            .map { it.toInt() }
        println(Day1.part2(depth))
    }
}
