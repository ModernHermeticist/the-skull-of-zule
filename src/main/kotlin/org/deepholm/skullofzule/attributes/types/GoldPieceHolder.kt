package org.deepholm.skullofzule.attributes.types

import org.deepholm.skullofzule.attributes.GoldPieceCounter
import org.deepholm.skullofzule.extensions.GameEntity
import org.hexworks.amethyst.api.entity.EntityType

interface GoldPieceHolder: EntityType

val GameEntity<GoldPieceHolder>.goldPieceCounter: GoldPieceCounter
    get() = findAttribute(GoldPieceCounter::class).get()