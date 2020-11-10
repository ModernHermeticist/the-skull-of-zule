package org.deepholm.skullofzule.attributes.types

import org.deepholm.skullofzule.GameContext
import org.deepholm.skullofzule.attributes.ItemCombatStats
import org.hexworks.amethyst.api.entity.Entity

interface Armor : CombatItem

val Entity<Armor, GameContext>.attackValue: Int
    get() = findAttribute(ItemCombatStats::class).get().attackValue

val Entity<Armor, GameContext>.defenseValue: Int
    get() = findAttribute(ItemCombatStats::class).get().defenseValue