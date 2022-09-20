package com.dragonwellstudios.riichitoolbox.android.ui.views.score_calculator

import androidx.compose.foundation.layout.Row
import androidx.compose.material.DropdownMenu
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun HanSelector(han: Int, onHanChanged: (Int) -> Unit, modifier: Modifier = Modifier) {
    var expanded by remember { mutableStateOf(false) }

    Row(modifier = modifier){
        Text("Han", Modifier.align(Alignment.CenterVertically))
        TextButton(onClick = { expanded = true }) {
            Text(text = "$han")
        }

        DropdownMenu(expanded = expanded, onDismissRequest = { expanded = false }) {
            (1..13).forEach {
                DropdownMenuItem(onClick = {
                    expanded = false
                    onHanChanged(it)
                }) {
                    Text("$it")
                }
            }
        }
    }
}