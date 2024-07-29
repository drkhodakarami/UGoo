package jiraiyah.ugoo.block;

import com.mojang.serialization.MapCodec;
import jiraiyah.ugoo.blockentity.WaterGeneratingGooBlockEntity;
import jiraiyah.ugoo.registry.ModBlockEntities;
import net.minecraft.block.Block;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.block.BlockWithEntity;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.stat.Stats;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.Hand;
import net.minecraft.util.ItemActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class WaterGeneratingGoo extends BlockWithEntity
{
    public static final MapCodec<WaterGeneratingGoo> CODEC = createCodec(WaterGeneratingGoo::new);

    public static final BooleanProperty UNSTABLE = Properties.UNSTABLE;

    public WaterGeneratingGoo(Settings settings)
    {
        super(settings);
    }

    @Override
    protected MapCodec<? extends BlockWithEntity> getCodec()
    {
        return CODEC;
    }

    public BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(UNSTABLE);
    }

    protected ItemActionResult onUseWithItem(ItemStack stack, BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if (!stack.isOf(Items.FLINT_AND_STEEL))
        {
            return super.onUseWithItem(stack, state, world, pos, player, hand, hit);
        }
        else
        {
            world.setBlockState(pos, state.with(UNSTABLE, true), 3);
            Item item = stack.getItem();
            if (!player.isCreative()) {
                if (stack.isOf(Items.FLINT_AND_STEEL)) {
                    stack.damage(1, player, LivingEntity.getSlotForHand(hand));
                } else {
                    stack.decrement(1);
                }
            }

            player.incrementStat(Stats.USED.getOrCreateStat(item));
            return ItemActionResult.success(world.isClient);
        }
    }

    @Override
    public void onPlaced(World world, BlockPos pos, BlockState state, @Nullable LivingEntity placer, ItemStack itemStack)
    {
        world.setBlockState(pos,state.with(UNSTABLE, false), 3);
        super.onPlaced(world, pos, state, placer, itemStack);
    }

    @Nullable
    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state)
    {
        return new WaterGeneratingGooBlockEntity(pos, state);
    }

    public <T extends BlockEntity> @Nullable BlockEntityTicker<T> getTicker(World level, BlockState state, BlockEntityType<T> type) {
        return validateTicker(type, ModBlockEntities.WATER_GENERATING_GOO, WaterGeneratingGooBlockEntity::tick);
    }
}