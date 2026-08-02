package net.vonix.everydayfurniture;

import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.PotionUtils;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public final class SinkBlock extends Block {
    private final VoxelShape shape;
    public SinkBlock(VoxelShape shape) { super(BlockBehaviour.Properties.of(net.minecraft.world.level.material.Material.METAL).strength(1.5f).sound(SoundType.METAL).noOcclusion()); this.shape = shape; }
    @Override public VoxelShape getShape(net.minecraft.world.level.block.state.BlockState state, net.minecraft.world.level.BlockGetter level, BlockPos pos, CollisionContext context) { return shape; }
    @Override public InteractionResult use(net.minecraft.world.level.block.state.BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        ItemStack held = player.getItemInHand(hand);
        if (!held.is(Items.GLASS_BOTTLE)) return InteractionResult.PASS;
        if (level.isClientSide) return InteractionResult.SUCCESS;
        ItemStack water = PotionUtils.setPotion(new ItemStack(Items.POTION), Potions.WATER);
        if (!player.getAbilities().instabuild) held.shrink(1);
        if (!player.getInventory().add(water)) player.drop(water, false);
        return InteractionResult.CONSUME;
    }
}
