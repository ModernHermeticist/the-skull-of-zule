package org.deepholm.skullofzule.builders

import org.deepholm.skullofzule.GameContext
import org.deepholm.skullofzule.attributes.*
import org.deepholm.skullofzule.config.GameTileRepository
import org.hexworks.amethyst.api.Entities
import org.hexworks.amethyst.api.builder.EntityBuilder
import org.hexworks.amethyst.api.entity.EntityType
import org.deepholm.skullofzule.attributes.flags.BlockOccupier
import org.deepholm.skullofzule.attributes.flags.EmptyItem
import org.deepholm.skullofzule.attributes.flags.VisionBlocker
import org.deepholm.skullofzule.attributes.types.*
import org.deepholm.skullofzule.builders.ZombieEntityFactory.newNecrospore
import org.deepholm.skullofzule.commands.Attack
import org.deepholm.skullofzule.commands.Dig
import org.deepholm.skullofzule.entities.FogOfWar
import org.deepholm.skullofzule.extensions.GameEntity
import org.deepholm.skullofzule.systems.*
import org.deepholm.skullofzule.world.Game
import org.hexworks.zircon.api.GraphicalTilesetResources
import org.hexworks.zircon.api.Tiles
import kotlin.random.Random

fun <T: EntityType> newGameEntityOfType(type: T, init: EntityBuilder<T, GameContext>.() -> Unit) =
        Entities.newEntityOfType(type, init)

object EntityFactory {

    fun newPlayer() = newGameEntityOfType(Player) {
        attributes(
                Experience(),
                Vision(9),
                EntityPosition(),
                BlockOccupier,
                EntityTile(GameTileRepository.PLAYER),
                EntityActions(Dig::class, Attack::class),
                GoldPieceCounter(),
                CombatStats.create(
                        maxHp = 100,
                        attackValue = 10,
                        defenseValue = 5),
                Inventory(10),
                EnergyLevel(1000,1000),
                Equipment(
                        initialWeapon = newClub(),
                        initialChestArmor = newEmptyChestArmor(),
                        initialLegArmor = newEmptyLegArmor(),
                        initialHeadArmor = newEmptyHeadArmor(),
                        initialBackArmor = newEmptyBackArmor(),
                        initialFeetArmor = newEmptyFeetArmor(),
                        initialHandArmor = newEmptyHandArmor(),
                        initialShoulderArmor = newEmptyShoulderArmor(),
                        initialWaistArmor = newEmptyWaistArmor(),
                        initialLeftEarring = newEmptyEarring(),
                        initialRightEarring = newEmptyEarring(),
                        initialLeftRing = newEmptyRing(),
                        initialRightRing = newEmptyRing(),
                        initialRelic = newEmptyRelic()))
        behaviors(InputReceiver, EnergyExpender)
        facets(GoldPieceGatherer, ExperienceAccumulator, Movable, CameraMover, StairClimber, StairDescender,
                Attackable, Destructible, ItemPicker, InventoryInspector, ItemDropper,
                EnergyExpender, DigestiveSystem)
    }

    fun newRandomWeapon(): GameEntity<Weapon> = when (Random.nextInt(3)) {
        0 -> newDagger()
        1 -> newSword()
        else -> newStaff()
    }

    fun newRandomArmor(): GameEntity<Armor> = when (Random.nextInt(3)) {
        0 -> newLightArmor()
        1 -> newMediumArmor()
        else -> newHeavyArmor()
    }

    fun newWall() = newGameEntityOfType(Wall) {
        attributes(
                VisionBlocker,
                EntityPosition(),
                BlockOccupier,
                EntityTile(GameTileRepository.WALL))
        behaviors()
        facets(Diggable)
    }

    fun newFungus(fungusSpread: FungusSpread = FungusSpread(),
                    timedEntitySpawner: TimedEntitySpawner = TimedEntitySpawner(
                            { newNecrospore() },
                            1,
                            10,
                            0)) = newGameEntityOfType(Fungus) {
        attributes(
                timedEntitySpawner,
                BlockOccupier,
                EntityPosition(),
                EntityTile(GameTileRepository.FUNGUS),
                fungusSpread,
                CombatStats.create(
                        maxHp = 10,
                        attackValue = 0,
                        defenseValue = 0
                ),
                )
        behaviors(FungusGrowth, TimedEntitySpawn)
        facets(Attackable, Destructible)
    }

