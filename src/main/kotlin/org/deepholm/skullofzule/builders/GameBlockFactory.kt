package org.deepholm.skullofzule.builders

import org.deepholm.skullofzule.GameBlock
import org.deepholm.skullofzule.config.GameTileRepository

object GameBlockFactory {

    fun floor() = GameBlock(GameTileRepository.FLOOR)

    fun wall() = GameBlock.createWith(EntityFactory.newWall())

    fun stairsUp() = GameBlock.createWith(EntityFactory.newStairsUp())

    fun stairsDown() = GameBlock.createWith(EntityFactory.newStairsDown())
}