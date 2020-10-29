package org.deepholm.skullofzule.functions

import org.deepholm.skullofzule.events.GameLogEvent
import org.hexworks.zircon.internal.Zircon

fun logGameEvent(text: String) {
    Zircon.eventBus.publish(GameLogEvent(text))
}