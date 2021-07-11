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

package com.dragonwellstudios.riichitoolbox.android.ui.views

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.tooling.preview.Preview
import androidx.constraintlayout.compose.ConstraintLayout
import com.dragonwellstudios.riichitoolbox.logic.Wind

@Composable
fun RecordGameView() {
    ConstraintLayout(modifier = Modifier.fillMaxSize()) {
        val (east, south, west, north, center) = createRefs()
        PlayerView(PlayerData(Wind.EAST, "East"), modifier = Modifier.constrainAs(east) {
            with(top) { linkTo(center.bottom) }
            centerHorizontallyTo(parent)
        })
        PlayerView(PlayerData(Wind.SOUTH, "South"), modifier = Modifier
            .constrainAs(south) {
                with(absoluteLeft) { linkTo(center.absoluteRight) }
                centerVerticallyTo(parent)
            }
            .rotate(270.0f))
        PlayerView(PlayerData(Wind.WEST, "West"), modifier = Modifier
            .constrainAs(west) {
                with(bottom) { linkTo(center.top) }
                centerHorizontallyTo(parent)
            }
            .rotate(180.0f))
        PlayerView(PlayerData(Wind.NORTH, "North"), modifier = Modifier
            .constrainAs(north) {
                with(absoluteRight) { linkTo(center.absoluteLeft) }
                centerVerticallyTo(parent)
            }
            .rotate(90.0f))
        RoundView(RoundData(Wind.EAST, 0, 0, 1), modifier = Modifier.constrainAs(center) {
            centerVerticallyTo(parent)
            centerHorizontallyTo(parent)
        })
    }
}

@Preview(showBackground = true)
@Composable
fun RecordGameViewPreview() {
    RecordGameView()
}