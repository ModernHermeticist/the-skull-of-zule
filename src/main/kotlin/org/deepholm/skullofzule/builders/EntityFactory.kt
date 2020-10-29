package org.deepholm.skullofzule.builders

import org.deepholm.skullofzule.GameContext
import org.deepholm.skullofzule.attributes.*
import org.deepholm.skullofzule.config.GameTileRepository
import org.hexworks.amethyst.api.Entities
import org.hexworks.amethyst.api.builder.EntityBuilder
import org.hexworks.amethyst.api.entity.EntityType
import org.deepholm.skullofzule.attributes.flags.BlockOccupier
import org.deepholm.skullofzule.attributes.types.*
import org.deepholm.skullofzule.commands.Attack
import org.deepholm.skullofzule.commands.Dig
import org.deepholm.skullofzule.systems.*

fun <T: EntityType> newGameEntityOfType(type: T, init: EntityBuilder<T, GameContext>.() -> Unit) =
        Entities.newEntityOfType(type, init)

object EntityFactory {

    fun newPlayer() = newGameEntityOfType(Player) {
        attributes(
                EntityPosition(),
                EntityTile(GameTileRepository.PLAYER),
                EntityActions(Dig::class, Attack::class),
                CombatStats.create(
                        maxHp = 100,
                        attackValue = 10,
                        defenseValue = 5))
        behaviors(InputReceiver)
        facets(Movable, CameraMover)
    }

    fun newWall() = newGameEntityOfType(Wall) {
        attributes(
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
}