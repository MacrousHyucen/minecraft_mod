package net.archasmiel.thaumcraft.screen.arcane_workbench;

import net.archasmiel.thaumcraft.block.Blocks;
import net.archasmiel.thaumcraft.blockentity.ArcaneWorkbenchBlockEntity;
import net.archasmiel.thaumcraft.blockentity.inventory.ImplementedInventory;
import net.archasmiel.thaumcraft.item.wandcraft.abilities.VisCraft;
import net.archasmiel.thaumcraft.recipe.VisCraftingRecipe;
import net.archasmiel.thaumcraft.screen.ScreenHandlers;
import net.archasmiel.thaumcraft.screen.arcane_workbench.inventory.CraftingWandInventory;
import net.archasmiel.thaumcraft.screen.arcane_workbench.slot.ResultSlot;
import net.archasmiel.thaumcraft.screen.arcane_workbench.slot.WandSlot;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.CraftingInventory;
import net.minecraft.inventory.CraftingResultInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.network.packet.s2c.play.ScreenHandlerSlotUpdateS2CPacket;
import net.minecraft.recipe.CraftingRecipe;
import net.minecraft.recipe.Recipe;
import net.minecraft.recipe.RecipeManager;
import net.minecraft.recipe.RecipeMatcher;
import net.minecraft.recipe.book.RecipeBookCategory;
import net.minecraft.screen.AbstractRecipeScreenHandler;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.ScreenHandlerContext;
import net.minecraft.screen.slot.Slot;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.world.World;

import java.util.Optional;

import static net.archasmiel.thaumcraft.recipe.Recipes.VIS_RECIPE_TYPE;
import static net.minecraft.recipe.RecipeType.CRAFTING;

public class ArcaneWorkbenchScreenHandler extends AbstractRecipeScreenHandler<CraftingInventory> {

    private final int OUTPUT_INDEX;
    private final int WAND_INDEX;
    private final int CRAFTING_INDEX_A;
    private final int CRAFTING_INDEX_B;
    private final int INVENTORY_INDEX_A;
    private final int INVENTORY_INDEX_B;
    private final int HOTBAR_INDEX_A;
    private final int HOTBAR_INDEX_B;

    private final ArcaneWorkbenchBlockEntity entity;
    static ArcaneWorkbenchBlockEntity lockedEntity;
    private boolean isReading;

    private final CraftingInventory input;
    private final CraftingResultInventory result;
    private final CraftingWandInventory wand;
    private final ScreenHandlerContext context;
    private final PlayerEntity player;





    public ArcaneWorkbenchScreenHandler(int i, PlayerInventory inventory) {
        this(i, inventory, ScreenHandlerContext.EMPTY, null);
    }

