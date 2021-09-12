package com.dragonwellstudios.riichitoolbox.android.ui.views.hand_finder

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dragonwellstudios.riichitoolbox.android.ui.views.tile.TileView
import com.dragonwellstudios.riichitoolbox.logic.Suit
import com.dragonwellstudios.riichitoolbox.logic.Tile

@Composable
fun HandView(
    modifier: Modifier = Modifier,
    tiles: List<Tile>,
    minimumTiles: Int = 0,
    tileSelected: (Tile) -> Unit
) {
    Row(modifier = modifier.fillMaxWidth()) {
        tiles.forEach {
            if(!it.blank) {
                TileView(
                    it,
                    modifier = Modifier
                        .padding(2.dp)
                        .weight(1f),
                    tileSelected = tileSelected
                )
            } else {
                Spacer(
                    modifier = Modifier
                        .padding(2.dp)
                        .weight(1f)
                )
            }
        }

        repeat(minimumTiles - tiles.size) {
            Spacer(
                modifier = Modifier
                    .padding(2.dp)
                    .weight(1f)
            )
        }
    }
}

@Preview
@Composable
fun HandViewPreview() {
    HandView(
        tiles =
        listOf(
            Tile(Suit.MANZU, 1),
            Tile(Suit.MANZU, 1),
            Tile(Suit.MANZU, 2),
            Tile(Suit.MANZU, 2),
            Tile(Suit.SOUZU, 1),
            Tile(Suit.SOUZU, 1),
            Tile(Suit.PINZU, 3),
            Tile(Suit.PINZU, 3),
            Tile(Suit.SANGENPAI, 1),
            Tile(Suit.SANGENPAI, 1),
            Tile(Suit.SANGENPAI, 2),
            Tile(Suit.SANGENPAI, 3),
            Tile(Suit.KAZEHAI, 3),
            Tile(Suit.KAZEHAI, 3)
        ),
        tileSelected = {}
    )
}

@Preview
@Composable
fun HandViewPreviewMinimum() {
    HandView(
        tiles =
        listOf(
            Tile(Suit.MANZU, 1),
        ),
        minimumTiles = 14
    ) {}
}
