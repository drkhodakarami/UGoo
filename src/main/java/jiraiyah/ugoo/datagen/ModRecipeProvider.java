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
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.block.Blocks;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

import static jiraiyah.ugoo.Reference.logRGB256;
import static jiraiyah.ugoo.Reference.vanillaID;

public class ModRecipeProvider extends FabricRecipeProvider
{

    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture)
    {
        super(output, registriesFuture);
    }

    @Override
    public void generate(RecipeExporter exporter)
    {
        logRGB256("Generating Recipe Data", 0, 255, 0);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.BRIDGE_GOO, 1)
                               .pattern("DED")
                               .pattern("EWE")
                               .pattern("DSD")
                               .input('E', Items.ENDER_PEARL)
                               .input('W', Blocks.GOLD_BLOCK)
                               .input('D', Blocks.YELLOW_WOOL)
                               .input('S', Blocks.STONE)
                               .criterion(hasItem(Items.ENDER_PEARL), conditionsFromItem(Items.ENDER_PEARL))
                               .criterion(hasItem(Blocks.GOLD_BLOCK), conditionsFromItem(Blocks.GOLD_BLOCK))
                               .criterion(hasItem(Blocks.YELLOW_WOOL), conditionsFromItem(Blocks.YELLOW_WOOL))
                               .criterion(hasItem(Blocks.STONE), conditionsFromItem(Blocks.STONE))
                               .offerTo(exporter, vanillaID(getRecipeName(ModBlocks.BRIDGE_GOO)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.CHUNK_GOO, 1)
                               .pattern("DPD")
                               .pattern("EWE")
                               .pattern("DED")
                               .input('E', Items.ENDER_PEARL)
                               .input('W', Blocks.DIAMOND_BLOCK)
                               .input('D', Blocks.PINK_WOOL)
                               .input('P', Items.DIAMOND_PICKAXE)
                               .criterion(hasItem(Items.ENDER_PEARL), conditionsFromItem(Items.ENDER_PEARL))
                               .criterion(hasItem(Blocks.DIAMOND_BLOCK), conditionsFromItem(Blocks.DIAMOND_BLOCK))
                               .criterion(hasItem(Blocks.PINK_WOOL), conditionsFromItem(Blocks.PINK_WOOL))
                               .criterion(hasItem(Items.DIAMOND_PICKAXE), conditionsFromItem(Items.DIAMOND_PICKAXE))
                               .offerTo(exporter, vanillaID(getRecipeName(ModBlocks.CHUNK_GOO)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.LAVA_EATING_GOO, 1)
                               .pattern("DBD")
                               .pattern("EWE")
                               .pattern("DED")
                               .input('E', Items.ENDER_PEARL)
                               .input('W', Items.ENDER_EYE)
                               .input('D', Items.MAGENTA_WOOL)
                               .input('B', Items.LAVA_BUCKET)
                               .criterion(hasItem(Items.ENDER_PEARL), conditionsFromItem(Items.ENDER_PEARL))
                               .criterion(hasItem(Items.ENDER_EYE), conditionsFromItem(Items.ENDER_EYE))
                               .criterion(hasItem(Items.MAGENTA_WOOL), conditionsFromItem(Items.MAGENTA_WOOL))
                               .criterion(hasItem(Items.LAVA_BUCKET), conditionsFromItem(Items.LAVA_BUCKET))
                               .offerTo(exporter, vanillaID(getRecipeName(ModBlocks.LAVA_EATING_GOO)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.LAVA_GENERATING_GOO, 1)
                               .pattern("DBD")
                               .pattern("EWE")
                               .pattern("DBD")
                               .input('E', Items.ENDER_PEARL)
                               .input('W', Items.ENDER_EYE)
                               .input('D', Items.RED_WOOL)
                               .input('B', Items.LAVA_BUCKET)
                               .criterion(hasItem(Items.ENDER_PEARL), conditionsFromItem(Items.ENDER_PEARL))
                               .criterion(hasItem(Items.ENDER_EYE), conditionsFromItem(Items.ENDER_EYE))
                               .criterion(hasItem(Items.RED_WOOL), conditionsFromItem(Items.RED_WOOL))
                               .criterion(hasItem(Items.LAVA_BUCKET), conditionsFromItem(Items.LAVA_BUCKET))
                               .offerTo(exporter, vanillaID(getRecipeName(ModBlocks.LAVA_GENERATING_GOO)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.TOWERING_GOO, 1)
                               .pattern("DTD")
                               .pattern("ETE")
                               .pattern("DTD")
                               .input('E', Items.ENDER_PEARL)
                               .input('D', Items.PURPLE_WOOL)
                               .input('T', Blocks.TNT)
                               .criterion(hasItem(Items.ENDER_PEARL), conditionsFromItem(Items.ENDER_PEARL))
                               .criterion(hasItem(Items.ENDER_EYE), conditionsFromItem(Items.ENDER_EYE))
                               .criterion(hasItem(Items.PURPLE_WOOL), conditionsFromItem(Items.PURPLE_WOOL))
                               .criterion(hasItem(Blocks.TNT), conditionsFromItem(Blocks.TNT))
                               .offerTo(exporter, vanillaID(getRecipeName(ModBlocks.TOWERING_GOO)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.TUNNELING_GOO, 1)
                               .pattern("DED")
                               .pattern("TTT")
                               .pattern("DED")
                               .input('E', Items.ENDER_PEARL)
                               .input('D', Items.CYAN_WOOL)
                               .input('T', Blocks.TNT)
                               .criterion(hasItem(Items.ENDER_PEARL), conditionsFromItem(Items.ENDER_PEARL))
                               .criterion(hasItem(Items.CYAN_WOOL), conditionsFromItem(Items.CYAN_WOOL))
                               .criterion(hasItem(Blocks.TNT), conditionsFromItem(Blocks.TNT))
                               .offerTo(exporter, vanillaID(getRecipeName(ModBlocks.TUNNELING_GOO)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.WATER_EATING_GOO, 1)
                               .pattern("DBD")
                               .pattern("EWE")
                               .pattern("DED")
                               .input('E', Items.ENDER_PEARL)
                               .input('W', Items.ENDER_EYE)
                               .input('D', Items.GRAY_WOOL)
                               .input('B', Items.WATER_BUCKET)
                               .criterion(hasItem(Items.ENDER_PEARL), conditionsFromItem(Items.ENDER_PEARL))
                               .criterion(hasItem(Items.ENDER_EYE), conditionsFromItem(Items.ENDER_EYE))
                               .criterion(hasItem(Items.GRAY_WOOL), conditionsFromItem(Items.GRAY_WOOL))
                               .criterion(hasItem(Items.WATER_BUCKET), conditionsFromItem(Items.WATER_BUCKET))
                               .offerTo(exporter, vanillaID(getRecipeName(ModBlocks.WATER_EATING_GOO)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.WATER_GENERATING_GOO, 1)
                               .pattern("DBD")
                               .pattern("EDE")
                               .pattern("DBD")
                               .input('E', Items.ENDER_PEARL)
                               .input('D', Items.BLUE_WOOL)
                               .input('B', Items.WATER_BUCKET)
                               .criterion(hasItem(Items.ENDER_PEARL), conditionsFromItem(Items.ENDER_PEARL))
                               .criterion(hasItem(Items.BLUE_WOOL), conditionsFromItem(Items.BLUE_WOOL))
                               .criterion(hasItem(Items.WATER_BUCKET), conditionsFromItem(Items.WATER_BUCKET))
                               .offerTo(exporter, vanillaID(getRecipeName(ModBlocks.WATER_GENERATING_GOO)));
    }
}