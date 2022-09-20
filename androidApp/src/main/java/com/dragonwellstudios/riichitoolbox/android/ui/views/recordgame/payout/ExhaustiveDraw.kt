package com.dragonwellstudios.riichitoolbox.android.ui.views.recordgame.payout

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material.Switch
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.dragonwellstudios.riichitoolbox.logic.Game
import com.dragonwellstudios.riichitoolbox.logic.InitialSettings
import com.dragonwellstudios.riichitoolbox.logic.Wind
import com.dragonwellstudios.riichitoolbox.logic.gamestate.Player

@Composable
fun ExhaustiveDraw(game: Game) {
//    Dialog(onDismissRequest = { /*TODO*/ }) {
        Column {
            game.players.forEach {
                Row {
                    Text(text = it.name)
                    Text(text = "Tenpai");
                    Switch(checked = false, onCheckedChange = {})
                }
            }


        }
//    }
}

@Preview(showBackground = true)
@Composable
fun ExhaustiveDrawPreview() {
    ExhaustiveDraw(
        Game(
            InitialSettings(
                east = Player("East", Wind.EAST, 25_000),
                south = Player("East", Wind.EAST, 25_000),
                west = Player("East", Wind.EAST, 25_000),
                north = Player("East", Wind.EAST, 25_000)
            )
        )
    );
}
