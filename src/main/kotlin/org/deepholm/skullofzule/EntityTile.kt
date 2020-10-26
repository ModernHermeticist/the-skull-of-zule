package org.deepholm.skullofzule

import org.hexworks.amethyst.api.Attribute
import org.hexworks.zircon.api.Tiles
import org.hexworks.zircon.api.data.Tile

data class EntityTile(val tile: Tile = Tiles.empty()) : Attribute