package net.archasmiel.thaumcraft.item.wandcraft;

import net.archasmiel.thaumcraft.block.Blocks;
import net.archasmiel.thaumcraft.block.advanced.ArcaneWorkbench;
import net.archasmiel.thaumcraft.block.advanced.Table;
import net.archasmiel.thaumcraft.blockentity.ArcaneWorkbenchBlockEntity;
import net.archasmiel.thaumcraft.item.basic.ThaumcraftItem;
import net.archasmiel.thaumcraft.item.wandcraft.abilities.VisCraft;
import net.archasmiel.thaumcraft.materials.wand.CapMaterials;
import net.archasmiel.thaumcraft.materials.wand.RodMaterials;
import net.fabricmc.loader.impl.util.StringUtil;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.LiteralText;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.HashMap;
import java.util.List;

import static net.archasmiel.thaumcraft.materials.aspect.Aspect.primaryAspects;
import static net.archasmiel.thaumcraft.materials.aspect.Aspect.primaryAspectsColor;
import static net.minecraft.util.Formatting.GOLD;

public abstract class WandAbstract extends ThaumcraftItem {
    /**
            Set multiplier always as:
            10% aspect margin     ->   -0.10f to multiplier constructor/setter,
             5% aspect margin     ->   -0.05f ...,
             0%                   ->    0.00f ...,
            10% aspect discount   ->    0.10f ...,
            25% aspect discount   ->    0.25f ...;

            Getter will give same discount/margin in float you put into setter.

            Program changes discount/margin to [1 - multiplier] which means:
            -0.10f to constructor/setter   ->   1.10 multiplier for wand,
            -0.05f to constructor/setter   ->   1.05 ...,
             0.00f to constructor/setter   ->   1.00 ...,
             0.10f to constructor/setter   ->   0.90 ...,
             0.25f to constructor/setter   ->   0.75 ...;
    */



    private final CapMaterials cap;
    private final RodMaterials rod;
    private final String type;

    private final float capacityMultiplier;
    private final int capacity;

    private final float wandDiscount;
    private final float discount;


    protected WandAbstract(Settings settings, String name, RodMaterials rod, CapMaterials cap,
                        float wandDiscount, float capacityMultiplier,
                        String type) {
        super(settings, name);

        // basic info for rod and cap
        this.rod = rod;
        this.cap = cap;
        this.type = type;

        // info for capacity and vis discount
        this.capacityMultiplier = capacityMultiplier;
        this.capacity = (int) (this.rod.getCapacity() * capacityMultiplier);
        this.wandDiscount = wandDiscount;
        this.discount = 1.00f - this.cap.getVisDiscount() - this.wandDiscount;
    }



    public CapMaterials getCap() {
        return cap;
    }
    public RodMaterials getRod() {
        return rod;
    }
    public String getType() {
        return type;
    }

    public float getDiscount() {
        return discount;
    }
    public int getCapacity() {
        return capacity;
    }
    public float getCapacityMultiplier() {
        return capacityMultiplier;
    }
    public float getWandDiscount() {
        return wandDiscount;
    }








    /*   WORLD INTERACTIONS   */
    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        PlayerEntity player = context.getPlayer();
        World world = context.getWorld();
        BlockPos pos = context.getBlockPos();

        if (world.isClient) return ActionResult.SUCCESS;

        if (player != null) {
            ItemStack stack = player.getMainHandStack();

            BlockState state = world.getBlockState(pos);
            if (state.getBlock() instanceof Table) {
                changeTableToWorkbench(world, pos, new ItemPlacementContext(context));
                putWandToWorkbench(stack.getItem(), world, pos, player);
            }
            if (state.getBlock() instanceof ArcaneWorkbench) {
                putWandToWorkbench(stack.getItem(), world, pos, player);
                // get item from workbench in workbench class
            }
        }

