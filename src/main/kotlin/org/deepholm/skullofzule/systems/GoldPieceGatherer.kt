package org.deepholm.skullofzule.systems

import org.deepholm.skullofzule.GameContext
import org.deepholm.skullofzule.attributes.GoldPieceCounter
import org.deepholm.skullofzule.attributes.types.GoldPiece
import org.deepholm.skullofzule.attributes.types.GoldPieceHolder
import org.deepholm.skullofzule.attributes.types.goldPieceCounter
import org.deepholm.skullofzule.commands.PickItemUp
import org.deepholm.skullofzule.extensions.whenTypeIs
import org.deepholm.skullofzule.functions.logGameEvent
import org.hexworks.amethyst.api.Command
import org.hexworks.amethyst.api.Consumed
import org.hexworks.amethyst.api.Pass
import org.hexworks.amethyst.api.Response
import org.hexworks.amethyst.api.base.BaseFacet
import org.hexworks.amethyst.api.entity.EntityType
import org.hexworks.cobalt.datatypes.extensions.map

object GoldPieceGatherer: BaseFacet<GameContext>(GoldPieceCounter::class) {

    override fun executeCommand(command: Command<out EntityType, GameContext>) = command.responseWhenCommandIs(PickItemUp::class) {
        val (context, source, position) = it
        var response: Response = Pass
        val world = context.world
        world.findTopItem(position).map { item ->
            source.whenTypeIs<GoldPieceHolder> { goldPieceHolder ->
                if (item.type == GoldPiece) {
                    goldPieceHolder.goldPieceCounter.goldPieceCount++
                    world.removeEntity(item)
                    logGameEvent("$goldPieceHolder picked up a Gold piece!")
                    response = Consumed
                }
            }
        }
        response
    }
}