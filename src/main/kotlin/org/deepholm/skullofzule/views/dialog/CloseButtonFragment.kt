package org.deepholm.skullofzule.views.dialog

import org.hexworks.zircon.api.Components
import org.hexworks.zircon.api.component.ComponentAlignment
import org.hexworks.zircon.api.component.Container
import org.hexworks.zircon.api.component.Fragment
import org.hexworks.zircon.api.component.modal.Modal
import org.hexworks.zircon.api.extensions.handleComponentEvents
import org.hexworks.zircon.api.uievent.ComponentEventType
import org.hexworks.zircon.api.uievent.Processed
import org.hexworks.zircon.internal.component.modal.EmptyModalResult

class CloseButtonFragment(modal: Modal<EmptyModalResult>, parent: Container): Fragment {

    override val root = Components.button().withText("Close")
            .withAlignmentWithin(parent, ComponentAlignment.BOTTOM_RIGHT)
            .build().apply {
                handleComponentEvents(ComponentEventType.ACTIVATED) {
                    modal.close(EmptyModalResult)
                    Processed
                }
            }
}