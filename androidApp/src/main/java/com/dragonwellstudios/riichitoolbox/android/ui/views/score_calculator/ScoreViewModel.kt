/*
 * Riichi Toolbox
 * Copyright (C) 2021 Dragon Well Studios
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.dragonwellstudios.riichitoolbox.android.ui.views.score_calculator

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.dragonwellstudios.riichitoolbox.logic.HandResult

class ScoreViewModel : ViewModel() {
    private val _score = MutableLiveData(HandResult(1, 20))
    val handResult: LiveData<HandResult> = _score

    private val _han = MutableLiveData(1)
    val han: LiveData<Int> = _han

    private val _fu = MutableLiveData(20)
    val fu: LiveData<Int> = _fu

    private val _kiriageMangan = MutableLiveData(true)
    val kiriageMangan: LiveData<Boolean> = _kiriageMangan

    private val _dealer = MutableLiveData(false)
    val dealer: LiveData<Boolean> = _dealer

    fun onFuChanged(newFu: Int) {
        _fu.value = newFu
        recalculateScore()
    }

    fun onHanChanged(newHan: Int) {
        _han.value = newHan
        recalculateScore()
    }

    fun onKiriageManganChanged(newKiriageMangan: Boolean) {
        _kiriageMangan.value = newKiriageMangan
        recalculateScore()
    }

    fun onDealerChanged(newDealer: Boolean) {
        _dealer.value = newDealer
        recalculateScore()
    }

    private fun recalculateScore() {
        _score.value = HandResult(
            _han.value ?: 1,
            _fu.value ?: 30,
            _kiriageMangan.value!!
        )
    }
}
