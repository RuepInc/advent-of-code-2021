package day1

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.io.File

class Day2 {
    companion object {
        fun part1(commands: List<String>): Int {
            val pos = Position()
            commands
                .map { Pair(it.substringBefore(' ').trim(), it.substringAfter(' ').trim().toInt()) }
                .forEach {
                    when (it.first) {
                        "forward" -> pos.forward(it.second)
                        "up" -> pos.up(it.second)
                        "down" -> pos.down(it.second)
                    }
                }
            return pos.out()
        }


        fun part2(commands: List<String>): Int {
            val pos = AimedPosition()
            commands
                .map { Pair(it.substringBefore(' ').trim(), it.substringAfter(' ').trim().toInt()) }
                .forEach {
                    when (it.first) {
                        "forward" -> pos.forward(it.second)
                        "up" -> pos.up(it.second)
                        "down" -> pos.down(it.second)
                    }
                }
            return pos.out()
        }
    }

    data class Position(
        var x: Int = 0,
        var y: Int = 0
    ) {
        fun forward(distance: Int) {
            x += distance
        }
        fun down(distance: Int) {
            y += distance
        }
        fun up(distance: Int) {
            y -= distance
        }
        fun out() = x * y

    }

    data class AimedPosition(
        var x: Int = 0,
        var y: Int = 0,
        var aim: Int = 0
    ) {
        fun forward(distance: Int) {
            x += distance
            y += aim * distance
        }
        fun down(distance: Int) {
            aim += distance
        }
        fun up(distance: Int) {
            aim -= distance
        }
        fun out() = x * y

    }

    class Day2Test {
        @Test
        fun testPart1() {
            val commands =
                File("/home/thomas/dev/learning/adventOfCode2021/src/main/resources/day2/testinput.txt").readLines()
            assertEquals(150, part1(commands))
        }

        @Test
        fun outPart1() {
            val commands =
                File("/home/thomas/dev/learning/adventOfCode2021/src/main/resources/day2/puzzleinput.txt").readLines()
            println(part1(commands))
        }

        @Test
        fun testPart2() {
            val commands =
                File("/home/thomas/dev/learning/adventOfCode2021/src/main/resources/day2/testinput.txt").readLines()
            assertEquals(900, part2(commands))
        }

        @Test
        fun outPart2() {
            val commands =
                File("/home/thomas/dev/learning/adventOfCode2021/src/main/resources/day2/puzzleinput.txt").readLines()
            println(part2(commands))
        }
    }
}
