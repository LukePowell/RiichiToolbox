/*
 * Riichi Toolbox
 * Copyright (C) 2021 Dragon Well Studios
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.dragonwellstudios.riichitoolbox

import com.dragonwellstudios.riichitoolbox.logic.HandResult
import kotlin.test.Test
import kotlin.test.assertEquals

class TestHandResultCalculator {
    @Test
    fun doesNotRoundUp() {
        val score = HandResult(4, 25)
        assertEquals(9600, score.getPayoutToDealerRon())
        assertEquals(3200, score.getPayoutToDealerTsumo())
        assertEquals(6400, score.getPayoutToNonDealerRon())
        assertEquals(3200, score.getPayoutToNonDealerTsumo().dealer)
        assertEquals(1600, score.getPayoutToNonDealerTsumo().nonDealer)
    }

    @Test
    fun doesRoundUp() {
        val score = HandResult(4, 27)
        assertEquals(11600, score.getPayoutToDealerRon())
        assertEquals(3900, score.getPayoutToDealerTsumo())
        assertEquals(7700, score.getPayoutToNonDealerRon())
        assertEquals(3900, score.getPayoutToNonDealerTsumo().dealer)
        assertEquals(2000, score.getPayoutToNonDealerTsumo().nonDealer)
    }

    @Test
    fun kiriageMangan() {
        val _4han30fu = HandResult(4, 30, true)
        val _3han60fu = HandResult(3, 60, true)

        assertEquals(12000, _4han30fu.getPayoutToDealerRon())
        assertEquals(12000, _3han60fu.getPayoutToDealerRon())
    }

    @Test
    fun mangan() {
        val score = HandResult(5, 0)

        assertEquals(12000, score.getPayoutToDealerRon())
        assertEquals(4000, score.getPayoutToDealerTsumo())
        assertEquals(8000, score.getPayoutToNonDealerRon())
        assertEquals(4000, score.getPayoutToNonDealerTsumo().dealer)
        assertEquals(2000, score.getPayoutToNonDealerTsumo().nonDealer)
    }

    @Test
    fun haneman() {
        for (han in 6..7) {
            val score = HandResult(han, 0)

            assertEquals(18000, score.getPayoutToDealerRon())
            assertEquals(6000, score.getPayoutToDealerTsumo())
            assertEquals(12000, score.getPayoutToNonDealerRon())
            assertEquals(6000, score.getPayoutToNonDealerTsumo().dealer)
            assertEquals(3000, score.getPayoutToNonDealerTsumo().nonDealer)
        }
    }

    @Test
    fun baimain() {
        for (han in 8..10) {
            val score = HandResult(han, 0)

            assertEquals(24000, score.getPayoutToDealerRon())
            assertEquals(8000, score.getPayoutToDealerTsumo())
            assertEquals(16000, score.getPayoutToNonDealerRon())
            assertEquals(8000, score.getPayoutToNonDealerTsumo().dealer)
            assertEquals(4000, score.getPayoutToNonDealerTsumo().nonDealer)
        }
    }

    @Test
    fun sanbaiman() {
        for (han in 11..12) {
            val score = HandResult(han, 0)

            assertEquals(36000, score.getPayoutToDealerRon())
            assertEquals(12000, score.getPayoutToDealerTsumo())
            assertEquals(24000, score.getPayoutToNonDealerRon())
            assertEquals(12000, score.getPayoutToNonDealerTsumo().dealer)
            assertEquals(6000, score.getPayoutToNonDealerTsumo().nonDealer)
        }
    }

    @Test
    fun yakuman() {
        val score = HandResult(13, 0)

        assertEquals(48000, score.getPayoutToDealerRon())
        assertEquals(16000, score.getPayoutToDealerTsumo())
        assertEquals(32000, score.getPayoutToNonDealerRon())
        assertEquals(16000, score.getPayoutToNonDealerTsumo().dealer)
        assertEquals(8000, score.getPayoutToNonDealerTsumo().nonDealer)
    }
}