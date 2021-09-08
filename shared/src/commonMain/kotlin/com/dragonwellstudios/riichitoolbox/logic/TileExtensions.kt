package com.dragonwellstudios.riichitoolbox.logic

fun MutableList<Tile>.countUniquePairs(): Int {
    val map: Map<Suit, Array<Int>> = mapOf(
        Suit.MANZU to Array(9) { 0 },
        Suit.SOUZU to Array(9) { 0 },
        Suit.PINZU to Array(9) { 0 },
        Suit.KAZEHAI to Array(4) { 0 },
        Suit.SAGENPAI to Array(4) { 0 }
    )

    for (tile in this) {
        map[tile.suit]!![tile.index]++
    }

    var unique = 0

    for (entry in map) {
        unique += entry.value.count {
            it >= 2
        }
    }

    return unique
}

fun MutableList<Tile>.isSevenPairs() : Boolean = this.countUniquePairs() == 7