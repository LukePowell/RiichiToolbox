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
package com.dragonwellstudios.riichitoolbox.logic

import kotlin.math.ceil
import kotlin.math.min
import kotlin.math.pow

class Score(private val basePoints: Int) {
    data class Payout(val dealer: Int, val nonDealer: Int)

    /**
     * Payout to non-dealer by tsumo is 2 * base points from the dealer, base points
     * from other players
     */
    fun getPayoutToNonDealerTsumo() =
        Payout(roundToNearest100(2 * basePoints), roundToNearest100(basePoints))

    /**
     * \brief Payout to non-dealer ron is 4 * base points
     */
    fun getPayoutToNonDealerRon() = roundToNearest100(4 * basePoints)

    /**
     *  Payment to dealer by tsumo is 2 * base points from other players
     */
    fun getPayoutToDealerTsumo() = roundToNearest100(2 * basePoints)

    /**
     * \brief Payout to dealer by ron is 6 * base points
     */
    fun getPayoutToDealerRon() = roundToNearest100(6 * basePoints)

    /**
     * Points are rounded up to the nearest 100
     * @param value value to round to nearest 100
     */
    private fun roundToNearest100(value: Int) = ceil(value.toDouble() / 100.0f).toInt() * 100
}

class ScoreCalculator {
    companion object {
        private const val MANGAN_BASE_POINTS = 2000
        private const val HANEMAN_BASE_POINTS = 3000
        private const val BAIMAN_BASE_POINTS = 4000
        private const val SANBAIMAN_BASE_POINTS = 6000
        private const val YAKUMAN_BASE_POINTS = 8000

        fun calculate(han: Int, fu: Int, kiriageMangan: Boolean = false): Score {
            //Round up for any fu besides chiitoitsu
            var croppedFu = fu
            if (fu != 25) {
                croppedFu = ceil(fu.toFloat() / 10.0f).toInt() * 10
            }

            var basePoints: Int
            when (han) {
                1, 2, 3, 4 -> {
                    //Standard equation to calculate base points
                    basePoints = croppedFu * 2.0.pow((2 + han).toDouble()).toInt()
                    basePoints = min(basePoints, MANGAN_BASE_POINTS)
                }
                5 -> basePoints = MANGAN_BASE_POINTS
                6, 7 -> basePoints = HANEMAN_BASE_POINTS
                8, 9, 10 -> basePoints = BAIMAN_BASE_POINTS
                11, 12 -> basePoints = SANBAIMAN_BASE_POINTS
                else -> basePoints = YAKUMAN_BASE_POINTS
            }

            if (kiriageMangan && basePoints == 1920)
                basePoints = 2000

            return Score(basePoints)
        }
    }
}
