package org.deepholm.skullofzule.attributes

import org.deepholm.skullofzule.extensions.toStringProperty
import org.hexworks.cobalt.databinding.api.createPropertyFrom
import org.hexworks.cobalt.databinding.api.expression.concat
import org.hexworks.zircon.api.Components

class EnergyLevel(initialEnergy: Int, val maxEnergy: Int) : DisplayableAttribute {

    var currentEnergy: Int
        get() = currentValueProperty.value
        set(value) {
            currentValueProperty.value = value.coerceAtMost(maxEnergy)
        }

    override fun toComponent(width: Int) = Components.vbox()
            .withSize(width, 5)
            .build().apply {
                val hungerLabel = Components.label()
                        .withSize(width, 1)
                        .build()

                hungerLabel.textProperty.updateFrom(currentValueProperty.toStringProperty()
                        .concat("/").concat(maxEnergy))

                addComponent(Components.textBox(width)
                        .addHeader("Hunger"))
                addComponent(hungerLabel)

            }

    private val currentValueProperty = createPropertyFrom(initialEnergy)
}