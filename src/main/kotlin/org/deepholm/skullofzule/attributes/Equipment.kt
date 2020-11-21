package org.deepholm.skullofzule.attributes

import org.deepholm.skullofzule.attributes.flags.EmptyItem
import org.deepholm.skullofzule.attributes.types.*
import org.deepholm.skullofzule.extensions.*
import org.deepholm.skullofzule.extensions.attackValue
import org.hexworks.amethyst.api.entity.EntityType
import org.hexworks.cobalt.databinding.api.createPropertyFrom
import org.hexworks.cobalt.databinding.api.property.Property
import org.hexworks.zircon.api.Components
import org.hexworks.zircon.api.component.Component
import kotlin.reflect.KFunction
import kotlin.reflect.KProperty1
import kotlin.reflect.full.memberFunctions
import kotlin.reflect.full.memberProperties
import kotlin.reflect.jvm.reflect

class Equipment(initialWeapon: GameEntity<Weapon>,
                initialChestArmor: GameEntity<ChestArmor>,
                initialLegArmor: GameEntity<LegArmor>,
                initialHeadArmor: GameEntity<HeadArmor>,
                initialHandArmor: GameEntity<HandArmor>,
                initialFeetArmor: GameEntity<FeetArmor>,
                initialShoulderArmor: GameEntity<ShoulderArmor>,
                initialWaistArmor: GameEntity<WaistArmor>,
                initialBackArmor: GameEntity<BackArmor>,
                initialLeftRing: GameEntity<Ring>,
                initialRightRing: GameEntity<Ring>,
                initialLeftEarring: GameEntity<Earring>,
                initialRightEarring: GameEntity<Earring>,
                initialRelic: GameEntity<Relic>) : DisplayableAttribute {

    private val weaponProperty: Property<GameEntity<Weapon>> = createPropertyFrom(initialWeapon)
    private val chestArmorProperty: Property<GameEntity<ChestArmor>> = createPropertyFrom(initialChestArmor)

    val attackValue: Int
        get() = weaponProperty.value.attackValue + chestArmorProperty.value.attackValue

    val defenseValue: Int
        get() = weaponProperty.value.defenseValue + chestArmorProperty.value.defenseValue

    val armorName: String
        get() = chestArmorProperty.value.name

    val weaponName: String
        get() = weaponProperty.value.name


    private val weapon: GameEntity<Weapon> by weaponProperty.asDelegate()
    private val armor: GameEntity<Armor> by chestArmorProperty.asDelegate()

    private val weaponStats: String
        get() = " A: ${weapon.attackValue} D: ${weapon.defenseValue}"

    private val armorStats: String
        get() = " A: ${armor.attackValue} D: ${armor.defenseValue}"

    fun equip(inventory: Inventory, combatItem: GameCombatItem): GameCombatItem {
        combatItem.whenTypeIs<Weapon> {
            return equipWeapon(inventory, it)
        }
        combatItem.whenTypeIs<ChestArmor> {
            return equipArmor(inventory, it)
        }
        throw IllegalStateException("Combat item is not Weapon or Armor.")
    }

    private fun equipWeapon(inventory: Inventory, newWeapon: GameEntity<Weapon>): GameCombatItem {
        val oldWeapon = weapon
        inventory.removeItem(newWeapon)
        inventory.addItem(oldWeapon)
        weaponProperty.value = newWeapon
        return oldWeapon
    }

    private fun equipArmor(inventory: Inventory, newArmor: GameEntity<ChestArmor>): GameCombatItem {
        val oldArmor = armor
        inventory.removeItem(newArmor)
        if (!oldArmor.isEmptyItem) inventory.addItem(oldArmor)
        chestArmorProperty.value = newArmor
        return oldArmor
    }

    override fun toComponent(width: Int): Component {
        val weaponIcon = Components.icon().withIcon(weaponProperty.value.iconTile).build()
        val weaponNameLabel = Components.label()
                .withText(weaponName)
                .withSize(width - 2, 1)
                .build()
        val weaponStatsLabel = Components.label()
                .withText(weaponStats)
                .withSize(width - 1, 1)
                .build()

        val armorIcon = Components.icon().withIcon(chestArmorProperty.value.iconTile).build()
        val armorNameLabel = Components.label()
                .withText(armorName)
                .withSize(width - 2, 1)
                .build()
        val armorStatsLabel = Components.label()
                .withText(armorStats)
                .withSize(width - 1, 1)
                .build()

        weaponProperty.onChange {
            weaponIcon.iconProperty.value = weapon.iconTile
            weaponNameLabel.textProperty.value = weapon.name
            weaponStatsLabel.textProperty.value = weaponStats
        }

        chestArmorProperty.onChange {
            armorIcon.iconProperty.value = armor.iconTile
            armorNameLabel.textProperty.value = armor.name
            armorStatsLabel.textProperty.value = armorStats
        }

        return Components.textBox(width)
                .addHeader("Weapon", withNewLine = false)
                .addInlineComponent(weaponIcon)
                .addInlineComponent(weaponNameLabel)
                .commitInlineElements()
                .addInlineComponent(weaponStatsLabel)
                .commitInlineElements()
                .addNewLine()
                .addHeader("Armor", withNewLine = false)
                .addInlineComponent(armorIcon)
                .addInlineComponent(armorNameLabel)
                .commitInlineElements()
                .addInlineComponent(armorStatsLabel)
                .commitInlineElements()
                .build()
    }
}