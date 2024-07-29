package jiraiyah.ugoo.blockentity;

import jiraiyah.ugoo.Main;
import jiraiyah.ugoo.registry.ModBlockEntities;
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
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;

public class LavaPumpGooBlockEntity extends BlockEntity
{
    private static final FluidVariant lava = FluidVariant.of(Fluids.LAVA);

    private int maxProgress;
    private int progress;

    public LavaPumpGooBlockEntity(BlockPos pos, BlockState state)
    {
        super(ModBlockEntities.LAVA_PUMP_GOO, pos, state);
        this.progress = this.maxProgress;
    }

    public static void tick(World world, BlockPos pos, BlockState state, LavaPumpGooBlockEntity entity)
    {
        if (world.isClient() ||
            !world.getGameRules().getBoolean(Main.SPREAD))
            return;

        entity.maxProgress = world.getGameRules().getInt(Main.LAVA_PUMP_COOLDOWN);

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
                if (storage != null && storage.insert(lava, 1, transaction) > 0)
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

        try (Transaction transaction = Transaction.openOuter())
        {
            if (storage.insert(lava, 1, transaction) <= 0)
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

        int pumpDistance = world.getGameRules().getInt(Main.PUMP_DISTANCE);

        for (int x = -pumpDistance; x < pumpDistance  + 1; x++)
        {
            for (int z = -pumpDistance; z < pumpDistance + 1; z++)
            {
                for (int y = -1; y >= -world.getGameRules().getInt(Main.PUMP_DEPTH); y--)
                {
                    BlockPos newPos= pos.up(y).north(x).west(z);

                    //Chunk chunk = world.getChunk(newPos);
                    //if(!world.isChunkLoaded(chunk.getPos().x, chunk.getPos().z))
                    //    continue;

                    if (world.getBlockState(newPos).isOf(Blocks.LAVA) &&
                        world.getBlockState(newPos).getFluidState().isStill())
                    {
                        try (Transaction transaction = Transaction.openOuter())
                        {
                            if(storage.insert(lava, FluidConstants.BUCKET, transaction) == FluidConstants.BUCKET)
                            {
                                transaction.commit();
                                world.setBlockState(newPos, Blocks.AIR.getDefaultState(), 3);
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
    protected void readNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registryLookup)
    {
        super.readNbt(nbt, registryLookup);
        this.progress = nbt.getInt("ugoo.lava.pump.progress");
    }

    @Override
    protected void writeNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registryLookup)
    {
        super.writeNbt(nbt, registryLookup);
        nbt.putInt("ugoo.lava.pump.progress", this.progress);
    }
}