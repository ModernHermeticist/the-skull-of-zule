package org.deepholm.skullofzule.attributes

import org.hexworks.cobalt.databinding.api.createPropertyFrom
import org.hexworks.cobalt.databinding.api.expression.concat
import org.hexworks.cobalt.databinding.api.property.Property
import org.hexworks.zircon.api.Components
import org.hexworks.zircon.api.component.Component

data class TurnTracker(private val turnCounterProperty: Property<Int> = createPropertyFrom(0)): DisplayableAttribute {

    var turnCount: Int by turnCounterProperty.asDelegate()

    override fun toComponent(width: Int): Component {
        val turnCountProp = createPropertyFrom("Turn: ").concat(turnCounterProperty) { it.value.toString()}
        return Components.header()
                .withText(turnCountProp.value)
                .withSize(width, 1)
                .build().apply {
                    textProperty.updateFrom(turnCountProp)
                }
    }
}