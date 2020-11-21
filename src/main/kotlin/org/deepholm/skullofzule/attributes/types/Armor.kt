package org.deepholm.skullofzule.attributes.types

import org.deepholm.skullofzule.GameContext
import org.deepholm.skullofzule.attributes.ItemCombatStats
import org.hexworks.amethyst.api.entity.Entity

interface Armor : CombatItem {

    val Entity<Armor, GameContext>.attackValue: Int

    val Entity<Armor, GameContext>.defenseValue: Int

    val Entity<Armor, GameContext>.strengthValue: Int

    val Entity<Armor, GameContext>.dexterityValue: Int

    val Entity<Armor, GameContext>.staminaValue: Int

    val Entity<Armor, GameContext>.intelligenceValue: Int

    val Entity<Armor, GameContext>.wisdomValue: Int

    val Entity<Armor, GameContext>.constitutionValue: Int

}

interface EmptyChestArmorHolder: ChestArmor
interface EmptyLegArmorHolder: LegArmor
interface EmptyHeadArmorHolder: HeadArmor
interface EmptyHandArmorHolder: HandArmor
interface EmptyFeetArmorHolder: FeetArmor
interface EmptyShoulderArmorHolder: ShoulderArmor
interface EmptyWaistArmorHolder: WaistArmor
interface EmptyBackArmorHolder: BackArmor
interface EmptyRingHolder: Ring
interface EmptyEarringHolder: Earring
interface EmptyRelicHolder: Relic

interface ChestArmor: Armor {

    override val Entity<Armor, GameContext>.attackValue: Int
        get() = findAttribute(ItemCombatStats::class).get().attackValue

    override val Entity<Armor, GameContext>.defenseValue: Int
        get() = findAttribute(ItemCombatStats::class).get().defenseValue

    override val Entity<Armor, GameContext>.strengthValue: Int
        get() = findAttribute(ItemCombatStats::class).get().strengthValue

    override val Entity<Armor, GameContext>.dexterityValue: Int
        get() = findAttribute(ItemCombatStats::class).get().dexterityValue

    override val Entity<Armor, GameContext>.staminaValue: Int
        get() = findAttribute(ItemCombatStats::class).get().staminaValue

    override val Entity<Armor, GameContext>.intelligenceValue: Int
        get() = findAttribute(ItemCombatStats::class).get().intelligenceValue

    override val Entity<Armor, GameContext>.wisdomValue: Int
        get() = findAttribute(ItemCombatStats::class).get().wisdomValue

    override val Entity<Armor, GameContext>.constitutionValue: Int
        get() = findAttribute(ItemCombatStats::class).get().constitutionValue
}

interface LegArmor: Armor {

    override val Entity<Armor, GameContext>.attackValue: Int
        get() = findAttribute(ItemCombatStats::class).get().attackValue

    override val Entity<Armor, GameContext>.defenseValue: Int
        get() = findAttribute(ItemCombatStats::class).get().defenseValue

    override val Entity<Armor, GameContext>.strengthValue: Int
        get() = findAttribute(ItemCombatStats::class).get().strengthValue

    override val Entity<Armor, GameContext>.dexterityValue: Int
        get() = findAttribute(ItemCombatStats::class).get().dexterityValue

    override val Entity<Armor, GameContext>.staminaValue: Int
        get() = findAttribute(ItemCombatStats::class).get().staminaValue

    override val Entity<Armor, GameContext>.intelligenceValue: Int
        get() = findAttribute(ItemCombatStats::class).get().intelligenceValue

    override val Entity<Armor, GameContext>.wisdomValue: Int
        get() = findAttribute(ItemCombatStats::class).get().wisdomValue

    override val Entity<Armor, GameContext>.constitutionValue: Int
        get() = findAttribute(ItemCombatStats::class).get().constitutionValue
}

interface HeadArmor: Armor {

    override val Entity<Armor, GameContext>.attackValue: Int
        get() = findAttribute(ItemCombatStats::class).get().attackValue

    override val Entity<Armor, GameContext>.defenseValue: Int
        get() = findAttribute(ItemCombatStats::class).get().defenseValue

    override val Entity<Armor, GameContext>.strengthValue: Int
        get() = findAttribute(ItemCombatStats::class).get().strengthValue

    override val Entity<Armor, GameContext>.dexterityValue: Int
        get() = findAttribute(ItemCombatStats::class).get().dexterityValue

    override val Entity<Armor, GameContext>.staminaValue: Int
        get() = findAttribute(ItemCombatStats::class).get().staminaValue

    override val Entity<Armor, GameContext>.intelligenceValue: Int
        get() = findAttribute(ItemCombatStats::class).get().intelligenceValue

    override val Entity<Armor, GameContext>.wisdomValue: Int
        get() = findAttribute(ItemCombatStats::class).get().wisdomValue

