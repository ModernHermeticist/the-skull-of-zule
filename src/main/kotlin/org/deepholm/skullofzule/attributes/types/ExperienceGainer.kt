package org.deepholm.skullofzule.attributes.types

import org.deepholm.skullofzule.attributes.CombatStats
import org.deepholm.skullofzule.attributes.Experience
import org.deepholm.skullofzule.extensions.GameEntity
import org.hexworks.amethyst.api.entity.EntityType

interface ExperienceGainer : EntityType

val GameEntity<ExperienceGainer>.experience: Experience
    get() = findAttribute(Experience::class).get()

val GameEntity<ExperienceGainer>.combatStats: CombatStats
    get() = findAttribute(CombatStats::class).get()
