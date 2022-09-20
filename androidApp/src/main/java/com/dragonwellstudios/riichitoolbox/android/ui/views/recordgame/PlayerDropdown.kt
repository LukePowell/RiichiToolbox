package com.dragonwellstudios.riichitoolbox.android.ui.views.recordgame

import androidx.compose.foundation.layout.Row
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.tooling.preview.Preview
import com.dragonwellstudios.riichitoolbox.logic.Wind
import com.dragonwellstudios.riichitoolbox.logic.gamestate.Player

@Composable
fun PlayerDropdown(players: List<Player>) {
    var expanded by remember { mutableStateOf(false) }
    var selectedIndex by remember { mutableStateOf(0) }

    TextButton(onClick = {
        expanded = true
    }) {
        Text( players[selectedIndex].name)
    }

    DropdownMenu(expanded = expanded, onDismissRequest = { expanded = false }) {
        players.forEachIndexed {index, player ->
            DropdownMenuItem(onClick = {
                selectedIndex = index
                expanded = false
            }) {
                Text(text = player.name)
            }
        }
    }
}

@Preview
@Composable
fun PlayerDropdownPreview() {
    PlayerDropdown(players = listOf(
        Player("East", Wind.EAST, 25_000),
        Player("South", Wind.SOUTH, 25_000),
        Player("West", Wind.WEST, 25_000),
        Player("North", Wind.NORTH, 25_000)
    ))
}