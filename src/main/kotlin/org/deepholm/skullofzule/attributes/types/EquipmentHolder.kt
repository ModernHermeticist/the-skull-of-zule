package org.deepholm.skullofzule.attributes.types

import org.deepholm.skullofzule.attributes.Equipment
import org.deepholm.skullofzule.attributes.Inventory
import org.deepholm.skullofzule.extensions.GameCombatItem
import org.deepholm.skullofzule.extensions.GameEquipmentHolder
import org.hexworks.amethyst.api.entity.EntityType

interface EquipmentHolder : EntityType

fun GameEquipmentHolder.equip(inventory: Inventory, item: GameCombatItem): GameCombatItem {
    return equipment.equip(inventory, item)
}

val GameEquipmentHolder.equipment: Equipment
    get() = findAttribute(Equipment::class).get()