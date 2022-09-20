package com.dragonwellstudios.riichitoolbox.android.ui.views.recordgame.payout

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.dragonwellstudios.riichitoolbox.logic.Game
import com.dragonwellstudios.riichitoolbox.logic.HandResult
import com.dragonwellstudios.riichitoolbox.logic.gamestate.Player

sealed class Payout {
    class ExhaustiveDraw(val tenpai: List<Player>) : Payout()
    class Tsumo(val winner: Player) : Payout()
    class Ron(val payee: Player, val payer: Player) : Payout()
}

fun Game.previewPayout(payout: Payout, handResult: HandResult): List<Pair<Player, Int>> {
    val output = mutableListOf<Pair<Player, Int>>()

    when (payout) {
        is Payout.ExhaustiveDraw -> return output
        is Payout.Ron -> return output
        is Payout.Tsumo -> {
            if (dealer == payout.winner) {
                val loss = handResult.getPayoutToDealerTsumo()
                val gain = 3 * loss
                players.forEach {
                    output.add(if (it == payout.winner) Pair(it, gain) else Pair(it, -loss))
                }
            } else {
                val gain =
                    2 * handResult.getPayoutToNonDealerTsumo().nonDealer + handResult.getPayoutToNonDealerTsumo().dealer
                players.forEach {
                    if (it == payout.winner) {
                        output.add(Pair(it, gain))
                    } else {
                        output.add(
                            Pair(
                                it,
                                if (it == dealer) handResult.getPayoutToNonDealerTsumo().dealer else handResult.getPayoutToNonDealerTsumo().nonDealer
                            )
                        )
                    }
                }
            }
        }
    }

    return output
}