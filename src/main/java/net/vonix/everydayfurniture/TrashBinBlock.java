package net.vonix.everydayfurniture;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public final class TrashBinBlock extends Block {
    private final VoxelShape shape;
    public TrashBinBlock(VoxelShape shape) { super(BlockBehaviour.Properties.of(net.minecraft.world.level.material.Material.METAL).strength(1.0f).sound(SoundType.METAL).noOcclusion()); this.shape = shape; }
    @Override public VoxelShape getShape(net.minecraft.world.level.block.state.BlockState state, net.minecraft.world.level.BlockGetter level, BlockPos pos, CollisionContext context) { return shape; }
    @Override public InteractionResult use(net.minecraft.world.level.block.state.BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        ItemStack held = player.getItemInHand(hand);
        if (held.isEmpty()) { if (!level.isClientSide) player.displayClientMessage(new TextComponent("Hold an item to discard it."), true); return InteractionResult.sidedSuccess(level.isClientSide); }
        if (!level.isClientSide && !player.getAbilities().instabuild) held.shrink(held.getCount());
        return InteractionResult.sidedSuccess(level.isClientSide);
    }
}
