package org.deepholm.skullofzule.views

import org.deepholm.skullofzule.world.Game
import org.deepholm.skullofzule.GameBlock
import org.deepholm.skullofzule.config.GameConfig
import org.deepholm.skullofzule.events.GameLogEvent
import org.deepholm.skullofzule.events.PlayerGainedLevel
import org.deepholm.skullofzule.views.dialog.LevelUpDialog
import org.deepholm.skullofzule.views.fragment.PlayerStatsFragment
import org.deepholm.skullofzule.world.GameBuilder
import org.hexworks.cobalt.events.api.subscribe
import org.hexworks.zircon.api.ColorThemes
import org.hexworks.zircon.api.Components
import org.hexworks.zircon.api.GameComponents
import org.hexworks.zircon.api.component.ComponentAlignment
import org.hexworks.zircon.api.data.Tile
import org.hexworks.zircon.api.extensions.box
import org.hexworks.zircon.api.extensions.handleKeyboardEvents
import org.hexworks.zircon.api.extensions.onKeyboardEvent
import org.hexworks.zircon.api.game.ProjectionMode
import org.hexworks.zircon.api.mvc.base.BaseView
import org.hexworks.zircon.api.uievent.KeyboardEventType
import org.hexworks.zircon.api.uievent.Processed
import org.hexworks.zircon.internal.Zircon

class PlayView(private val game: Game = GameBuilder.defaultGame()) : BaseView() {
    override val theme = ColorThemes.arc()

    override fun onDock() {

        val sideBar = Components.panel()
                .withSize(GameConfig.SIDEBAR_WIDTH, GameConfig.WINDOW_HEIGHT)
                .withDecorations(box())
                .build()

        val logArea = Components.logArea()
                .withDecorations(box(title = "Log"))
                .withDecorations(box())
                .withSize(GameConfig.WINDOW_WIDTH - GameConfig.SIDEBAR_WIDTH, GameConfig.LOG_AREA_HEIGHT)
                .withAlignmentWithin(screen, ComponentAlignment.BOTTOM_RIGHT)
                .build()

        val gameComponent = GameComponents.newGameComponentBuilder<Tile, GameBlock>()
                .withGameArea(game.world)
                .withVisibleSize(game.world.visibleSize())
                .withProjectionMode(ProjectionMode.TOP_DOWN)
                .withAlignmentWithin(screen, ComponentAlignment.TOP_RIGHT)
                .build()

        sideBar.addFragment(PlayerStatsFragment(
                width = sideBar.contentSize.width,
                player = game.player))

        screen.handleKeyboardEvents(KeyboardEventType.KEY_PRESSED) { event, _ ->
            game.world.update(screen, event, game)
            Processed
        }

        screen.addComponent(gameComponent)
        screen.addComponent(sideBar)
        screen.addComponent(logArea)

        Zircon.eventBus.subscribe<GameLogEvent> { (text) ->
            logArea.addParagraph(
                    paragraph = text,
                    withNewLine = false,
                    withTypingEffectSpeedInMs = 10
            )
        }

        Zircon.eventBus.subscribe<PlayerGainedLevel> {
            screen.openModal(LevelUpDialog(screen, game.player))
        }
    }
}