    override val Entity<Armor, GameContext>.constitutionValue: Int
        get() = findAttribute(ItemCombatStats::class).get().constitutionValue
}

interface HandArmor: Armor {

    override val Entity<Armor, GameContext>.attackValue: Int
        get() = findAttribute(ItemCombatStats::class).get().attackValue

    override val Entity<Armor, GameContext>.defenseValue: Int
        get() = findAttribute(ItemCombatStats::class).get().defenseValue

    override val Entity<Armor, GameContext>.strengthValue: Int
        get() = findAttribute(ItemCombatStats::class).get().strengthValue

    override val Entity<Armor, GameContext>.dexterityValue: Int
        get() = findAttribute(ItemCombatStats::class).get().dexterityValue

    override val Entity<Armor, GameContext>.staminaValue: Int
        get() = findAttribute(ItemCombatStats::class).get().staminaValue

    override val Entity<Armor, GameContext>.intelligenceValue: Int
        get() = findAttribute(ItemCombatStats::class).get().intelligenceValue

    override val Entity<Armor, GameContext>.wisdomValue: Int
        get() = findAttribute(ItemCombatStats::class).get().wisdomValue

    override val Entity<Armor, GameContext>.constitutionValue: Int
        get() = findAttribute(ItemCombatStats::class).get().constitutionValue
}

interface FeetArmor: Armor {

    override val Entity<Armor, GameContext>.attackValue: Int
        get() = findAttribute(ItemCombatStats::class).get().attackValue

    override val Entity<Armor, GameContext>.defenseValue: Int
        get() = findAttribute(ItemCombatStats::class).get().defenseValue

    override val Entity<Armor, GameContext>.strengthValue: Int
        get() = findAttribute(ItemCombatStats::class).get().strengthValue

    override val Entity<Armor, GameContext>.dexterityValue: Int
        get() = findAttribute(ItemCombatStats::class).get().dexterityValue

    override val Entity<Armor, GameContext>.staminaValue: Int
        get() = findAttribute(ItemCombatStats::class).get().staminaValue

    override val Entity<Armor, GameContext>.intelligenceValue: Int
        get() = findAttribute(ItemCombatStats::class).get().intelligenceValue

    override val Entity<Armor, GameContext>.wisdomValue: Int
        get() = findAttribute(ItemCombatStats::class).get().wisdomValue

    override val Entity<Armor, GameContext>.constitutionValue: Int
        get() = findAttribute(ItemCombatStats::class).get().constitutionValue
}

interface ShoulderArmor: Armor {

    override val Entity<Armor, GameContext>.attackValue: Int
        get() = findAttribute(ItemCombatStats::class).get().attackValue

    override val Entity<Armor, GameContext>.defenseValue: Int
        get() = findAttribute(ItemCombatStats::class).get().defenseValue

    override val Entity<Armor, GameContext>.strengthValue: Int
        get() = findAttribute(ItemCombatStats::class).get().strengthValue

    override val Entity<Armor, GameContext>.dexterityValue: Int
        get() = findAttribute(ItemCombatStats::class).get().dexterityValue

    override val Entity<Armor, GameContext>.staminaValue: Int
        get() = findAttribute(ItemCombatStats::class).get().staminaValue

    override val Entity<Armor, GameContext>.intelligenceValue: Int
        get() = findAttribute(ItemCombatStats::class).get().intelligenceValue

    override val Entity<Armor, GameContext>.wisdomValue: Int
        get() = findAttribute(ItemCombatStats::class).get().wisdomValue

    override val Entity<Armor, GameContext>.constitutionValue: Int
        get() = findAttribute(ItemCombatStats::class).get().constitutionValue
}

interface WaistArmor: Armor {

    override val Entity<Armor, GameContext>.attackValue: Int
        get() = findAttribute(ItemCombatStats::class).get().attackValue

    override val Entity<Armor, GameContext>.defenseValue: Int
        get() = findAttribute(ItemCombatStats::class).get().defenseValue

    override val Entity<Armor, GameContext>.strengthValue: Int
        get() = findAttribute(ItemCombatStats::class).get().strengthValue

    override val Entity<Armor, GameContext>.dexterityValue: Int
        get() = findAttribute(ItemCombatStats::class).get().dexterityValue

    override val Entity<Armor, GameContext>.staminaValue: Int
        get() = findAttribute(ItemCombatStats::class).get().staminaValue

    override val Entity<Armor, GameContext>.intelligenceValue: Int
        get() = findAttribute(ItemCombatStats::class).get().intelligenceValue

    override val Entity<Armor, GameContext>.wisdomValue: Int
        get() = findAttribute(ItemCombatStats::class).get().wisdomValue

