package org.deepholm.skullofzule.world

import org.deepholm.skullofzule.attributes.types.Player
import org.deepholm.skullofzule.extensions.GameEntity

class Game(val world: World,
           val player: GameEntity<Player>) {

    companion object {

        fun create(player: GameEntity<Player>,
                   world: World) = Game(
                world = world,
                player = player)
    }
}
