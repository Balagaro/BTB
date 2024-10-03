package my.limitless.btb

import kotlin.random.Random

const val MAP_WIDTH = 20
const val MAP_HEIGHT = 20 // You can change this value to increase/decrease the height of the map
const val TILE_TYPES = 3 // For simplicity, let's say we have 3 tile types

// Define your tile types here
enum class TileType(val value: Int) {
    LAND(0), WATER(1), MOUNTAIN(2)
}

data class Tile(val type: TileType)

class MapGenerator {
    private val map: Array<Array<Tile>> = Array(MAP_HEIGHT) { Array(MAP_WIDTH) { Tile(TileType.LAND) } }

    fun generateMap() {
        for (y in 0 until MAP_HEIGHT) {
            for (x in 0 until MAP_WIDTH) {
                map[y][x] = Tile(generateRandomTile())
            }
        }
    }

    private fun generateRandomTile(): TileType {
        val randomValue = Random.nextInt(0, TILE_TYPES)
        return when (randomValue) {
            0 -> TileType.LAND
            1 -> TileType.WATER
            2 -> TileType.MOUNTAIN
            else -> TileType.LAND // Fallback (should never happen)
        }
    }

    fun printMap() {
        for (row in map) {
            println(row.joinToString(" ") { it.type.name.substring(0, 1) })
        }
    }
}

fun main() {
    val mapGenerator = MapGenerator()
    mapGenerator.generateMap()
    mapGenerator.printMap()
}