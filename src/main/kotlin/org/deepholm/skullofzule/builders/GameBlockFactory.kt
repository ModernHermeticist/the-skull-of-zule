package org.deepholm.skullofzule.builders

import org.deepholm.skullofzule.GameBlock
import org.deepholm.skullofzule.config.GameTileRepository

object GameBlockFactory {

    fun floor() = GameBlock(GameTileRepository.FLOOR)

    fun wall() = GameBlock(GameTileRepository.WALL)
}