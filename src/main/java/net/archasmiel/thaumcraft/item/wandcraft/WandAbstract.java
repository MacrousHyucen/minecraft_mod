package net.archasmiel.thaumcraft.item.wandcraft;

import net.archasmiel.thaumcraft.block.Blocks;
import net.archasmiel.thaumcraft.block.advanced.ArcaneWorkbench;
import net.archasmiel.thaumcraft.block.advanced.Table;
import net.archasmiel.thaumcraft.blockentity.ArcaneWorkbenchBlockEntity;
import net.archasmiel.thaumcraft.item.basic.ThaumcraftItem;
import net.archasmiel.thaumcraft.item.wandcraft.abilities.VisCraft;
import net.archasmiel.thaumcraft.materials.CapMaterials;
import net.archasmiel.thaumcraft.materials.RodMaterials;
import net.fabricmc.loader.impl.util.StringUtil;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.LiteralText;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.HashMap;
import java.util.List;

import static net.archasmiel.thaumcraft.Thaumcraft.primaryAspects;
import static net.archasmiel.thaumcraft.Thaumcraft.primaryAspectsColor;
import static net.minecraft.util.Formatting.GOLD;

public abstract class WandAbstract extends ThaumcraftItem {
    /*
            Set multiplier always as:
            10% aspect margin     ->   -0.10f to multiplier constructor/setter,
             5% aspect margin     ->   -0.05f ...,
             0%                   ->    0.00f ...,
            10% aspect discount   ->    0.10f ...,
            25% aspect discount   ->    0.25f ...;

            Getter will give same discount/margin in float you put into setter.

            Program changes discount/margin to [1 - multiplier] which means:
            -0.10f to constructor/setter   ->   1.10 multiplier for wand,
            -0.05f to constructor/setter   ->   1.05 ..,
             0.00f to constructor/setter   ->   1.00 ..,
             0.10f to constructor/setter   ->   0.90 ..,
             0.25f to constructor/setter   ->   0.75 ..;
    */



    private CapMaterials cap;
    private RodMaterials rod;
    private String type;

    private float capacityMultiplier;
    private float discount;
    private int capacity;
    private float wandDiscount;


    public WandAbstract(Settings settings, String name, RodMaterials rod, CapMaterials caps,
                        float wandDiscount, float capacityMultiplier,
                        String type) {
        super(settings, name);

        this.setType(type);

        // basic info for capacity and discount
        this.setRod(rod);
        this.setCaps(caps);

        // info for capacity and info final values
        this.setCapacityMultiplier(capacityMultiplier);
        this.wandDiscount = wandDiscount;
        this.setDiscount(wandDiscount);
    }



    public CapMaterials getCap() {
        return cap;
    }
    public void setCaps(CapMaterials cap) {
        this.cap = cap;
    }

    public RodMaterials getRod() {
        return rod;
    }
    public void setRod(RodMaterials rod) {
        this.rod = rod;
    }

    public float getDiscount() {
        return discount;
    }

    public void setDiscount(float wandDiscount) {
        this.discount = 1.00f - this.cap.getVisDiscount() - this.wandDiscount;
    }
    public void setWandDiscount(float wandDiscount) {
        this.wandDiscount = wandDiscount;
    }

    public float getCapacityMultiplier() {
        return capacityMultiplier;
    }
    public void setCapacityMultiplier(float capacityMultiplier) {
        this.capacityMultiplier = capacityMultiplier;
        this.capacity = (int) (this.rod.getCapacity() * this.capacityMultiplier);
    }

    public int getCapacity() {
        return capacity;
    }

    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }






    /*   WORLD INTERACTIONS   */
    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {

        if (!context.getWorld().isClient && context.getHand() == Hand.MAIN_HAND) {
            if (context.getPlayer() != null){
                Item usingItem = context.getPlayer().getStackInHand(Hand.MAIN_HAND).getItem();

                if (usingItem instanceof WandAbstract){
                    BlockState state = context.getWorld().getBlockState(context.getBlockPos());

                    if (state.getBlock() instanceof Table) {
                        context.getWorld().setBlockState(
                            context.getBlockPos(),
                            Blocks.ARCANE_WORKBENCH.block().getDefaultState()
                        );

                        context.getWorld().playSound(
                            null,
                            context.getBlockPos(),
                            SoundEvents.ENTITY_ZOMBIE_BREAK_WOODEN_DOOR,
                            SoundCategory.BLOCKS,
                            0.3f,
                            2.0f
                        );

                        if (usingItem instanceof VisCraft && Screen.hasShiftDown()) {
                            BlockEntity entity = context.getWorld().getBlockEntity(context.getBlockPos());
                            if (entity instanceof ArcaneWorkbenchBlockEntity arcane) {
                                BlockState aState = entity.getWorld().getBlockState(entity.getPos());

                                PlayerInventory inv = context.getPlayer().getInventory();
                                arcane.setStack(10, inv.removeStack(inv.selectedSlot));
                                arcane.markDirty();

                                BlockState bState = entity.getWorld().getBlockState(entity.getPos());
                                entity.getWorld().updateListeners(entity.getPos(), aState, bState, Block.NOTIFY_LISTENERS);
                            }
                        }
                    }

                    if (state.getBlock() instanceof ArcaneWorkbench) {
                        if (usingItem instanceof VisCraft && Screen.hasShiftDown()) {
                            BlockEntity entity = context.getWorld().getBlockEntity(context.getBlockPos());
                            if (entity instanceof ArcaneWorkbenchBlockEntity arcane) {
                                if (arcane.getStack(10) == ItemStack.EMPTY) {
                                    BlockState aState = entity.getWorld().getBlockState(entity.getPos());

                                    PlayerInventory inv = context.getPlayer().getInventory();
                                    arcane.setStack(10, inv.removeStack(inv.selectedSlot));
                                    arcane.markDirty();

                                    context.getWorld().playSound(
                                            null,
                                            context.getBlockPos(),
                                            SoundEvents.BLOCK_BARREL_CLOSE,
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
                }
            }
        }

        return ActionResult.SUCCESS;
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
                            .append(new TranslatableText("gui.thaumcraft.wand_capacity").append(this.getCapacity() + " ").formatted(GOLD))
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
        if (nbt == null)
            nbt = new NbtCompound();

        for (String i: primaryAspects)
            if (!nbt.contains(i))
                nbt.putFloat(i, 0);

        return nbt;
    }

    private String getStringDiscount(float discount) {
        return Integer.toString((int) (discount * 100));
    }

    private String cutFloat(float num) {
        return String.valueOf((int) num);
    }

    private String uncutFloat(float num) {
        return String.valueOf(num);
    }

}
