package org.deepholm.skullofzule.config

import org.hexworks.zircon.api.AppConfigs
import org.hexworks.zircon.api.CP437TilesetResources
import org.hexworks.zircon.api.ColorThemes
import org.hexworks.zircon.api.Sizes
import org.hexworks.zircon.api.application.DebugConfig

object GameConfig {

    const val DUNGEON_LEVELS = 2

    val TILESET = CP437TilesetResources.rogueYun16x16()
    val THEME = ColorThemes.zenburnVanilla()
    const val SIDEBAR_WIDTH = 18
    const val LOG_AREA_HEIGHT = 8

    const val WINDOW_WIDTH = 90
    const val WINDOW_HEIGHT = 60

    const val FUNGI_PER_LEVEL = 15
    const val MAXIMUM_FUNGUS_SPREAD = 20

    const val BATS_PER_LEVEL = 10

    const val TIN_PER_LEVEL = 20

    const val WEAPONS_PER_LEVEL = 3
    const val ARMOR_PER_LEVEL = 3

    const val NECROSPORES_PER_LEVEL = 3


    val WORLD_SIZE = Sizes.create3DSize(WINDOW_WIDTH * 2, WINDOW_HEIGHT, DUNGEON_LEVELS)

    fun buildAppConfig() = AppConfigs.newConfig()
            .withDebugMode(debugMode = false)
            .enableBetaFeatures()
            .withDefaultTileset(TILESET)
            .withSize(Sizes.create(WINDOW_WIDTH, WINDOW_HEIGHT))
            .build()
}