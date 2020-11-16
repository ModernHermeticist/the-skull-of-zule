package org.deepholm.skullofzule.commands

import org.deepholm.skullofzule.GameContext
import org.deepholm.skullofzule.extensions.GameCommand
import org.deepholm.skullofzule.extensions.GameEntity
import org.hexworks.amethyst.api.entity.EntityType

data class Spawn(override val context: GameContext, override val source: GameEntity<EntityType>, 
                 val entityToSpawn: GameEntity<EntityType>, val numberToSpawn: Int): GameCommand<EntityType>