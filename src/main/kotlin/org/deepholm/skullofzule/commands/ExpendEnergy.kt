package org.deepholm.skullofzule.commands

import org.deepholm.skullofzule.GameContext
import org.deepholm.skullofzule.attributes.types.EnergyUser
import org.deepholm.skullofzule.extensions.GameCommand
import org.deepholm.skullofzule.extensions.GameEntity
import org.hexworks.amethyst.api.entity.EntityType

data class ExpendEnergy(override val context: GameContext, override val source: GameEntity<EnergyUser>,
                        val energy: Int): GameCommand<EntityType>