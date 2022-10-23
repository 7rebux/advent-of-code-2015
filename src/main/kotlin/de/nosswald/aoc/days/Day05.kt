package de.nosswald.aoc.days

import de.nosswald.aoc.Day

object Day05 : Day(5, "Doesn't He Have Intern-Elves For This?") {
    private val VOWELS = arrayOf('a', 'e', 'i', 'o', 'u')
    private val FORBIDDEN = arrayOf("ab", "cd", "pq", "xy")

    override fun partOne(): Any {
        return inputList.count { input ->
            val vowels = input.toCharArray().count { it in VOWELS }
            val repeating = input.asSequence().zipWithNext().count { it.first == it.second }
            val forbidden = FORBIDDEN.any { input.contains(it) }

            vowels >= 3 && repeating > 0 && !forbidden
        }
    }

    override fun partTwo(): Any {
        return inputList.count { input ->
            val repeatingPairs = input.contains(Regex("([a-z][a-z]).*\\1"))
            val repeatingLetters = input.contains(Regex("([a-z])[a-z]\\1"))

            repeatingPairs && repeatingLetters
        }
    }
}
