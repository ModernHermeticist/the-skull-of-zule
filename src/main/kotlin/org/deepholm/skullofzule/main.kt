package org.deepholm.skullofzule

import org.deepholm.skullofzule.views.StartView
import org.hexworks.zircon.api.ColorThemes
import org.hexworks.zircon.api.Components
import org.hexworks.zircon.api.Screens
import org.hexworks.zircon.api.SwingApplications
import org.hexworks.zircon.api.component.ComponentAlignment

@Suppress("ConstantConditionIf")
fun main(args: Array<String>) {

    val application = SwingApplications.startApplication(GameConfig.buildAppConfig())

    application.start()
    application.dock(StartView())

}
