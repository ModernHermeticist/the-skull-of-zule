package org.deepholm.skullofzule.systems

import org.deepholm.skullofzule.GameContext
import org.deepholm.skullofzule.attributes.types.combatStats
import org.deepholm.skullofzule.commands.Attack
import org.deepholm.skullofzule.commands.Destroy
import org.deepholm.skullofzule.extensions.GameCommand
import org.deepholm.skullofzule.functions.logGameEvent
import org.deepholm.skullofzule.isPlayer
import org.deepholm.skullofzule.whenHasNoHealthLeft
import org.hexworks.amethyst.api.Consumed
import org.hexworks.amethyst.api.Pass
import org.hexworks.amethyst.api.base.BaseFacet
import org.hexworks.amethyst.api.entity.EntityType

object Attackable : BaseFacet<GameContext>() {

    override fun executeCommand(command: GameCommand<out EntityType>) = command.responseWhenCommandIs(Attack::class) {(context, attacker, target) ->
        if (attacker.isPlayer || target.isPlayer) {
            val damage = Math.max(0, attacker.combatStats.attackValue - target.combatStats.defenseValue)
            val finalDamage = (Math.random() * damage).toInt() + 1
            target.combatStats.hp -= finalDamage
            logGameEvent("The $attacker hits the $target for $finalDamage!")
            target.whenHasNoHealthLeft {
                target.executeCommand(Destroy(
                        context = context,
                        source = attacker,
                        target = target,
                        cause = "a blow to the head"
                ))
            }
            Consumed
        }
        else Pass
    }
}