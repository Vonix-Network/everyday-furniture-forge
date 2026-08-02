package net.vonix.everydayfurniture;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public final class FurnitureBlock extends Block {
    private final VoxelShape shape;
    private final String culinaryStation;
    public FurnitureBlock(VoxelShape shape) { this(shape, ""); }
    public FurnitureBlock(VoxelShape shape, String culinaryStation) {
        super(BlockBehaviour.Properties.of(net.minecraft.world.level.material.Material.WOOD).strength(1.5f).noOcclusion());
        this.shape = shape;
        this.culinaryStation = culinaryStation;
    }
    @Override public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) { return shape; }
    @Override public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        if (culinaryStation.isEmpty()) return InteractionResult.PASS;
        if (level.isClientSide) return InteractionResult.SUCCESS;
        ItemStack result = CulinaryCompat.process(culinaryStation, player.getItemInHand(hand));
        if (result.isEmpty()) {
            String message = CulinaryCompat.loaded()
                    ? "This appliance cannot process that item."
                    : "Install Culinary Dragons to use this appliance.";
            player.displayClientMessage(new TextComponent(message), true);
            return InteractionResult.CONSUME;
        }
        ItemStack held = player.getItemInHand(hand);
        if (!player.getAbilities().instabuild) held.shrink(1);
        if (!player.getInventory().add(result)) player.drop(result, false);
        player.displayClientMessage(new TextComponent("Prepared " + result.getHoverName().getString() + "."), true);
        return InteractionResult.CONSUME;
    }
}