        return ActionResult.SUCCESS;
    }

    // puts wand to arcane workbench if slot is empty
    private void putWandToWorkbench(Item usingItem, World world, BlockPos pos, PlayerEntity player) {
        if (usingItem instanceof VisCraft && world.getBlockEntity(pos) instanceof ArcaneWorkbenchBlockEntity arcane && arcane.getStack(10).isEmpty()) {
            PlayerInventory inventory = player.getInventory();
            if (inventory.getStack(inventory.selectedSlot).isEmpty()) return;

            arcane.setStack(10, inventory.removeStack(inventory.selectedSlot));
            arcane.markDirty();

            world.playSound(
                    null, pos,
                    SoundEvents.BLOCK_BARREL_CLOSE, SoundCategory.BLOCKS,
                    0.5f, 2.0f
            );

            world.updateListeners(pos, world.getBlockState(pos), world.getBlockState(pos), Block.NOTIFY_LISTENERS);
        }
    }

    // changing table to arcane workbench
    private void changeTableToWorkbench(World world, BlockPos pos, ItemPlacementContext context) {
        world.setBlockState(pos, Blocks.ARCANE_WORKBENCH.getPlacementState(context));
        world.playSound(null, pos, SoundEvents.ENTITY_ZOMBIE_BREAK_WOODEN_DOOR, SoundCategory.BLOCKS, 0.3f, 2.0f);
    }










    /*   NBT DATA   */
    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        // nbt get&check
        NbtCompound nbt = stack.getNbt();
        nbt = checkWandNbt(nbt);
        stack.setNbt(nbt);


        // collecting vis information
        HashMap<String, Float> visData = new HashMap<>();
        for (String i: primaryAspects)
            visData.put(i, nbt.getFloat(i));



        if (Screen.hasShiftDown()) {
            // only capacity tooltip
            tooltip.add(
                    new LiteralText("")
                    .append(new TranslatableText("gui.thaumcraft.wand_capacity")
                    .append(this.getCapacity() + " ").formatted(GOLD))
            );

            // all aspects information (6 lines)
            for (int i = 0 ; i < primaryAspects.length ; i++)
                tooltip.add(
                    new LiteralText("")
                        .append(String.format(
                                " %s%s §f× %s, ",
                                primaryAspectsColor[i],
                                StringUtil.capitalize(primaryAspects[i]),
                                uncutFloat(visData.get(primaryAspects[i]))
                        ))
                        .append("§f(" + getStringDiscount(this.getDiscount()) + "%")
                        .append(new TranslatableText("gui.thaumcraft.vis_cost"))
                        .append(")")
                );
        } else {
            // capacity and vis discount information
            tooltip.add(
                new LiteralText("")
                    .append(new TranslatableText("gui.thaumcraft.wand_capacity").append(this.getCapacity() + " ").formatted(GOLD))
                    .append("§f(" + getStringDiscount(this.getDiscount()) + "%")
                    .append(new TranslatableText("gui.thaumcraft.vis_cost"))
                    .append(")")
            );

            // one-line information about vis
            tooltip.add(
                Text.of(
                    String.format(
                        "%s%s §f§l╎ %s%s §f§l╎ %s%s §f§l╎ %s%s §f§l╎ %s%s §f§l╎ %s%s",
                        primaryAspectsColor[0], cutFloat(visData.get(primaryAspects[0])),
                        primaryAspectsColor[1], cutFloat(visData.get(primaryAspects[1])),
                        primaryAspectsColor[2], cutFloat(visData.get(primaryAspects[2])),
                        primaryAspectsColor[3], cutFloat(visData.get(primaryAspects[3])),
                        primaryAspectsColor[4], cutFloat(visData.get(primaryAspects[4])),
                        primaryAspectsColor[5], cutFloat(visData.get(primaryAspects[5]))
                    )
                )
            );
        }

        super.appendTooltip(stack, world, tooltip, context);
    }

    private NbtCompound checkWandNbt(NbtCompound nbt) {
        if (nbt == null) nbt = new NbtCompound();

        for (String i: primaryAspects)
            if (!nbt.contains(i))
                nbt.putFloat(i, 0);

        return nbt;
    }

    private String getStringDiscount(float discount) {
        return String.format("%.0f", discount * 100);
    }

    private String cutFloat(float num) {
        return String.format("%.0f", num);
    }

    private String uncutFloat(float num) {
        return String.format("%.2f", num);
    }

}
