package com.dragonwellstudios.riichitoolbox.android.ui.views.hand_finder

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.dragonwellstudios.riichitoolbox.logic.Suit
import com.dragonwellstudios.riichitoolbox.logic.Tile

@Composable
fun HandFinderView(viewModel: HandViewModel = viewModel()) {
    val tiles = viewModel.tiles

    Column {
        HandView(
            tiles = List(9) {
                Tile(Suit.MANZU, it + 1)
            }
        ) {
            viewModel.addTileToHand(it)
        }

        HandView(
            tiles = List(9) {
                Tile(Suit.SOUZU, it + 1)
            }
        ) {
            viewModel.addTileToHand(it)
        }

        HandView(
            tiles = List(9) {
                Tile(Suit.PINZU, it + 1)
            }
        ) {
            viewModel.addTileToHand(it)
        }

        Row {
            val mutableList = mutableListOf<Tile>()
            for (value in 1..4) {
                mutableList.add(Tile(Suit.KAZEHAI, value))
            }
            for (value in 1..3) {
                mutableList.add(Tile(Suit.SANGENPAI, value))
            }

            HandView(
                tiles = mutableList,
            ) {
                viewModel.addTileToHand(it)
            }
        }

        HandView(tiles = tiles, tileSelected = viewModel::removeTile)

        HandControl()

        Button(
            onClick = { /*TODO*/ },
            modifier = Modifier.align(Alignment.CenterHorizontally)
        ) {
            Text(text = "Calculate Hand")
        }
    }
}