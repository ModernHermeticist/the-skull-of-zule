package org.deepholm.skullofzule.builders

import org.deepholm.skullofzule.attributes.*
import org.deepholm.skullofzule.attributes.flags.BlockOccupier
import org.deepholm.skullofzule.attributes.types.Necrospore
import org.deepholm.skullofzule.attributes.types.Sporeling
import org.deepholm.skullofzule.builders.EntityFactory.newRandomArmor
import org.deepholm.skullofzule.builders.EntityFactory.newRandomWeapon
import org.deepholm.skullofzule.commands.Attack
import org.deepholm.skullofzule.config.ZombieTileTypes
import org.deepholm.skullofzule.systems.*

object ZombieEntityFactory {

    fun newNecrospore() = newGameEntityOfType(Necrospore) {
        attributes(BlockOccupier, EntityPosition(), EntityTile(ZombieTileTypes.NECROSPORE), Vision(10),
                    CombatStats.create(
                            maxHp = 25,
                            attackValue = 8,
                            defenseValue = 4),
                    Inventory(2).apply {
                        addItem(newRandomWeapon())
                        addItem(newRandomArmor())
                    },
                    EntityActions(Attack::class),
                    SpawnsOnDeath.create(entity = newSporeling()))
        facets(Movable, Attackable, ItemDropper, LootDropper, Destructible, Spawner)
        behaviors(HunterSeeker or Wanderer)
    }

    fun newSporeling() = newGameEntityOfType(Sporeling) {
        attributes(BlockOccupier, EntityPosition(), EntityTile(ZombieTileTypes.SPORELING),
                    CombatStats.create(
                                maxHp = 10,
                                attackValue =  4,
                                defenseValue = 0),
                    EntityActions(Attack::class))
        facets(Movable, Attackable, Destructible)
        behaviors(Wanderer)
    }
}