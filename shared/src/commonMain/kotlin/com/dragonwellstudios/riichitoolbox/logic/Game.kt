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

class Player(val name: String, val startingWind: Wind, var points: Int)

data class GameSettings(val east: String, val south: String, val west: String, val north: String, val startingPoints: Int = 25_000, val targetPoints: Int = 30_000) {
    fun name(wind: Wind): String = when(wind) {
        Wind.EAST -> east
        Wind.SOUTH -> south
        Wind.WEST -> west
        Wind.NORTH -> north
    }
}

class Game(val startingPoints: Int = 25_000, val targetPoints: Int = 30_000) {
    val wind = Wind.EAST
    val riichi = 0
    val honba = 0
    val hand = 1

    fun ron() {

    }

    fun tsumo() {

    }

    fun ryuukyoku() {

    }
}