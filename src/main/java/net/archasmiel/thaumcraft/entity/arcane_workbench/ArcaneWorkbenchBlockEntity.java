package net.archasmiel.thaumcraft.entity.arcane_workbench;

import net.archasmiel.thaumcraft.entity.BlockEntities;
import net.archasmiel.thaumcraft.entity.abilities.inventory.ImplementedInventory;
import net.archasmiel.thaumcraft.recipe.ThaumcraftShapedRecipe;
import net.archasmiel.thaumcraft.screen.arcane_workbench.ArcaneWorkbenchScreenHandler;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventories;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.text.LiteralText;
import net.minecraft.text.Text;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

public class ArcaneWorkbenchBlockEntity extends BlockEntity implements NamedScreenHandlerFactory, ImplementedInventory {

    public static final int GUI_SIZE = 11;
    public static final int RESULT_SLOT = 9;
    private final DefaultedList<ItemStack> inventory =
            DefaultedList.ofSize(GUI_SIZE, ItemStack.EMPTY);




    public ArcaneWorkbenchBlockEntity(BlockPos pos, BlockState state) {
        super(BlockEntities.ARCANE_WORKBENCH, pos, state);
    }




    @Override
    public DefaultedList<ItemStack> getItems() {
        return inventory;
    }

    @Override
    public Text getDisplayName() {
        return new LiteralText("");
    }

    @Nullable
    @Override
    public ScreenHandler createMenu(int syncId, PlayerInventory inv, PlayerEntity player) {
        return new ArcaneWorkbenchScreenHandler(syncId, inv, this);
    }



    @Override
    public void readNbt(NbtCompound nbt) {
        Inventories.readNbt(nbt, inventory);
        super.readNbt(nbt);
    }

    @Override
    protected void writeNbt(NbtCompound nbt) {
        super.writeNbt(nbt);
        Inventories.writeNbt(nbt, inventory);
    }


    public static void tick(World world, BlockPos pos, BlockState state, ArcaneWorkbenchBlockEntity entity) {
        // optimization for empty inventories
        if (hasItems(entity)){
            Optional<ThaumcraftShapedRecipe> thaumcraftShapedRecipe = getThaumcraftShapedRecipe(entity);
            // TODO     Add vanilla recipes
            // checking for recipes
            ItemStack output = ItemStack.EMPTY;
            if (thaumcraftShapedRecipe.isPresent()) output = thaumcraftShapedRecipe.get().getOutput();


            // if output from recipes is empty and result slot has items - making it empty
            if (output == ItemStack.EMPTY && entity.getStack(RESULT_SLOT) != ItemStack.EMPTY) {
                entity.setStack(RESULT_SLOT, ItemStack.EMPTY);
                markDirty(world, pos, state);
            }

            // if output from recipes has item and result slot is empty - copying it to slot
            if (output != ItemStack.EMPTY && entity.getStack(RESULT_SLOT) != output) {
                entity.setStack(RESULT_SLOT, output.copy());
                markDirty(world, pos, state);
            }
        } else {
            if (entity.getStack(RESULT_SLOT) != ItemStack.EMPTY) {
                entity.setStack(RESULT_SLOT, ItemStack.EMPTY);
                markDirty(world, pos, state);
            }
        }
    }

    private static boolean hasItems(ArcaneWorkbenchBlockEntity entity) {
        for (int i = 0 ; i < 9 ; i++) {
            if (entity.getStack(i) != ItemStack.EMPTY)
                return true;
        }
        return false;
    }

    private static Optional<ThaumcraftShapedRecipe> getThaumcraftShapedRecipe(ArcaneWorkbenchBlockEntity entity) {
        if (entity.world != null){

            SimpleInventory inventory = new SimpleInventory(entity.inventory.size());
            for (int i = 0 ; i < 9 ; i++) {
                inventory.setStack(i, entity.getStack(i));
            }

            return entity.world.getRecipeManager().getFirstMatch(
                    ThaumcraftShapedRecipe.Type.INSTANCE,
                    inventory,
                    entity.world
            );
        }
        return Optional.empty();
    }

//    private static Optional<CraftingRecipe> getShapedRecipe(ArcaneWorkbenchBlockEntity entity) {
//        if (entity.world != null){
//
//            SimpleInventory inventory = new SimpleInventory(entity.inventory.size());
//            for (int i = 0 ; i < 9 ; i++) {
//                inventory.setStack(i, entity.getStack(i));
//            }
//
//            CraftingInventory inv = new CraftingInventory(new CraftingScreenHandler());
//
//            return entity.world.getRecipeManager().getFirstMatch(
//                    RecipeType.CRAFTING,
//                    entity.inventory,
//                    entity.world
//            );
//        }
//        return Optional.empty();
//    }



}
