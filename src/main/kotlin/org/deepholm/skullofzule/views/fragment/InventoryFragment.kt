package org.deepholm.skullofzule.views.fragment

import org.deepholm.skullofzule.attributes.Inventory
import org.deepholm.skullofzule.commands.Eat
import org.deepholm.skullofzule.config.GameConfig
import org.deepholm.skullofzule.extensions.GameItem
import org.deepholm.skullofzule.extensions.isEmptyItem
import org.hexworks.cobalt.datatypes.Maybe
import org.hexworks.cobalt.datatypes.extensions.map
import org.hexworks.zircon.api.Components
import org.hexworks.zircon.api.component.Fragment
import org.hexworks.zircon.api.component.VBox
import org.hexworks.zircon.api.extensions.handleComponentEvents
import org.hexworks.zircon.api.uievent.ComponentEventType
import org.hexworks.zircon.api.uievent.Processed

class InventoryFragment(inventory: Inventory,
                        width: Int,
                        private val onDrop: (GameItem) -> Unit,
                        private val onEat: (GameItem) -> Unit,
                        private val onEquip: (GameItem) -> Maybe<GameItem>,
                        private val onExamine: (GameItem) -> Unit) : Fragment {

    override val root = Components.vbox().withSize(width, inventory.size + 1).build().apply {
        val list = this
        addComponent(Components.hbox().withSpacing(1).withSize(width, 1).build().apply {
            addComponent(Components.label().withText("").withSize(1, 1))
            addComponent(Components.header().withText("Name").withSize(NAME_COLUMN_WIDTH, 1))
            addComponent(Components.header().withText("Actions").withSize(ACTIONS_COLUMN_WIDTH, 1))
        })
        inventory.items.forEach { item ->
            addRow(width, item, list)
        }
    }

    private fun addRow(width: Int, item: GameItem, list: VBox) {
        list.addFragment(InventoryRowFragment(width, item).apply {
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
            equipButton.handleComponentEvents(ComponentEventType.ACTIVATED) {
                onEquip(item).map { oldItem ->
                    list.removeComponent(this.root)
                    if (!oldItem.isEmptyItem) addRow(width, oldItem, list)
                }
                Processed
            }
            examineButton.handleComponentEvents(ComponentEventType.ACTIVATED) {
                onExamine(item)
                Processed
            }
        })
        list.applyColorTheme(GameConfig.THEME)
    }

    companion object {
        const val NAME_COLUMN_WIDTH = 15
        const val ACTIONS_COLUMN_WIDTH = 10
    }
}