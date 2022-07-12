package net.archasmiel.thaumcraft.block.advanced;

import net.archasmiel.thaumcraft.Thaumcraft;
import net.archasmiel.thaumcraft.block.ThaumcraftBlock;
import net.archasmiel.thaumcraft.generation.ThaumcraftRegistry;
import net.archasmiel.thaumcraft.register.Register;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.BlockMirror;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.function.BooleanBiFunction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import org.jetbrains.annotations.Nullable;

import java.util.stream.Stream;

public class Table extends ThaumcraftBlock {



    public Table(Settings settings, String name){
        super(settings, name);
    }




    /*  ROTATING SETTINGS  */
    public static final DirectionProperty FACING = Properties.HORIZONTAL_FACING;

    @Nullable
    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return this.getDefaultState().with(FACING, ctx.getPlayerFacing().getOpposite());
    }

    @Override
    public BlockState rotate(BlockState state, BlockRotation rotation) {
        return state.with(FACING, rotation.rotate(state.get(FACING)));
    }

    @Override
    public BlockState mirror(BlockState state, BlockMirror mirror) {
        return state.rotate(mirror.getRotation(state.get(FACING)));
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }





    /*  LOADING  */
    public void model() {
        ThaumcraftRegistry.simpleBlockItemModel(Thaumcraft.MOD_ID, name());
        ThaumcraftRegistry.horizontalRotatableBlockState(Thaumcraft.MOD_ID, name());
        ThaumcraftRegistry.simpleBlockLootTable(Thaumcraft.MOD_ID, name());
    }

    public void register() {
        setBlock(Register.registerBlock(name(), this));
    }




    /*  BLOCK SHAPE  */
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





    /*  BLOCK ENTITY  */
    // DOESN'T EXIST FOR TABLE
}
