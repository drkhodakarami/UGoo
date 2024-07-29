package jiraiyah.ugoo.blockentity;

import jiraiyah.ugoo.Main;
import jiraiyah.ugoo.Utils;
import jiraiyah.ugoo.block.ChunkGooBomb;
import jiraiyah.ugoo.registry.ModBlockEntities;
import jiraiyah.ugoo.registry.ModBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import static jiraiyah.ugoo.Reference.Tags.Block.TOWERING_GOO_BLACKLIST;

public class ChunkGooBombBlockEntity extends BlockEntity
{
    public ChunkGooBombBlockEntity(BlockPos pos, BlockState state)
    {
        super(ModBlockEntities.CHUNK_GOO_BOMB, pos, state);
    }

    public static void tick(World world, BlockPos pos, BlockState state, ChunkGooBombBlockEntity entity)
    {
        if (world.isClient() ||
            !world.getGameRules().getBoolean(Main.SPREAD) ||
            !state.get(ChunkGooBomb.UNSTABLE))
            return;

        float chance = Utils.getChance(world.getGameRules().getInt(Main.CHUNK_BOMB_CHANCE));

        if(world.getRandom().nextFloat() < chance)
            return;

        BlockPos[] sides = Utils.getPositionSideTo(pos);
        for (BlockPos side : sides)
        {
            if(world.getWorldChunk(pos).equals(world.getWorldChunk(side)))
                continue;
            if(world.getBlockState(side).isOf(Blocks.WATER) ||
               world.getBlockState(side).isOf(Blocks.LAVA) ||
               world.getBlockState(side).isOf(Blocks.AIR))
                world.setBlockState(side, Blocks.STONE.getDefaultState(), 3);
        }

        BlockPos newPos = Utils.getPositionDirectionTo(pos, 1); //down
        if(newPos.getY() > world.getBottomY())
        {
            if (!world.getBlockState(newPos).isIn(TOWERING_GOO_BLACKLIST))
                world.setBlockState(newPos,
                            ModBlocks.CHUNK_GOO_BOMB.getDefaultState().with(ChunkGooBomb.UNSTABLE, true),
                            3);
            else if(!world.getBlockState(newPos.down()).isIn(TOWERING_GOO_BLACKLIST))
                world.setBlockState(newPos.down(),
                                    ModBlocks.CHUNK_GOO_BOMB.getDefaultState().with(ChunkGooBomb.UNSTABLE, true),
                                    3);
            else if(!world.getBlockState(newPos.down(2)).isIn(TOWERING_GOO_BLACKLIST))
                world.setBlockState(newPos.down(2),
                                    ModBlocks.CHUNK_GOO_BOMB.getDefaultState().with(ChunkGooBomb.UNSTABLE, true),
                                    3);
            else if(!world.getBlockState(newPos.down(3)).isIn(TOWERING_GOO_BLACKLIST))
                world.setBlockState(newPos.down(3),
                                    ModBlocks.CHUNK_GOO_BOMB.getDefaultState().with(ChunkGooBomb.UNSTABLE, true),
                                    3);
            else if(!world.getBlockState(newPos.down(4)).isIn(TOWERING_GOO_BLACKLIST))
                world.setBlockState(newPos.down(4),
                                    ModBlocks.CHUNK_GOO_BOMB.getDefaultState().with(ChunkGooBomb.UNSTABLE, true),
                                    3);
            else if(!world.getBlockState(newPos.down(5)).isIn(TOWERING_GOO_BLACKLIST))
                world.setBlockState(newPos.down(5),
                                    ModBlocks.CHUNK_GOO_BOMB.getDefaultState().with(ChunkGooBomb.UNSTABLE, true),
                                    3);
        }

        world.setBlockState(pos, Blocks.AIR.getDefaultState(), 3);
    }
}