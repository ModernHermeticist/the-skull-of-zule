package org.deepholm.skullofzule.systems

import org.deepholm.skullofzule.GameContext
import org.deepholm.skullofzule.attributes.types.Player
import org.deepholm.skullofzule.commands.MoveCamera
import org.deepholm.skullofzule.commands.MoveTo
import org.deepholm.skullofzule.extensions.GameCommand
import org.deepholm.skullofzule.position
import org.hexworks.amethyst.api.CommandResponse
import org.hexworks.amethyst.api.Consumed
import org.hexworks.amethyst.api.Pass
import org.hexworks.amethyst.api.Response
import org.hexworks.amethyst.api.base.BaseFacet
import org.hexworks.amethyst.api.entity.EntityType

object Movable : BaseFacet<GameContext>() {

    override fun executeCommand(command: GameCommand<out EntityType>) =
            command.responseWhenCommandIs(MoveTo::class) { (context, entity, position) ->
                val world = context.world
                val previousPosition = entity.position
                var result: Response = Pass
                if (world.moveEntity(entity, position)) {
                    result = if (entity.type == Player) {
                        CommandResponse(MoveCamera(
                                context = context,
                                source = entity,
                                previousPosition = previousPosition))
                    } else Consumed
                }
                result
            }
}