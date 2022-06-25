package net.archasmiel.thaumcraft.block.advanced;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.util.function.BooleanBiFunction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;

import java.util.stream.Stream;

public class Table extends RotatableBlock {

    public Table(Settings settings){
        super(settings);
    }

    private static final VoxelShape SHAPE_NS = Stream.of(
            Block.createCuboidShape(2, 4, 6, 6, 12, 10),
            Block.createCuboidShape(10, 4, 6, 14, 12, 10),
            Block.createCuboidShape(0, 12, 0, 16, 16, 16),
            Block.createCuboidShape(0, 0, 4, 16, 4, 12)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();

    private static final VoxelShape SHAPE_EW = Stream.of(
            Block.createCuboidShape(6, 4, 10, 10, 12, 14),
            Block.createCuboidShape(6, 4, 2, 10, 12, 6),
            Block.createCuboidShape(0, 12, 0, 16, 16, 16),
            Block.createCuboidShape(4, 0, 0, 12, 4, 16)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return switch (state.get(FACING)) {
            case EAST, WEST -> SHAPE_EW;
            default -> SHAPE_NS;
        };
    }
}
