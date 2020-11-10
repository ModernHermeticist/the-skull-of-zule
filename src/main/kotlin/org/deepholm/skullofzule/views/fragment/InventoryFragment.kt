package org.deepholm.skullofzule.views.fragment

import org.deepholm.skullofzule.attributes.Inventory
import org.deepholm.skullofzule.commands.Eat
import org.deepholm.skullofzule.extensions.GameItem
import org.hexworks.zircon.api.Components
import org.hexworks.zircon.api.component.Fragment
import org.hexworks.zircon.api.extensions.handleComponentEvents
import org.hexworks.zircon.api.uievent.ComponentEventType
import org.hexworks.zircon.api.uievent.Processed

class InventoryFragment(inventory: Inventory,
                        width: Int,
                        onDrop: (GameItem) -> Unit,
                        onEat: (GameItem) -> Unit) : Fragment {

    override val root = Components.vbox().withSize(width, inventory.size + 1).build().apply {
        val list = this
        addComponent(Components.hbox().withSpacing(1).withSize(width, 1).build().apply {
            addComponent(Components.label().withText("").withSize(1, 1))
            addComponent(Components.header().withText("Name").withSize(NAME_COLUMN_WIDTH, 1))
            addComponent(Components.header().withText("Actions").withSize(ACTIONS_COLUMN_WIDTH, 1))
        })
        inventory.items.forEach { item ->
            addFragment(InventoryRowFragment(width, item).apply {
                dropButton.handleComponentEvents(ComponentEventType.ACTIVATED) {
                    list.removeComponent(this.root)
                    onDrop(item)
                    Processed
                }
                eatButton.handleComponentEvents(ComponentEventType.ACTIVATED) {
                    list.removeComponent(this.root)
                    onEat(item)
                    Processed
                }
            })
        }
    }

    companion object {
        const val NAME_COLUMN_WIDTH = 15
        const val ACTIONS_COLUMN_WIDTH = 10
    }
}