package org.deepholm.skullofzule.systems

import org.deepholm.skullofzule.GameContext
import org.deepholm.skullofzule.attributes.EnergyLevel
import org.deepholm.skullofzule.attributes.types.energy
import org.deepholm.skullofzule.attributes.types.energyLevel
import org.deepholm.skullofzule.commands.Eat
import org.deepholm.skullofzule.extensions.GameCommand
import org.deepholm.skullofzule.functions.logGameEvent
import org.deepholm.skullofzule.extensions.isPlayer
import org.hexworks.amethyst.api.Consumed
import org.hexworks.amethyst.api.base.BaseFacet
import org.hexworks.amethyst.api.entity.EntityType

object DigestiveSystem: BaseFacet<GameContext>(EnergyLevel::class) {

    override fun executeCommand(command: GameCommand<out EntityType>) = command.responseWhenCommandIs(Eat::class) { (_, entity, food) ->
        entity.energyLevel.currentEnergy += food.energy
        val verb = if (entity.isPlayer) {
            "You eat"
        } else "The $entity eats"
        logGameEvent("$verb the $food.")
        Consumed
    }
}