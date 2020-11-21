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
import org.hexworks.zircon.api.data.Size
import org.hexworks.zircon.api.data.impl.Position3D
import org.hexworks.zircon.api.data.impl.Size3D
import kotlin.random.Random

object Spawner : BaseFacet<GameContext>() {

    override fun executeCommand(command: GameCommand<out EntityType>) = command.responseWhenCommandIs(Spawn::class) { (context, source,
        entityToSpawn, numberToSpawn) ->
        (1..numberToSpawn).forEach { _ ->
            val x = Random.nextInt(1,4)
            val y = Random.nextInt(1,4)
            context.world.addAtEmptyPosition(entityToSpawn.get().invoke(), offset = source.position, size = Size3D.from2DSize(Size.create(x, y)))
            logGameEvent("$entityToSpawn erupts out of the $source!")
        }
        Consumed
    }
}