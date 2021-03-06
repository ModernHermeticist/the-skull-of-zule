package org.deepholm.skullofzule.config

import org.deepholm.skullofzule.config.GameColors
import org.hexworks.zircon.api.Tiles
import org.hexworks.zircon.api.color.ANSITileColor
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

    val GOLD_PIECE = Tiles.newBuilder()
            .withCharacter(',')
            .withBackgroundColor(GameColors.FLOOR_BACKGROUND)
            .withForegroundColor(GameColors.GOLD_PIECE_COLOR)
            .buildCharacterTile()

    val BAT_MEAT = Tiles.newBuilder()
            .withCharacter('m')
            .withBackgroundColor(GameColors.FLOOR_BACKGROUND)
            .withForegroundColor(GameColors.BAT_MEAT_COLOR)
            .buildCharacterTile()


    val CLUB = Tiles.newBuilder()
            .withCharacter('(')
            .withForegroundColor(ANSITileColor.GRAY)
            .withBackgroundColor(GameColors.FLOOR_BACKGROUND)
            .buildCharacterTile()

    val DAGGER = Tiles.newBuilder()
            .withCharacter('(')
            .withForegroundColor(ANSITileColor.WHITE)
            .withBackgroundColor(GameColors.FLOOR_BACKGROUND)
            .buildCharacterTile()

    val SWORD = Tiles.newBuilder()
            .withCharacter('(')
            .withForegroundColor(ANSITileColor.BRIGHT_WHITE)
            .withBackgroundColor(GameColors.FLOOR_BACKGROUND)
            .buildCharacterTile()

    val STAFF = Tiles.newBuilder()
            .withCharacter('(')
            .withForegroundColor(ANSITileColor.YELLOW)
            .withBackgroundColor(GameColors.FLOOR_BACKGROUND)
            .buildCharacterTile()

    val JACKET = Tiles.newBuilder()
            .withCharacter('[')
            .withForegroundColor(ANSITileColor.GRAY)
            .withBackgroundColor(GameColors.FLOOR_BACKGROUND)
            .buildCharacterTile()

    val LIGHT_ARMOR = Tiles.newBuilder()
            .withCharacter('[')
            .withForegroundColor(ANSITileColor.GREEN)
            .withBackgroundColor(GameColors.FLOOR_BACKGROUND)
            .buildCharacterTile()

    val MEDIUM_ARMOR = Tiles.newBuilder()
            .withCharacter('[')
            .withForegroundColor(ANSITileColor.WHITE)
            .withBackgroundColor(GameColors.FLOOR_BACKGROUND)
            .buildCharacterTile()

    val HEAVY_ARMOR = Tiles.newBuilder()
            .withCharacter('[')
            .withForegroundColor(ANSITileColor.BRIGHT_WHITE)
            .withBackgroundColor(GameColors.FLOOR_BACKGROUND)
            .buildCharacterTile()
}