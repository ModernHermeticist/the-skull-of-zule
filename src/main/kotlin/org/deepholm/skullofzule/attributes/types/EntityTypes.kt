package org.deepholm.skullofzule.attributes.types

import org.hexworks.amethyst.api.base.BaseEntityType

object Player : BaseEntityType(name = "player"), Combatant, ItemHolder

object Wall: BaseEntityType(name = "wall")

object Fungus: BaseEntityType(name = "fungus"), Combatant

object StairsDown : BaseEntityType(name="stairs down")
object StairsUp : BaseEntityType(name="stairs up")

object FogOfWarType : BaseEntityType()

object Bat : BaseEntityType(name = "bat"), Combatant

object Tin : BaseEntityType(
        name = "Tin",
        description = "A small piece of Tin. What might one do with such a thing?"), Item