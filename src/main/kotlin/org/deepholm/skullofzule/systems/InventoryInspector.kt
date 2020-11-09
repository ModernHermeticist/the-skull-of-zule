package org.deepholm.skullofzule.systems

import org.deepholm.skullofzule.GameContext
import org.deepholm.skullofzule.attributes.types.inventory
import org.deepholm.skullofzule.commands.DropItem
import org.deepholm.skullofzule.commands.InspectInventory
import org.deepholm.skullofzule.config.GameConfig
import org.deepholm.skullofzule.extensions.GameCommand
import org.deepholm.skullofzule.views.fragment.InventoryFragment
import org.hexworks.amethyst.api.Consumed
import org.hexworks.amethyst.api.base.BaseFacet
import org.hexworks.amethyst.api.entity.EntityType
import org.hexworks.zircon.api.Components
import org.hexworks.zircon.api.Sizes
import org.hexworks.zircon.api.builder.component.ModalBuilder
import org.hexworks.zircon.api.component.ComponentAlignment
import org.hexworks.zircon.api.extensions.box
import org.hexworks.zircon.api.extensions.handleComponentEvents
import org.hexworks.zircon.api.extensions.onComponentEvent
import org.hexworks.zircon.api.extensions.shadow
import org.hexworks.zircon.api.uievent.ComponentEventType
import org.hexworks.zircon.api.uievent.Processed
import org.hexworks.zircon.internal.component.modal.EmptyModalResult


object InventoryInspector : BaseFacet<GameContext>() {

    val DIALOG_SIZE = Sizes.create(33, 14)

    override fun executeCommand(command: GameCommand<out EntityType>) = command
            .responseWhenCommandIs(InspectInventory::class) { (context, itemHolder, position) ->

                val screen = context.screen

                val panel = Components.panel()
                        .withSize(DIALOG_SIZE)
                        .withDecorations(box())
                        .withDecorations(shadow())
                        .withDecorations(box(title = "Inventory"))
                        .build()

                val fragment = InventoryFragment(itemHolder.inventory, DIALOG_SIZE.width - 3) { item ->
                    itemHolder.executeCommand(DropItem(context, itemHolder, item, position))
                }

                panel.addFragment(fragment)

                val modal = ModalBuilder.newBuilder<EmptyModalResult>()
                        .withParentSize(screen.size)
                        .withComponent(panel)
                        .build()

                panel.addComponent(Components.button()
                        .withText("Close")
                        .withAlignmentWithin(panel, ComponentAlignment.BOTTOM_LEFT)
                        .build().apply {
                            handleComponentEvents(ComponentEventType.ACTIVATED ) {
                                modal.close(EmptyModalResult)
                                Processed
                            }
                        })

                modal.applyColorTheme(GameConfig.THEME)
                screen.openModal(modal)
                Consumed
            }

}