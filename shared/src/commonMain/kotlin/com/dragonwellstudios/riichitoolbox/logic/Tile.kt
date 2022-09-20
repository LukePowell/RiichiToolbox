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

enum class Wind(val kanji: String) {
    EAST("東"),
    SOUTH("南"),
    WEST("西"),
    NORTH("北")
}

enum class Suit(val count: Int) {
    MANZU(9),
    SOUZU(9),
    PINZU(9),
    KAZEHAI(4),
    SANGENPAI(3)
}

data class Tile(val suit: Suit, val value: Int) : Comparable<Tile> {
    override fun compareTo(other: Tile): Int {
        if (suit != other.suit) {
            return suit.compareTo(other.suit)
        }

        return value.compareTo(other.value)
    }

    val index get() = this.value - 1
    val blank get() = this.value == -1
}