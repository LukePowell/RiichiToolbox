package com.dragonwellstudios.riichitoolbox.android.ui.views.hand_finder

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.width
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun HandControl(modifier: Modifier = Modifier) {
    Row(horizontalArrangement = Arrangement.SpaceEvenly) {
        Button(onClick = { /*TODO*/ }, modifier = modifier.weight(1f)) {
            Text("Pon")
        }

        Button(onClick = { /*TODO*/ }, modifier = modifier.weight(1f)) {
            Text("Kan")
        }

        Button(onClick = { /*TODO*/ }, modifier = modifier.weight(1f)) {
            Text("Chii")
        }

        Button(onClick = { /*TODO*/ }, modifier = modifier.weight(1f)) {
            Text("Kan (Closed)")
        }
    }
}

@Preview
@Composable
fun HandControlPreview() {
    HandControl()
}
