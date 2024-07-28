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
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;

import static jiraiyah.ugoo.Reference.logRGB256;

public class ModModelProvider extends FabricModelProvider
{
    public ModModelProvider(FabricDataOutput output)
    {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator)
    {
        logRGB256("Generating Block Model Data", 0, 255, 0);

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.AIR_GOO_BOMB);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.STONE_GOO_BOMB);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.BRIDGE_GOO);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.TUNNELING_GOO);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.TOWERING_GOO);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.CHUNK_GOO);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.CHUNK_GOO_BOMB);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.LAVA_EATING_GOO);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.LAVA_GENERATING_GOO);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.LAVA_PUMP_GOO);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.WATER_EATING_GOO);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.WATER_GENERATING_GOO);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.WATER_PUMP_GOO);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator)
    {
        logRGB256("Generating Item Model Data", 0, 255, 0);
    }
}