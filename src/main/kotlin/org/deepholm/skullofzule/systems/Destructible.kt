package org.deepholm.skullofzule.systems

import org.deepholm.skullofzule.GameContext
import org.deepholm.skullofzule.commands.Destroy
import org.deepholm.skullofzule.commands.EntityDestroyed
import org.deepholm.skullofzule.extensions.GameCommand
import org.deepholm.skullofzule.functions.logGameEvent
import org.hexworks.amethyst.api.Consumed
import org.hexworks.amethyst.api.base.BaseFacet
import org.hexworks.amethyst.api.entity.EntityType

object Destructible : BaseFacet<GameContext>() {

    override fun executeCommand(command: GameCommand<out EntityType>) = command.responseWhenCommandIs(Destroy::class) { (context, attacker, target, cause) ->
        context.world.removeEntity(target)
        attacker.executeCommand(EntityDestroyed(context, target, attacker))
        logGameEvent("$target dies $cause.")
        Consumed
    }
}