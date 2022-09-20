package com.dragonwellstudios.riichitoolbox.android.ui.views.hand_finder

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.dragonwellstudios.riichitoolbox.logic.ScoringModifiers
import com.dragonwellstudios.riichitoolbox.logic.Tile
import com.dragonwellstudios.riichitoolbox.logic.Wind
import com.dragonwellstudios.riichitoolbox.logic.calculateShanten

enum class HandStates {
    RIICHI,
    DOUBLE_RIICHI,
    IPPATSU,
    HOUTEI_OR_HAITEI,
    RINSHAN_KAIHOU,
    CHANKAN
}

enum class WindType {
    SEAT,
    ROUND
}

class HandViewModel : ViewModel() {
    var tiles = mutableStateListOf<Tile>()
        private set

    var shanten by mutableStateOf(14)
        private set

    var scoreModifiers by mutableStateOf(ScoringModifiers())
        private set

    fun addTileToHand(tile: Tile) {
        tiles.add(tile)
        shanten = tiles.calculateShanten()
    }

    fun removeTile(tile: Tile) {
        tiles.remove(tile)
        shanten = tiles.calculateShanten()
    }

    fun isFull(): Boolean = tiles.size == 14

    fun setScoreModifierState(state: HandStates, set: Boolean) {
        scoreModifiers = when (state) {
            HandStates.RIICHI -> scoreModifiers.copy(riichi = set, doubleRiichi = false)
            HandStates.DOUBLE_RIICHI -> scoreModifiers.copy(riichi = false, doubleRiichi = set)
            HandStates.IPPATSU -> scoreModifiers.copy(ippatsu = set)
            HandStates.HOUTEI_OR_HAITEI -> scoreModifiers.copy(houteiOrHaitei = set)
            HandStates.RINSHAN_KAIHOU -> scoreModifiers.copy(rinshanKaihou = set)
            HandStates.CHANKAN -> scoreModifiers.copy(chankan = set)
        }
    }

    fun setWind(windType: WindType, wind: Wind) {
        scoreModifiers = when(windType) {
            WindType.SEAT -> scoreModifiers.copy(seatWind = wind)
            WindType.ROUND -> scoreModifiers.copy(roundWind = wind)
        }
    }
}