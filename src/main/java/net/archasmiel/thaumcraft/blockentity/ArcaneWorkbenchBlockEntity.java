package net.archasmiel.thaumcraft.blockentity;

import net.archasmiel.thaumcraft.blockentity.inventory.ImplementedInventory;
import net.archasmiel.thaumcraft.screen.arcane_workbench.ArcaneWorkbenchScreenHandler;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventories;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.Packet;
import net.minecraft.network.listener.ClientPlayPacketListener;
import net.minecraft.network.packet.s2c.play.BlockEntityUpdateS2CPacket;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.ScreenHandlerContext;
import net.minecraft.text.LiteralText;
import net.minecraft.text.Text;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import org.jetbrains.annotations.Nullable;

public class ArcaneWorkbenchBlockEntity extends BlockEntity implements NamedScreenHandlerFactory, ImplementedInventory {



    public static final int SIZE = 11;
    private final DefaultedList<ItemStack> inventory;

    private ScreenHandlerContext context;





    public ArcaneWorkbenchBlockEntity(BlockPos pos, BlockState state) {
        super(BlockEntities.ARCANE_WORKBENCH, pos, state);
        this.inventory = DefaultedList.ofSize(SIZE, ItemStack.EMPTY);
    }



    @Override
    public DefaultedList<ItemStack> getItems() {
        return inventory;
    }




    @Override
    public void readNbt(NbtCompound nbt) {
        super.readNbt(nbt);
        inventory.clear();
        Inventories.readNbt(nbt, inventory);
    }

    @Override
    protected void writeNbt(NbtCompound nbt) {
        super.writeNbt(nbt);
        Inventories.writeNbt(nbt, inventory);
    }



    @Nullable
    @Override
    public Packet<ClientPlayPacketListener> toUpdatePacket() {
        return BlockEntityUpdateS2CPacket.create(this);
    }

    @Override
    public NbtCompound toInitialChunkDataNbt() {
        NbtCompound nbtCompound = new NbtCompound();
        Inventories.writeNbt(nbtCompound, inventory, true);
        return nbtCompound;
    }





    @Override
    public Text getDisplayName() {
        return new LiteralText("");
    }

    @Nullable
    @Override
    public ScreenHandler createMenu(int syncId, PlayerInventory inv, PlayerEntity player) {
        return new ArcaneWorkbenchScreenHandler(
            syncId, inv, ScreenHandlerContext.create(world, pos), this
        );
    }

}
