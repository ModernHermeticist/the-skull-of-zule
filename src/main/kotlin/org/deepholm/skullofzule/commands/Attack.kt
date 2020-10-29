package org.deepholm.skullofzule.commands

import org.deepholm.skullofzule.GameContext
import org.deepholm.skullofzule.attributes.types.Combatant
import org.deepholm.skullofzule.extensions.GameEntity

data class Attack(override val context: GameContext,
                    override val source: GameEntity<Combatant>,
                    override val target: GameEntity<Combatant>) : EntityAction<Combatant, Combatant>