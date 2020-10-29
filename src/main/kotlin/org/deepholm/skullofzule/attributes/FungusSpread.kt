package org.deepholm.skullofzule.attributes

import org.deepholm.skullofzule.config.GameConfig
import org.hexworks.amethyst.api.Attribute

data class FungusSpread(var spreadCount: Int = 0,
                        val maximumSpread: Int = GameConfig.MAXIMUM_FUNGUS_SPREAD) : Attribute