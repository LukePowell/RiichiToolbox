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

package com.dragonwellstudios.riichitoolbox.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.dragonwellstudios.riichitoolbox.android.ui.theme.Riichi_ToolboxTheme
import com.dragonwellstudios.riichitoolbox.logic.Score
import com.dragonwellstudios.riichitoolbox.logic.ScoreCalculator

class MainActivityCompose : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            Riichi_ToolboxTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    ScoreCalculatorView()
                }
            }
        }
    }
}

class ScoreViewModel : ViewModel() {
    private val _score = MutableLiveData(ScoreCalculator.calculate(1, 30))
    val score: LiveData<Score> = _score

    private val _han = MutableLiveData(1)
    val han: LiveData<Int> = _han

    private val _fu = MutableLiveData(1)
    val fu: LiveData<Int> = _fu

    private val _kiriageMangan = MutableLiveData(false)
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
        _score.value = ScoreCalculator.calculate(
            _han.value ?: 1,
            _fu.value ?: 30,
            _kiriageMangan.value ?: false
        )
    }
}

@Composable
fun ScoreCalculatorView(scoreViewModel: ScoreViewModel = viewModel()) {
    val han: Int by scoreViewModel.han.observeAsState(1)
    val fu: Int by scoreViewModel.fu.observeAsState(1)
    val score: Score by scoreViewModel.score.observeAsState(ScoreCalculator.calculate(1, 1))

    Column {
        OutlinedTextField(
            value = "$han",
            onValueChange = {
                if (it.isEmpty()) {
                    scoreViewModel.onHanChanged(1)
                } else {
                    scoreViewModel.onHanChanged(it.toInt())
                }
            },
            label = { Text("Han") },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number
            )
        )
        OutlinedTextField(
            value = "$fu",
            onValueChange = { scoreViewModel.onFuChanged(it.toInt()) },
            label = { Text("Fu") },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number
            )
        )
        Text(text = "${score.getPayoutToDealerTsumo()}\n${score.getPayoutToDealerRon()}\n\n${score.getPayoutToNonDealerTsumo().dealer}/${score.getPayoutToNonDealerTsumo().nonDealer}\n${score.getPayoutToNonDealerRon()}")
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Riichi_ToolboxTheme {
        ScoreCalculatorView()
    }
}