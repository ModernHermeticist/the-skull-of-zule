package org.deepholm.skullofzule.attributes

import org.deepholm.skullofzule.extensions.GameEntity
import org.hexworks.amethyst.api.Attribute
import org.hexworks.amethyst.api.entity.EntityType
import org.hexworks.cobalt.databinding.api.createPropertyFrom
import org.hexworks.cobalt.databinding.api.property.Property

data class SpawnsOnDeath(val entityProperty: Property<() -> GameEntity<EntityType>>): Attribute {

    val entity: () -> GameEntity<EntityType> by entityProperty.asDelegate()

    companion object {

        fun create(entity: () -> GameEntity<EntityType>) =
                SpawnsOnDeath(entityProperty = createPropertyFrom(entity))
    }
}