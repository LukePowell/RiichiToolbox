package com.dragonwellstudios.riichitoolbox.android.ui.views.hand_finder

import androidx.compose.foundation.layout.*
import androidx.compose.material.Switch
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dragonwellstudios.riichitoolbox.logic.ScoringModifiers
import com.dragonwellstudios.riichitoolbox.logic.Wind

@Composable
fun ScoreModifiersControl(
    scoringModifiers: ScoringModifiers,
    windChanged: (WindType, Wind) -> Unit,
    scoringModifierChanged: (HandStates, Boolean) -> Unit,
    modifier: Modifier = Modifier
) {
    Column {
        Row(
            modifier = modifier
                .fillMaxWidth()
                .padding(8.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            WindSelector(
                wind = scoringModifiers.roundWind,
                windSelected = { windChanged(WindType.ROUND, it) }
            ) {
                Text("Round Wind: ")
            }

            WindSelector(
                wind = scoringModifiers.seatWind,
                windSelected = { windChanged(WindType.SEAT, it) }
            ) {
                Text("Seat Wind: ")
            }
        }

        Row(
            modifier = modifier
                .fillMaxWidth()
                .padding(8.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Text("Riichi")
            Switch(checked = scoringModifiers.riichi, onCheckedChange = {
                scoringModifierChanged(HandStates.RIICHI, it)
            })
            Text("Double Riichi")
            Switch(checked = scoringModifiers.doubleRiichi, onCheckedChange = {
                scoringModifierChanged(HandStates.DOUBLE_RIICHI, it)
            })
            Text("Ippatsu")
            Switch(checked = scoringModifiers.ippatsu, onCheckedChange = {
                scoringModifierChanged(HandStates.IPPATSU, it)
            })
        }

        Row(
            modifier = modifier
                .fillMaxWidth()
                .padding(8.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Text("Chankan")
            Switch(checked = scoringModifiers.chankan, onCheckedChange = {
                scoringModifierChanged(HandStates.CHANKAN, it)
            })
            Text("Rinshan Kaihou")
            Switch(checked = scoringModifiers.rinshanKaihou, onCheckedChange = {
                scoringModifierChanged(HandStates.RINSHAN_KAIHOU, it)
            })
            Text("Haitei or Houtei")
            Switch(checked = scoringModifiers.houteiOrHaitei, onCheckedChange = {
                scoringModifierChanged(HandStates.HOUTEI_OR_HAITEI, it)
            })
        }
    }
}

@Preview
@Composable
fun ScoreModifiersControlPreview() {
    ScoreModifiersControl(ScoringModifiers(), { _, _ -> }, { _, _ -> })
}