package org.deepholm.skullofzule

import org.deepholm.skullofzule.config.GameConfig
import org.deepholm.skullofzule.views.StartView
import org.hexworks.zircon.api.SwingApplications

@Suppress("ConstantConditionIf")
fun main() {

    val application = SwingApplications.startApplication(GameConfig.buildAppConfig())
    application.start()
    application.dock(StartView())

}
