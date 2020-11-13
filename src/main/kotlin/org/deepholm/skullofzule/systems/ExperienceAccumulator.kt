package org.deepholm.skullofzule.systems

import org.deepholm.skullofzule.GameContext
import org.deepholm.skullofzule.attributes.CombatStats
import org.deepholm.skullofzule.attributes.types.ExperienceGainer
import org.deepholm.skullofzule.attributes.types.combatStats
import org.deepholm.skullofzule.attributes.types.experience
import org.deepholm.skullofzule.commands.EntityDestroyed
import org.deepholm.skullofzule.events.PlayerGainedLevel
import org.deepholm.skullofzule.extensions.*
import org.deepholm.skullofzule.functions.logGameEvent
import org.hexworks.amethyst.api.Consumed
import org.hexworks.amethyst.api.base.BaseFacet
import org.hexworks.amethyst.api.entity.EntityType
import org.hexworks.cobalt.datatypes.extensions.map
import org.hexworks.zircon.internal.Zircon
import kotlin.math.min
import kotlin.math.pow


object ExperienceAccumulator : BaseFacet<GameContext>() {

    override fun executeCommand(command: GameCommand<out EntityType>) = command.responseWhenCommandIs(EntityDestroyed::class) { (_, defender, attacker) ->
        attacker.whenTypeIs<ExperienceGainer> { experienceGainer ->   // 1
            val xp = experienceGainer.experience
            val stats = experienceGainer.combatStats
            val defenderHp = defender.findAttribute(CombatStats::class).map { it.maxHp }.orElse(0)          // 2
            val amount = (defenderHp + defender.attackValue + defender.defenseValue) - xp.currentLevel * 2    // 3
            if (amount > 0) {
                xp.currentXP += amount
                while (xp.currentXP > xp.currentLevel.toDouble().pow(1.5) * 20) {                 // 4
                    xp.currentLevel++
                    logGameEvent("$attacker advanced to level ${xp.currentLevel}.")
                    stats.hpProperty.value = min(stats.hp + xp.currentLevel * 2, stats.maxHp)           // 5
                    if (attacker.isPlayer) {
                        Zircon.eventBus.publish(PlayerGainedLevel)                                      // 6
                    }
                }
            }

        }
        Consumed
    }
}