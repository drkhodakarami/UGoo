package jiraiyah.ugoo.blockentity;

import jiraiyah.ugoo.Main;
import jiraiyah.ugoo.block.ChunkGoo;
import jiraiyah.ugoo.block.LavaPumpGoo;
import jiraiyah.ugoo.block.WaterPumpGoo;
import jiraiyah.ugoo.registry.ModBlockEntities;
import jiraiyah.ugoo.registry.ModBlocks;
import net.fabricmc.fabric.api.transfer.v1.context.ContainerItemContext;
import net.fabricmc.fabric.api.transfer.v1.fluid.FluidConstants;
import net.fabricmc.fabric.api.transfer.v1.fluid.FluidStorage;
import net.fabricmc.fabric.api.transfer.v1.fluid.FluidVariant;
import net.fabricmc.fabric.api.transfer.v1.storage.Storage;
import net.fabricmc.fabric.api.transfer.v1.transaction.Transaction;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.fluid.Fluids;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import net.minecraft.world.chunk.Chunk;

public class WaterPumpGooBlockEntity extends BlockEntity
{
    private static final FluidVariant water = FluidVariant.of(Fluids.WATER);

    private final int maxProgress = 20;
    private int progress;

    public WaterPumpGooBlockEntity(BlockPos pos, BlockState state)
    {
        super(ModBlockEntities.WATER_PUMP_GOO, pos, state);
        this.progress = this.maxProgress;
    }

    public static void tick(World world, BlockPos pos, BlockState state, WaterPumpGooBlockEntity entity)
    {
        if (world.isClient() ||
            !world.getGameRules().getBoolean(Main.SPREAD))
            return;

        if(world.getBlockState(pos.up()).isOf(Blocks.AIR))
        {
            entity.progress = entity.maxProgress;
            entity.markDirty();
            return;
        }

        Storage<FluidVariant> storage = null;
        for (Direction direction : Direction.values())
        {
            storage = FluidStorage.SIDED.find(world, pos.up(), direction);
            try (Transaction transaction = Transaction.openOuter())
            {
                if (storage != null && storage.insert(water, 1, transaction) > 0)
                    break;
            }
        }

        if (storage == null ||
            !storage.supportsInsertion())
        {
            entity.progress = entity.maxProgress;
            entity.markDirty();
            return;
        }

        // If no proper container was found or it cannot accept water, simply return
        try (Transaction transaction = Transaction.openOuter())
        {
            if (storage.insert(water, 1, transaction) <= 0)
            {
                entity.progress = entity.maxProgress;
                entity.markDirty();
                return;
            }
        }

        entity.progress--;

        if(entity.progress > 0)
            return;

        entity.progress = entity.maxProgress;

        // If we found proper container
        int pumpDistance = world.getGameRules().getInt(Main.PUMP_DISTANCE);

        for (int x = -pumpDistance; x < pumpDistance  + 1; x++)
        {
            for (int z = -pumpDistance; z < pumpDistance + 1; z++)
            {
                for (int y = -1; y >= -world.getGameRules().getInt(Main.PUMP_DEPTH); y--)
                {
                    // Get the block pos
                    BlockPos newPos= pos.up(y).north(x).west(z);

                    // Get the chunk at block pos
                    //Chunk chunk = world.getChunk(newPos);
                    // If chunk is not loaded continue
                    //if(!world.isChunkLoaded(chunk.getPos().x, chunk.getPos().z))
                    //    continue;

                    // If the block at position is water
                    if (world.getBlockState(newPos).isOf(Blocks.WATER) &&
                        world.getBlockState(newPos).getFluidState().isStill())
                    {
                        try (Transaction transaction = Transaction.openOuter())
                        {
                            // if the block above can accept one bucket of water
                            if(storage.insert(water, FluidConstants.BUCKET, transaction) == FluidConstants.BUCKET)
                            {
                                // transfer the water to tank
                                transaction.commit();
                                // set the water block to air
                                world.setBlockState(newPos, Blocks.AIR.getDefaultState(), 3);
                                // break out of the loop and finish the tick
                                entity.markDirty();
                                return;
                            }
                        }
                    }
                }
            }
        }
        entity.markDirty();
    }

    @Override
    public void readNbt(NbtCompound nbt)
    {
        super.readNbt(nbt);
        this.progress = nbt.getInt("ugoo.water.pump.progress");
    }

    @Override
    protected void writeNbt(NbtCompound nbt)
    {
        super.writeNbt(nbt);
        nbt.putInt("ugoo.water.pump.progress", this.progress);
    }
}