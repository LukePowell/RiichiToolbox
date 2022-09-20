package com.dragonwellstudios.riichitoolbox.logic.gamestate

import com.dragonwellstudios.riichitoolbox.logic.Game
import com.dragonwellstudios.riichitoolbox.logic.Wind

data class Player(val name: String, val startingWind: Wind, val startingPoints: Int) {
    val currentPoints = startingPoints

    fun getCurrentWind(game: Game): Wind {
        return startingWind
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || this::class != other::class) return false

        other as Player

        if (name != other.name) return false
        if (startingWind != other.startingWind) return false

        return true
    }

    override fun hashCode(): Int {
        var result = name.hashCode()
        result = 31 * result + startingWind.hashCode()
        return result
    }
}
