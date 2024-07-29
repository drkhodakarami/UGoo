/***********************************************************************************
 * Copyright (c) 2024 Alireza Khodakarami (Jiraiyah)                               *
 * ------------------------------------------------------------------------------- *
 * MIT License                                                                     *
 * =============================================================================== *
 * Permission is hereby granted, free of charge, to any person obtaining a copy    *
 * of this software and associated documentation files (the "Software"), to deal   *
 * in the Software without restriction, including without limitation the rights    *
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell       *
 * copies of the Software, and to permit persons to whom the Software is           *
 * furnished to do so, subject to the following conditions:                        *
 * ------------------------------------------------------------------------------- *
 * The above copyright notice and this permission notice shall be included in all  *
 * copies or substantial portions of the Software.                                 *
 * ------------------------------------------------------------------------------- *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR      *
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,        *
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE     *
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER          *
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,   *
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE   *
 * SOFTWARE.                                                                       *
 ***********************************************************************************/

package jiraiyah.ugoo.datagen;

import jiraiyah.ugoo.registry.ModBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.block.Blocks;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;

import java.util.concurrent.CompletableFuture;

import static jiraiyah.ugoo.Reference.Tags.Block.*;
import static jiraiyah.ugoo.Reference.logRGB256;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider
{
    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture)
    {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg)
    {
        logRGB256("Generating Block Tag Data", 0, 255, 0);

        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
                .add(ModBlocks.BRIDGE_GOO)
                .add(ModBlocks.CHUNK_GOO)
                .add(ModBlocks.LAVA_EATING_GOO)
                .add(ModBlocks.LAVA_GENERATING_GOO)
                .add(ModBlocks.TOWERING_GOO)
                .add(ModBlocks.TUNNELING_GOO)
                .add(ModBlocks.WATER_EATING_GOO)
                .add(ModBlocks.WATER_GENERATING_GOO);

        getOrCreateTagBuilder(BlockTags.NEEDS_STONE_TOOL)
                .add(ModBlocks.BRIDGE_GOO)
                .add(ModBlocks.CHUNK_GOO)
                .add(ModBlocks.LAVA_EATING_GOO)
                .add(ModBlocks.LAVA_GENERATING_GOO)
                .add(ModBlocks.TOWERING_GOO)
                .add(ModBlocks.TUNNELING_GOO)
                .add(ModBlocks.WATER_EATING_GOO)
                .add(ModBlocks.WATER_GENERATING_GOO);

        getOrCreateTagBuilder(BRIDGE_GOO_BLACKLIST)
                .add(Blocks.AMETHYST_BLOCK)
                .add(Blocks.AMETHYST_CLUSTER)
                .add(Blocks.ANCIENT_DEBRIS)
                .add(Blocks.ANVIL)
                .add(Blocks.BARREL)
                .add(Blocks.BEACON)
                .add(Blocks.BEDROCK)
                .add(Blocks.BEE_NEST)
                .add(Blocks.BEEHIVE)
                .add(Blocks.BELL)
                .add(Blocks.BLACK_SHULKER_BOX)
                .add(Blocks.BLAST_FURNACE)
                .add(Blocks.BLUE_SHULKER_BOX)
                .add(Blocks.BREWING_STAND)
                .add(Blocks.BROWN_SHULKER_BOX)
                .add(Blocks.BUDDING_AMETHYST)
                .add(Blocks.CALIBRATED_SCULK_SENSOR)
                .add(Blocks.CAULDRON)
                .add(Blocks.CHEST)
                .add(Blocks.CHIPPED_ANVIL)
                .add(Blocks.COAL_BLOCK)
                .add(Blocks.COAL_ORE)
                .add(Blocks.COMMAND_BLOCK)
                .add(Blocks.COMPARATOR)
                .add(Blocks.COMPOSTER)
                .add(Blocks.CONDUIT)
                .add(Blocks.COPPER_BLOCK)
                .add(Blocks.COPPER_ORE)
                .add(Blocks.CYAN_SHULKER_BOX)
                .add(Blocks.DAMAGED_ANVIL)
                .add(Blocks.DARK_PRISMARINE)
                .add(Blocks.DARK_PRISMARINE_SLAB)
                .add(Blocks.DARK_PRISMARINE_STAIRS)
                .add(Blocks.DAYLIGHT_DETECTOR)
                .add(Blocks.DEEPSLATE_COAL_ORE)
                .add(Blocks.DEEPSLATE_COPPER_ORE)
                .add(Blocks.DEEPSLATE_DIAMOND_ORE)
                .add(Blocks.DEEPSLATE_EMERALD_ORE)
                .add(Blocks.DEEPSLATE_GOLD_ORE)
                .add(Blocks.DEEPSLATE_IRON_ORE)
                .add(Blocks.DEEPSLATE_LAPIS_ORE)
                .add(Blocks.DEEPSLATE_REDSTONE_ORE)
                .add(Blocks.DETECTOR_RAIL)
                .add(Blocks.DIAMOND_BLOCK)
                .add(Blocks.DIAMOND_ORE)
                .add(Blocks.DISPENSER)
                .add(Blocks.DRAGON_EGG)
                .add(Blocks.DROPPER)
                .add(Blocks.EMERALD_BLOCK)
                .add(Blocks.EMERALD_ORE)
                .add(Blocks.ENCHANTING_TABLE)
                .add(Blocks.END_GATEWAY)
                .add(Blocks.END_PORTAL)
                .add(Blocks.END_PORTAL_FRAME)
                .add(Blocks.ENDER_CHEST)
                .add(Blocks.FURNACE)
                .add(Blocks.GLOWSTONE)
                .add(Blocks.GOLD_BLOCK)
                .add(Blocks.GOLD_ORE)
                .add(Blocks.GRAY_SHULKER_BOX)
                .add(Blocks.GREEN_SHULKER_BOX)
                .add(Blocks.GRINDSTONE)
                .add(Blocks.HONEY_BLOCK)
                .add(Blocks.HONEYCOMB_BLOCK)
                .add(Blocks.HOPPER)
                .add(Blocks.IRON_BLOCK)
                .add(Blocks.IRON_DOOR)
                .add(Blocks.IRON_ORE)
                .add(Blocks.LAPIS_BLOCK)
                .add(Blocks.LAPIS_ORE)
                .add(Blocks.LARGE_AMETHYST_BUD)
                .add(Blocks.LAVA_CAULDRON)
                .add(Blocks.LIGHT_BLUE_SHULKER_BOX)
                .add(Blocks.LIGHT_GRAY_SHULKER_BOX)
                .add(Blocks.MAGENTA_SHULKER_BOX)
                .add(Blocks.NETHER_GOLD_ORE)
                .add(Blocks.NETHER_PORTAL)
                .add(Blocks.NETHER_QUARTZ_ORE)
                .add(Blocks.NETHERITE_BLOCK)
                .add(Blocks.ORANGE_SHULKER_BOX)
                .add(Blocks.PINK_SHULKER_BOX)
                .add(Blocks.PISTON)
                .add(Blocks.PISTON_HEAD)
                .add(Blocks.PRISMARINE)
                .add(Blocks.PRISMARINE_BRICK_SLAB)
                .add(Blocks.PRISMARINE_BRICK_STAIRS)
                .add(Blocks.PRISMARINE_BRICKS)
                .add(Blocks.PRISMARINE_SLAB)
                .add(Blocks.PRISMARINE_STAIRS)
                .add(Blocks.PURPLE_SHULKER_BOX)
                .add(Blocks.QUARTZ_BLOCK)
                .add(Blocks.QUARTZ_BRICKS)
                .add(Blocks.QUARTZ_PILLAR)
                .add(Blocks.QUARTZ_SLAB)
                .add(Blocks.QUARTZ_STAIRS)
                .add(Blocks.RED_SHULKER_BOX)
                .add(Blocks.REDSTONE_BLOCK)
                .add(Blocks.REDSTONE_LAMP)
                .add(Blocks.REDSTONE_ORE)
                .add(Blocks.REPEATER)
                .add(Blocks.REPEATING_COMMAND_BLOCK)
                .add(Blocks.SCULK)
                .add(Blocks.SCULK_CATALYST)
                .add(Blocks.SCULK_SENSOR)
                .add(Blocks.SCULK_SHRIEKER)
                .add(Blocks.SCULK_VEIN)
                .add(Blocks.SEA_LANTERN)
                .add(Blocks.SHULKER_BOX)
                .add(Blocks.SLIME_BLOCK)
                .add(Blocks.SPAWNER)
                .add(Blocks.SPONGE)
                .add(Blocks.STICKY_PISTON)
                .add(Blocks.TRAPPED_CHEST)
                .add(Blocks.WHITE_SHULKER_BOX)
                .add(Blocks.YELLOW_SHULKER_BOX);

        getOrCreateTagBuilder(CHUNK_GOO_BLACKLIST)
                .add(Blocks.AMETHYST_BLOCK)
                .add(Blocks.AMETHYST_CLUSTER)
                .add(Blocks.ANCIENT_DEBRIS)
                .add(Blocks.ANVIL)
                .add(Blocks.BARREL)
                .add(Blocks.BEACON)
                .add(Blocks.BEDROCK)
                .add(Blocks.BEE_NEST)
                .add(Blocks.BEEHIVE)
                .add(Blocks.BELL)
                .add(Blocks.BLACK_SHULKER_BOX)
                .add(Blocks.BLAST_FURNACE)
                .add(Blocks.BLUE_SHULKER_BOX)
                .add(Blocks.BREWING_STAND)
                .add(Blocks.BROWN_SHULKER_BOX)
                .add(Blocks.BUDDING_AMETHYST)
                .add(Blocks.CALIBRATED_SCULK_SENSOR)
                .add(Blocks.CAULDRON)
                .add(Blocks.CHEST)
                .add(Blocks.CHIPPED_ANVIL)
                .add(Blocks.COAL_BLOCK)
                .add(Blocks.COAL_ORE)
                .add(Blocks.COMMAND_BLOCK)
                .add(Blocks.COMPARATOR)
                .add(Blocks.COMPOSTER)
                .add(Blocks.CONDUIT)
                .add(Blocks.COPPER_BLOCK)
                .add(Blocks.COPPER_ORE)
                .add(Blocks.CYAN_SHULKER_BOX)
                .add(Blocks.DAMAGED_ANVIL)
                .add(Blocks.DARK_PRISMARINE)
                .add(Blocks.DARK_PRISMARINE_SLAB)
                .add(Blocks.DARK_PRISMARINE_STAIRS)
                .add(Blocks.DAYLIGHT_DETECTOR)
                .add(Blocks.DEEPSLATE_COAL_ORE)
                .add(Blocks.DEEPSLATE_COPPER_ORE)
                .add(Blocks.DEEPSLATE_DIAMOND_ORE)
                .add(Blocks.DEEPSLATE_EMERALD_ORE)
                .add(Blocks.DEEPSLATE_GOLD_ORE)
                .add(Blocks.DEEPSLATE_IRON_ORE)
                .add(Blocks.DEEPSLATE_LAPIS_ORE)
                .add(Blocks.DEEPSLATE_REDSTONE_ORE)
                .add(Blocks.DETECTOR_RAIL)
                .add(Blocks.DIAMOND_BLOCK)
                .add(Blocks.DIAMOND_ORE)
                .add(Blocks.DISPENSER)
                .add(Blocks.DRAGON_EGG)
                .add(Blocks.DROPPER)
                .add(Blocks.EMERALD_BLOCK)
                .add(Blocks.EMERALD_ORE)
                .add(Blocks.ENCHANTING_TABLE)
                .add(Blocks.END_GATEWAY)
                .add(Blocks.END_PORTAL)
                .add(Blocks.END_PORTAL_FRAME)
                .add(Blocks.ENDER_CHEST)
                .add(Blocks.FURNACE)
                .add(Blocks.GLOWSTONE)
                .add(Blocks.GOLD_BLOCK)
                .add(Blocks.GOLD_ORE)
                .add(Blocks.GRAY_SHULKER_BOX)
                .add(Blocks.GREEN_SHULKER_BOX)
                .add(Blocks.GRINDSTONE)
                .add(Blocks.HONEY_BLOCK)
                .add(Blocks.HONEYCOMB_BLOCK)
                .add(Blocks.HOPPER)
                .add(Blocks.IRON_BLOCK)
                .add(Blocks.IRON_DOOR)
                .add(Blocks.IRON_ORE)
                .add(Blocks.LAPIS_BLOCK)
                .add(Blocks.LAPIS_ORE)
                .add(Blocks.LARGE_AMETHYST_BUD)
                .add(Blocks.LAVA_CAULDRON)
                .add(Blocks.LIGHT_BLUE_SHULKER_BOX)
                .add(Blocks.LIGHT_GRAY_SHULKER_BOX)
                .add(Blocks.MAGENTA_SHULKER_BOX)
                .add(Blocks.NETHER_GOLD_ORE)
                .add(Blocks.NETHER_PORTAL)
                .add(Blocks.NETHER_QUARTZ_ORE)
                .add(Blocks.NETHERITE_BLOCK)
                .add(Blocks.ORANGE_SHULKER_BOX)
                .add(Blocks.PINK_SHULKER_BOX)
                .add(Blocks.PISTON)
                .add(Blocks.PISTON_HEAD)
                .add(Blocks.PRISMARINE)
                .add(Blocks.PRISMARINE_BRICK_SLAB)
                .add(Blocks.PRISMARINE_BRICK_STAIRS)
                .add(Blocks.PRISMARINE_BRICKS)
                .add(Blocks.PRISMARINE_SLAB)
                .add(Blocks.PRISMARINE_STAIRS)
                .add(Blocks.PURPLE_SHULKER_BOX)
                .add(Blocks.QUARTZ_BLOCK)
                .add(Blocks.QUARTZ_BRICKS)
                .add(Blocks.QUARTZ_PILLAR)
                .add(Blocks.QUARTZ_SLAB)
                .add(Blocks.QUARTZ_STAIRS)
                .add(Blocks.RED_SHULKER_BOX)
                .add(Blocks.REDSTONE_BLOCK)
                .add(Blocks.REDSTONE_LAMP)
                .add(Blocks.REDSTONE_ORE)
                .add(Blocks.REPEATER)
                .add(Blocks.REPEATING_COMMAND_BLOCK)
                .add(Blocks.SCULK)
                .add(Blocks.SCULK_CATALYST)
                .add(Blocks.SCULK_SENSOR)
                .add(Blocks.SCULK_SHRIEKER)
                .add(Blocks.SCULK_VEIN)
                .add(Blocks.SEA_LANTERN)
                .add(Blocks.SHULKER_BOX)
                .add(Blocks.SLIME_BLOCK)
                .add(Blocks.SPAWNER)
                .add(Blocks.SPONGE)
                .add(Blocks.STICKY_PISTON)
                .add(Blocks.TRAPPED_CHEST)
                .add(Blocks.WHITE_SHULKER_BOX)
                .add(Blocks.YELLOW_SHULKER_BOX);

        getOrCreateTagBuilder(TOWERING_GOO_BLACKLIST)
                .add(Blocks.AMETHYST_BLOCK)
                .add(Blocks.AMETHYST_CLUSTER)
                .add(Blocks.ANCIENT_DEBRIS)
                .add(Blocks.ANVIL)
                .add(Blocks.BARREL)
                .add(Blocks.BEACON)
                .add(Blocks.BEDROCK)
                .add(Blocks.BEE_NEST)
                .add(Blocks.BEEHIVE)
                .add(Blocks.BELL)
                .add(Blocks.BLACK_SHULKER_BOX)
                .add(Blocks.BLAST_FURNACE)
                .add(Blocks.BLUE_SHULKER_BOX)
                .add(Blocks.BREWING_STAND)
                .add(Blocks.BROWN_SHULKER_BOX)
                .add(Blocks.BUDDING_AMETHYST)
                .add(Blocks.CALIBRATED_SCULK_SENSOR)
                .add(Blocks.CAULDRON)
                .add(Blocks.CHEST)
                .add(Blocks.CHIPPED_ANVIL)
                .add(Blocks.COAL_BLOCK)
                .add(Blocks.COAL_ORE)
                .add(Blocks.COMMAND_BLOCK)
                .add(Blocks.COMPARATOR)
                .add(Blocks.COMPOSTER)
                .add(Blocks.CONDUIT)
                .add(Blocks.COPPER_BLOCK)
                .add(Blocks.COPPER_ORE)
                .add(Blocks.CYAN_SHULKER_BOX)
                .add(Blocks.DAMAGED_ANVIL)
                .add(Blocks.DARK_PRISMARINE)
                .add(Blocks.DARK_PRISMARINE_SLAB)
                .add(Blocks.DARK_PRISMARINE_STAIRS)
                .add(Blocks.DAYLIGHT_DETECTOR)
                .add(Blocks.DEEPSLATE_COAL_ORE)
                .add(Blocks.DEEPSLATE_COPPER_ORE)
                .add(Blocks.DEEPSLATE_DIAMOND_ORE)
                .add(Blocks.DEEPSLATE_EMERALD_ORE)
                .add(Blocks.DEEPSLATE_GOLD_ORE)
                .add(Blocks.DEEPSLATE_IRON_ORE)
                .add(Blocks.DEEPSLATE_LAPIS_ORE)
                .add(Blocks.DEEPSLATE_REDSTONE_ORE)
                .add(Blocks.DETECTOR_RAIL)
                .add(Blocks.DIAMOND_BLOCK)
                .add(Blocks.DIAMOND_ORE)
                .add(Blocks.DISPENSER)
                .add(Blocks.DRAGON_EGG)
                .add(Blocks.DROPPER)
                .add(Blocks.EMERALD_BLOCK)
                .add(Blocks.EMERALD_ORE)
                .add(Blocks.ENCHANTING_TABLE)
                .add(Blocks.END_GATEWAY)
                .add(Blocks.END_PORTAL)
                .add(Blocks.END_PORTAL_FRAME)
                .add(Blocks.ENDER_CHEST)
                .add(Blocks.FURNACE)
                .add(Blocks.GLOWSTONE)
                .add(Blocks.GOLD_BLOCK)
                .add(Blocks.GOLD_ORE)
                .add(Blocks.GRAY_SHULKER_BOX)
                .add(Blocks.GREEN_SHULKER_BOX)
                .add(Blocks.GRINDSTONE)
                .add(Blocks.HONEY_BLOCK)
                .add(Blocks.HONEYCOMB_BLOCK)
                .add(Blocks.HOPPER)
                .add(Blocks.IRON_BLOCK)
                .add(Blocks.IRON_DOOR)
                .add(Blocks.IRON_ORE)
                .add(Blocks.LAPIS_BLOCK)
                .add(Blocks.LAPIS_ORE)
                .add(Blocks.LARGE_AMETHYST_BUD)
                .add(Blocks.LAVA_CAULDRON)
                .add(Blocks.LIGHT_BLUE_SHULKER_BOX)
                .add(Blocks.LIGHT_GRAY_SHULKER_BOX)
                .add(Blocks.MAGENTA_SHULKER_BOX)
                .add(Blocks.NETHER_GOLD_ORE)
                .add(Blocks.NETHER_PORTAL)
                .add(Blocks.NETHER_QUARTZ_ORE)
                .add(Blocks.NETHERITE_BLOCK)
                .add(Blocks.ORANGE_SHULKER_BOX)
                .add(Blocks.PINK_SHULKER_BOX)
                .add(Blocks.PISTON)
                .add(Blocks.PISTON_HEAD)
                .add(Blocks.PRISMARINE)
                .add(Blocks.PRISMARINE_BRICK_SLAB)
                .add(Blocks.PRISMARINE_BRICK_STAIRS)
                .add(Blocks.PRISMARINE_BRICKS)
                .add(Blocks.PRISMARINE_SLAB)
                .add(Blocks.PRISMARINE_STAIRS)
                .add(Blocks.PURPLE_SHULKER_BOX)
                .add(Blocks.QUARTZ_BLOCK)
                .add(Blocks.QUARTZ_BRICKS)
                .add(Blocks.QUARTZ_PILLAR)
                .add(Blocks.QUARTZ_SLAB)
                .add(Blocks.QUARTZ_STAIRS)
                .add(Blocks.RED_SHULKER_BOX)
                .add(Blocks.REDSTONE_BLOCK)
                .add(Blocks.REDSTONE_LAMP)
                .add(Blocks.REDSTONE_ORE)
                .add(Blocks.REPEATER)
                .add(Blocks.REPEATING_COMMAND_BLOCK)
                .add(Blocks.SCULK)
                .add(Blocks.SCULK_CATALYST)
                .add(Blocks.SCULK_SENSOR)
                .add(Blocks.SCULK_SHRIEKER)
                .add(Blocks.SCULK_VEIN)
                .add(Blocks.SEA_LANTERN)
                .add(Blocks.SHULKER_BOX)
                .add(Blocks.SLIME_BLOCK)
                .add(Blocks.SPAWNER)
                .add(Blocks.SPONGE)
                .add(Blocks.STICKY_PISTON)
                .add(Blocks.TRAPPED_CHEST)
                .add(Blocks.WHITE_SHULKER_BOX)
                .add(Blocks.YELLOW_SHULKER_BOX);

        getOrCreateTagBuilder(TUNNELING_GOO_BLACKLIST)
                .add(Blocks.AMETHYST_BLOCK)
                .add(Blocks.AMETHYST_CLUSTER)
                .add(Blocks.ANCIENT_DEBRIS)
                .add(Blocks.ANVIL)
                .add(Blocks.BARREL)
                .add(Blocks.BEACON)
                .add(Blocks.BEDROCK)
                .add(Blocks.BEE_NEST)
                .add(Blocks.BEEHIVE)
                .add(Blocks.BELL)
                .add(Blocks.BLACK_SHULKER_BOX)
                .add(Blocks.BLAST_FURNACE)
                .add(Blocks.BLUE_SHULKER_BOX)
                .add(Blocks.BREWING_STAND)
                .add(Blocks.BROWN_SHULKER_BOX)
                .add(Blocks.BUDDING_AMETHYST)
                .add(Blocks.CALIBRATED_SCULK_SENSOR)
                .add(Blocks.CAULDRON)
                .add(Blocks.CHEST)
                .add(Blocks.CHIPPED_ANVIL)
                .add(Blocks.COAL_BLOCK)
                .add(Blocks.COAL_ORE)
                .add(Blocks.COMMAND_BLOCK)
                .add(Blocks.COMPARATOR)
                .add(Blocks.COMPOSTER)
                .add(Blocks.CONDUIT)
                .add(Blocks.COPPER_BLOCK)
                .add(Blocks.COPPER_ORE)
                .add(Blocks.CYAN_SHULKER_BOX)
                .add(Blocks.DAMAGED_ANVIL)
                .add(Blocks.DARK_PRISMARINE)
                .add(Blocks.DARK_PRISMARINE_SLAB)
                .add(Blocks.DARK_PRISMARINE_STAIRS)
                .add(Blocks.DAYLIGHT_DETECTOR)
                .add(Blocks.DEEPSLATE_COAL_ORE)
                .add(Blocks.DEEPSLATE_COPPER_ORE)
                .add(Blocks.DEEPSLATE_DIAMOND_ORE)
                .add(Blocks.DEEPSLATE_EMERALD_ORE)
                .add(Blocks.DEEPSLATE_GOLD_ORE)
                .add(Blocks.DEEPSLATE_IRON_ORE)
                .add(Blocks.DEEPSLATE_LAPIS_ORE)
                .add(Blocks.DEEPSLATE_REDSTONE_ORE)
                .add(Blocks.DETECTOR_RAIL)
                .add(Blocks.DIAMOND_BLOCK)
                .add(Blocks.DIAMOND_ORE)
                .add(Blocks.DISPENSER)
                .add(Blocks.DRAGON_EGG)
                .add(Blocks.DROPPER)
                .add(Blocks.EMERALD_BLOCK)
                .add(Blocks.EMERALD_ORE)
                .add(Blocks.ENCHANTING_TABLE)
                .add(Blocks.END_GATEWAY)
                .add(Blocks.END_PORTAL)
                .add(Blocks.END_PORTAL_FRAME)
                .add(Blocks.ENDER_CHEST)
                .add(Blocks.FURNACE)
                .add(Blocks.GLOWSTONE)
                .add(Blocks.GOLD_BLOCK)
                .add(Blocks.GOLD_ORE)
                .add(Blocks.GRAY_SHULKER_BOX)
                .add(Blocks.GREEN_SHULKER_BOX)
                .add(Blocks.GRINDSTONE)
                .add(Blocks.HONEY_BLOCK)
                .add(Blocks.HONEYCOMB_BLOCK)
                .add(Blocks.HOPPER)
                .add(Blocks.IRON_BLOCK)
                .add(Blocks.IRON_DOOR)
                .add(Blocks.IRON_ORE)
                .add(Blocks.LAPIS_BLOCK)
                .add(Blocks.LAPIS_ORE)
                .add(Blocks.LARGE_AMETHYST_BUD)
                .add(Blocks.LAVA_CAULDRON)
                .add(Blocks.LIGHT_BLUE_SHULKER_BOX)
                .add(Blocks.LIGHT_GRAY_SHULKER_BOX)
                .add(Blocks.MAGENTA_SHULKER_BOX)
                .add(Blocks.NETHER_GOLD_ORE)
                .add(Blocks.NETHER_PORTAL)
                .add(Blocks.NETHER_QUARTZ_ORE)
                .add(Blocks.NETHERITE_BLOCK)
                .add(Blocks.ORANGE_SHULKER_BOX)
                .add(Blocks.PINK_SHULKER_BOX)
                .add(Blocks.PISTON)
                .add(Blocks.PISTON_HEAD)
                .add(Blocks.PRISMARINE)
                .add(Blocks.PRISMARINE_BRICK_SLAB)
                .add(Blocks.PRISMARINE_BRICK_STAIRS)
                .add(Blocks.PRISMARINE_BRICKS)
                .add(Blocks.PRISMARINE_SLAB)
                .add(Blocks.PRISMARINE_STAIRS)
                .add(Blocks.PURPLE_SHULKER_BOX)
                .add(Blocks.QUARTZ_BLOCK)
                .add(Blocks.QUARTZ_BRICKS)
                .add(Blocks.QUARTZ_PILLAR)
                .add(Blocks.QUARTZ_SLAB)
                .add(Blocks.QUARTZ_STAIRS)
                .add(Blocks.RED_SHULKER_BOX)
                .add(Blocks.REDSTONE_BLOCK)
                .add(Blocks.REDSTONE_LAMP)
                .add(Blocks.REDSTONE_ORE)
                .add(Blocks.REPEATER)
                .add(Blocks.REPEATING_COMMAND_BLOCK)
                .add(Blocks.SCULK)
                .add(Blocks.SCULK_CATALYST)
                .add(Blocks.SCULK_SENSOR)
                .add(Blocks.SCULK_SHRIEKER)
                .add(Blocks.SCULK_VEIN)
                .add(Blocks.SEA_LANTERN)
                .add(Blocks.SHULKER_BOX)
                .add(Blocks.SLIME_BLOCK)
                .add(Blocks.SPAWNER)
                .add(Blocks.SPONGE)
                .add(Blocks.STICKY_PISTON)
                .add(Blocks.TRAPPED_CHEST)
                .add(Blocks.WHITE_SHULKER_BOX)
                .add(Blocks.YELLOW_SHULKER_BOX);
    }
}