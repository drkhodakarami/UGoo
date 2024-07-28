package jiraiyah.ugoo.blockentity;

import jiraiyah.ugoo.Main;
import jiraiyah.ugoo.Utils;
import jiraiyah.ugoo.block.ChunkGoo;
import jiraiyah.ugoo.block.LavaEatingGoo;
import jiraiyah.ugoo.registry.ModBlockEntities;
import jiraiyah.ugoo.registry.ModBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class LavaEatingGooBlockEntity extends BlockEntity
{
    public LavaEatingGooBlockEntity(BlockPos pos, BlockState state)
    {
        super(ModBlockEntities.LAVA_EATING_GOO, pos, state);
    }

    public static void tick(World world, BlockPos pos, BlockState state, LavaEatingGooBlockEntity entity)
    {
        if (world.isClient() ||
            !world.getGameRules().getBoolean(Main.SPREAD) ||
            !state.get(LavaEatingGoo.UNSTABLE))
            return;

        if(world.getRandom().nextFloat() < 0.9)
            return;

        BlockPos[] sides = Utils.getPositionNextTo(pos);
        for (BlockPos side : sides)
            if (world.getBlockState(side).isOf(Blocks.LAVA))
                // Set the next Goo
                world.setBlockState(side,
                                    ModBlocks.LAVA_EATING_GOO.getDefaultState().with(LavaEatingGoo.UNSTABLE, true),
                                    3);

        // Set ourselves to Air
        world.setBlockState(pos, Blocks.AIR.getDefaultState(), 3);
    }
}