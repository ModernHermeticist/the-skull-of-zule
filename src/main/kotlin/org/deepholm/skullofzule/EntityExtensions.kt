package org.deepholm.skullofzule

import org.deepholm.skullofzule.attributes.EntityPosition
import org.deepholm.skullofzule.attributes.EntityTile
import org.deepholm.skullofzule.attributes.flags.BlockOccupier
import org.deepholm.skullofzule.extensions.AnyGameEntity
import org.hexworks.amethyst.api.Attribute
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

fun <T : Attribute> AnyGameEntity.tryToFindAttribute(klass: KClass<T>): T = findAttribute(klass).orElseThrow {
    NoSuchElementException("Entity '$this' has no property with type '${klass.simpleName}'.")
}