    public ArcaneWorkbenchScreenHandler(int syncId, PlayerInventory playerInventory, ScreenHandlerContext context, ArcaneWorkbenchBlockEntity entity) {
        super(ScreenHandlers.ARCANE_WORKBENCH_SCREEN_HANDLER, syncId);

        if (entity != null) {
            lockedEntity = entity;
        }

        this.entity = entity;

        this.input = new CraftingInventory(this, 3, 3);
        this.result = new CraftingResultInventory();
        this.wand = new CraftingWandInventory(this);

        this.context = context;
        this.player = playerInventory.player;



        // output slot
        OUTPUT_INDEX = 0;
        this.addSlot(new ResultSlot(playerInventory.player, this.input, this.wand, this.result, 0, 160, 64));

        // wand slot
        WAND_INDEX = 1;
        this.addSlot(new WandSlot(this.wand, 0, 160, 25));

        // crafting slots
        CRAFTING_INDEX_A = 2;
        CRAFTING_INDEX_B = 11;
        for (int i = 0 ; i < 3 ; i++) {
            for (int j = 0; j < 3; j++) {
                this.addSlot(new Slot(this.input, i * 3 + j, 40 + j * 24, 40 + i * 24));
            }
        }

        // inventory
        INVENTORY_INDEX_A = 11;
        INVENTORY_INDEX_B = 38;
        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 9; ++j) {
                this.addSlot(new Slot(playerInventory, 9 + i * 9 + j, 16 + 18 * j, 151 + 18 * i));
            }
        }

        // hotbar
        HOTBAR_INDEX_A = 38;
        HOTBAR_INDEX_B = 47;
        for (int i = 0; i < 9; ++i) {
            this.addSlot(new Slot(playerInventory, i, 16 + 18 * i, 209));
        }
    }






    public void onContentChanged(Inventory inventory) {
        // this function also being called on readContainer method, so here is checking for this
        // if not checking reading state, then a lot of mess happens

        if (!isReading) {
            this.context.run((world, pos) -> updateResult(this, world, this.player, this.input, this.result, this.wand));
            // saving container after updates
            saveContainer();
        }
    }

    protected static void updateResult(ScreenHandler handler, World world, PlayerEntity player, CraftingInventory input, CraftingResultInventory result, CraftingWandInventory wand) {
        if (!world.isClient) {
            ServerPlayerEntity serverPlayerEntity = (ServerPlayerEntity) player;
            ItemStack itemStack = ItemStack.EMPTY;

            if (world.getServer() == null) return;
            RecipeManager manager = world.getServer().getRecipeManager();

            DefaultedList<ItemStack> inv = DefaultedList.ofSize(10, ItemStack.EMPTY);
            for (int i = 0 ; i < 9 ; i++)
                inv.set(i, input.getStack(i));
            inv.set(9, wand.getStack(0));
            ImplementedInventory inventory = () -> inv;

            Optional<CraftingRecipe> optional = manager.getFirstMatch(CRAFTING, input, world);
            Optional<VisCraftingRecipe> optionalVisShaped = manager.getFirstMatch(VIS_RECIPE_TYPE, inventory, world);

            if (optional.isPresent()) {
                itemStack = optional.get().craft(input);
            } else if (optionalVisShaped.isPresent()){
                itemStack = optionalVisShaped.get().craft(inventory);
            }

            result.setStack(0, itemStack);
            handler.setPreviousTrackedSlot(0, itemStack);
            serverPlayerEntity.networkHandler.sendPacket(new ScreenHandlerSlotUpdateS2CPacket(handler.syncId, handler.nextRevision(), 0, itemStack));
        }
    }

    @Override
    public void sendContentUpdates() {
        // on content-updates reading content in workbench
        readContainer();
        super.sendContentUpdates();
    }

    private void readContainer() {
        // calls onContentChange every setStack
        isReading = true;
        if (entity != null) {
            BlockState aState = player.getWorld().getBlockState(entity.getPos());

            for (int i = 0; i < 9; i++)
                input.setStack(i, entity.getStack(i));
            input.markDirty();
            wand.setStack(0, entity.getStack(10));
            wand.markDirty();

            BlockState bState = player.getWorld().getBlockState(entity.getPos());
            player.getWorld().updateListeners(entity.getPos(), aState, bState, Block.NOTIFY_ALL);
        }
        isReading = false;

        // calling for recipe checking
        onContentChanged(input);
    }

    private void saveContainer() {
        // doesn't call onContentChange
        if (entity != null) {
            BlockState aState = player.getWorld().getBlockState(entity.getPos());

            for (int i = 0; i < 9; i++) {
                entity.setStack(i, input.getStack(i));
            }
            entity.setStack(10, wand.getStack(0));
            entity.markDirty();

            BlockState bState = player.getWorld().getBlockState(entity.getPos());
            player.getWorld().updateListeners(entity.getPos(), aState, bState, Block.NOTIFY_ALL);
        }
    }



    public void populateRecipeFinder(RecipeMatcher finder) {
        this.input.provideRecipeInputs(finder);
    }

    public void clearCraftingSlots() {
        this.input.clear();
        this.result.clear();
    }

    public boolean matches(Recipe<? super CraftingInventory> recipe) {
        return recipe.matches(this.input, this.player.world);
    }

    public void close(PlayerEntity player) {
        super.close(player);
    }

    public boolean canUse(PlayerEntity player) {
        // important - use correct block
        return canUse(this.context, player, Blocks.ARCANE_WORKBENCH);
    }

    public ItemStack transferSlot(PlayerEntity player, int index) {

        ItemStack itemStack = ItemStack.EMPTY;
        Slot slot = this.slots.get(index);
        if (slot.hasStack()) {
            ItemStack itemStack2 = slot.getStack();
            itemStack = itemStack2.copy();

            // if transferred from result slot
            if (index == OUTPUT_INDEX) {
                this.context.run((world, pos) -> itemStack2.getItem().onCraft(itemStack2, world, player));
                if (!this.insertItem(itemStack2, INVENTORY_INDEX_A, HOTBAR_INDEX_B, true)) {
                    return ItemStack.EMPTY;
                }
                slot.onQuickTransfer(itemStack2, itemStack);

            // if transferred from wand slot
            } else if (index == WAND_INDEX) {
                if (!this.insertItem(itemStack2, INVENTORY_INDEX_A, HOTBAR_INDEX_B, true)) {
                    return ItemStack.EMPTY;
                }

            // if transferred from inventory slot
            } else if (index >= INVENTORY_INDEX_A && index < HOTBAR_INDEX_B) {

                // inserting VisCraft item from inventory to slot
                if (itemStack2.getItem() instanceof VisCraft) {
                    if (!this.insertItem(itemStack2, WAND_INDEX, WAND_INDEX + 1, false)) {
                        return ItemStack.EMPTY;
                    }
                } else {
                    if (!this.insertItem(itemStack2, CRAFTING_INDEX_A, CRAFTING_INDEX_B, false)) {
                        if (index < HOTBAR_INDEX_A) {
                            if (!this.insertItem(itemStack2, HOTBAR_INDEX_A, HOTBAR_INDEX_B, false)) {
                                return ItemStack.EMPTY;
                            }
                        } else if (!this.insertItem(itemStack2, INVENTORY_INDEX_A, INVENTORY_INDEX_B, false)) {
                            return ItemStack.EMPTY;
                        }
                    }
                }

            // if transferred from crafting slot
            } else if (!this.insertItem(itemStack2, INVENTORY_INDEX_A, HOTBAR_INDEX_B, false)) {
                return ItemStack.EMPTY;
            }

            if (itemStack2.isEmpty()) {
                slot.setStack(ItemStack.EMPTY);
            } else {
                slot.markDirty();
            }

            if (itemStack2.getCount() == itemStack.getCount()) {
                return ItemStack.EMPTY;
            }

            slot.onTakeItem(player, itemStack2);
            if (index == 0) {
                player.dropItem(itemStack2, false);
            }
        }

        return itemStack;
    }

    public boolean canInsertIntoSlot(ItemStack stack, Slot slot) {
        return slot.getIndex() != OUTPUT_INDEX && super.canInsertIntoSlot(stack, slot);
    }

    public int getCraftingResultSlotIndex() {
        return 0;
    }

    public int getCraftingWidth() {
        return this.input.getWidth();
    }

    public int getCraftingHeight() {
        return this.input.getHeight();
    }

    public int getCraftingSlotCount() {
        return 11;
    }

    public RecipeBookCategory getCategory() {
        return RecipeBookCategory.CRAFTING;
    }

    public boolean canInsertIntoSlot(int index) {
        return index != this.getCraftingResultSlotIndex();
    }
}
