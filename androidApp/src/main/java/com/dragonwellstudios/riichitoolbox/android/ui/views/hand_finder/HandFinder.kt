package com.dragonwellstudios.riichitoolbox.android.ui.views.hand_finder

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.dragonwellstudios.riichitoolbox.android.R
import com.dragonwellstudios.riichitoolbox.logic.Suit
import com.dragonwellstudios.riichitoolbox.logic.Tile

@Composable
fun HandFinder(viewModel: HandViewModel = viewModel()) {
    val tiles = viewModel.tiles

    Column(modifier = Modifier.fillMaxSize()) {
        HandView(tiles = tiles, tileSelected = viewModel::removeTile, minimumTiles = 14)

        Divider()

        listOf(Suit.MANZU, Suit.SOUZU, Suit.PINZU).forEach { suit ->
            HandView(
                tiles = List(suit.count) {
                    Tile(suit, it + 1)
                },
                tileSelected = viewModel::addTileToHand
            )
        }

        val mutableList = mutableListOf<Tile>().apply {
            // blank tiles before and after to have 9 tiles in the view
            add(Tile(Suit.MANZU, -1))

            repeat(Suit.KAZEHAI.count) {
                add(Tile(Suit.KAZEHAI, it + 1))

            }

            repeat(Suit.SANGENPAI.count) {
                add(Tile(Suit.SANGENPAI, it + 1))
            }

            add(Tile(Suit.MANZU, -1))
        }

        HandView(tiles = mutableList, tileSelected = viewModel::addTileToHand)

        HandControl()

        Divider()

        ScoreModifiersControl(
            viewModel.scoreModifiers,
            viewModel::setWind,
            viewModel::setScoreModifierState
        )

        Divider()

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp), horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Button(
                onClick = { /*TODO*/ },
            ) {
                Text(text = "Calculate Hand")
            }
            Button(
                onClick = { /*TODO*/ },
            ) {
                Text(text = "Calculate Waits")
            }
        }
    }
}