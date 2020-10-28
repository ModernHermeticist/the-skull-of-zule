package org.deepholm.skullofzule.commands

import org.deepholm.skullofzule.GameContext
import org.deepholm.skullofzule.extensions.GameCommand
import org.deepholm.skullofzule.extensions.GameEntity
import org.hexworks.amethyst.api.entity.EntityType
import org.hexworks.zircon.api.data.impl.Position3D

data class MoveCamera(override val context: GameContext,
                        override val source: GameEntity<EntityType>,
                        val previousPosition: Position3D) : GameCommand<EntityType>