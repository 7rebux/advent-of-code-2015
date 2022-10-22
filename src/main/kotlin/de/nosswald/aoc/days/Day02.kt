package de.nosswald.aoc.days

import de.nosswald.aoc.Day

object Day02 : Day(2, "I Was Told There Would Be No Math") {
    override fun partOne(): Any {
        var totalPaper = 0

        inputList.forEach { dimension ->
            val (length, width, height) = parseDimension(dimension)
            val faces = listOf(
                length * width,
                length * height,
                width * height
            )

            totalPaper += faces.sumOf { it * 2 } + faces.min()
        }

        return totalPaper
    }

    override fun partTwo(): Any {
        var totalRibbon = 0

        inputList.forEach { dimension ->
            val sides = parseDimension(dimension).sorted()
            val ribbon = 2 * sides[0] + 2 * sides[1]
            val bowRibbon = sides.reduce(Int::times)

            totalRibbon += bowRibbon + ribbon
        }

        return totalRibbon
    }

    private fun parseDimension(dimension: String) = dimension.split("x").map { it.toInt() }
}
