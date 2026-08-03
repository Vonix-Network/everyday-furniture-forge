package net.vonix.everydayfurniture;

import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

/** A shallow, open, wall-mounted shelf: three boards and two thin side supports. */
public final class OpenShelfBlock extends Block {
    private static final VoxelShape SHAPE = Shapes.or(
            Block.box(0, 0, 2, 16, 1, 8), Block.box(0, 7, 2, 16, 8, 8), Block.box(0, 14, 2, 16, 15, 8),
            Block.box(0, 0, 2, 1, 15, 8), Block.box(15, 0, 2, 16, 15, 8));
    public OpenShelfBlock() { super(BlockBehaviour.Properties.of(net.minecraft.world.level.material.Material.WOOD).strength(1.2f).sound(SoundType.WOOD).noOcclusion()); }
    @Override public VoxelShape getShape(BlockState state, net.minecraft.world.level.BlockGetter level, BlockPos pos, CollisionContext context) { return SHAPE; }
    @Override public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        if (level.isClientSide) return InteractionResult.SUCCESS;
        if (player.getItemInHand(hand).isEmpty()) {
            player.displayClientMessage(new net.minecraft.network.chat.TextComponent("This is an open kitchen shelf."), true);
            return InteractionResult.CONSUME;
        }
        return InteractionResult.PASS;
    }
}
