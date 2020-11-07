package org.deepholm.skullofzule.views

import org.hexworks.zircon.api.ColorThemes
import org.hexworks.zircon.api.Components
import org.hexworks.zircon.api.component.ComponentAlignment
import org.hexworks.zircon.api.extensions.box
import org.hexworks.zircon.api.extensions.handleComponentEvents
import org.hexworks.zircon.api.extensions.onComponentEvent
import org.hexworks.zircon.api.graphics.BoxType
import org.hexworks.zircon.api.mvc.base.BaseView
import org.hexworks.zircon.api.uievent.ComponentEventType
import org.hexworks.zircon.api.uievent.Processed
import kotlin.system.exitProcess

class LoseView: BaseView() {

    override val theme = ColorThemes.arc()

    override fun onDock() {
        val msg = "Game Over!"
        val header = Components.textBox(30)
                .addHeader(msg)
                .withAlignmentWithin(screen, ComponentAlignment.CENTER)
                .build()
        val restartButton = Components.button()
                .withAlignmentAround(header, ComponentAlignment.BOTTOM_LEFT)
                .withText("Restart")
                .withDecorations(box())
                .withDecorations(box(boxType = BoxType.SINGLE))
                .build()
        val exitButton = Components.button()
                .withAlignmentAround(header, ComponentAlignment.BOTTOM_RIGHT)
                .withText("Quit")
                .withDecorations(box())
                .withDecorations(box(boxType = BoxType.SINGLE))
                .build()

        restartButton.handleComponentEvents(ComponentEventType.ACTIVATED) {
            replaceWith(PlayView())
            close()
            Processed
        }

        exitButton.handleComponentEvents(ComponentEventType.ACTIVATED) {
            exitProcess(0)
            Processed
        }

        screen.addComponent(header)
        screen.addComponent(restartButton)
        screen.addComponent(exitButton)
    }
}