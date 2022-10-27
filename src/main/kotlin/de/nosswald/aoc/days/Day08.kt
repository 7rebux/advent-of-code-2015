package de.nosswald.aoc.days

import de.nosswald.aoc.Day

object Day08 : Day(8, "Matchsticks") {
    override fun partOne(): Any {
        return inputList.map { line ->
            Pair(
                line.substring(1, line.length - 1)
                    .replace("\\\\", ".")
                    .replace("\\\"", ".")
                    .replace(Regex("\\\\x[0-9a-f]{2}"), ".")
                    .length,
                line.length
            )
        }.sumOf { it.second - it.first }
    }

    override fun partTwo(): Any {
        return inputList.map { line ->
            Pair(
                "\"${
                    line.replace("\\", "\\\\")
                        .replace("\"", "\\\"")
                }\""
                    .length,
                line.length
            )
        }.sumOf { it.first - it.second }
    }
}
