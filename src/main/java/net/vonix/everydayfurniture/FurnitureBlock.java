package net.vonix.everydayfurniture;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public final class FurnitureBlock extends Block {
    public static final DirectionProperty FACING = DirectionProperty.create("facing", Direction.Plane.HORIZONTAL);
    private final VoxelShape shape;
    private final String culinaryStation;
    private final float seatHeight;
    public FurnitureBlock(VoxelShape shape, String culinaryStation, float seatHeight) {
        super(BlockBehaviour.Properties.of(net.minecraft.world.level.material.Material.WOOD).strength(1.5f).noOcclusion());
        this.shape = shape; this.culinaryStation = culinaryStation; this.seatHeight = seatHeight;
        registerDefaultState(stateDefinition.any().setValue(FACING, Direction.NORTH));
    }
    @Override protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) { builder.add(FACING); }
    @Override public BlockState getStateForPlacement(BlockPlaceContext context) { return defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite()); }
    @Override public BlockState rotate(BlockState state, Rotation rotation) { return state.setValue(FACING, rotation.rotate(state.getValue(FACING))); }
    @Override public BlockState mirror(BlockState state, Mirror mirror) { return state.rotate(mirror.getRotation(state.getValue(FACING))); }
    @Override public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) { return shape; }
    @Override public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        if (seatHeight > 0 && player.getItemInHand(hand).isEmpty()) {
            if (!level.isClientSide && !player.isPassenger()) {
                boolean occupied = !level.getEntitiesOfClass(FurnitureSeatEntity.class, new AABB(pos).inflate(.45)).isEmpty();
                if (!occupied) { FurnitureSeatEntity seat = new FurnitureSeatEntity(EverydayFurnitureMod.SEAT_ENTITY.get(), level); seat.setPos(pos.getX() + .5, pos.getY() + seatHeight, pos.getZ() + .5); level.addFreshEntity(seat); player.startRiding(seat); }
            }
            return InteractionResult.sidedSuccess(level.isClientSide);
        }
        if (culinaryStation.isEmpty()) return InteractionResult.PASS;
        if (level.isClientSide) return InteractionResult.SUCCESS;
        ItemStack result = CulinaryCompat.process(culinaryStation, player.getItemInHand(hand));
        if (result.isEmpty()) { player.displayClientMessage(new TextComponent(CulinaryCompat.loaded() ? "This appliance cannot process that item." : "Install Culinary Dragons to use this appliance."), true); return InteractionResult.CONSUME; }
        ItemStack held = player.getItemInHand(hand);
        if (!player.getAbilities().instabuild) held.shrink(1);
        if (!player.getInventory().add(result)) player.drop(result, false);
        player.displayClientMessage(new TextComponent("Prepared " + result.getHoverName().getString() + "."), true);
        return InteractionResult.CONSUME;
    }
}
