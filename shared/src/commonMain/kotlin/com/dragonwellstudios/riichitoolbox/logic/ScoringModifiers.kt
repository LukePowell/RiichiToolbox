package com.dragonwellstudios.riichitoolbox.logic

data class ScoringModifiers(
    val roundWind: Wind = Wind.EAST,
    val seatWind: Wind = Wind.EAST,
    val riichi: Boolean = false,
    val doubleRiichi: Boolean = false,
    val chankan: Boolean = false,
    val houteiOrHaitei: Boolean = false,
    val ippatsu: Boolean = false,
    val rinshanKaihou: Boolean = false
)