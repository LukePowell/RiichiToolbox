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

package com.dragonwellstudios.riichitoolbox.android.ui.views

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Switch
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.dragonwellstudios.riichitoolbox.android.ui.theme.Riichi_ToolboxTheme
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

@Composable
fun ScoreCalculatorView(scoreViewModel: ScoreViewModel = viewModel()) {
    val han: Int by scoreViewModel.han.observeAsState(1)
    val fu: Int by scoreViewModel.fu.observeAsState(20)
    val handResult: HandResult by scoreViewModel.handResult.observeAsState(HandResult(0, 0))
    val dealer: Boolean by scoreViewModel.dealer.observeAsState(false)
    val kiriageMangan: Boolean by scoreViewModel.kiriageMangan.observeAsState(true)

    var hanText by remember {
        mutableStateOf("$han")
    }
    var fuText by remember {
        mutableStateOf("$fu")
    }

    Column {
        OutlinedTextField(
            value = hanText,
            onValueChange = {
                hanText = it
                if (hanText.isNotEmpty()) {
                    scoreViewModel.onHanChanged(hanText.toInt())
                }
            },
            label = { Text("Han") },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number
            ),
            singleLine = true
        )
        OutlinedTextField(
            value = fuText,
            onValueChange = {
                fuText = it
                if (fuText.isNotEmpty()) {
                    scoreViewModel.onFuChanged(fuText.toInt())
                }
            },
            label = { Text("Fu") },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number
            ),
            singleLine = true
        )
        Row {
            Text(text = "Kiriage Mangan")
            Switch(
                checked = kiriageMangan,
                onCheckedChange = { scoreViewModel.onKiriageManganChanged(it) }
            )
        }
        Row {
            Text(text = "Dealer")
            Switch(
                checked = dealer,
                onCheckedChange = { scoreViewModel.onDealerChanged(it) }
            )
        }
        if (dealer) {
            Text("${handResult.getPayoutToDealerTsumo()}")
            Text("${handResult.getPayoutToDealerRon()}")
        } else {
            val payout = handResult.getPayoutToNonDealerTsumo()
            Text("${payout.nonDealer}/${payout.dealer}")
            Text("${handResult.getPayoutToNonDealerRon()}")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Riichi_ToolboxTheme {
        ScoreCalculatorView()
    }
}