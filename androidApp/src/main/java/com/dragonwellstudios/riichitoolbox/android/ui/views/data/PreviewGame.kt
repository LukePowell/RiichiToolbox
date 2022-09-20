package com.dragonwellstudios.riichitoolbox.android.ui.views.data

import com.dragonwellstudios.riichitoolbox.logic.InitialSettings
import com.dragonwellstudios.riichitoolbox.logic.Wind
import com.dragonwellstudios.riichitoolbox.logic.gamestate.Player

sealed class PreviewGame(val settings: InitialSettings) {
    object Saki : PreviewGame(
        InitialSettings(
            east = Player("宮永 咲", Wind.EAST, 25_000),
            south = Player("天江 衣", Wind.SOUTH, 25_000),
            west = Player("原村 和", Wind.WEST, 25_000),
            north = Player("片岡 優希", Wind.NORTH, 25_000)
        )
    )

    object Winds:  PreviewGame(
        InitialSettings(
            east = Player("East", Wind.EAST, 25_000),
            south = Player("South", Wind.SOUTH, 25_000),
            west = Player("West", Wind.WEST, 25_000),
            north = Player("North", Wind.NORTH, 25_000)
        )
    )

}