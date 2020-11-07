package org.deepholm.skullofzule.views

import org.hexworks.zircon.api.ColorThemes
import org.hexworks.zircon.api.Components
import org.hexworks.zircon.api.component.ComponentAlignment
import org.hexworks.zircon.api.extensions.box
import org.hexworks.zircon.api.extensions.handleComponentEvents
import org.hexworks.zircon.api.extensions.onComponentEvent
import org.hexworks.zircon.api.extensions.shadow
import org.hexworks.zircon.api.graphics.BoxType
import org.hexworks.zircon.api.mvc.base.BaseView
import org.hexworks.zircon.api.uievent.ComponentEventType
import org.hexworks.zircon.api.uievent.Processed


class StartView: BaseView() {

    override val theme = ColorThemes.arc()

    override fun onDock() {
        val msg = "Welcome to Skull of Zule."
        val header = Components.textBox(msg.length)
                .addHeader(msg)
                .addNewLine()
                .withAlignmentWithin(screen, ComponentAlignment.CENTER)
                .build()

        val startButton = Components.button()
                .withAlignmentAround(header, ComponentAlignment.BOTTOM_CENTER)
                .withText("Start!")
                .withDecorations(box(boxType = BoxType.SINGLE))
                .withDecorations(shadow())
                .withDecorations(box())
                .build()

        startButton.handleComponentEvents(ComponentEventType.ACTIVATED) {
            replaceWith(PlayView())
            close()
            Processed
        }


        screen.addComponent(header)
        screen.addComponent(startButton)
    }
}