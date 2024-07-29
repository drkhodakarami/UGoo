package jiraiyah.ugoo.blockentity;

import jiraiyah.ugoo.Main;
import jiraiyah.ugoo.Utils;
import jiraiyah.ugoo.block.ChunkGoo;
import jiraiyah.ugoo.block.WaterEatingGoo;
import jiraiyah.ugoo.registry.ModBlockEntities;
import jiraiyah.ugoo.registry.ModBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class WaterEatingGooBlockEntity extends BlockEntity
{
    public WaterEatingGooBlockEntity(BlockPos pos, BlockState state)
    {
        super(ModBlockEntities.WATER_EATING_GOO, pos, state);
    }

    public static void tick(World world, BlockPos pos, BlockState state, WaterEatingGooBlockEntity entity)
    {
        if (world.isClient() ||
            !world.getGameRules().getBoolean(Main.SPREAD) ||
            !state.get(WaterEatingGoo.UNSTABLE))
            return;

        float chance = Utils.getChance(world.getGameRules().getInt(Main.WATER_EATING_CHANCE));

        if(world.getRandom().nextFloat() < chance)
            return;

        BlockPos[] sides = Utils.getPositionNextTo(pos);
        for (BlockPos side : sides)
            if (world.getBlockState(side).isOf(Blocks.WATER) &&
                world.getBlockState(side).getFluidState().isStill())
                world.setBlockState(side,
                                    ModBlocks.WATER_EATING_GOO.getDefaultState().with(WaterEatingGoo.UNSTABLE, true),
                                    3);

        world.setBlockState(pos, Blocks.AIR.getDefaultState(), 3);
    }
}