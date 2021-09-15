package com.dragonwellstudios.riichitoolbox.logic

import kotlin.math.min

fun shanten(tiles: List<Tile>, groups: List<TileGroup>): Int {
    if (groups.isEmpty()) {
        return min(
            shanten(
                tiles.subList(1, tiles.size),
                listOf(TileGroup(listOf(tiles.first()), TileGrouping.PAIR))
            ),
            shanten(
                tiles.subList(1, tiles.size),
                listOf(TileGroup(listOf(tiles.first()), TileGrouping.PAIR))
            )
        )
    }

    for(group in groups) {
        if(group.insert(tiles.first()) {
            return shanten(tiles.subList(1, tiles.size), groups)
        }
    }

    return tiles.size
}