package com.dragonwellstudios.riichitoolbox.android.ui.views.hand_finder

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.dragonwellstudios.riichitoolbox.logic.HandResult
import com.dragonwellstudios.riichitoolbox.logic.Tile

class HandViewModel : ViewModel() {
    var tiles = mutableStateListOf<Tile>()
        private set

    fun addTileToHand(tile: Tile) {
        tiles.add(tile)
    }

    fun removeTile(tile : Tile) {
        tiles.remove(tile)
    }

    fun isFull() : Boolean = tiles.size == 14
}