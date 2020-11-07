package org.deepholm.skullofzule.commands

import org.deepholm.skullofzule.GameContext
import org.deepholm.skullofzule.extensions.GameCommand
import org.deepholm.skullofzule.extensions.GameItem
import org.deepholm.skullofzule.extensions.GameItemHolder
import org.hexworks.amethyst.api.entity.EntityType
import org.hexworks.zircon.api.data.impl.Position3D

data class DropItem(override val context: GameContext, override val source: GameItemHolder,
                    val item: GameItem, val position: Position3D): GameCommand<EntityType>