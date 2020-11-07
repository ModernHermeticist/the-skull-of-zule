package org.deepholm.skullofzule.commands

import org.deepholm.skullofzule.GameContext
import org.deepholm.skullofzule.extensions.GameCommand
import org.deepholm.skullofzule.extensions.GameItemHolder
import org.hexworks.amethyst.api.entity.EntityType
import org.hexworks.zircon.api.data.impl.Position3D

data class InspectInventory(override val context: GameContext, override val source: GameItemHolder,
                            val position: Position3D): GameCommand<EntityType>