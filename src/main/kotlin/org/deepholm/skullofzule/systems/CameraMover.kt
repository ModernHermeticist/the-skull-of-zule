package org.deepholm.skullofzule.systems

import org.deepholm.skullofzule.GameContext
import org.deepholm.skullofzule.commands.MoveCamera
import org.deepholm.skullofzule.extensions.GameCommand
import org.deepholm.skullofzule.position
import org.hexworks.amethyst.api.Consumed
import org.hexworks.amethyst.api.base.BaseFacet
import org.hexworks.amethyst.api.entity.EntityType

object CameraMover : BaseFacet<GameContext>() {

    override fun executeCommand(command: GameCommand<out EntityType>) =
            command.responseWhenCommandIs(MoveCamera::class) { cmd ->
                val(context, source, previousPosition) = cmd
                val world = context.world
                val screenPos = source.position - world.visibleOffset()
                val halfHeight = world.visibleSize().yLength / 2
                val halfWidth = world.visibleSize().xLength / 2
                val currentPosition = source.position
                when {                                                      // 3
                    previousPosition.y > currentPosition.y && screenPos.y < halfHeight -> {
                        world.scrollOneBackward()
                    }
                    previousPosition.y < currentPosition.y && screenPos.y > halfHeight -> {
                        world.scrollOneForward()
                    }
                    previousPosition.x > currentPosition.x && screenPos.x < halfWidth -> {
                        world.scrollOneLeft()
                    }
                    previousPosition.x < currentPosition.x && screenPos.x > halfWidth -> {
                        world.scrollOneRight()
                    }
                }
                Consumed
            }
}