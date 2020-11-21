package org.deepholm.skullofzule.attributes

import org.hexworks.zircon.api.Components
import org.hexworks.zircon.api.component.Component

data class ItemCombatStats(val attackValue: Int = 0,
                            val defenseValue: Int = 0,
                           val strengthValue: Int = 0,
                           val dexterityValue: Int = 0,
                           val staminaValue: Int = 0,
                           val intelligenceValue: Int = 0,
                           val wisdomValue: Int = 0,
                           val constitutionValue: Int = 0,
                            val combatItemType: String) : DisplayableAttribute {

    override fun toComponent(width: Int): Component {
        return Components.textBox(width)
                .addParagraph("Type: $combatItemType", withNewLine = false)
                .addParagraph("Attack: $attackValue", withNewLine = false)
                .addParagraph("Defense: $defenseValue", withNewLine = false)
                .build()
    }
}