package org.deepholm.skullofzule.systems

import org.deepholm.skullofzule.GameContext
import org.deepholm.skullofzule.builders.ZombieEntityFactory
import org.deepholm.skullofzule.commands.Destroy
import org.deepholm.skullofzule.extensions.GameCommand
import org.deepholm.skullofzule.extensions.position
import org.deepholm.skullofzule.functions.logGameEvent
import org.hexworks.amethyst.api.Pass
import org.hexworks.amethyst.api.base.BaseFacet
import org.hexworks.amethyst.api.entity.EntityType

object DivideZombie : BaseFacet<GameContext>() {

    override fun executeCommand(command: GameCommand<out EntityType>) = command.responseWhenCommandIs(Destroy::class) { (context, attacker, target, cause) ->
        context.world.addEntity(ZombieEntityFactory.newSporeling(), target.position.withRelativeX(1))
        context.world.addEntity(ZombieEntityFactory.newSporeling(), target.position.withRelativeX(-1))
        context.world.addEntity(ZombieEntityFactory.newSporeling(), target.position.withRelativeY(1))
        context.world.addEntity(ZombieEntityFactory.newSporeling(), target.position.withRelativeY(-1))
        logGameEvent("Necrospores erupt out of the $target!")
        Pass
    }
}