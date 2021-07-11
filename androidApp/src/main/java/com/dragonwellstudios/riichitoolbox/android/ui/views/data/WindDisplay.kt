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

package com.dragonwellstudios.riichitoolbox.android.ui.views.data

import androidx.annotation.StringRes
import com.dragonwellstudios.riichitoolbox.android.R
import com.dragonwellstudios.riichitoolbox.logic.Wind

sealed class WindDisplay(
    @StringRes val east: Int,
    @StringRes val south: Int,
    @StringRes val west: Int,
    @StringRes val north: Int
) {
    object Kanji : WindDisplay(
        R.string.kanji_east,
        R.string.kanji_south,
        R.string.kanji_west,
        R.string.kanji_north
    )

    object Localized : WindDisplay(
        R.string.localized_east,
        R.string.localized_south,
        R.string.localized_west,
        R.string.localized_north
    )

    /**
     * Maps a wind direction @see Wind to the corresponding string resource
     * @param wind Wind direction to get string resource for
     * @return String resource for the given wind
     */
    @StringRes
    fun getStringRes(wind: Wind): Int {
        return when (wind) {
            Wind.EAST -> east
            Wind.SOUTH -> south
            Wind.WEST -> west
            Wind.NORTH -> north
        }
    }
}