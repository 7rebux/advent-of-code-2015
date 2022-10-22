package de.nosswald.aoc.days

import de.nosswald.aoc.Day

object Day01 : Day(1, "Not Quite Lisp") {
    private const val FLOOR_UP      = '('
    private const val FLOOR_DOWN    = ')'

    override fun partOne(): Any {
        return inputString.count { it == FLOOR_UP } - inputString.count { it == FLOOR_DOWN }
    }

    override fun partTwo(): Any {
        var floor = 0

        inputString.toCharArray().forEachIndexed { i, c ->
            if (c == FLOOR_UP) floor++
            if (c == FLOOR_DOWN) floor--

            if (floor < 0) return i + 1
        }
        return 0
    }
}
