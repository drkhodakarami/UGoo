package jiraiyah.ugoo.blockentity;

import jiraiyah.ugoo.Main;
import jiraiyah.ugoo.Utils;
import jiraiyah.ugoo.block.ChunkGoo;
import jiraiyah.ugoo.block.ToweringGoo;
import jiraiyah.ugoo.registry.ModBlockEntities;
import jiraiyah.ugoo.registry.ModBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import static jiraiyah.ugoo.Reference.Tags.Block.TOWERING_GOO_BLACKLIST;

public class ToweringGooBlockEntity extends BlockEntity
{
    public ToweringGooBlockEntity(BlockPos pos, BlockState state)
    {
        super(ModBlockEntities.TOWERING_GOO, pos, state);
    }

    public static void tick(World world, BlockPos pos, BlockState state, ToweringGooBlockEntity entity)
    {
        if (world.isClient() ||
            !world.getGameRules().getBoolean(Main.SPREAD) ||
            !state.get(ToweringGoo.UNSTABLE))
            return;

        if(world.getRandom().nextFloat() < 0.9)
            return;

        BlockPos[] sides = Utils.getPositionSideTo(pos);
        for (BlockPos side : sides)
            if (world.getBlockState(side).isOf(Blocks.LAVA) ||
                world.getBlockState(side).isOf(Blocks.WATER) ||
                world.getBlockState(side).isOf(Blocks.AIR))
                world.setBlockState(side,
                                    Blocks.STONE.getDefaultState(),
                                    3);

        BlockPos newPos = Utils.getPositionDirectionTo(pos, 1); //down
        if(newPos.getY() > world.getBottomY())
        {
            if (!world.getBlockState(newPos).isIn(TOWERING_GOO_BLACKLIST))
                // Set the next Goo
                world.setBlockState(newPos,
                            ModBlocks.TOWERING_GOO.getDefaultState().with(ToweringGoo.UNSTABLE, true),
                            3);
            if (!world.getBlockState(newPos.down()).isIn(TOWERING_GOO_BLACKLIST))
                // Set the next Goo
                world.setBlockState(newPos.down(),
                                    ModBlocks.TOWERING_GOO.getDefaultState().with(ToweringGoo.UNSTABLE, true),
                                    3);
            if (!world.getBlockState(newPos.down(2)).isIn(TOWERING_GOO_BLACKLIST))
                // Set the next Goo
                world.setBlockState(newPos.down(2),
                                    ModBlocks.TOWERING_GOO.getDefaultState().with(ToweringGoo.UNSTABLE, true),
                                    3);
            if (!world.getBlockState(newPos.down(3)).isIn(TOWERING_GOO_BLACKLIST))
                // Set the next Goo
                world.setBlockState(newPos.down(3),
                                    ModBlocks.TOWERING_GOO.getDefaultState().with(ToweringGoo.UNSTABLE, true),
                                    3);
            if (!world.getBlockState(newPos.down(4)).isIn(TOWERING_GOO_BLACKLIST))
                // Set the next Goo
                world.setBlockState(newPos.down(4),
                                    ModBlocks.TOWERING_GOO.getDefaultState().with(ToweringGoo.UNSTABLE, true),
                                    3);
            if (!world.getBlockState(newPos.down(5)).isIn(TOWERING_GOO_BLACKLIST))
                // Set the next Goo
                world.setBlockState(newPos.down(5),
                                    ModBlocks.TOWERING_GOO.getDefaultState().with(ToweringGoo.UNSTABLE, true),
                                    3);
        }

        // Set ourselves to Air
        world.setBlockState(pos, Blocks.AIR.getDefaultState(), 3);
    }
}