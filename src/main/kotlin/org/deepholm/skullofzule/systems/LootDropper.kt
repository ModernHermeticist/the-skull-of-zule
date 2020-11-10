package org.deepholm.skullofzule.systems

import org.deepholm.skullofzule.GameContext
import org.deepholm.skullofzule.attributes.types.ItemHolder
import org.deepholm.skullofzule.attributes.types.inventory
import org.deepholm.skullofzule.commands.Destroy
import org.deepholm.skullofzule.commands.DropItem
import org.deepholm.skullofzule.extensions.GameCommand
import org.deepholm.skullofzule.extensions.position
import org.deepholm.skullofzule.extensions.whenTypeIs
import org.hexworks.amethyst.api.Pass
import org.hexworks.amethyst.api.base.BaseFacet
import org.hexworks.amethyst.api.entity.EntityType

object LootDropper: BaseFacet<GameContext>() {

    override fun executeCommand(command: GameCommand<out EntityType>) = command
            .responseWhenCommandIs(Destroy::class) { (context, _, target) ->
                target.whenTypeIs<ItemHolder> { entity ->
                    entity.inventory.items.forEach { item ->
                        entity.executeCommand(DropItem(context, entity, item, entity.position))
                    }
                }
                Pass
            }
}