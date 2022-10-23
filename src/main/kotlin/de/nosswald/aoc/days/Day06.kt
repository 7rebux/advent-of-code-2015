package de.nosswald.aoc.days

import de.nosswald.aoc.Day
import de.nosswald.aoc.utils.Point

object Day06 : Day(6, "Probably a Fire Hazard") {
    private const val TOGGLE  = "toggle"
    private const val ON      = "turn on"
    private const val OFF     = "turn off"

    override fun partOne(): Any {
        val grid = Array(1000) { Array(1000) { -1 } }

        inputList.forEach { instruction ->
            val type = instruction.getType()
            val (start: Point, end) = instruction
                .split(type)[1]
                .trim()
                .split(" through ")
                .map { pair ->
                    pair.split(",")
                        .map(String::toInt)
                }
                .map { Point(it[0], it[1]) }

            (start.x..end.x).forEach { x ->
                (start.y..end.y).forEach { y ->
                    when (type) {
                        TOGGLE -> grid[x][y] *= -1
                        ON -> grid[x][y] = 1
                        OFF -> grid[x][y] = -1
                    }
                }
            }
        }

        return grid.flatten().count { it == 1 }
    }

    override fun partTwo(): Any {
        val grid = Array(1000) { Array(1000) { 0 } }

        inputList.forEach { instruction ->
            val type = instruction.getType()
            val (start: Point, end) = instruction
                .split(type)[1]
                .trim()
                .split(" through ")
                .map { pair ->
                    pair.split(",")
                        .map(String::toInt)
                }
                .map { Point(it[0], it[1]) }

            (start.x..end.x).forEach { x ->
                (start.y..end.y).forEach { y ->
                    when (type) {
                        TOGGLE -> grid[x][y] += 2
                        ON -> grid[x][y] += 1
                        OFF -> if (grid[x][y] > 0) grid[x][y] -= 1
                    }
                }
            }
        }

        return grid.flatten().sum()
    }

    private fun String.getType(): String {
        when {
            this.startsWith(TOGGLE) -> return TOGGLE
            this.startsWith(ON) -> return ON
            this.startsWith(OFF) -> return OFF
        }
        error("Type for instruction $this is invalid!")
    }
}
