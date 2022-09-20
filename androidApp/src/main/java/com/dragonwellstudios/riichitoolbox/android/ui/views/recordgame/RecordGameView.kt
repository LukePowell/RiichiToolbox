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

import android.graphics.Color
import android.graphics.Color.BLACK
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.AlertDialog
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.constraintlayout.compose.ConstraintLayout
import com.dragonwellstudios.riichitoolbox.android.ui.views.RoundData
import com.dragonwellstudios.riichitoolbox.android.ui.views.RoundView
import com.dragonwellstudios.riichitoolbox.logic.Wind
import androidx.annotation.StringRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.dragonwellstudios.riichitoolbox.android.R
import com.dragonwellstudios.riichitoolbox.android.ui.views.data.PreviewGame
import com.dragonwellstudios.riichitoolbox.android.ui.views.recordgame.payout.GameViewModel
import com.dragonwellstudios.riichitoolbox.android.ui.views.recordgame.payout.Payout
import com.dragonwellstudios.riichitoolbox.logic.Game

@Composable
fun RecordGameView(gameViewModel: GameViewModel = viewModel()) {
    val game by gameViewModel.game.observeAsState(Game(initialSettings = PreviewGame.Saki.settings))
    var tsumoDialog by remember { mutableStateOf(false) }
    var ronDialog by remember { mutableStateOf(false) }
    var exhaustiveDrawDialog by remember { mutableStateOf(false) }

    ConstraintLayout(modifier = Modifier.fillMaxSize()) {
        val (east, south, west, north, center, controls) = createRefs()
        PlayerView(
            PlayerData(Wind.EAST, game.players[0].name),
            modifier = Modifier
                .constrainAs(east) {
                    with(top) { linkTo(center.bottom) }
                    centerHorizontallyTo(parent)
                }
        )
        PlayerView(
            PlayerData(Wind.SOUTH,  game.players[1].name),
            modifier = Modifier
                    .constrainAs(south) {
                        with(absoluteLeft) { linkTo(center.absoluteRight) }
                        centerVerticallyTo(parent)
                    }
                    .rotate(270.0f)
        )
        PlayerView(
            PlayerData(Wind.WEST,  game.players[2].name),
            modifier = Modifier
                    .constrainAs(west) {
                        with(bottom) { linkTo(center.top) }
                        centerHorizontallyTo(parent)
                    }
                    .rotate(180.0f)
        )
        PlayerView(
            PlayerData(Wind.NORTH,  game.players[3].name),
            modifier = Modifier
                    .constrainAs(north) {
                        with(absoluteRight) { linkTo(center.absoluteLeft) }
                        centerVerticallyTo(parent)
                    }
                    .rotate(90.0f)
        )
        RoundView(
            RoundData(Wind.EAST, 0, 0, 1),
            modifier = Modifier.constrainAs(center) {
                centerVerticallyTo(parent)
                centerHorizontallyTo(parent)
            }
        )

        Row(
            modifier = Modifier
                    .constrainAs(controls) {
                        with(bottom) { linkTo(parent.bottom) }
                        with(start) { linkTo(parent.start) }
                        with(end) { linkTo(parent.end) }
                    }
                    .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Button(onClick = { ronDialog = true }) {
                Text("Ron");
            }
            Button(onClick = { tsumoDialog = true }) {
                Text(stringResource(id = R.string.tsumo))
            }
            Button(onClick = { exhaustiveDrawDialog = true}) {
                Text("Exhaustive");
            }

            if (tsumoDialog) {
                AlertDialog(
                    onDismissRequest = {
                        tsumoDialog = false
                    },
                    title = {
                        Text(text = stringResource(id = R.string.tsumo))
                    },
                    text = {
                        TsumoPayoutDialog(game = game, Payout.Tsumo(game.players[0]))
                    },
                    confirmButton = {
                        Button(

                            onClick = {
                                tsumoDialog = false
                            }) {
                            Text(stringResource(id = R.string.apply))
                        }
                    },
                    dismissButton = {
                        Button(
                            onClick = {
                                tsumoDialog = false
                            }) {
                            Text(stringResource(id = R.string.cancel))
                        }
                    }
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun RecordGameViewPreview() {
    RecordGameView()
}