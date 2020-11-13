package org.deepholm.skullofzule.views.fragment

import org.deepholm.skullofzule.attributes.types.CombatItem
import org.deepholm.skullofzule.attributes.types.Food
import org.deepholm.skullofzule.attributes.types.iconTile
import org.deepholm.skullofzule.extensions.GameItem
import org.deepholm.skullofzule.extensions.whenTypeIs
import org.hexworks.zircon.api.Components
import org.hexworks.zircon.api.component.Fragment

class InventoryRowFragment(width: Int, item: GameItem) : Fragment {

    val dropButton = Components.button()
            .withText("Drop")
            .build()

    val eatButton = Components.button()
            .withText("Eat")
            .build()

    val equipButton = Components.button()
            .withText("Equip")
            .build()

    override val root = Components.hbox().withSpacing(1).withSize(width, 1).build().apply {
        addComponent(Components.icon().withIcon(item.iconTile))
        addComponent(Components.label().withSize(InventoryFragment.NAME_COLUMN_WIDTH, 1).withText(item.name))
        addComponent(dropButton)
        item.whenTypeIs<Food> { addComponent(eatButton) }
        item.whenTypeIs<CombatItem> { addComponent(equipButton) }
    }
}