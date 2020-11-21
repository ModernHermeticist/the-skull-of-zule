package org.deepholm.skullofzule.config

import org.hexworks.zircon.api.Tiles

object ZombieTileTypes {

    val NECROSPORE = Tiles.newBuilder()
            .withCharacter('n')
            .withForegroundColor(GameColors.NECROSPORE_COLOR)
            .withBackgroundColor(GameColors.FLOOR_BACKGROUND)
            .buildCharacterTile()

    val SPORELING = Tiles.newBuilder()
            .withCharacter('s')
            .withForegroundColor(GameColors.SPORELING_COLOR)
            .withBackgroundColor(GameColors.FLOOR_BACKGROUND)
            .buildCharacterTile()

    val FUNGALZOMBIE = Tiles.newBuilder()
            .withCharacter('z')
            .withForegroundColor(GameColors.SPORELING_COLOR)
            .withBackgroundColor(GameColors.FLOOR_BACKGROUND)
            .buildCharacterTile()
}