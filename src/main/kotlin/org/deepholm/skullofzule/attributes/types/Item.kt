package org.deepholm.skullofzule.attributes.types

import org.deepholm.skullofzule.attributes.EntityTile
import org.deepholm.skullofzule.attributes.ItemIcon
import org.deepholm.skullofzule.extensions.GameEntity
import org.hexworks.amethyst.api.entity.EntityType
import org.hexworks.zircon.api.data.GraphicalTile
import org.hexworks.zircon.api.data.Tile

interface Item : EntityType

val GameEntity<Item>.tile: Tile
    get() = findAttribute(EntityTile::class).get().tile

val GameEntity<Item>.iconTile: GraphicalTile
    get() = findAttribute(ItemIcon::class).get().iconTile