package org.deepholm.skullofzule

import org.deepholm.skullofzule.attributes.types.Player
import org.deepholm.skullofzule.extensions.GameEntity
import org.deepholm.skullofzule.world.World
import org.hexworks.amethyst.api.Context
import org.hexworks.zircon.api.screen.Screen
import org.hexworks.zircon.api.uievent.UIEvent

data class GameContext(val world: World,
                       val screen: Screen,
                       val uiEvent: UIEvent,
                       val player: GameEntity<Player>) : Context
