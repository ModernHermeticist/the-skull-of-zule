package org.deepholm.skullofzule.systems

import org.deepholm.skullofzule.GameContext
import org.deepholm.skullofzule.attributes.TurnTracker
import org.deepholm.skullofzule.extensions.GameEntity
import org.deepholm.skullofzule.extensions.tryToFindAttribute
import org.hexworks.amethyst.api.base.BaseBehavior
import org.hexworks.amethyst.api.entity.EntityType

object TurnCounter: BaseBehavior<GameContext>(TurnTracker::class) {

    override fun update(entity: GameEntity<out EntityType>, context: GameContext): Boolean {
        val turnTracker = entity.tryToFindAttribute(TurnTracker::class)
        turnTracker.turnCount++
        return true
    }
}