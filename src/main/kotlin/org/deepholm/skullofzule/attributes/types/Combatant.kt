package org.deepholm.skullofzule.attributes.types

import org.deepholm.skullofzule.attributes.CombatStats
import org.deepholm.skullofzule.extensions.GameEntity
import org.hexworks.amethyst.api.entity.EntityType

interface Combatant: EntityType

val GameEntity<Combatant>.combatStats: CombatStats
    get() = findAttribute(CombatStats::class).get()