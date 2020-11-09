package org.deepholm.skullofzule.commands

import org.deepholm.skullofzule.GameContext
import org.deepholm.skullofzule.attributes.types.EnergyUser
import org.deepholm.skullofzule.attributes.types.Food
import org.deepholm.skullofzule.extensions.GameEntity

data class Eat(override val context: GameContext, override val source: GameEntity<EnergyUser>,
                override val target: GameEntity<Food>): EntityAction<EnergyUser, Food>