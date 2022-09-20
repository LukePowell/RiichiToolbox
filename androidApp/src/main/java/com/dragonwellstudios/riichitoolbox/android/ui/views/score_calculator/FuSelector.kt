package com.dragonwellstudios.riichitoolbox.android.ui.views.score_calculator

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel

fun validFu(han: Int) =
    when (han) {
        1 -> 30..130 step 10
        else -> (20..25 step 5) + (30..130 step 10)
    }


@Composable
fun FuSelector(fu: Int, han: Int,  onFuChanged: (Int) -> Unit, modifier: Modifier = Modifier) {
    var expanded by remember { mutableStateOf(false) }

    Row(modifier = modifier){
        Text("Fu", Modifier.align(Alignment.CenterVertically))
        TextButton(onClick = { expanded = true }) {
            Text(text = "$fu")
        }

        DropdownMenu(expanded = expanded, onDismissRequest = { expanded = false }) {
            validFu(han).forEach {
                DropdownMenuItem(onClick = {
                    onFuChanged(it)
                    expanded = false
                }) {
                    Text("$it")
                }
            }
        }
    }
}

@Preview
@Composable
fun FuSelectorPreview() {
    FuSelector(30, 1, onFuChanged = {})
}