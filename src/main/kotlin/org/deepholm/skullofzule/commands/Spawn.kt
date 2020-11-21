package org.deepholm.skullofzule.commands

import org.deepholm.skullofzule.GameContext
import org.deepholm.skullofzule.extensions.GameCommand
import org.deepholm.skullofzule.extensions.GameEntity
import org.hexworks.amethyst.api.entity.EntityType
import org.hexworks.cobalt.datatypes.Maybe

data class Spawn(override val context: GameContext, override val source: GameEntity<EntityType>,
                 val fn: Maybe<() -> GameEntity<EntityType>>, val numberToSpawn: Int): GameCommand<EntityType>