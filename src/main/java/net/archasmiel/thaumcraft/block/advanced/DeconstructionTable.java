package net.archasmiel.thaumcraft.block.advanced;

import net.archasmiel.thaumcraft.block.ThaumcraftBlock;
import net.archasmiel.thaumcraft.lib.generation.BlockDataGenerator;
import net.archasmiel.thaumcraft.lib.generation.ItemDataGenerator;
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

public class DeconstructionTable extends ThaumcraftBlock {

    public DeconstructionTable(Settings settings, String name){
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
        ItemDataGenerator.simpleItemBlockModel(name());
        BlockDataGenerator.simpleRotatableBlockState(name());
        BlockDataGenerator.simpleBlockLootTable(name());
    }

    public void register() {
        setBlock(Register.registerBlock(name(), this));
    }




    /*  BLOCK SHAPE  */
    private static final VoxelShape SHAPE_ALL = Stream.of(
            Block.createCuboidShape(11, 4, 11, 15, 8, 15),
            Block.createCuboidShape(1, 4, 1, 5, 8, 5),
            Block.createCuboidShape(1, 4, 11, 5, 8, 15),
            Block.createCuboidShape(11, 4, 1, 15, 8, 5),
            Block.createCuboidShape(0, 8, 0, 16, 16, 16),
            Block.createCuboidShape(0, 0, 0, 16, 4, 16)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPE_ALL;
    }





    /*  BLOCK ENTITY  */
}
