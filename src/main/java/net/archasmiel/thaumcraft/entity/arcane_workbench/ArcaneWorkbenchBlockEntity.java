package net.archasmiel.thaumcraft.entity.arcane_workbench;

import net.archasmiel.thaumcraft.entity.BlockEntities;
import net.archasmiel.thaumcraft.entity.abilities.inventory.ImplementedInventory;
import net.archasmiel.thaumcraft.recipe.ArcaneWorkbenchRecipe;
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

        Optional<ArcaneWorkbenchRecipe> recipe;
        // TODO     Add vanilla recipes
        recipe = getArcaneRecipe(entity);


        if (recipe.isPresent()) {
            if (entity.getStack(RESULT_SLOT) != recipe.get().getOutput()) {
                entity.setStack(RESULT_SLOT, recipe.get().getOutput());
                markDirty(world, pos, state);
            }
        } else {
            if (entity.getStack(RESULT_SLOT) != ItemStack.EMPTY) {
                entity.setStack(RESULT_SLOT, ItemStack.EMPTY);
                markDirty(world, pos, state);
            }
        }


    }

    private static Optional<ArcaneWorkbenchRecipe> getArcaneRecipe(ArcaneWorkbenchBlockEntity entity) {
        if (entity.world != null){
            World world = entity.world;
            SimpleInventory inventory = new SimpleInventory(entity.inventory.size());
            for (int i = 0 ; i < 9 ; i++) {
                inventory.setStack(i, entity.getStack(i));
            }

            return world.getRecipeManager().getFirstMatch(ArcaneWorkbenchRecipe.Type.INSTANCE, inventory, world);
        }
        return Optional.empty();
    }

}
