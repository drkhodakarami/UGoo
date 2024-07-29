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

package jiraiyah.ugoo.registry;

import jiraiyah.ugoo.block.*;
import net.minecraft.block.*;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;

import java.util.List;

import static jiraiyah.ugoo.Reference.identifier;
import static jiraiyah.ugoo.Reference.log;

public class ModBlocks
{
    public static final Block AIR_GOO_BOMB = registerBlock("air_goo_bomb", new AirGooBomb(AbstractBlock.Settings.copy(Blocks.STONE)), "air_bomb", false);
    public static final Block STONE_GOO_BOMB = registerBlock("stone_goo_bomb", new StoneGooBomb(AbstractBlock.Settings.copy(Blocks.STONE)), "stone_bomb", false);
    public static final Block BRIDGE_GOO = registerBlock("bridge_goo", new BridgeGoo(AbstractBlock.Settings.copy(Blocks.STONE)), "bridge", false);
    public static final Block CHUNK_GOO = registerBlock("chunk_goo", new ChunkGoo(AbstractBlock.Settings.copy(Blocks.STONE)), "chunk", true);
    public static final Block CHUNK_GOO_BOMB = registerBlock("chunk_goo_bomb", new ChunkGooBomb(AbstractBlock.Settings.copy(Blocks.STONE)), "chunk_bomb", false);
    public static final Block LAVA_EATING_GOO = registerBlock("lava_eating_goo", new LavaEatingGoo(AbstractBlock.Settings.copy(Blocks.STONE)), "lava_eating", true);
    public static final Block LAVA_GENERATING_GOO = registerBlock("lava_generating_goo", new LavaGeneratingGoo(AbstractBlock.Settings.copy(Blocks.STONE)), "lava_generating", true);
    public static final Block LAVA_PUMP_GOO = registerBlock("lava_pump_goo", new LavaPumpGoo(AbstractBlock.Settings.copy(Blocks.STONE)), "lava_pump", false);
    public static final Block TOWERING_GOO = registerBlock("towering_goo", new ToweringGoo(AbstractBlock.Settings.copy(Blocks.STONE)), "towering", false);
    public static final Block TUNNELING_GOO = registerBlock("tunneling_goo", new TunnelingGoo(AbstractBlock.Settings.copy(Blocks.STONE)), "tunneling", false);
    public static final Block WATER_EATING_GOO = registerBlock("water_eating_goo", new WaterEatingGoo(AbstractBlock.Settings.copy(Blocks.STONE)), "water_eating", true);
    public static final Block WATER_GENERATING_GOO = registerBlock("water_generating_goo", new WaterGeneratingGoo(AbstractBlock.Settings.copy(Blocks.STONE)), "water_generating", true);
    public static final Block WATER_PUMP_GOO = registerBlock("water_pump_goo", new WaterPumpGoo(AbstractBlock.Settings.copy(Blocks.STONE)), "water_pump", false);

    public ModBlocks()
    {
        throw new AssertionError();
    }

    //region HELPER METHODS

    public static void register()
    {
        log("Registering Blocks");
    }

    private static Block registerBlock(String name, Block block, String tooltip, boolean warning)
    {
        registerBlockItem(name, block, tooltip, warning);
        return Registry.register(Registries.BLOCK, identifier(name), block);
    }

    private static Item registerBlockItem(String name, Block block, String tooltip, boolean warning)
    {
        return Registry.register(Registries.ITEM, identifier(name),
                                 new BlockItem(block, new Item.Settings()) {
                                     @Override
                                     public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type)
                                     {
                                         if(warning)
                                             tooltip.add(Text.translatable("tooltip.ugoo.warning"));
                                         if (Screen.hasShiftDown()) {
                                             tooltip.add(Text.translatable("tooltip.ugoo." + tooltip));
                                         } else {
                                             tooltip.add(Text.translatable("tooltip.ugoo.shift"));
                                         }
                                         super.appendTooltip(stack, context, tooltip, type);
                                     }
                                 });
    }

    //endregion
}