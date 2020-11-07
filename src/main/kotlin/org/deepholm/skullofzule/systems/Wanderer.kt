package org.deepholm.skullofzule.systems

import org.deepholm.skullofzule.GameContext
import org.deepholm.skullofzule.commands.MoveTo
import org.deepholm.skullofzule.extensions.GameEntity
import org.deepholm.skullofzule.position
import org.deepholm.skullofzule.sameLevelNeighborsShuffled
import org.hexworks.amethyst.api.base.BaseBehavior
import org.hexworks.amethyst.api.entity.EntityType

object Wanderer : BaseBehavior<GameContext>() {

    override fun update(entity: GameEntity<EntityType>, context: GameContext): Boolean {
        val pos = entity.position
        if (pos.isUnknown().not()) {
            entity.executeCommand(MoveTo(
                    context = context,
                    source = entity,
                    position = pos.sameLevelNeighborsShuffled().first()
            ))
            return true
        }
        return false
    }
}