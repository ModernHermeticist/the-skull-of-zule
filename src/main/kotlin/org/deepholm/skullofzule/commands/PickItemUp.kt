package org.deepholm.skullofzule.commands

import org.deepholm.skullofzule.GameContext
import org.deepholm.skullofzule.attributes.types.ItemHolder
import org.deepholm.skullofzule.extensions.GameCommand
import org.deepholm.skullofzule.extensions.GameItemHolder
import org.hexworks.zircon.api.data.impl.Position3D

data class PickItemUp(override val context: GameContext, override val source: GameItemHolder, val position: Position3D): GameCommand<ItemHolder>