    fun newStairsDown() = newGameEntityOfType(StairsDown) {
        attributes(
                EntityTile(GameTileRepository.STAIRS_DOWN),
                EntityPosition())
    }

    fun newStairsUp() = newGameEntityOfType(StairsUp) {
        attributes(
                EntityTile(GameTileRepository.STAIRS_UP),
                EntityPosition())
    }

    fun newFogOfWar(game: Game) = FogOfWar(game)

    fun newBat() = newGameEntityOfType(Bat) {
        attributes(BlockOccupier,
        EntityPosition(),
        EntityTile(GameTileRepository.BAT),
        CombatStats.create(
                maxHp = 5,
                attackValue = 2,
                defenseValue = 1),
        EntityActions(Attack::class),
        Inventory(1).apply {
            addItem(newBatMeat())
        })
        facets(Movable, Attackable, ItemDropper, LootDropper, Destructible)
        behaviors(Wanderer)
    }

    fun newTin() = newGameEntityOfType(Tin) {
        attributes(ItemIcon(Tiles.newBuilder()
                .withName("white gem")
                .withTileset(GraphicalTilesetResources.nethack16x16())
                .buildGraphicTile()),
        EntityPosition(),
        EntityTile(GameTileRepository.TIN))
    }

    fun newGoldPiece() = newGameEntityOfType(GoldPiece) {
        attributes(ItemIcon(Tiles.newBuilder()
                .withName("Gold piece")
                .withTileset(GraphicalTilesetResources.nethack16x16())
                .buildGraphicTile()),
        EntityPosition(),
        EntityTile(GameTileRepository.GOLD_PIECE))
    }

    fun newBatMeat() = newGameEntityOfType(BatMeat) {
        attributes(ItemIcon(Tiles.newBuilder()
                .withName("Meatball")
                .withTileset(GraphicalTilesetResources.nethack16x16())
                .buildGraphicTile()),
                NutritionalValue(750),
                EntityPosition(),
                EntityTile(GameTileRepository.BAT_MEAT))
    }

    fun newDagger() = newGameEntityOfType(Dagger) {
        attributes(ItemIcon(Tiles.newBuilder()
                .withName("Dagger")
                .withTileset(GraphicalTilesetResources.nethack16x16())
                .buildGraphicTile()),
                EntityPosition(),
                ItemCombatStats(
                        attackValue = 4,
                        combatItemType = "Weapon"),
                EntityTile(GameTileRepository.DAGGER))
    }

    fun newSword() = newGameEntityOfType(Sword) {
        attributes(ItemIcon(Tiles.newBuilder()
                .withName("Short sword")
                .withTileset(GraphicalTilesetResources.nethack16x16())
                .buildGraphicTile()),
                EntityPosition(),
                ItemCombatStats(
                        attackValue = 6,
                        combatItemType = "Weapon"),
                EntityTile(GameTileRepository.SWORD))
    }

    fun newStaff() = newGameEntityOfType(Staff) {
        attributes(ItemIcon(Tiles.newBuilder()
                .withName("staff")
                .withTileset(GraphicalTilesetResources.nethack16x16())
                .buildGraphicTile()),
                EntityPosition(),
                ItemCombatStats(
                        attackValue = 4,
                        defenseValue = 2,
                        combatItemType = "Weapon"),
                EntityTile(GameTileRepository.STAFF))
    }

    fun newLightArmor() = newGameEntityOfType(LightArmor) {
        attributes(ItemIcon(Tiles.newBuilder()
                .withName("Leather armor")
                .withTileset(GraphicalTilesetResources.nethack16x16())
                .buildGraphicTile()),
                EntityPosition(),
                ItemCombatStats(
                        defenseValue = 2,
                        combatItemType = "Armor"),
                EntityTile(GameTileRepository.LIGHT_ARMOR))
    }

    fun newMediumArmor() = newGameEntityOfType(MediumArmor) {
        attributes(ItemIcon(Tiles.newBuilder()
                .withName("Chain mail")
                .withTileset(GraphicalTilesetResources.nethack16x16())
                .buildGraphicTile()),
                EntityPosition(),
                ItemCombatStats(
                        defenseValue = 3,
                        combatItemType = "Armor"),
                EntityTile(GameTileRepository.MEDIUM_ARMOR))
    }

