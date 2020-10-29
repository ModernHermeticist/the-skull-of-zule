package org.deepholm.skullofzule

import org.deepholm.skullofzule.attributes.EntityActions
import org.deepholm.skullofzule.attributes.EntityPosition
import org.deepholm.skullofzule.attributes.EntityTile
import org.deepholm.skullofzule.attributes.flags.BlockOccupier
import org.deepholm.skullofzule.attributes.types.Combatant
import org.deepholm.skullofzule.attributes.types.Player
import org.deepholm.skullofzule.attributes.types.combatStats
import org.deepholm.skullofzule.extensions.AnyGameEntity
import org.deepholm.skullofzule.extensions.GameEntity
import org.hexworks.amethyst.api.Attribute
import org.hexworks.amethyst.api.Consumed
import org.hexworks.amethyst.api.Pass
import org.hexworks.amethyst.api.Response
import org.hexworks.cobalt.datatypes.extensions.orElseThrow
import org.hexworks.cobalt.datatypes.extensions.map
import org.hexworks.zircon.api.data.Tile
import kotlin.reflect.KClass

var AnyGameEntity.position
    get() = tryToFindAttribute(EntityPosition::class).position
    set(value) {
        findAttribute(EntityPosition::class).map {
            it.position = value
        }
    }

val AnyGameEntity.tile: Tile
    get() = this.tryToFindAttribute(EntityTile::class).tile

val AnyGameEntity.occupiesBlock: Boolean
    get() = findAttribute(BlockOccupier::class).isPresent

val AnyGameEntity.isPlayer: Boolean
    get() = this.type == Player

fun <T : Attribute> AnyGameEntity.tryToFindAttribute(klass: KClass<T>): T = findAttribute(klass).orElseThrow {
    NoSuchElementException("Entity '$this' has no property with type '${klass.simpleName}'.")
}

fun AnyGameEntity.tryActionsOn(context: GameContext, target: AnyGameEntity) : Response {
    var result: Response = Pass
    findAttribute(EntityActions::class).map {
        it.createActionsFor(context, this, target).forEach { action ->
            if (target.executeCommand(action) is Consumed) {
                result = Consumed
                return@forEach
            }
        }
    }
    return result
}

fun GameEntity<Combatant>.whenHasNoHealthLeft(fn: () -> Unit) {
    if (combatStats.hp <= 0) {
        fn()
    }
}