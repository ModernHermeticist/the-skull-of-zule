package org.deepholm.skullofzule.attributes

import org.deepholm.skullofzule.GameContext
import org.deepholm.skullofzule.commands.EntityAction
import org.deepholm.skullofzule.extensions.GameEntity
import org.hexworks.amethyst.api.Attribute
import org.hexworks.amethyst.api.entity.EntityType
import java.lang.IllegalArgumentException
import kotlin.reflect.KClass

class EntityActions(private vararg val actions: KClass<out EntityAction<out EntityType, out EntityType>>) : Attribute {

    fun createActionsFor(context: GameContext, source: GameEntity<EntityType>, target: GameEntity<EntityType>):
            Iterable<EntityAction<out EntityType, out EntityType>> {
        return actions.map {
            try {
                it.constructors.first().call(context, source, target)
            }
            catch(e: Exception) {
                throw IllegalArgumentException("Can't create EntityAction. Does it have the proper constructor?")
            }
        }
    }
}