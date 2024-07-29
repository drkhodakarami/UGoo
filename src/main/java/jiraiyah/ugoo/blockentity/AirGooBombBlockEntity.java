package jiraiyah.ugoo.blockentity;

import jiraiyah.ugoo.Main;
import jiraiyah.ugoo.Utils;
import jiraiyah.ugoo.block.AirGooBomb;
import jiraiyah.ugoo.registry.ModBlockEntities;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class AirGooBombBlockEntity extends BlockEntity
{
    public AirGooBombBlockEntity(BlockPos pos, BlockState state)
    {
        super(ModBlockEntities.AIR_GOO_BOMB, pos, state);
    }

    public static void tick(World world, BlockPos pos, BlockState state, AirGooBombBlockEntity entity)
    {
        if (world.isClient() ||
            !world.getGameRules().getBoolean(Main.SPREAD) ||
            !state.get(AirGooBomb.UNSTABLE))
            return;

        float chance = Utils.getChance(world.getGameRules().getInt(Main.AIR_BOMB_CHANCE));

        if(world.getRandom().nextFloat() < chance)
            return;

        if(world.getBlockState(pos.up()).isOf(Blocks.WATER) ||
           world.getBlockState(pos.up()).isOf(Blocks.LAVA))
            world.setBlockState(pos.up(), Blocks.STONE.getDefaultState(), 3);

        world.setBlockState(pos, Blocks.AIR.getDefaultState(), 3);
    }
}