    override val Entity<Armor, GameContext>.constitutionValue: Int
        get() = findAttribute(ItemCombatStats::class).get().constitutionValue
}

interface BackArmor: Armor {

    override val Entity<Armor, GameContext>.attackValue: Int
        get() = findAttribute(ItemCombatStats::class).get().attackValue

    override val Entity<Armor, GameContext>.defenseValue: Int
        get() = findAttribute(ItemCombatStats::class).get().defenseValue

    override val Entity<Armor, GameContext>.strengthValue: Int
        get() = findAttribute(ItemCombatStats::class).get().strengthValue

    override val Entity<Armor, GameContext>.dexterityValue: Int
        get() = findAttribute(ItemCombatStats::class).get().dexterityValue

    override val Entity<Armor, GameContext>.staminaValue: Int
        get() = findAttribute(ItemCombatStats::class).get().staminaValue

    override val Entity<Armor, GameContext>.intelligenceValue: Int
        get() = findAttribute(ItemCombatStats::class).get().intelligenceValue

    override val Entity<Armor, GameContext>.wisdomValue: Int
        get() = findAttribute(ItemCombatStats::class).get().wisdomValue

    override val Entity<Armor, GameContext>.constitutionValue: Int
        get() = findAttribute(ItemCombatStats::class).get().constitutionValue
}

interface Ring: Armor {

    override val Entity<Armor, GameContext>.attackValue: Int
        get() = findAttribute(ItemCombatStats::class).get().attackValue

    override val Entity<Armor, GameContext>.defenseValue: Int
        get() = findAttribute(ItemCombatStats::class).get().defenseValue

    override val Entity<Armor, GameContext>.strengthValue: Int
        get() = findAttribute(ItemCombatStats::class).get().strengthValue

    override val Entity<Armor, GameContext>.dexterityValue: Int
        get() = findAttribute(ItemCombatStats::class).get().dexterityValue

    override val Entity<Armor, GameContext>.staminaValue: Int
        get() = findAttribute(ItemCombatStats::class).get().staminaValue

    override val Entity<Armor, GameContext>.intelligenceValue: Int
        get() = findAttribute(ItemCombatStats::class).get().intelligenceValue

    override val Entity<Armor, GameContext>.wisdomValue: Int
        get() = findAttribute(ItemCombatStats::class).get().wisdomValue

    override val Entity<Armor, GameContext>.constitutionValue: Int
        get() = findAttribute(ItemCombatStats::class).get().constitutionValue
}

interface Earring: Armor {

    override val Entity<Armor, GameContext>.attackValue: Int
        get() = findAttribute(ItemCombatStats::class).get().attackValue

    override val Entity<Armor, GameContext>.defenseValue: Int
        get() = findAttribute(ItemCombatStats::class).get().defenseValue

    override val Entity<Armor, GameContext>.strengthValue: Int
        get() = findAttribute(ItemCombatStats::class).get().strengthValue

    override val Entity<Armor, GameContext>.dexterityValue: Int
        get() = findAttribute(ItemCombatStats::class).get().dexterityValue

    override val Entity<Armor, GameContext>.staminaValue: Int
        get() = findAttribute(ItemCombatStats::class).get().staminaValue

    override val Entity<Armor, GameContext>.intelligenceValue: Int
        get() = findAttribute(ItemCombatStats::class).get().intelligenceValue

    override val Entity<Armor, GameContext>.wisdomValue: Int
        get() = findAttribute(ItemCombatStats::class).get().wisdomValue

    override val Entity<Armor, GameContext>.constitutionValue: Int
        get() = findAttribute(ItemCombatStats::class).get().constitutionValue
}

interface Relic: Armor {

    override val Entity<Armor, GameContext>.attackValue: Int
        get() = findAttribute(ItemCombatStats::class).get().attackValue

    override val Entity<Armor, GameContext>.defenseValue: Int
        get() = findAttribute(ItemCombatStats::class).get().defenseValue

    override val Entity<Armor, GameContext>.strengthValue: Int
        get() = findAttribute(ItemCombatStats::class).get().strengthValue

    override val Entity<Armor, GameContext>.dexterityValue: Int
        get() = findAttribute(ItemCombatStats::class).get().dexterityValue

    override val Entity<Armor, GameContext>.staminaValue: Int
        get() = findAttribute(ItemCombatStats::class).get().staminaValue

    override val Entity<Armor, GameContext>.intelligenceValue: Int
        get() = findAttribute(ItemCombatStats::class).get().intelligenceValue

    override val Entity<Armor, GameContext>.wisdomValue: Int
        get() = findAttribute(ItemCombatStats::class).get().wisdomValue

    override val Entity<Armor, GameContext>.constitutionValue: Int
        get() = findAttribute(ItemCombatStats::class).get().constitutionValue
}