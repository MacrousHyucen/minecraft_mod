package net.archasmiel.thaumcraft.blockentity;

import net.archasmiel.thaumcraft.Thaumcraft;
import net.archasmiel.thaumcraft.block.Blocks;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class BlockEntities {

    public static BlockEntityType<ArcaneWorkbenchBlockEntity> ARCANE_WORKBENCH;

    public static void register(){
        ARCANE_WORKBENCH = Registry.register(
            Registry.BLOCK_ENTITY_TYPE,
            new Identifier(Thaumcraft.MOD_ID, "arcane_workbench"),
            FabricBlockEntityTypeBuilder.create(
                ArcaneWorkbenchBlockEntity::new,
                Blocks.ARCANE_WORKBENCH.block()
            ).build(null)
        );
    }

}
