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

import com.dragonwellstudios.riichitoolbox.logic.gamestate.Player

data class InitialSettings(val east: Player, val south: Player, val west: Player, val north: Player?, val startingPoints: Int = 25_000, val targetPoints: Int = 30_000) {
    fun name(wind: Wind): String = when(wind) {
        Wind.EAST -> east.name
        Wind.SOUTH -> south.name
        Wind.WEST -> west.name
        Wind.NORTH -> north?.name ?: ""
    }
}

enum class RoundEnd {
    RON,
    TSUMO,
    RYUUKYOKU
}

class Game(private val initialSettings: InitialSettings) {
    val roundWind: Wind = Wind.EAST
    val round: Int = 0

    val players get() = listOfNotNull(initialSettings.east, initialSettings.west, initialSettings.south, initialSettings.north)
    val dealer get() = players[round]
}