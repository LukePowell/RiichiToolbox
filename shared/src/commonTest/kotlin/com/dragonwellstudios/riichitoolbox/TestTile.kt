package com.dragonwellstudios.riichitoolbox

import com.dragonwellstudios.riichitoolbox.logic.Suit
import com.dragonwellstudios.riichitoolbox.logic.Tile
import kotlin.test.Test
import kotlin.test.assertEquals

class TestTile {
    @Test
    fun tileOrderDifferentSuits() {
        val manzu = Tile(Suit.MANZU, 1)
        val souzu = Tile(Suit.SOUZU, 1)

        assertEquals(true, manzu < souzu)
    }

    @Test
    fun tileOrderInSameSuit() {
        val manzuLow = Tile(Suit.MANZU, 1)
        val manzuHigh = Tile(Suit.SOUZU, 9)

        assertEquals(true, manzuLow < manzuHigh)
    }
}