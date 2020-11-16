package org.deepholm.skullofzule.systems

import org.deepholm.skullofzule.GameContext
import org.deepholm.skullofzule.builders.ZombieEntityFactory
import org.deepholm.skullofzule.commands.Destroy
import org.deepholm.skullofzule.commands.Spawn
import org.deepholm.skullofzule.extensions.AnyGameEntity
import org.deepholm.skullofzule.extensions.GameCommand
import org.deepholm.skullofzule.extensions.GameEntity
import org.deepholm.skullofzule.extensions.position
import org.deepholm.skullofzule.functions.logGameEvent
import org.hexworks.amethyst.api.Consumed
import org.hexworks.amethyst.api.Pass
import org.hexworks.amethyst.api.base.BaseFacet
import org.hexworks.amethyst.api.entity.EntityType
import org.hexworks.zircon.api.data.impl.Position3D

object Spawner : BaseFacet<GameContext>() {

    override fun executeCommand(command: GameCommand<out EntityType>) = command.responseWhenCommandIs(Spawn::class) { (context, source,
        entityToSpawn, numberToSpawn) ->
        (0..numberToSpawn).forEach { _ ->
            val x = (Math.random() * 2 - 1).toInt()
            val y = (Math.random() * 2 - 1).toInt()
            context.world.addEntity(entityToSpawn, source.position.withRelative(Position3D.create(x, y, source.position.z)))
        }
        logGameEvent("$entityToSpawn erupt out of the $source!")
        Consumed
    }
}