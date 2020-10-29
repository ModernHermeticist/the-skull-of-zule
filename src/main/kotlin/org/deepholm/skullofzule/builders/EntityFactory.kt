package org.deepholm.skullofzule.builders

import org.deepholm.skullofzule.GameContext
import org.deepholm.skullofzule.attributes.EntityActions
import org.deepholm.skullofzule.config.GameTileRepository
import org.hexworks.amethyst.api.Entities
import org.hexworks.amethyst.api.builder.EntityBuilder
import org.hexworks.amethyst.api.entity.EntityType
import org.deepholm.skullofzule.attributes.EntityPosition
import org.deepholm.skullofzule.attributes.EntityTile
import org.deepholm.skullofzule.attributes.FungusSpread
import org.deepholm.skullofzule.attributes.flags.BlockOccupier
import org.deepholm.skullofzule.attributes.types.Fungus
import org.deepholm.skullofzule.attributes.types.Player
import org.deepholm.skullofzule.attributes.types.Wall
import org.deepholm.skullofzule.commands.Attack
import org.deepholm.skullofzule.commands.Dig
import org.deepholm.skullofzule.systems.*

fun <T: EntityType> newGameEntityOfType(type: T, init: EntityBuilder<T, GameContext>.() -> Unit) =
        Entities.newEntityOfType(type, init)

object EntityFactory {

    fun newPlayer() = newGameEntityOfType(Player) {
        attributes(EntityPosition(), EntityTile(GameTileRepository.PLAYER), EntityActions(Dig::class, Attack::class))
        behaviors(InputReceiver)
        facets(Movable, CameraMover)
    }

    fun newWall() = newGameEntityOfType(Wall) {
        attributes(EntityPosition(), BlockOccupier, EntityTile(GameTileRepository.WALL))
        behaviors()
        facets(Diggable)
    }

    fun newFungus(fungusSpread: FungusSpread = FungusSpread()) = newGameEntityOfType(Fungus) {
        attributes(BlockOccupier,
                EntityPosition(),
                EntityTile(GameTileRepository.FUNGUS),
                fungusSpread)
        behaviors(FungusGrowth)
        facets(Attackable)
    }
}