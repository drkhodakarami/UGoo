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

import jiraiyah.ugoo.blockentity.*;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.Block;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

import static jiraiyah.ugoo.Reference.*;

public class ModBlockEntities
{
    public static BlockEntityType<AirGooBombBlockEntity> AIR_GOO_BOMB;
    public static BlockEntityType<StoneGooBombBlockEntity> STONE_GOO_BOMB;
    public static BlockEntityType<BridgeGooBlockEntity> BRIDGE_GOO;
    public static BlockEntityType<ChunkGooBlockEntity> CHUNK_GOO;
    public static BlockEntityType<ChunkGooBombBlockEntity> CHUNK_GOO_BOMB;
    public static BlockEntityType<LavaEatingGooBlockEntity> LAVA_EATING_GOO;
    public static BlockEntityType<LavaGeneratingGooBlockEntity> LAVA_GENERATING_GOO;
    public static BlockEntityType<LavaPumpGooBlockEntity> LAVA_PUMP_GOO;
    public static BlockEntityType<ToweringGooBlockEntity> TOWERING_GOO;
    public static BlockEntityType<TunnelingGooBlockEntity> TUNNELING_GOO;
    public static BlockEntityType<WaterEatingGooBlockEntity> WATER_EATING_GOO;
    public static BlockEntityType<WaterGeneratingGooBlockEntity> WATER_GENERATING_GOO;
    public static BlockEntityType<WaterPumpGooBlockEntity> WATER_PUMP_GOO;

    public ModBlockEntities()
    {
        throw new AssertionError();
    }

    public static void register()
    {
        log("Registering Block Entities");

        AIR_GOO_BOMB = Registry.register(Registries.BLOCK_ENTITY_TYPE, identifier("air_goo_bomb"),
                                         BlockEntityType.Builder.create(
                                                   AirGooBombBlockEntity::new, new Block[]{ModBlocks.AIR_GOO_BOMB}
                                           ).build(null));

        STONE_GOO_BOMB = Registry.register(Registries.BLOCK_ENTITY_TYPE, identifier("stone_goo_bomb"),
                                           BlockEntityType.Builder.create(
                                                 StoneGooBombBlockEntity::new, new Block[]{ModBlocks.STONE_GOO_BOMB}
                                         ).build(null));

        BRIDGE_GOO = Registry.register(Registries.BLOCK_ENTITY_TYPE, identifier("bridge_goo"),
                                       BlockEntityType.Builder.create(
                                              BridgeGooBlockEntity::new, new Block[]{ModBlocks.BRIDGE_GOO}
                                      ).build(null));

        CHUNK_GOO = Registry.register(Registries.BLOCK_ENTITY_TYPE, identifier("chunk_goo"),
                                      BlockEntityType.Builder.create(
                                            ChunkGooBlockEntity::new, new Block[]{ModBlocks.CHUNK_GOO}
                                                ).build(null));

        CHUNK_GOO_BOMB = Registry.register(Registries.BLOCK_ENTITY_TYPE, identifier("chunk_goo_bomb"),
                                           BlockEntityType.Builder.create(
                                                 ChunkGooBombBlockEntity::new, new Block[]{ModBlocks.CHUNK_GOO_BOMB}
                                         ).build(null));

        LAVA_EATING_GOO = Registry.register(Registries.BLOCK_ENTITY_TYPE, identifier("lava_eating_goo"),
                                            BlockEntityType.Builder.create(
                                              LavaEatingGooBlockEntity::new, new Block[]{ModBlocks.LAVA_EATING_GOO}
                                      ).build(null));

        LAVA_GENERATING_GOO = Registry.register(Registries.BLOCK_ENTITY_TYPE, identifier("lava_generating_goo"),
                                                BlockEntityType.Builder.create(
                                                    LavaGeneratingGooBlockEntity::new, new Block[]{ModBlocks.LAVA_GENERATING_GOO}
                                            ).build(null));

        LAVA_PUMP_GOO = Registry.register(Registries.BLOCK_ENTITY_TYPE, identifier("lava_pump_goo"),
                                          BlockEntityType.Builder.create(
                                                        LavaPumpGooBlockEntity::new, new Block[]{ModBlocks.LAVA_PUMP_GOO}
                                                ).build(null));

        TOWERING_GOO = Registry.register(Registries.BLOCK_ENTITY_TYPE, identifier("towering_goo"),
                                         BlockEntityType.Builder.create(
                                              ToweringGooBlockEntity::new, new Block[]{ModBlocks.TOWERING_GOO}
                                      ).build(null));

        TUNNELING_GOO = Registry.register(Registries.BLOCK_ENTITY_TYPE, identifier("tunneling_goo"),
                                          BlockEntityType.Builder.create(
                                                 TunnelingGooBlockEntity::new, new Block[]{ModBlocks.TUNNELING_GOO}
                                         ).build(null));

        WATER_EATING_GOO = Registry.register(Registries.BLOCK_ENTITY_TYPE, identifier("water_eating_goo"),
                                             BlockEntityType.Builder.create(
                                                    WaterEatingGooBlockEntity::new, new Block[]{ModBlocks.WATER_EATING_GOO}
                                            ).build(null));

        WATER_GENERATING_GOO = Registry.register(Registries.BLOCK_ENTITY_TYPE, identifier("water_generating_goo"),
                                                 BlockEntityType.Builder.create(
                                                        WaterGeneratingGooBlockEntity::new, new Block[]{ModBlocks.WATER_GENERATING_GOO}
                                                ).build(null));

        WATER_PUMP_GOO = Registry.register(Registries.BLOCK_ENTITY_TYPE, identifier("water_pump_goo"),
                                           BlockEntityType.Builder.create(
                                                         WaterPumpGooBlockEntity::new, new Block[]{ModBlocks.WATER_PUMP_GOO}
                                                 ).build(null));
    }
}