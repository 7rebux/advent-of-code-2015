package de.nosswald.aoc.days

import de.nosswald.aoc.Day
import java.security.MessageDigest

object Day04 : Day(4, "The Ideal Stocking Stuffer") {
    override fun partOne(): Any {
        return findLowestNumberToMatch("0".repeat(5))
    }

    override fun partTwo(): Any {
        return findLowestNumberToMatch("0".repeat(6))
    }

    private fun findLowestNumberToMatch(startsWith: String): Int {
        (1..Integer.MAX_VALUE).forEach { number ->
            val message = inputString + number
            val hash = toMd5(message).toHex()

            if (hash.startsWith(startsWith))
                return number
        }

        return -1
    }

    private fun toMd5(string: String) = MessageDigest.getInstance("MD5").digest(string.toByteArray())
    private fun ByteArray.toHex() = joinToString(separator = "") { byte -> "%02x".format(byte) }
}
