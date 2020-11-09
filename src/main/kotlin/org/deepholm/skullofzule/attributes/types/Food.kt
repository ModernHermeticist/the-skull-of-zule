package org.deepholm.skullofzule.attributes.types

import org.deepholm.skullofzule.attributes.NutritionalValue
import org.deepholm.skullofzule.extensions.GameEntity
import org.deepholm.skullofzule.tryToFindAttribute

interface Food : Item

val GameEntity<Food>.energy: Int
    get() = tryToFindAttribute(NutritionalValue::class).energy