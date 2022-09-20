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

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dragonwellstudios.riichitoolbox.android.ui.views.data.WindDisplay
import com.dragonwellstudios.riichitoolbox.logic.Wind

data class RoundData(val wind: Wind, val honba: Int, val riichi: Int, val round: Int)

@Composable
fun RoundView(roundData: RoundData, modifier: Modifier = Modifier) {
    Column(modifier = modifier, horizontalAlignment = Alignment.CenterHorizontally) {
        Row {
            Text(
                stringResource(id = WindDisplay.Kanji.getStringRes(roundData.wind)),
                style = MaterialTheme.typography.h2
            )
            Spacer(modifier = Modifier.padding(4.dp))
            Text(roundData.round.toString(), style = MaterialTheme.typography.h2)
        }
        Row {
            Text("H: ${roundData.honba}")
            Spacer(modifier = Modifier.padding(4.dp))
            Text("R: ${roundData.riichi}")
        }
    }
}


@Preview(showBackground = true)
@Composable
fun RoundViewPreview() {
    RoundView(RoundData(Wind.EAST, 0, 0, 1))
}