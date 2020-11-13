package org.deepholm.skullofzule.world

import org.deepholm.skullofzule.config.GameConfig
import org.deepholm.skullofzule.config.GameConfig.WORLD_SIZE
import org.deepholm.skullofzule.attributes.types.Player
import org.deepholm.skullofzule.builders.EntityFactory
import org.deepholm.skullofzule.builders.ZombieEntityFactory
import org.deepholm.skullofzule.config.GameConfig.ARMOR_PER_LEVEL
import org.deepholm.skullofzule.config.GameConfig.BATS_PER_LEVEL
import org.deepholm.skullofzule.config.GameConfig.FUNGI_PER_LEVEL
import org.deepholm.skullofzule.config.GameConfig.NECROSPORES_PER_LEVEL
import org.deepholm.skullofzule.config.GameConfig.TIN_PER_LEVEL
import org.deepholm.skullofzule.config.GameConfig.WEAPONS_PER_LEVEL
import org.deepholm.skullofzule.extensions.GameEntity
import org.hexworks.amethyst.api.entity.EntityType
import org.hexworks.zircon.api.Positions
import org.hexworks.zircon.api.Sizes
import org.hexworks.zircon.api.data.Size
import org.hexworks.zircon.api.data.impl.Position3D
import org.hexworks.zircon.api.data.impl.Size3D

class GameBuilder(val worldSize: Size3D) {

    private val visibleSize = Sizes.create3DSize(
            xLength = GameConfig.WINDOW_WIDTH - GameConfig.SIDEBAR_WIDTH,
            yLength = GameConfig.WINDOW_HEIGHT - GameConfig.LOG_AREA_HEIGHT,
            zLength = 1)

    val world = WorldBuilder(worldSize)
            .makeCaves()
            .build(visibleSize = visibleSize)

    fun buildGame(): Game {

        prepareWorld()

        val player = addPlayer()
        addFungi()
        addBats()
        addTin()
        addWeapons()
        addArmor()
        addNecrospores()

        val game = Game.create(
                player = player,
                world = world)

        world.addWorldEntity(EntityFactory.newFogOfWar(game))

        return game
    }

    private fun prepareWorld() = also {
        world.scrollUpBy(world.actualSize().zLength)
    }

    private fun addPlayer(): GameEntity<Player> {
        return EntityFactory.newPlayer().addToWorld(
                atLevel = GameConfig.DUNGEON_LEVELS - 1,
                atArea = world.visibleSize().to2DSize())
    }

    private fun addWeapons() = also {
        repeat(world.actualSize().zLength) { level ->
            repeat(WEAPONS_PER_LEVEL) {
                EntityFactory.newRandomWeapon().addToWorld(level)
            }
        }
    }

    private fun addArmor() = also {
        repeat(world.actualSize().zLength) { level ->
            repeat(ARMOR_PER_LEVEL) {
                EntityFactory.newRandomArmor().addToWorld(level)
            }
        }
    }

    private fun addFungi() = also {
        repeat(world.actualSize().zLength) { level ->
            repeat(FUNGI_PER_LEVEL) {
                EntityFactory.newFungus().addToWorld(level)
            }
        }
    }

    private fun addBats() = also {
        repeat(world.actualSize().zLength) {level ->
            repeat(BATS_PER_LEVEL) {
                EntityFactory.newBat().addToWorld(level)
            }
        }
    }

    private fun addTin() = also {
        repeat(world.actualSize().zLength) { level ->
            repeat(TIN_PER_LEVEL) {
                EntityFactory.newTin().addToWorld(level)
            }
        }
    }

    private fun addNecrospores() = also {
        repeat(world.actualSize().zLength) { level ->
            repeat(NECROSPORES_PER_LEVEL) {
                ZombieEntityFactory.newNecrospore().addToWorld(level)
            }
        }
    }

    private fun <T: EntityType> GameEntity<T>.addToWorld(
            atLevel: Int,
            atArea: Size = world.actualSize().to2DSize()): GameEntity<T> {
        world.addAtEmptyPosition(this,
                offset = Position3D.defaultPosition().withZ(atLevel),
                size = Size3D.from2DSize(atArea))
        return this

    }

    companion object {

        fun defaultGame() = GameBuilder(
                worldSize = WORLD_SIZE).buildGame()
    }
}
