package org.deepholm.skullofzule.attributes.types

import org.deepholm.skullofzule.attributes.EnergyLevel
import org.deepholm.skullofzule.extensions.GameEntity
import org.hexworks.amethyst.api.entity.EntityType

interface EnergyUser : EntityType

val GameEntity<EnergyUser>.energyLevel: EnergyLevel
    get() = findAttribute(EnergyLevel::class).get()