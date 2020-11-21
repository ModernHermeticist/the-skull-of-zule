package org.deepholm.skullofzule.functions

import org.deepholm.skullofzule.events.GameLogEvent
import org.hexworks.zircon.internal.Zircon
import java.util.*
import kotlin.concurrent.fixedRateTimer

fun logGameEvent(text: String) {
    Zircon.eventBus.publish(GameLogEvent(text))
}