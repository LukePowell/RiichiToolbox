package com.dragonwellstudios.riichitoolbox.logic

enum class TileGrouping(val size: Int) {
    PON(3),
    CHI(3),
    KAN(4),
    PAIR(2)
}

class TileGroup(val list: MutableList<Tile>, private val grouping: TileGrouping) {
    fun insert(tile: Tile): Boolean {
        if (list.size == grouping.size) {
            return false
        }

        if (list.isEmpty()) {
            return true
        }

        val front = list.first()

        val valid = when (grouping) {
            TileGrouping.PON, TileGrouping.KAN, TileGrouping.PAIR -> tile == front
            TileGrouping.CHI -> false
        }

        if (valid) {
            list.add(tile)
        }

        return valid
    }
}

class Hand {
    private val ungroupedTiles: MutableList<Tile> = mutableListOf()
    private val tileGroups: MutableList<TileGroup> = mutableListOf()

    fun addTile(tile: Tile) {
        ungroupedTiles.add(tile)
    }

    fun removeTile(tile: Tile) {
        ungroupedTiles.remove(tile)
    }

    fun addGroup(tileGroup: TileGroup) {
        tileGroups.add(tileGroup)
    }

    fun removeGroup(tileGroup: TileGroup) {
        tileGroups.remove(tileGroup)
    }

    fun calculateShanten(): Int {
        return 0
    }

    val tiles: List<Tile>
        get() {
            val tileList = mutableListOf<Tile>()
            tileGroups.forEach {
                tileList.addAll(it.list)
            }
            tileList.addAll(ungroupedTiles)
            return tileList
        }
}