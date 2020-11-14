package org.deepholm.skullofzule.views.dialog

import org.deepholm.skullofzule.attributes.CombatStats
import org.deepholm.skullofzule.attributes.Vision
import org.deepholm.skullofzule.attributes.types.Player
import org.deepholm.skullofzule.extensions.GameEntity
import org.deepholm.skullofzule.extensions.tryToFindAttribute
import org.deepholm.skullofzule.functions.logGameEvent
import org.hexworks.zircon.api.Components
import org.hexworks.zircon.api.component.Container
import org.hexworks.zircon.api.extensions.box
import org.hexworks.zircon.api.extensions.handleComponentEvents
import org.hexworks.zircon.api.graphics.BoxType
import org.hexworks.zircon.api.screen.Screen
import org.hexworks.zircon.api.uievent.ComponentEventType
import org.hexworks.zircon.api.uievent.Processed
import org.hexworks.zircon.internal.component.modal.EmptyModalResult

class LevelUpDialog(screen: Screen, player: GameEntity<Player>): Dialog(screen, false) {

    override val container = Components.vbox()
            .withDecorations(box(title = "Ding!"))
            .withDecorations(box(boxType = BoxType.TOP_BOTTOM_DOUBLE))
            .withSize(30,15)
            .withDecorations(box())
            .build().apply {
                val stats = player.tryToFindAttribute(CombatStats::class)
                val vision = player.tryToFindAttribute(Vision::class)

                addComponent(Components.textBox(27)
                        .addHeader("Congratulations, you leveled up!")
                        .addParagraph("Pick an improvement from the options below:"))   // 2

                addComponent(Components.button()                                        // 3
                        .withText("Max HP")
                        .build().apply {
                            handleComponentEvents(ComponentEventType.ACTIVATED) {
                                stats.maxHpProperty.value += 10
                                logGameEvent("You look healthier.")
                                root.close(EmptyModalResult)
                                Processed
                            }
                        })


                addComponent(Components.button()
                        .withText("Attack")
                        .build().apply {
                            handleComponentEvents(ComponentEventType.ACTIVATED) {
                                stats.attackValueProperty.value += 2
                                logGameEvent("You look stronger.")
                                root.close(EmptyModalResult)
                                Processed
                            }
                        })

                addComponent(Components.button()
                        .withText("Defense")
                        .build().apply {
                            handleComponentEvents(ComponentEventType.ACTIVATED) {
                                stats.defenseValueProperty.value += 2
                                logGameEvent("You look tougher.")
                                root.close(EmptyModalResult)
                                Processed
                            }
                        })

                addComponent(Components.button()
                        .withText("Vision")
                        .build().apply {
                            handleComponentEvents(ComponentEventType.ACTIVATED) {
                                vision.radius++                                 // 4
                                logGameEvent("You look more perceptive.")
                                root.close(EmptyModalResult)
                                Processed
                            }
                        })
            }
}