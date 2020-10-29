package org.deepholm.skullofzule.commands

import org.deepholm.skullofzule.GameContext
import org.deepholm.skullofzule.extensions.GameEntity
import org.hexworks.amethyst.api.entity.EntityType

data class Attack(override val context: GameContext,
                    override val source: GameEntity<EntityType>,
                    override val target: GameEntity<EntityType>) : EntityAction<EntityType, EntityType>