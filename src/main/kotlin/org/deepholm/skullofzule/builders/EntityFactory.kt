package org.deepholm.skullofzule.builders

import org.deepholm.skullofzule.GameContext
import org.deepholm.skullofzule.attributes.*
import org.deepholm.skullofzule.config.GameTileRepository
import org.hexworks.amethyst.api.Entities
import org.hexworks.amethyst.api.builder.EntityBuilder
import org.hexworks.amethyst.api.entity.EntityType
import org.deepholm.skullofzule.attributes.flags.BlockOccupier
import org.deepholm.skullofzule.attributes.flags.VisionBlocker
import org.deepholm.skullofzule.attributes.types.*
import org.deepholm.skullofzule.commands.Attack
import org.deepholm.skullofzule.commands.Dig
import org.deepholm.skullofzule.entities.FogOfWar
import org.deepholm.skullofzule.systems.*
import org.deepholm.skullofzule.world.Game
import org.hexworks.zircon.api.GraphicalTilesetResources
import org.hexworks.zircon.api.Tiles

fun <T: EntityType> newGameEntityOfType(type: T, init: EntityBuilder<T, GameContext>.() -> Unit) =
        Entities.newEntityOfType(type, init)

object EntityFactory {

    fun newPlayer() = newGameEntityOfType(Player) {
        attributes(
                Vision(9),
                EntityPosition(),
                BlockOccupier,
                EntityTile(GameTileRepository.PLAYER),
                EntityActions(Dig::class, Attack::class),
                CombatStats.create(
                        maxHp = 100,
                        attackValue = 10,
                        defenseValue = 5),
                Inventory(10))
        behaviors(InputReceiver)
        facets(Movable, CameraMover, StairClimber, StairDescender,
                Attackable, Destructible, ItemPicker, InventoryInspector, ItemDropper)
    }

    fun newWall() = newGameEntityOfType(Wall) {
        attributes(
                VisionBlocker,
                EntityPosition(),
                BlockOccupier,
                EntityTile(GameTileRepository.WALL))
        behaviors()
        facets(Diggable)
    }

    fun newFungus(fungusSpread: FungusSpread = FungusSpread()) = newGameEntityOfType(Fungus) {
        attributes(
                BlockOccupier,
                EntityPosition(),
                EntityTile(GameTileRepository.FUNGUS),
                fungusSpread,
                CombatStats.create(
                        maxHp = 10,
                        attackValue = 0,
                        defenseValue = 0
                ))
        behaviors(FungusGrowth)
        facets(Attackable, Destructible)
    }

    fun newStairsDown() = newGameEntityOfType(StairsDown) {
        attributes(
                EntityTile(GameTileRepository.STAIRS_DOWN),
                EntityPosition())
    }

    fun newStairsUp() = newGameEntityOfType(StairsUp) {
        attributes(
                EntityTile(GameTileRepository.STAIRS_UP),
                EntityPosition())
    }

    fun newFogOfWar(game: Game) = FogOfWar(game)

    fun newBat() = newGameEntityOfType(Bat) {
        attributes(BlockOccupier,
        EntityPosition(),
        EntityTile(GameTileRepository.BAT),
        CombatStats.create(
                maxHp = 5,
                attackValue = 2,
                defenseValue = 1),
        EntityActions(Attack::class))
        facets(Movable, Attackable, Destructible)
        behaviors(Wanderer)
    }

    fun newTin() = newGameEntityOfType(Tin) {
        attributes(ItemIcon(Tiles.newBuilder()
                .withName("white gem")
                .withTileset(GraphicalTilesetResources.nethack16x16())
                .buildGraphicTile()),
        EntityPosition(),
        EntityTile(GameTileRepository.TIN))
    }
}