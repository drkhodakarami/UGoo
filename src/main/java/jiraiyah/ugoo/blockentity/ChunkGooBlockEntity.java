package jiraiyah.ugoo.blockentity;

import jiraiyah.ugoo.Main;
import jiraiyah.ugoo.block.ChunkGoo;
import jiraiyah.ugoo.block.ChunkGooBomb;
import jiraiyah.ugoo.registry.ModBlockEntities;
import jiraiyah.ugoo.registry.ModBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.WorldChunk;

public class ChunkGooBlockEntity extends BlockEntity
{
    private WorldChunk originalChunk = null;

    public ChunkGooBlockEntity(BlockPos pos, BlockState state)
    {
        super(ModBlockEntities.CHUNK_GOO, pos, state);
    }

    public static void tick(World world, BlockPos pos, BlockState state, ChunkGooBlockEntity entity)
    {
        if (world.isClient() ||
            !world.getGameRules().getBoolean(Main.SPREAD) ||
            !state.get(ChunkGoo.UNSTABLE))
            return;

        for (int x = -32; x < 32; x++)
        {
            for (int z = -32; z < 32; z++)
            {
                BlockPos flatPos = pos.west(x).north(z);
                if(isWithinChunk(world, flatPos, entity.originalChunk) &&
                   !world.getBlockState(flatPos).isOf(ModBlocks.TOWERING_GOO) &&
                   !world.getBlockState(flatPos).isOf(ModBlocks.CHUNK_GOO))
                    world.setBlockState(flatPos,
                                ModBlocks.CHUNK_GOO_BOMB.getDefaultState().with(ChunkGooBomb.UNSTABLE, true),
                                3);
            }
        }

        if(world.getBlockEntity(pos) != null)
            ((ChunkGooBlockEntity) world.getBlockEntity(pos)).resetChunk();
        world.setBlockState(pos,
                    ModBlocks.CHUNK_GOO_BOMB.getDefaultState().with(ChunkGooBomb.UNSTABLE, true),
                    3);
    }

    public void setChunk()
    {
        this.originalChunk = this.world.getWorldChunk(this.pos);
    }

    public void resetChunk()
    {
        this.originalChunk = null;
    }

    private static boolean isWithinChunk(World world, BlockPos pos, WorldChunk entityChunk)
    {
        return entityChunk.equals(world.getWorldChunk(pos));
    }
}