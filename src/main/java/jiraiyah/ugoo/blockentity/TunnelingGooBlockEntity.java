package jiraiyah.ugoo.blockentity;

import jiraiyah.ugoo.Main;
import jiraiyah.ugoo.block.AirGooBomb;
import jiraiyah.ugoo.block.TunnelingGoo;
import jiraiyah.ugoo.registry.ModBlockEntities;
import jiraiyah.ugoo.registry.ModBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;

import static jiraiyah.ugoo.Reference.Tags.Block.TUNNELING_GOO_BLACKLIST;
import static jiraiyah.ugoo.Reference.log;

public class TunnelingGooBlockEntity extends BlockEntity
{
    private int x, y, z;
    public TunnelingGooBlockEntity(BlockPos pos, BlockState state)
    {
        super(ModBlockEntities.TUNNELING_GOO, pos, state);
    }

    public static void tick(World world, BlockPos pos, BlockState state, TunnelingGooBlockEntity entity)
    {
        if (world.isClient() ||
            !world.getGameRules().getBoolean(Main.SPREAD) ||
            !state.get(TunnelingGoo.UNSTABLE))
            return;

        Direction direction = state.get(TunnelingGoo.FACING);
        BlockPos newPos;

        for (int x = -1; x < 2; x++)
        {
            for (int y = 1; y < 4; y++)
            {
                for (int z = 0; z < world.getGameRules().getInt(Main.SPREAD_DISTANCE); z++)
                {
                    newPos = pos.up(y);
                    if (direction == Direction.NORTH)
                    {
                        newPos = newPos.north(z);
                        newPos = newPos.east(x);
                    }
                    if (direction == Direction.SOUTH)
                    {
                        newPos = newPos.south(z);
                        newPos = newPos.west(x);
                    }
                    if (direction == Direction.EAST)
                    {
                        newPos = newPos.east(z);
                        newPos = newPos.south(x);
                    }
                    if (direction == Direction.WEST)
                    {
                        newPos = newPos.west(z);
                        newPos = newPos.north(x);
                    }
                    if (!world.getBlockState(newPos).isIn(TUNNELING_GOO_BLACKLIST))
                        world.setBlockState(newPos,
                                    ModBlocks.AIR_GOO_BOMB.getDefaultState().with(AirGooBomb.UNSTABLE, true),
                                    3);
                }
            }
        }

        world.setBlockState(pos, Blocks.STONE.getDefaultState(), 3);
    }
}