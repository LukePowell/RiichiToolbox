package com.dragonwellstudios.riichitoolbox.android.ui.views.recordgame.payout

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.dragonwellstudios.riichitoolbox.logic.Game

class GameViewModel : ViewModel() {
    private val _game = MutableLiveData<Game>()
    val game: LiveData<Game> = _game

    fun applyPayout(payout: Payout) {

    }
}