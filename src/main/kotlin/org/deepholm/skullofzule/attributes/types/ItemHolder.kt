package org.deepholm.skullofzule.attributes.types

import org.deepholm.skullofzule.attributes.Inventory
import org.deepholm.skullofzule.extensions.GameItem
import org.deepholm.skullofzule.extensions.GameItemHolder
import org.hexworks.amethyst.api.entity.EntityType

interface ItemHolder : EntityType

fun GameItemHolder.addItem(item: GameItem) = inventory.addItem(item)

fun GameItemHolder.removeItem(item: GameItem) = inventory.removeItem(item)

val GameItemHolder.inventory: Inventory
    get() = findAttribute(Inventory::class).get()