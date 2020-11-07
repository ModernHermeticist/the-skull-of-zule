package org.deepholm.skullofzule.systems

import org.deepholm.skullofzule.GameContext
import org.deepholm.skullofzule.attributes.types.removeItem
import org.deepholm.skullofzule.commands.DropItem
import org.deepholm.skullofzule.extensions.GameCommand
import org.deepholm.skullofzule.functions.logGameEvent
import org.deepholm.skullofzule.isPlayer
import org.hexworks.amethyst.api.Consumed
import org.hexworks.amethyst.api.base.BaseFacet
import org.hexworks.amethyst.api.entity.EntityType

object ItemDropper: BaseFacet<GameContext>() {

    override fun executeCommand(command: GameCommand<out EntityType>) = command
            .responseWhenCommandIs(DropItem::class) { (context, itemHolder, item, position) ->
                if (itemHolder.removeItem(item)) {
                    context.world.addEntity(item, position)
                    val subject = if (itemHolder.isPlayer) "You" else "The $itemHolder"
                    val verb = if (itemHolder.isPlayer) "drop" else "drops"
                    logGameEvent("$subject $verb the $item.")
                }
                Consumed
            }
}