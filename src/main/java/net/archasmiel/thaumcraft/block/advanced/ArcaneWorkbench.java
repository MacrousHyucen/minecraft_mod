package net.archasmiel.thaumcraft.block.advanced;

import net.archasmiel.thaumcraft.block.ThaumcraftBlockWithEntity;
import net.archasmiel.thaumcraft.blockentity.ArcaneWorkbenchBlockEntity;
import net.archasmiel.thaumcraft.item.wandcraft.abilities.VisCraft;
import net.archasmiel.thaumcraft.lib.generation.BlockDataGeneration;
import net.archasmiel.thaumcraft.lib.generation.ItemDataGeneration;
import net.archasmiel.thaumcraft.register.Register;
import net.minecraft.block.Block;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.ItemScatterer;
import net.minecraft.util.function.BooleanBiFunction;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.stream.Stream;



public class ArcaneWorkbench extends ThaumcraftBlockWithEntity {
    public ArcaneWorkbench(Settings settings, String name){
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
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }





    /*  LOADING  */
    public void model() {
        ItemDataGeneration.simpleItemBlockModel(name());
        BlockDataGeneration.simpleRotatableBlockState(name());
        BlockDataGeneration.simpleBlockLootTable(name());
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
    @Override
    public BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }

    @Nullable
    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new ArcaneWorkbenchBlockEntity(pos, state);
    }

    @Override
    public void onStateReplaced(BlockState state, World world, BlockPos pos, BlockState newState, boolean moved) {
        if (state.getBlock() != newState.getBlock()){
            BlockEntity blockEntity = world.getBlockEntity(pos);
            if (blockEntity instanceof ArcaneWorkbenchBlockEntity){
                ItemScatterer.spawn(world, pos, (Inventory) blockEntity);
                world.updateComparators(pos, this);
            }
            super.onStateReplaced(state, world, pos, newState, moved);
        }
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {

        // get wand from workench by shifting+rmb on it
        if (Screen.hasShiftDown()) {
            if (world.getBlockEntity(pos) instanceof ArcaneWorkbenchBlockEntity entity && hand == Hand.MAIN_HAND) {
                if (!entity.getStack(10).isEmpty()) {
                    if (entity.getStack(10).getItem() instanceof VisCraft){
                        if (player.getStackInHand(Hand.MAIN_HAND) == ItemStack.EMPTY) {

                            BlockState aState = entity.getWorld().getBlockState(entity.getPos());

                            player.getInventory().setStack(player.getInventory().selectedSlot, entity.getStack(10));
                            entity.setStack(10, ItemStack.EMPTY);
                            entity.markDirty();

                            world.playSound(
                                    null,
                                    pos,
                                    SoundEvents.BLOCK_BARREL_OPEN,
                                    SoundCategory.BLOCKS,
                                    0.5f,
                                    2.0f
                            );


                            BlockState bState = entity.getWorld().getBlockState(entity.getPos());
                            entity.getWorld().updateListeners(entity.getPos(), aState, bState, Block.NOTIFY_ALL);

                        }
                    }
                }
            }
        } else {
            // arcane workbench GUI onUse
            if (!world.isClient) {
                NamedScreenHandlerFactory screenHandlerFactory = state.createScreenHandlerFactory(world, pos);

                if (screenHandlerFactory != null){
                    player.openHandledScreen(screenHandlerFactory);
                }

            }

        }

        return ActionResult.SUCCESS;
    }
}
