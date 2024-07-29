package jiraiyah.ugoo.blockentity;

import jiraiyah.ugoo.Main;
import jiraiyah.ugoo.block.*;
import jiraiyah.ugoo.registry.ModBlockEntities;
import jiraiyah.ugoo.registry.ModBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;

import static jiraiyah.ugoo.Reference.Tags.Block.BRIDGE_GOO_BLACKLIST;

public class BridgeGooBlockEntity extends BlockEntity
{
    public BridgeGooBlockEntity(BlockPos pos, BlockState state)
    {
        super(ModBlockEntities.BRIDGE_GOO, pos, state);
    }

    public static void tick(World world, BlockPos pos, BlockState state, BridgeGooBlockEntity entity)
    {
        if (world.isClient() ||
            !world.getGameRules().getBoolean(Main.SPREAD) ||
            !state.get(BridgeGoo.UNSTABLE))
            return;

        Direction direction = state.get(TunnelingGoo.FACING);
        BlockPos newPos;
        BlockPos temp;

        for (int z = 0; z < world.getGameRules().getInt(Main.SPREAD_DISTANCE); z++)
        {
            for (int x = -1; x < 2; x++)
            {
                for (int y = 1; y < 4; y++)
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
                    if (!world.getBlockState(newPos).isIn(BRIDGE_GOO_BLACKLIST))
                        world.setBlockState(newPos,
                                    ModBlocks.AIR_GOO_BOMB.getDefaultState().with(AirGooBomb.UNSTABLE, true),
                                    3);
                }
            }

            if (direction == Direction.NORTH)
            {
                newPos = pos.north(z);
                for (int x = -1; x < 2; x++)
                {
                    temp = newPos.east(x);
                    if(!world.getBlockState(temp).isOf(ModBlocks.BRIDGE_GOO) &&
                       !world.getBlockState(temp).isIn(BRIDGE_GOO_BLACKLIST))
                            world.setBlockState(temp,
                                        ModBlocks.STONE_GOO_BOMB.getDefaultState().with(StoneGooBomb.UNSTABLE, true),
                                        3);
                    if(!world.getBlockState(temp.up(4)).isIn(BRIDGE_GOO_BLACKLIST))
                            world.setBlockState(temp.up(4),
                                                ModBlocks.STONE_GOO_BOMB.getDefaultState().with(StoneGooBomb.UNSTABLE, true),
                                                3);
                }
                newPos = pos.north(z).up();
                temp = newPos.east(-2);
                if(!world.getBlockState(temp).isIn(BRIDGE_GOO_BLACKLIST))
                    world.setBlockState(temp,
                                ModBlocks.STONE_GOO_BOMB.getDefaultState().with(StoneGooBomb.UNSTABLE, true),
                                3);
                temp = newPos.east(2);
                if(!world.getBlockState(temp).isIn(BRIDGE_GOO_BLACKLIST))
                    world.setBlockState(temp,
                                        ModBlocks.STONE_GOO_BOMB.getDefaultState().with(StoneGooBomb.UNSTABLE, true),
                                        3);
                newPos = pos.north(z).up(3);
                temp = newPos.east(-2);
                if(!world.getBlockState(temp).isIn(BRIDGE_GOO_BLACKLIST))
                    world.setBlockState(temp,
                                        ModBlocks.STONE_GOO_BOMB.getDefaultState().with(StoneGooBomb.UNSTABLE, true),
                                        3);
                temp = newPos.east(2);
                if(!world.getBlockState(temp).isIn(BRIDGE_GOO_BLACKLIST))
                    world.setBlockState(temp,
                                        ModBlocks.STONE_GOO_BOMB.getDefaultState().with(StoneGooBomb.UNSTABLE, true),
                                        3);
                newPos = pos.north(z).up(2);
                if(z % 2 != 0)
                {
                    temp = newPos.east(-2);
                    if(!world.getBlockState(temp).isIn(BRIDGE_GOO_BLACKLIST))
                        world.setBlockState(temp,
                                            ModBlocks.AIR_GOO_BOMB.getDefaultState().with(AirGooBomb.UNSTABLE, true),
                                            3);
                    temp = newPos.east(2);
                    if(!world.getBlockState(temp).isIn(BRIDGE_GOO_BLACKLIST))
                        world.setBlockState(temp,
                                            ModBlocks.AIR_GOO_BOMB.getDefaultState().with(AirGooBomb.UNSTABLE, true),
                                            3);
                }
                else
                {
                    temp = newPos.east(-2);
                    if(!world.getBlockState(temp).isIn(BRIDGE_GOO_BLACKLIST))
                        world.setBlockState(temp,
                                            ModBlocks.STONE_GOO_BOMB.getDefaultState().with(StoneGooBomb.UNSTABLE, true),
                                            3);
                    temp = newPos.east(2);
                    if(!world.getBlockState(temp).isIn(BRIDGE_GOO_BLACKLIST))
                        world.setBlockState(temp,
                                            ModBlocks.STONE_GOO_BOMB.getDefaultState().with(StoneGooBomb.UNSTABLE, true),
                                            3);
                }
            }

            if (direction == Direction.SOUTH)
            {
                newPos = pos.south(z);
                for (int x = -1; x < 2; x++)
                {
                    temp = newPos.west(x);
                    if(!world.getBlockState(temp).isOf(ModBlocks.BRIDGE_GOO) &&
                       !world.getBlockState(temp).isIn(BRIDGE_GOO_BLACKLIST))
                        world.setBlockState(temp,
                                            ModBlocks.STONE_GOO_BOMB.getDefaultState().with(StoneGooBomb.UNSTABLE, true),
                                            3);
                    if(!world.getBlockState(temp.up(4)).isIn(BRIDGE_GOO_BLACKLIST))
                        world.setBlockState(temp.up(4),
                                            ModBlocks.STONE_GOO_BOMB.getDefaultState().with(StoneGooBomb.UNSTABLE, true),
                                            3);
                }
                newPos = pos.south(z).up();
                temp = newPos.west(-2);
                if(!world.getBlockState(temp).isIn(BRIDGE_GOO_BLACKLIST))
                    world.setBlockState(temp,
                                        ModBlocks.STONE_GOO_BOMB.getDefaultState().with(StoneGooBomb.UNSTABLE, true),
                                        3);
                temp = newPos.west(2);
                if(!world.getBlockState(temp).isIn(BRIDGE_GOO_BLACKLIST))
                    world.setBlockState(temp,
                                        ModBlocks.STONE_GOO_BOMB.getDefaultState().with(StoneGooBomb.UNSTABLE, true),
                                        3);
                newPos = pos.south(z).up(3);
                temp = newPos.west(-2);
                if(!world.getBlockState(temp).isIn(BRIDGE_GOO_BLACKLIST))
                    world.setBlockState(temp,
                                        ModBlocks.STONE_GOO_BOMB.getDefaultState().with(StoneGooBomb.UNSTABLE, true),
                                        3);
                temp = newPos.west(2);
                if(!world.getBlockState(temp).isIn(BRIDGE_GOO_BLACKLIST))
                    world.setBlockState(temp,
                                        ModBlocks.STONE_GOO_BOMB.getDefaultState().with(StoneGooBomb.UNSTABLE, true),
                                        3);
                newPos = pos.south(z).up(2);
                if(z % 2 != 0)
                {
                    temp = newPos.west(-2);
                    if(!world.getBlockState(temp).isIn(BRIDGE_GOO_BLACKLIST))
                        world.setBlockState(temp,
                                            ModBlocks.AIR_GOO_BOMB.getDefaultState().with(AirGooBomb.UNSTABLE, true),
                                            3);
                    temp = newPos.west(2);
                    if(!world.getBlockState(temp).isIn(BRIDGE_GOO_BLACKLIST))
                        world.setBlockState(temp,
                                            ModBlocks.AIR_GOO_BOMB.getDefaultState().with(AirGooBomb.UNSTABLE, true),
                                            3);
                }
                else
                {
                    temp = newPos.west(-2);
                    if(!world.getBlockState(temp).isIn(BRIDGE_GOO_BLACKLIST))
                        world.setBlockState(temp,
                                            ModBlocks.STONE_GOO_BOMB.getDefaultState().with(StoneGooBomb.UNSTABLE, true),
                                            3);
                    temp = newPos.west(2);
                    if(!world.getBlockState(temp).isIn(BRIDGE_GOO_BLACKLIST))
                        world.setBlockState(temp,
                                            ModBlocks.STONE_GOO_BOMB.getDefaultState().with(StoneGooBomb.UNSTABLE, true),
                                            3);
                }
            }

            if (direction == Direction.EAST)
            {
                newPos = pos.east(z);
                for (int x = -1; x < 2; x++)
                {
                    temp = newPos.south(x);
                    if(!world.getBlockState(temp).isOf(ModBlocks.BRIDGE_GOO) &&
                       !world.getBlockState(temp).isIn(BRIDGE_GOO_BLACKLIST))
                        world.setBlockState(temp,
                                            ModBlocks.STONE_GOO_BOMB.getDefaultState().with(StoneGooBomb.UNSTABLE, true),
                                            3);
                    if(!world.getBlockState(temp.up(4)).isIn(BRIDGE_GOO_BLACKLIST))
                        world.setBlockState(temp.up(4),
                                            ModBlocks.STONE_GOO_BOMB.getDefaultState().with(StoneGooBomb.UNSTABLE, true),
                                            3);
                }
                newPos = pos.east(z).up();
                temp = newPos.south(-2);
                if(!world.getBlockState(temp).isIn(BRIDGE_GOO_BLACKLIST))
                    world.setBlockState(temp,
                                        ModBlocks.STONE_GOO_BOMB.getDefaultState().with(StoneGooBomb.UNSTABLE, true),
                                        3);
                temp = newPos.south(2);
                if(!world.getBlockState(temp).isIn(BRIDGE_GOO_BLACKLIST))
                    world.setBlockState(temp,
                                        ModBlocks.STONE_GOO_BOMB.getDefaultState().with(StoneGooBomb.UNSTABLE, true),
                                        3);
                newPos = pos.east(z).up(3);
                temp = newPos.south(-2);
                if(!world.getBlockState(temp).isIn(BRIDGE_GOO_BLACKLIST))
                    world.setBlockState(temp,
                                        ModBlocks.STONE_GOO_BOMB.getDefaultState().with(StoneGooBomb.UNSTABLE, true),
                                        3);
                temp = newPos.south(2);
                if(!world.getBlockState(temp).isIn(BRIDGE_GOO_BLACKLIST))
                    world.setBlockState(temp,
                                        ModBlocks.STONE_GOO_BOMB.getDefaultState().with(StoneGooBomb.UNSTABLE, true),
                                        3);
                newPos = pos.east(z).up(2);
                if(z % 2 != 0)
                {
                    temp = newPos.south(-2);
                    if(!world.getBlockState(temp).isIn(BRIDGE_GOO_BLACKLIST))
                        world.setBlockState(temp,
                                            ModBlocks.AIR_GOO_BOMB.getDefaultState().with(AirGooBomb.UNSTABLE, true),
                                            3);
                    temp = newPos.south(2);
                    if(!world.getBlockState(temp).isIn(BRIDGE_GOO_BLACKLIST))
                        world.setBlockState(temp,
                                            ModBlocks.AIR_GOO_BOMB.getDefaultState().with(AirGooBomb.UNSTABLE, true),
                                            3);
                }
                else
                {
                    temp = newPos.south(-2);
                    if(!world.getBlockState(temp).isIn(BRIDGE_GOO_BLACKLIST))
                        world.setBlockState(temp,
                                            ModBlocks.STONE_GOO_BOMB.getDefaultState().with(StoneGooBomb.UNSTABLE, true),
                                            3);
                    temp = newPos.south(2);
                    if(!world.getBlockState(temp).isIn(BRIDGE_GOO_BLACKLIST))
                        world.setBlockState(temp,
                                            ModBlocks.STONE_GOO_BOMB.getDefaultState().with(StoneGooBomb.UNSTABLE, true),
                                            3);
                }
            }

            if (direction == Direction.WEST)
            {
                newPos = pos.west(z);
                for (int x = -1; x < 2; x++)
                {
                    temp = newPos.north(x);
                    if(!world.getBlockState(temp).isOf(ModBlocks.BRIDGE_GOO) &&
                       !world.getBlockState(temp).isIn(BRIDGE_GOO_BLACKLIST))
                        world.setBlockState(temp,
                                            ModBlocks.STONE_GOO_BOMB.getDefaultState().with(StoneGooBomb.UNSTABLE, true),
                                            3);
                    if(!world.getBlockState(temp.up(4)).isIn(BRIDGE_GOO_BLACKLIST))
                        world.setBlockState(temp.up(4),
                                            ModBlocks.STONE_GOO_BOMB.getDefaultState().with(StoneGooBomb.UNSTABLE, true),
                                            3);
                }
                newPos = pos.west(z).up();
                temp = newPos.north(-2);
                if(!world.getBlockState(temp).isIn(BRIDGE_GOO_BLACKLIST))
                    world.setBlockState(temp,
                                        ModBlocks.STONE_GOO_BOMB.getDefaultState().with(StoneGooBomb.UNSTABLE, true),
                                        3);
                temp = newPos.north(2);
                if(!world.getBlockState(temp).isIn(BRIDGE_GOO_BLACKLIST))
                    world.setBlockState(temp,
                                        ModBlocks.STONE_GOO_BOMB.getDefaultState().with(StoneGooBomb.UNSTABLE, true),
                                        3);
                newPos = pos.west(z).up(3);
                temp = newPos.north(-2);
                if(!world.getBlockState(temp).isIn(BRIDGE_GOO_BLACKLIST))
                    world.setBlockState(temp,
                                        ModBlocks.STONE_GOO_BOMB.getDefaultState().with(StoneGooBomb.UNSTABLE, true),
                                        3);
                temp = newPos.north(2);
                if(!world.getBlockState(temp).isIn(BRIDGE_GOO_BLACKLIST))
                    world.setBlockState(temp,
                                        ModBlocks.STONE_GOO_BOMB.getDefaultState().with(StoneGooBomb.UNSTABLE, true),
                                        3);
                newPos = pos.west(z).up(2);
                if(z % 2 != 0)
                {
                    temp = newPos.north(-2);
                    if(!world.getBlockState(temp).isIn(BRIDGE_GOO_BLACKLIST))
                        world.setBlockState(temp,
                                            ModBlocks.AIR_GOO_BOMB.getDefaultState().with(AirGooBomb.UNSTABLE, true),
                                            3);
                    temp = newPos.north(2);
                    if(!world.getBlockState(temp).isIn(BRIDGE_GOO_BLACKLIST))
                        world.setBlockState(temp,
                                            ModBlocks.AIR_GOO_BOMB.getDefaultState().with(AirGooBomb.UNSTABLE, true),
                                            3);
                }
                else
                {
                    temp = newPos.north(-2);
                    if(!world.getBlockState(temp).isIn(BRIDGE_GOO_BLACKLIST))
                        world.setBlockState(temp,
                                            ModBlocks.STONE_GOO_BOMB.getDefaultState().with(StoneGooBomb.UNSTABLE, true),
                                            3);
                    temp = newPos.north(2);
                    if(!world.getBlockState(temp).isIn(BRIDGE_GOO_BLACKLIST))
                        world.setBlockState(temp,
                                            ModBlocks.STONE_GOO_BOMB.getDefaultState().with(StoneGooBomb.UNSTABLE, true),
                                            3);
                }
            }
        }

        world.setBlockState(pos, Blocks.STONE.getDefaultState(), 3);
    }
}