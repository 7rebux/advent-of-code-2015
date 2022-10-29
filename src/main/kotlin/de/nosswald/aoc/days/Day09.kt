package de.nosswald.aoc.days

import de.nosswald.aoc.Day
import de.nosswald.aoc.utils.permutations

object Day09 : Day(9, "All in a Single Night") {
    private val places = mutableListOf<String>()
    private val distances = mutableMapOf<Pair<String, String>, Int>()

    init {
        inputList.forEach { line ->
            val (from, to, distance) = line.split(" ").let { listOf(it[0], it[2], it[4]) }

            places.addAll(listOf(from, to))
            distances[Pair(from, to)] = distance.toInt()
        }
    }

    override fun partOne(): Any {
        return places.distinct().permutations()
            .minOfOrNull { it.zipWithNext().sumOf(::findDistance) } ?: 0
    }

    override fun partTwo(): Any {
        return places.distinct().permutations()
            .maxOfOrNull { it.zipWithNext().sumOf(::findDistance) } ?: 0
    }

    private fun findDistance(x: Pair<String, String>): Int {
        return distances[distances.keys.single { it in listOf(x, Pair(x.second, x.first)) }]!!
    }
}
