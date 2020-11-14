package org.deepholm.skullofzule.views.dialog

import org.hexworks.zircon.api.Components
import org.hexworks.zircon.api.extensions.box
import org.hexworks.zircon.api.graphics.BoxType
import org.hexworks.zircon.api.screen.Screen

class HelpDialog(screen: Screen) : Dialog(screen) {

    override val container = Components.panel()
            .withDecorations(box(title = "Help"))
            .withSize(52, 27)
            .withDecorations(box(boxType = BoxType.TOP_BOTTOM_DOUBLE))
            .withDecorations(box())
            .build().apply {
                addComponent(Components.textBox(50)
                        .addNewLine()
                        .addHeader("The Skull of Zule")
                        .addParagraph("""
                            Descend to the Skull of Zule and unlock the mysteries of the depths.
                            Use what you find to survive.""".trimIndent())
                        .addNewLine())

                addComponent(Components.textBox(27)
                        .withPosition(0, 8)
                        .addHeader("Movement:")
                        .addListItem("waxdqezc: Movement")
                        .addListItem("r: Move up")
                        .addListItem("f: Move down"))

                addComponent(Components.textBox(40)
                        .withPosition(0, 16)
                        .addHeader("Navigation:")
                        .addListItem("[Tab]: Focus next")
                        .addListItem("[Shift] + [Tab]: Focus previous")
                        .addListItem("[Space]: Activate focused item"))

                addComponent(Components.textBox(21)
                        .withPosition(28, 8)
                        .addHeader("Actions:")
                        .addListItem("(i)nventory")
                        .addListItem("(p)ick up")
                        .addListItem("(h)elp"))
            }
}