package org.deepholm.skullofzule.systems

import org.deepholm.skullofzule.GameContext
import org.deepholm.skullofzule.attributes.TimedEntitySpawner
import org.deepholm.skullofzule.extensions.GameEntity
import org.deepholm.skullofzule.extensions.position
import org.deepholm.skullofzule.extensions.tryToFindAttribute
import org.hexworks.amethyst.api.base.BaseBehavior
import org.hexworks.amethyst.api.entity.EntityType
import org.hexworks.cobalt.datatypes.extensions.map
import org.hexworks.zircon.api.Sizes
import kotlin.random.Random

object TimedEntitySpawn: BaseBehavior<GameContext>(TimedEntitySpawner::class) {

    override fun update(entity: GameEntity<out EntityType>, context: GameContext): Boolean {
        val world = context.world
        val timedEntitySpawner = entity.tryToFindAttribute(TimedEntitySpawner::class)
        val (entityToSpawn, maxTurns, turnsPassed) = timedEntitySpawner
        return if (canSpawn(maxTurns, turnsPassed) && Random.nextInt(0,100) > 50) {
            world.findEmptyLocationWithin(
                    offset = entity.position
                            .withRelativeX(-1)
                            .withRelativeY(-1),
                    size = Sizes.create3DSize(3,3,0)).map { emptyLocation ->
                world.addEntity(entityToSpawn.invoke(), emptyLocation)
            }
            timedEntitySpawner.turnsPassed = 0
            true
        }
        else {
            timedEntitySpawner.turnsPassed++
            false
        }
    }

    private fun canSpawn(maxTurns: Int, turnsPassed: Int): Boolean = turnsPassed >= maxTurns
}