package org.deepholm.skullofzule.systems

import org.deepholm.skullofzule.GameContext
import org.deepholm.skullofzule.attributes.EnergyLevel
import org.deepholm.skullofzule.attributes.types.EnergyUser
import org.deepholm.skullofzule.attributes.types.energyLevel
import org.deepholm.skullofzule.commands.Destroy
import org.deepholm.skullofzule.commands.ExpendEnergy
import org.deepholm.skullofzule.extensions.GameCommand
import org.deepholm.skullofzule.extensions.GameEntity
import org.deepholm.skullofzule.extensions.whenTypeIs
import org.hexworks.amethyst.api.Consumed
import org.hexworks.amethyst.api.Response
import org.hexworks.amethyst.api.base.BaseActor
import org.hexworks.amethyst.api.entity.EntityType

object EnergyExpender : BaseActor<GameContext>(EnergyLevel::class) {

    override fun executeCommand(command: GameCommand<out EntityType>): Response {
        return command.responseWhenCommandIs(ExpendEnergy::class) { (context, entity, energy) ->
            entity.energyLevel.currentEnergy -= energy
            checkStarvation(context, entity, entity.energyLevel)
            Consumed
        }
    }

    override fun update(entity: GameEntity<EntityType>, context: GameContext): Boolean {
        entity.whenTypeIs<EnergyUser> {
            entity.executeCommand(ExpendEnergy(
                    context = context,
                    source = it,
                    energy = 2))
        }
        return true
    }

    private fun checkStarvation(context: GameContext,
                                entity: GameEntity<EntityType>,
                                energyLevel: EnergyLevel) {
        if (energyLevel.currentEnergy <= 0) {
            entity.executeCommand(Destroy(
                    context = context,
                    source = entity,
                    target = entity,
                    cause = "because of starvation"))
        }
    }
}