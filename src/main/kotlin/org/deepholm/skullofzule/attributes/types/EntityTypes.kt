package org.deepholm.skullofzule.attributes.types

import org.hexworks.amethyst.api.base.BaseEntityType

object Player : BaseEntityType(name = "player"),
        Combatant, ItemHolder, EnergyUser, EquipmentHolder, ExperienceGainer, GoldPieceHolder

object Wall: BaseEntityType(name = "wall")

object Fungus: BaseEntityType(name = "fungus"), Combatant

object StairsDown : BaseEntityType(name="stairs down")
object StairsUp : BaseEntityType(name="stairs up")

object FogOfWarType : BaseEntityType()

object Bat : BaseEntityType(name = "bat"), Combatant, ItemHolder

object Tin : BaseEntityType(
        name = "Tin",
        description = "A small piece of Tin. What might one do with such a thing?"), Item

object GoldPiece: BaseEntityType(
        name = "Gold Piece",
        description = "A single gold piece. May be used to amass the wealth of nations."), Item

object BatMeat : BaseEntityType(
        name = "Bat Meat",
        description = "Stringy bat meat. It is edible, but not tasty."), Food

object Dagger : BaseEntityType(
        name = "Rusty Dagger",
        description = "A small, rusty dagger made of some metal alloy."), Weapon

object Sword : BaseEntityType(
        name = "Iron Sword",
        description = "A shiny sword made of iron. It is a two-hand weapon"), Weapon

object Staff : BaseEntityType(
        name = "Wooden Staff",
        description = "A wooden staff made of birch. It has seen some use"), Weapon

object LightArmor : BaseEntityType(
        name = "Leather Tunic",
        description = "A tunic made of rugged leather. It is very comfortable."), ChestArmor

object MediumArmor : BaseEntityType(
        name = "Chainmail",
        description = "A sturdy chainmail armor made of interlocking iron chains."), ChestArmor

object HeavyArmor : BaseEntityType(
        name = "Platemail",
        description = "A heavy and shiny platemail armor made of bronze."), ChestArmor

object Club : BaseEntityType(
        name = "Club",
        description = "A wooden club. It doesn't give you an edge over your opponent (haha)."), Weapon

object Jacket : BaseEntityType(
        name = "Leather Jacket",
        description = "Dirty and rugged jacket made of leather."), ChestArmor

object EmptyChestArmor : BaseEntityType(
        name = "",
        description = ""), EmptyChestArmorHolder

object EmptyLegArmor : BaseEntityType(
        name = "",
        description = ""), EmptyLegArmorHolder

object EmptyHeadArmor : BaseEntityType(
        name = "",
        description = ""), EmptyHeadArmorHolder

object EmptyHandArmor : BaseEntityType(
        name = "",
        description = ""), EmptyHandArmorHolder

object EmptyFeetArmor : BaseEntityType(
        name = "",
        description = ""), EmptyFeetArmorHolder

object EmptyShoulderArmor : BaseEntityType(
        name = "",
        description = ""), EmptyShoulderArmorHolder

object EmptyWaistArmor : BaseEntityType(
        name = "",
        description = ""), EmptyWaistArmorHolder

object EmptyBackArmor : BaseEntityType(
        name = "",
        description = ""), EmptyBackArmorHolder

object EmptyRing : BaseEntityType(
        name = "",
        description = ""), EmptyRingHolder

object EmptyEarring : BaseEntityType(
        name = "",
        description = ""), EmptyEarringHolder

object EmptyRelic : BaseEntityType(
        name = "",
        description = ""), EmptyRelicHolder