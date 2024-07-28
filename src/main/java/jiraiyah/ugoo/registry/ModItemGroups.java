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

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

import static jiraiyah.ugoo.Reference.*;

public class ModItemGroups
{
    public static final ItemGroup MAIN =
            Registry.register(Registries.ITEM_GROUP,
                              identifier(ModID + "_main_group"),
                              FabricItemGroup.builder().displayName(translate("main.group"))
                                             .icon(() -> new ItemStack(ModBlocks.CHUNK_GOO))
                                             .entries((displayContext, entries) ->
                                                      {
                                                          entries.add(ModBlocks.BRIDGE_GOO);
                                                          entries.add(ModBlocks.CHUNK_GOO);
                                                          entries.add(ModBlocks.TOWERING_GOO);
                                                          entries.add(ModBlocks.TUNNELING_GOO);
                                                          entries.add(ModBlocks.LAVA_EATING_GOO);
                                                          entries.add(ModBlocks.LAVA_GENERATING_GOO);
                                                          entries.add(ModBlocks.LAVA_PUMP_GOO);
                                                          entries.add(ModBlocks.WATER_EATING_GOO);
                                                          entries.add(ModBlocks.WATER_GENERATING_GOO);
                                                          entries.add(ModBlocks.WATER_PUMP_GOO);
                                                      }).build());

    public ModItemGroups()
    {
        throw new AssertionError();
    }

    public static void register()
    {
        log("Registering Item Groups");
    }
}