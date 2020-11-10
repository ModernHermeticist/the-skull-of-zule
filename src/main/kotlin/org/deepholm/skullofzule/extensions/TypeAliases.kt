package org.deepholm.skullofzule.extensions

import org.deepholm.skullofzule.GameContext
import org.deepholm.skullofzule.attributes.types.CombatItem
import org.deepholm.skullofzule.attributes.types.EquipmentHolder
import org.deepholm.skullofzule.attributes.types.Item
import org.deepholm.skullofzule.attributes.types.ItemHolder
import org.hexworks.amethyst.api.Command
import org.hexworks.amethyst.api.entity.Entity
import org.hexworks.amethyst.api.entity.EntityType

typealias AnyGameEntity = Entity<EntityType, GameContext>
typealias GameEntity<T> = Entity<T, GameContext>

typealias GameCommand<T> = Command<T, GameContext>

typealias GameItem = GameEntity<Item>

typealias GameItemHolder = GameEntity<ItemHolder>

typealias GameCombatItem = GameEntity<CombatItem>

typealias  GameEquipmentHolder = GameEntity<EquipmentHolder>

