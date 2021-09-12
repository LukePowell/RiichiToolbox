package com.dragonwellstudios.riichitoolbox.android.ui.views.hand_finder

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.DropdownMenu
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.dragonwellstudios.riichitoolbox.logic.Wind

@Composable
fun WindSelector(wind: Wind, windSelected: (Wind) -> Unit, children : @Composable () -> Unit) {
    var expanded by remember { mutableStateOf(false) }

    Row{
        children()
        Box {
            Text(wind.kanji, Modifier.clickable {
                expanded = true
            })
            DropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false },
            ) {
                Wind.values().forEach {
                    DropdownMenuItem(onClick = {
                        expanded = false
                        windSelected(it)
                    }) {
                        Text(text = it.kanji)
                    }
                }
            }
        }
    }

}

@Preview
@Composable
fun WindSelectorPreview() {
    WindSelector(Wind.EAST, {}) {
        Text("Select: ")
    }
}