package jiraiyah.ugoo.blockentity;

import jiraiyah.ugoo.Main;
import jiraiyah.ugoo.Utils;
import jiraiyah.ugoo.block.ChunkGoo;
import jiraiyah.ugoo.block.WaterGeneratingGoo;
import jiraiyah.ugoo.registry.ModBlockEntities;
import jiraiyah.ugoo.registry.ModBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class WaterGeneratingGooBlockEntity extends BlockEntity
{
    public WaterGeneratingGooBlockEntity(BlockPos pos, BlockState state)
    {
        super(ModBlockEntities.WATER_GENERATING_GOO, pos, state);
    }

    public static void tick(World world, BlockPos pos, BlockState state, WaterGeneratingGooBlockEntity entity)
    {
        if (world.isClient() ||
            !world.getGameRules().getBoolean(Main.SPREAD) ||
            !state.get(WaterGeneratingGoo.UNSTABLE))
            return;

        if(world.getRandom().nextFloat() < 0.9)
            return;

        BlockPos[] sides = Utils.getPositionSideBottomTo(pos);
        for (BlockPos side : sides)
            if (world.getBlockState(side).isOf(Blocks.AIR))
                // Set the next Goo
                world.setBlockState(side,
                                    ModBlocks.WATER_GENERATING_GOO.getDefaultState().with(WaterGeneratingGoo.UNSTABLE, true),
                                    3);

        // Set ourselves to Air
        world.setBlockState(pos, Blocks.WATER.getDefaultState(), 3);
    }
}