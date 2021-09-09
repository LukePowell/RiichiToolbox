package com.dragonwellstudios.riichitoolbox.android.ui.views.hand_finder

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dragonwellstudios.riichitoolbox.android.ui.views.tile.TileView
import com.dragonwellstudios.riichitoolbox.logic.Suit
import com.dragonwellstudios.riichitoolbox.logic.Tile

@Composable
fun HandView(tiles: List<Tile>) {
    Row(modifier = Modifier.fillMaxWidth()){
        tiles.forEach {
            val modifier = Modifier
                .padding(2.dp)
                .fillMaxWidth()
                .weight(1f)
            TileView(it, modifier = modifier)
        }
    }
}

@Preview
@Composable
fun HandViewPreview() {
    HandView(
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
        )
    )
}
