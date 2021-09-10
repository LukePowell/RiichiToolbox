package com.dragonwellstudios.riichitoolbox.android.ui.views.tile


import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.dragonwellstudios.riichitoolbox.android.R
import com.dragonwellstudios.riichitoolbox.logic.Suit
import com.dragonwellstudios.riichitoolbox.logic.Tile

@Composable
fun TileView(tile: Tile, modifier: Modifier = Modifier, tileSelected: (Tile) -> Unit) {
    val resourceArray = when (tile.suit) {
        Suit.MANZU -> LocalContext.current.resources.obtainTypedArray(R.array.manzu)
        Suit.SOUZU -> LocalContext.current.resources.obtainTypedArray(R.array.souzu)
        Suit.PINZU -> LocalContext.current.resources.obtainTypedArray(R.array.pinzu)
        Suit.KAZEHAI -> LocalContext.current.resources.obtainTypedArray(R.array.kazehai)
        Suit.SANGENPAI -> LocalContext.current.resources.obtainTypedArray(R.array.sangenpai)
    }

    Box(modifier = modifier) {
        Image(
            painter = painterResource(id = R.drawable.front),
            contentDescription = "back of a mahjong tile"
        )
        Image(
            painter = painterResource(id = resourceArray.getResourceId(tile.index, 0)),
            contentDescription = "${tile.index} of ${tile.suit}",
            modifier = Modifier.clickable {
                tileSelected(tile)
            }
        )
    }

    resourceArray.recycle()
}

@Preview
@Composable
fun TileViewPreview() {
    TileView(tile = Tile(Suit.KAZEHAI, 3), tileSelected = {})
}