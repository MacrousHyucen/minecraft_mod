package net.archasmiel.thaumcraft.entity.arcane_workbench;

import net.archasmiel.thaumcraft.entity.BlockEntities;
import net.archasmiel.thaumcraft.entity.abilities.inventory.ImplementedInventory;
import net.archasmiel.thaumcraft.item.Items;
import net.archasmiel.thaumcraft.screen.arcane_workbench.ArcaneWorkbenchScreenHandler;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventories;
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
        if (hasRecipe(entity) && hasNotReachedStackLimit(entity)) {
            craftItem(entity);
        }
    }

    private static void craftItem(ArcaneWorkbenchBlockEntity entity){
        entity.removeStack(0, 1);
        entity.removeStack(1, 1);
        entity.removeStack(2, 1);

        entity.setStack(RESULT_SLOT, new ItemStack(
            Items.THAUMONOMICON.getItem(),
            entity.getStack(RESULT_SLOT).getCount() + 1
        ));
    }

    private static boolean hasRecipe(ArcaneWorkbenchBlockEntity entity) {
        boolean itemIn1Slot = entity.getStack(0).getItem() == net.minecraft.item.Items.PAPER;
        boolean itemIn2Slot = entity.getStack(1).getItem() == net.minecraft.item.Items.PAPER;
        boolean itemIn3Slot = entity.getStack(2).getItem() == net.minecraft.item.Items.LEATHER;

        return itemIn1Slot && itemIn2Slot && itemIn3Slot;
    }

    private static boolean hasNotReachedStackLimit(ArcaneWorkbenchBlockEntity entity) {
        return entity.getStack(RESULT_SLOT).getCount() < entity.getStack(RESULT_SLOT).getMaxCount();
    }
}
