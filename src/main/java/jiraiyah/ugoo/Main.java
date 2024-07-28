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
	}
}