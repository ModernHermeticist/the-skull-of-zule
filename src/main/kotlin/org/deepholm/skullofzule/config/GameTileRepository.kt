package org.deepholm.skullofzule.config

import org.deepholm.skullofzule.config.GameColors
import org.hexworks.zircon.api.Tiles
import org.hexworks.zircon.api.data.CharacterTile
import org.hexworks.zircon.api.graphics.Symbols

object GameTileRepository {

    val UNREVEALED = Tiles.newBuilder()
            .withCharacter(' ')
            .withBackgroundColor(GameColors.UNREVEALED_COLOR)
            .buildCharacterTile()

    val EMPTY: CharacterTile = Tiles.empty()

    val FLOOR: CharacterTile = Tiles.newBuilder()
            .withCharacter(Symbols.INTERPUNCT)
            .withForegroundColor(GameColors.FLOOR_FOREGROUND)
            .withBackgroundColor(GameColors.FLOOR_BACKGROUND)
            .buildCharacterTile()

    val WALL: CharacterTile = Tiles.newBuilder()
            .withCharacter('#')
            .withForegroundColor(GameColors.WALL_FOREGROUND)
            .withBackgroundColor(GameColors.WALL_BACKGROUND)
            .buildCharacterTile()

    val STAIRS_UP: CharacterTile = Tiles.newBuilder()
            .withCharacter('<')
            .withForegroundColor(GameColors.ACCENT_COLOR)
            .withBackgroundColor(GameColors.WALL_BACKGROUND)
            .buildCharacterTile()

    val STAIRS_DOWN: CharacterTile = Tiles.newBuilder()
            .withCharacter('>')
            .withForegroundColor(GameColors.ACCENT_COLOR)
            .withBackgroundColor(GameColors.WALL_BACKGROUND)
            .buildCharacterTile()

    val PLAYER = Tiles.newBuilder()
            .withCharacter('@')
            .withBackgroundColor(GameColors.FLOOR_BACKGROUND)
            .withForegroundColor(GameColors.ACCENT_COLOR)
            .buildCharacterTile()

    val FUNGUS = Tiles.newBuilder()
            .withCharacter('f')
            .withBackgroundColor(GameColors.FLOOR_BACKGROUND)
            .withForegroundColor(GameColors.FUNGUS_COLOR)
            .buildCharacterTile()

    val BAT = Tiles.newBuilder()
            .withCharacter('b')
            .withBackgroundColor(GameColors.FLOOR_BACKGROUND)
            .withForegroundColor(GameColors.BAT_COLOR)
            .buildCharacterTile()

    val TIN = Tiles.newBuilder()
            .withCharacter(',')
            .withBackgroundColor(GameColors.FLOOR_BACKGROUND)
            .withForegroundColor(GameColors.TIN_COLOR)
            .buildCharacterTile()
}