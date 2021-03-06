package org.deepholm.skullofzule.systems

import org.deepholm.skullofzule.GameContext
import org.deepholm.skullofzule.commands.MoveTo
import org.deepholm.skullofzule.extensions.GameEntity
import org.deepholm.skullofzule.extensions.position
import org.hexworks.amethyst.api.base.BaseBehavior
import org.hexworks.amethyst.api.entity.EntityType
import org.hexworks.zircon.api.Positions

object HunterSeeker : BaseBehavior<GameContext>() {

    override fun update(entity: GameEntity<out EntityType>, context: GameContext): Boolean {
        val (world, _, _, player) = context
        var hunted = false
        world.whenCanSee(entity, player) {path ->
            entity.executeCommand(MoveTo(
                    context = context,
                    source = entity,
                    position = Positions.from2DTo3D(path.iterator().next(), player.position.z)))
            hunted = true
        }
        return hunted
    }
}