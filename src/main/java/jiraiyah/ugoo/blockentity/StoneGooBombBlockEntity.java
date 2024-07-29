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

public class StoneGooBombBlockEntity extends BlockEntity
{
    public StoneGooBombBlockEntity(BlockPos pos, BlockState state)
    {
        super(ModBlockEntities.STONE_GOO_BOMB, pos, state);
    }

    public static void tick(World world, BlockPos pos, BlockState state, StoneGooBombBlockEntity entity)
    {
        if (world.isClient() ||
            !world.getGameRules().getBoolean(Main.SPREAD) ||
            !state.get(AirGooBomb.UNSTABLE))
            return;

        float chance = Utils.getChance(world.getGameRules().getInt(Main.STONE_BOMB_CHANCE));

        if(world.getRandom().nextFloat() < chance)
            return;

        world.setBlockState(pos, Blocks.STONE.getDefaultState(), 3);
    }
}