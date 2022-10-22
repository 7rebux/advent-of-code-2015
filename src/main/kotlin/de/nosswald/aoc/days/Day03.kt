package de.nosswald.aoc.days

import de.nosswald.aoc.Day
import de.nosswald.aoc.utils.Point

object Day03 : Day(3, "Perfectly Spherical Houses in a Vacuum") {
    private const val NORTH = '^'
    private const val EAST  = '>'
    private const val SOUTH = 'v'
    private const val WEST  = '<'

    override fun partOne(): Any {
        val positions = mutableSetOf<Point>()
        var (x, y) = Point(0, 0)

        positions.add(Point(x, y))
        inputString.toCharArray().forEach { direction ->
            when (direction) {
                EAST -> x++
                WEST -> x--
                NORTH -> y++
                SOUTH -> y--
            }

            positions.add(Point(x, y))
        }

        return positions.size
    }

    override fun partTwo(): Any {
        val positions = mutableSetOf<Point>()
        var (santaX, santaY) = Point(0, 0)
        var (robotX, robotY) = Point(0, 0)

        positions.add(Point(0, 0))
        inputString.toCharArray().forEachIndexed { i, direction ->
            val santaHasMove = i % 2 == 0

            when (direction) {
                EAST -> if (santaHasMove) santaX++ else robotX++
                WEST -> if (santaHasMove) santaX-- else robotX--
                NORTH -> if (santaHasMove) santaY++ else robotY++
                SOUTH -> if (santaHasMove) santaY-- else robotY--
            }

            positions.add(
                if (santaHasMove)
                    Point(santaX, santaY)
                else
                    Point(robotX, robotY)
            )
        }

        return positions.size
    }
}
