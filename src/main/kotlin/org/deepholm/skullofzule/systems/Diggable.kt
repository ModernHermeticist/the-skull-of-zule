package org.deepholm.skullofzule.systems

import org.deepholm.skullofzule.GameContext
import org.deepholm.skullofzule.commands.Dig
import org.deepholm.skullofzule.extensions.GameCommand
import org.hexworks.amethyst.api.Command
import org.hexworks.amethyst.api.Consumed
import org.hexworks.amethyst.api.Response
import org.hexworks.amethyst.api.base.BaseFacet
import org.hexworks.amethyst.api.entity.EntityType

object Diggable: BaseFacet<GameContext>() {

    override fun executeCommand(command: GameCommand<out EntityType>) =
            command.responseWhenCommandIs(Dig::class) { (context, _, target) ->
        context.world.removeEntity(target)
        Consumed
    }
}