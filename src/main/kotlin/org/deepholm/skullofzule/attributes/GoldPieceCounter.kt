package org.deepholm.skullofzule.attributes

import org.hexworks.cobalt.databinding.api.createPropertyFrom
import org.hexworks.cobalt.databinding.api.expression.concat
import org.hexworks.cobalt.databinding.api.property.Property
import org.hexworks.zircon.api.Components
import org.hexworks.zircon.api.component.Component

data class GoldPieceCounter(private val goldPieceCountProperty: Property<Int> = createPropertyFrom(0)): DisplayableAttribute {

    var goldPieceCount: Int by goldPieceCountProperty.asDelegate()

    override fun toComponent(width: Int): Component {
        val goldPieceProp = createPropertyFrom("Gold: ")
                .concat(goldPieceCountProperty) { it.value.toString() }
        return Components.header()
                .withText(goldPieceProp.value)
                .withSize(width, 1)
                .build().apply {
                    textProperty.updateFrom(goldPieceProp)
                }
    }
}