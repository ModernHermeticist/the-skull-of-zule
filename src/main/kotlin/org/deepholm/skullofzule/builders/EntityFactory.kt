package org.deepholm.skullofzule.builders

import org.deepholm.skullofzule.GameContext
import org.deepholm.skullofzule.GameTileRepository
import org.hexworks.amethyst.api.Entities
import org.hexworks.amethyst.api.builder.EntityBuilder
import org.hexworks.amethyst.api.entity.EntityType
import org.deepholm.skullofzule.attributes.EntityPosition
import org.deepholm.skullofzule.attributes.EntityTile
import org.deepholm.skullofzule.attributes.types.Player

fun <T: EntityType> newGameEntityOfType(type: T, init: EntityBuilder<T, GameContext>.() -> Unit) =
        Entities.newEntityOfType(type, init)

object EntityFactory {

    fun newPlayer() = newGameEntityOfType(Player) {
        attributes(EntityPosition(), EntityTile(GameTileRepository.PLAYER))
        behaviors()
        facets()
    }
}