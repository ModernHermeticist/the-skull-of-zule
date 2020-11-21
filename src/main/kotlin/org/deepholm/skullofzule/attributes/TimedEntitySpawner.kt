package org.deepholm.skullofzule.attributes

import org.deepholm.skullofzule.extensions.GameEntity
import org.hexworks.amethyst.api.Attribute
import org.hexworks.amethyst.api.entity.EntityType

data class TimedEntitySpawner(val entity: () -> GameEntity<EntityType>,
                              val maximumTurnsProperty: Int,
                              var turnsPassed: Int,
                              val chanceToSpawn: Int): Attribute