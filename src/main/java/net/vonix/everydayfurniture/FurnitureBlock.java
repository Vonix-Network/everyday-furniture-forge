package net.vonix.everydayfurniture;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
public final class FurnitureBlock extends Block { private final VoxelShape shape; public FurnitureBlock(VoxelShape shape) { super(BlockBehaviour.Properties.of(net.minecraft.world.level.material.Material.WOOD).strength(1.5f).noOcclusion()); this.shape=shape; } @Override public VoxelShape getShape(BlockState state,BlockGetter level,BlockPos pos,CollisionContext context){return shape;} }
