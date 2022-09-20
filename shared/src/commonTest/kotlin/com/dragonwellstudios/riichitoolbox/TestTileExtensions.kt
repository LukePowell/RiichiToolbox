package com.dragonwellstudios.riichitoolbox

import com.dragonwellstudios.riichitoolbox.logic.Suit
import com.dragonwellstudios.riichitoolbox.logic.Tile
import com.dragonwellstudios.riichitoolbox.logic.countUniquePairs
import com.dragonwellstudios.riichitoolbox.logic.isSevenPairs
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class TestTileExtensions {
    @Test
    fun testCountUniquePairs() {
        val handMixedPairs = mutableListOf(
            Tile(Suit.MANZU, 1),
            Tile(Suit.MANZU, 1),
            Tile(Suit.MANZU, 2),
            Tile(Suit.SOUZU, 1),
            Tile(Suit.SOUZU, 1),
            Tile(Suit.SOUZU, 2),
            Tile(Suit.PINZU, 1),
            Tile(Suit.PINZU, 2),
            Tile(Suit.PINZU, 3),
            Tile(Suit.SANGENPAI, 1),
            Tile(Suit.SANGENPAI, 1),
            Tile(Suit.SANGENPAI, 1),
            Tile(Suit.KAZEHAI, 1),
            Tile(Suit.KAZEHAI, 2)
        )

        assertEquals( 3, handMixedPairs.countUniquePairs())

        val handAllPairs = mutableListOf(
            Tile(Suit.MANZU, 1),
            Tile(Suit.MANZU, 1),
            Tile(Suit.MANZU, 2),
            Tile(Suit.MANZU, 2),
            Tile(Suit.SOUZU, 1),
            Tile(Suit.SOUZU, 1),
            Tile(Suit.PINZU, 3),
            Tile(Suit.PINZU, 3),
            Tile(Suit.SANGENPAI, 1),
            Tile(Suit.SANGENPAI, 1),
            Tile(Suit.SANGENPAI, 2),
            Tile(Suit.SANGENPAI, 2),
            Tile(Suit.KAZEHAI, 3),
            Tile(Suit.KAZEHAI, 3)
        )

        assertEquals(7, handAllPairs.countUniquePairs())
        assertTrue(handAllPairs.isSevenPairs())

        val handAllPairsNotUnique = mutableListOf(
            Tile(Suit.MANZU, 1),
            Tile(Suit.MANZU, 1),
            Tile(Suit.MANZU, 2),
            Tile(Suit.MANZU, 2),
            Tile(Suit.SOUZU, 1),
            Tile(Suit.SOUZU, 1),
            Tile(Suit.PINZU, 3),
            Tile(Suit.PINZU, 3),
            Tile(Suit.SANGENPAI, 1),
            Tile(Suit.SANGENPAI, 1),
            Tile(Suit.SANGENPAI, 1),
            Tile(Suit.SANGENPAI, 1),
            Tile(Suit.KAZEHAI, 3),
            Tile(Suit.KAZEHAI, 3)
        )

        assertEquals(6, handAllPairsNotUnique.countUniquePairs())
        assertFalse(handAllPairsNotUnique.isSevenPairs())
    }
}