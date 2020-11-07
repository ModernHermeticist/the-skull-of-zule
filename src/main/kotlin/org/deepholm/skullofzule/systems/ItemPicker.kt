package org.deepholm.skullofzule.systems

import org.deepholm.skullofzule.GameContext
import org.deepholm.skullofzule.attributes.types.Item
import org.deepholm.skullofzule.attributes.types.addItem
import org.deepholm.skullofzule.commands.PickItemUp
import org.deepholm.skullofzule.extensions.GameCommand
import org.deepholm.skullofzule.filterType
import org.deepholm.skullofzule.functions.logGameEvent
import org.deepholm.skullofzule.isPlayer
import org.deepholm.skullofzule.world.World
import org.hexworks.amethyst.api.Consumed
import org.hexworks.amethyst.api.base.BaseFacet
import org.hexworks.amethyst.api.entity.EntityType
import org.hexworks.cobalt.datatypes.Maybe
import org.hexworks.cobalt.datatypes.extensions.flatMap
import org.hexworks.cobalt.datatypes.extensions.map
import org.hexworks.zircon.api.data.impl.Position3D

object ItemPicker : BaseFacet<GameContext>() {

    override fun executeCommand(command: GameCommand<out EntityType>) = command.responseWhenCommandIs(PickItemUp::class) { (context, itemHolder, position) ->
        val world = context.world
        world.findTopItem(position).map { item ->
            if (itemHolder.addItem(item)) {
                world.removeEntity(item)
                val subject = if (itemHolder.isPlayer) "You" else "The $itemHolder"
                val verb = if (itemHolder.isPlayer) "pick up" else "picks up"
                logGameEvent("$subject $verb the $item")
            }
        }
        Consumed
    }

    private fun World.findTopItem(position: Position3D) =
            fetchBlockAt(position).flatMap { block ->
                Maybe.ofNullable(block.entities.filterType<Item>().firstOrNull())
            }
}