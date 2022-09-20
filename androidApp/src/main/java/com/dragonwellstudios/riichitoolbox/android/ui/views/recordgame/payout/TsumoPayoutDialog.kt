package com.dragonwellstudios.riichitoolbox.android.ui.views.recordgame

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.window.Dialog
import androidx.lifecycle.viewmodel.compose.viewModel
import com.dragonwellstudios.riichitoolbox.android.ui.views.hand_finder.HandFinder
import com.dragonwellstudios.riichitoolbox.android.ui.views.recordgame.payout.GameViewModel
import com.dragonwellstudios.riichitoolbox.android.ui.views.recordgame.payout.Payout
import com.dragonwellstudios.riichitoolbox.android.ui.views.recordgame.payout.previewPayout
import com.dragonwellstudios.riichitoolbox.android.ui.views.score_calculator.FuSelector
import com.dragonwellstudios.riichitoolbox.android.ui.views.score_calculator.HanSelector
import com.dragonwellstudios.riichitoolbox.android.ui.views.score_calculator.ScoreViewModel
import com.dragonwellstudios.riichitoolbox.logic.Game
import com.dragonwellstudios.riichitoolbox.logic.HandResult
import com.dragonwellstudios.riichitoolbox.logic.InitialSettings
import com.dragonwellstudios.riichitoolbox.logic.Wind
import com.dragonwellstudios.riichitoolbox.logic.gamestate.Player
import kotlin.math.absoluteValue


@Composable
fun TsumoPayoutDialog(
    game: Game,
    payout: Payout.Tsumo,
    modifier: Modifier = Modifier
) {
    var fu by remember { mutableStateOf(30)}
    var han by remember { mutableStateOf(1)}

    Column(modifier = modifier) {
        Row {
            HanSelector(han, onHanChanged = {
                han = it
            })
            FuSelector(fu, han, onFuChanged = {
                fu = it
            })
        }
        Row {
            Text("Winner", Modifier.align(Alignment.CenterVertically))
            PlayerDropdown(players = game.players)
        }
        Column {
            val result = HandResult(han, fu, false)
            val changePreview = game.previewPayout(payout, result)
            changePreview.forEach {
                Text("${it.first.name} ${if (it.second > 0) "+" else ""}${it.second}")
            }
        }
    }
}


@Preview
@Composable
fun TsumoPayoutDialogPreview() {
    val game = Game(
        InitialSettings(
            east = Player("East", Wind.EAST, 25_000),
            south = Player("East", Wind.EAST, 25_000),
            west = Player("East", Wind.EAST, 25_000),
            north = Player("East", Wind.EAST, 25_000)
        )
    )
    TsumoPayoutDialog(
        game,
        Payout.Tsumo(game.players[0])
    )
}