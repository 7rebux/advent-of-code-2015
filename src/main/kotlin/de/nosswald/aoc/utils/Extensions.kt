package de.nosswald.aoc.utils

fun <T> List<T>.permutations(): List<List<T>> {
    return if (this.isEmpty())
        listOf(emptyList())
    else
        mutableListOf<List<T>>().also { out ->
            for (i in this.indices)
                (this - this[i]).permutations().forEach { out.add(it + this[i]) }
        }
}
