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

package com.dragonwellstudios.riichitoolbox.android.ui.views.recordgame

import androidx.compose.foundation.layout.*
import androidx.compose.material.Checkbox
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Switch
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dragonwellstudios.riichitoolbox.android.ui.views.data.WindDisplay
import com.dragonwellstudios.riichitoolbox.logic.Wind
import java.text.NumberFormat

data class PlayerData(
    val wind: Wind,
    val playerName: String,
    val localized: Boolean = false,
    val points: Int = 25000
)

@Composable
fun PlayerView(playerData: PlayerData, modifier: Modifier = Modifier) {
    val windDisplay = if (playerData.localized) WindDisplay.Localized else WindDisplay.Kanji

    Column(modifier = modifier) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(
                stringResource(id = windDisplay.getStringRes(playerData.wind)),
                modifier = Modifier.padding(8.dp),
                style = MaterialTheme.typography.h6
            )

            Column {
                Text(text = playerData.playerName)
                Text(text = NumberFormat.getInstance().format(playerData.points))
            }
        }

        Row(horizontalArrangement = Arrangement.SpaceBetween){
            Text("Riichi");
            Switch(checked = false, onCheckedChange = {})
        }
    }

}

@Preview(showBackground = true)
@Composable
fun PlayerViewPreview() {
    PlayerView(PlayerData(Wind.EAST, "East"))
}