package org.deepholm.skullofzule.commands

import org.deepholm.skullofzule.GameContext
import org.deepholm.skullofzule.extensions.GameCommand
import org.deepholm.skullofzule.extensions.GameEntity
import org.hexworks.amethyst.api.entity.EntityType

data class EntityDestroyed(override val context: GameContext,
                           override val source: GameEntity<EntityType>,
                           val destroyer: GameEntity<EntityType>) : GameCommand<EntityType>