    fun newHeavyArmor() = newGameEntityOfType(HeavyArmor) {
        attributes(ItemIcon(Tiles.newBuilder()
                .withName("Plate mail")
                .withTileset(GraphicalTilesetResources.nethack16x16())
                .buildGraphicTile()),
                EntityPosition(),
                ItemCombatStats(
                        defenseValue = 4,
                        combatItemType = "Armor"),
                EntityTile(GameTileRepository.HEAVY_ARMOR))
    }

    fun newClub() = newGameEntityOfType(Club) {
        attributes(ItemCombatStats(combatItemType = "Weapon"),
                EntityTile(GameTileRepository.CLUB),
                EntityPosition(),
                ItemIcon(Tiles.newBuilder()
                        .withName("Club")
                        .withTileset(GraphicalTilesetResources.nethack16x16())
                        .buildGraphicTile()))
    }

    fun newJacket() = newGameEntityOfType(Jacket) {
        attributes(ItemCombatStats(combatItemType = "Armor"),
                EntityTile(GameTileRepository.JACKET),
                EntityPosition(),
                ItemIcon(Tiles.newBuilder()
                        .withName("Leather jacket")
                        .withTileset(GraphicalTilesetResources.nethack16x16())
                        .buildGraphicTile()))
    }

    fun newEmptyChestArmor() = newGameEntityOfType(EmptyChestArmor) {
        attributes(EmptyItem, ItemIcon(Tiles.newBuilder()
                .withName("statue of an invisible monster").withTileset(GraphicalTilesetResources.nethack16x16()).buildGraphicTile())) }
    fun newEmptyLegArmor() = newGameEntityOfType(EmptyLegArmor) {
        attributes(EmptyItem, ItemIcon(Tiles.newBuilder()
                .withName("statue of an invisible monster").withTileset(GraphicalTilesetResources.nethack16x16()).buildGraphicTile())) }
    fun newEmptyHeadArmor() = newGameEntityOfType(EmptyHeadArmor) {
        attributes(EmptyItem, ItemIcon(Tiles.newBuilder()
                .withName("statue of an invisible monster").withTileset(GraphicalTilesetResources.nethack16x16()).buildGraphicTile())) }
    fun newEmptyHandArmor() = newGameEntityOfType(EmptyHandArmor) {
        attributes(EmptyItem, ItemIcon(Tiles.newBuilder()
                .withName("statue of an invisible monster").withTileset(GraphicalTilesetResources.nethack16x16()).buildGraphicTile())) }
    fun newEmptyFeetArmor() = newGameEntityOfType(EmptyFeetArmor) {
        attributes(EmptyItem, ItemIcon(Tiles.newBuilder()
                .withName("statue of an invisible monster").withTileset(GraphicalTilesetResources.nethack16x16()).buildGraphicTile())) }
    fun newEmptyShoulderArmor() = newGameEntityOfType(EmptyShoulderArmor) {
        attributes(EmptyItem, ItemIcon(Tiles.newBuilder()
                .withName("statue of an invisible monster").withTileset(GraphicalTilesetResources.nethack16x16()).buildGraphicTile())) }
    fun newEmptyWaistArmor() = newGameEntityOfType(EmptyWaistArmor) {
        attributes(EmptyItem, ItemIcon(Tiles.newBuilder()
                .withName("statue of an invisible monster").withTileset(GraphicalTilesetResources.nethack16x16()).buildGraphicTile())) }
    fun newEmptyBackArmor() = newGameEntityOfType(EmptyBackArmor) {
        attributes(EmptyItem, ItemIcon(Tiles.newBuilder()
                .withName("statue of an invisible monster").withTileset(GraphicalTilesetResources.nethack16x16()).buildGraphicTile())) }
    fun newEmptyRing() = newGameEntityOfType(EmptyRing) {
        attributes(EmptyItem, ItemIcon(Tiles.newBuilder()
                .withName("statue of an invisible monster").withTileset(GraphicalTilesetResources.nethack16x16()).buildGraphicTile())) }
    fun newEmptyEarring() = newGameEntityOfType(EmptyEarring) {
        attributes(EmptyItem, ItemIcon(Tiles.newBuilder()
                .withName("statue of an invisible monster").withTileset(GraphicalTilesetResources.nethack16x16()).buildGraphicTile())) }
    fun newEmptyRelic() = newGameEntityOfType(EmptyRelic) {
        attributes(EmptyItem, ItemIcon(Tiles.newBuilder()
                .withName("statue of an invisible monster").withTileset(GraphicalTilesetResources.nethack16x16()).buildGraphicTile())) }
}