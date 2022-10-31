package de.nosswald.aoc.days

import de.nosswald.aoc.Day

object Day10 : Day(10, "Elves Look, Elves Say") {
    override fun partOne() = applyLookAndSay(inputString, 40).length
    override fun partTwo() = applyLookAndSay(inputString, 50).length

    private fun applyLookAndSay(value: String, times: Int): String {
        return if (times == 0)
            value
        else
            applyLookAndSay(
                Regex("((\\d)\\2*)")
                    .findAll(value)
                    .map { it.value }
                    .joinToString(separator = "") { "${it.length}${it.first()}" }
                , times - 1
            )
    }
}
