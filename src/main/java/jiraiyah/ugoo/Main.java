package jiraiyah.ugoo;

import jiraiyah.ugoo.registry.ModBlockEntities;
import jiraiyah.ugoo.registry.ModBlocks;
import jiraiyah.ugoo.registry.ModItemGroups;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.gamerule.v1.GameRuleFactory;
import net.fabricmc.fabric.api.gamerule.v1.GameRuleRegistry;
import net.minecraft.world.GameRules;

public class Main implements ModInitializer
{
	public static final boolean DEBUG = true;

	public static final GameRules.Key<GameRules.BooleanRule> SPREAD;
	public static final GameRules.Key<GameRules.BooleanRule> LAVA_PUMP;
	public static final GameRules.Key<GameRules.BooleanRule> WATER_PUMP;
	public static final GameRules.Key<GameRules.IntRule> SPREAD_DISTANCE;
	public static final GameRules.Key<GameRules.IntRule> PUMP_DISTANCE;
	public static final GameRules.Key<GameRules.IntRule> PUMP_DEPTH;

	public static final GameRules.Key<GameRules.IntRule> AIR_BOMB_CHANCE;
	public static final GameRules.Key<GameRules.IntRule> CHUNK_BOMB_CHANCE;
	public static final GameRules.Key<GameRules.IntRule> LAVA_EATING_CHANCE;
	public static final GameRules.Key<GameRules.IntRule> LAVA_GENERATING_CHANCE;
	public static final GameRules.Key<GameRules.IntRule> STONE_BOMB_CHANCE;
	public static final GameRules.Key<GameRules.IntRule> TOWERING_CHANCE;
	public static final GameRules.Key<GameRules.IntRule> WATER_EATING_CHANCE;
	public static final GameRules.Key<GameRules.IntRule> WATER_GENERATING_CHANCE;

	public static final GameRules.Key<GameRules.IntRule> LAVA_PUMP_COOLDOWN;
	public static final GameRules.Key<GameRules.IntRule> WATER_PUMP_COOLDOWN;

	@Override
	public void onInitialize()
	{
		ModBlocks.register();
		ModItemGroups.register();
		ModBlockEntities.register();
	}

	static {
        SPREAD = GameRuleRegistry.register("gooSpread", GameRules.Category.UPDATES, GameRuleFactory.createBooleanRule(true));
		LAVA_PUMP = GameRuleRegistry.register("lavaPumpGoo", GameRules.Category.UPDATES, GameRuleFactory.createBooleanRule(true));
		WATER_PUMP = GameRuleRegistry.register("waterPumpGoo", GameRules.Category.UPDATES, GameRuleFactory.createBooleanRule(true));
		SPREAD_DISTANCE = GameRuleRegistry.register("gooSpreadDistance", GameRules.Category.UPDATES, GameRuleFactory.createIntRule(256));
		PUMP_DISTANCE = GameRuleRegistry.register("pumpDistance", GameRules.Category.UPDATES, GameRuleFactory.createIntRule(128));
		PUMP_DEPTH = GameRuleRegistry.register("pumpDepth", GameRules.Category.UPDATES, GameRuleFactory.createIntRule(10));

		AIR_BOMB_CHANCE = GameRuleRegistry.register("airBombChance", GameRules.Category.UPDATES, GameRuleFactory.createIntRule(5));
		CHUNK_BOMB_CHANCE = GameRuleRegistry.register("chunkBombChance", GameRules.Category.UPDATES, GameRuleFactory.createIntRule(5));
		LAVA_EATING_CHANCE = GameRuleRegistry.register("lavaEatingChance", GameRules.Category.UPDATES, GameRuleFactory.createIntRule(2));
		LAVA_GENERATING_CHANCE = GameRuleRegistry.register("lavaGeneratingChance", GameRules.Category.UPDATES, GameRuleFactory.createIntRule(10));
		STONE_BOMB_CHANCE = GameRuleRegistry.register("stoneBombChance", GameRules.Category.UPDATES, GameRuleFactory.createIntRule(5));
		TOWERING_CHANCE = GameRuleRegistry.register("toweringChance", GameRules.Category.UPDATES, GameRuleFactory.createIntRule(5));
		WATER_EATING_CHANCE = GameRuleRegistry.register("waterEatingChance", GameRules.Category.UPDATES, GameRuleFactory.createIntRule(50));
		WATER_GENERATING_CHANCE = GameRuleRegistry.register("waterGeneratingChance", GameRules.Category.UPDATES, GameRuleFactory.createIntRule(10));

		LAVA_PUMP_COOLDOWN = GameRuleRegistry.register("lavaPumpCooldown", GameRules.Category.UPDATES, GameRuleFactory.createIntRule(20));
		WATER_PUMP_COOLDOWN = GameRuleRegistry.register("waterPumpCooldown", GameRules.Category.UPDATES, GameRuleFactory.createIntRule(20));
	}
}