package org.deepholm.skullofzule.attributes.types

import org.deepholm.skullofzule.attributes.ItemCombatStats
import org.deepholm.skullofzule.extensions.GameEntity

interface Weapon : CombatItem

val GameEntity<Weapon>.attackValue: Int
    get() = findAttribute(ItemCombatStats::class).get().attackValue

val GameEntity<Weapon>.defenseValue: Int
    get() = findAttribute(ItemCombatStats::class).get().defenseValue