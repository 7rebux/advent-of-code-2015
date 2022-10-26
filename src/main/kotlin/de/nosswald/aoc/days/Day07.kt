package de.nosswald.aoc.days

import de.nosswald.aoc.Day

object Day07 : Day(7, "Some Assembly Required") {
    private val circuit = mutableMapOf<String, List<String>>()
    private val output = mutableMapOf<String, Int>()

    override fun partOne(): Any {
        init()

        return getSignal("a").also { output.clear() }
    }

    override fun partTwo(): Any {
        val a = partOne()

        init()
        circuit["b"] = listOf("$a")

        return getSignal("a")
    }

    private fun init() {
        inputList.forEach { line ->
            val (inst, out) = line.split(" -> ")
            circuit[out] = inst.split(" ")
        }
    }

    private fun getSignal(wire: String): Int {
        wire.toIntOrNull()?.let { return it }

        if (!output.containsKey(wire)) {
            val instruction = circuit[wire]!!
            var value = 0

            when (instruction.size) {
                1 -> value = getSignal(instruction[0])
                2 -> value = getSignal(instruction[1]).inv() and 0xffff
                else -> {
                    when (instruction[1]) {
                        "AND" -> value = getSignal(instruction[0]) and getSignal(instruction[2])
                        "OR" -> value = getSignal(instruction[0]) or getSignal(instruction[2])
                        "LSHIFT" -> value = getSignal(instruction[0]) shl instruction[2].toInt()
                        "RSHIFT" -> value = getSignal(instruction[0]) shr instruction[2].toInt()
                    }
                }
            }

            output[wire] = value
        }

        return output[wire]!!
    }
}
