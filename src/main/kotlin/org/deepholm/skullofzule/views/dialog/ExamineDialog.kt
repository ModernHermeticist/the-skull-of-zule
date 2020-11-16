package org.deepholm.skullofzule.views.dialog

import org.deepholm.skullofzule.attributes.types.iconTile
import org.deepholm.skullofzule.extensions.GameItem
import org.hexworks.zircon.api.Components
import org.hexworks.zircon.api.GraphicalTilesetResources
import org.hexworks.zircon.api.extensions.box
import org.hexworks.zircon.api.graphics.BoxType
import org.hexworks.zircon.api.screen.Screen


class ExamineDialog(screen: Screen, item: GameItem) : Dialog(screen) {

    override val container = Components.panel()
            .withDecorations(box(title = "Examining ${item.name}"))
            .withSize(25, 15)
            .withDecorations(box(boxType = BoxType.TOP_BOTTOM_DOUBLE))
            .withDecorations(box())
            .build().apply {
                addComponent(Components.textBox(23)
                        .addHeader("Name", withNewLine = false)
                        .addInlineComponent(Components.icon()
                                .withIcon(item.iconTile)
                                .withTileset(GraphicalTilesetResources.nethack16x16())
                                .build())
                        .addInlineComponent(Components.label()
                                .withText(" ${item.name}")
                                .build())
                        .commitInlineElements()
                        .addNewLine()
                        .addHeader("Description", withNewLine = false)
                        .addParagraph(item.description, withNewLine = false))
            }
}