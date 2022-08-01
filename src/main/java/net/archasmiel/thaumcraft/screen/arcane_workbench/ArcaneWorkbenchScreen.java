package net.archasmiel.thaumcraft.screen.arcane_workbench;

import com.mojang.blaze3d.systems.RenderSystem;
import net.archasmiel.thaumcraft.Thaumcraft;
import net.archasmiel.thaumcraft.item.wandcraft.WandAbstract;
import net.archasmiel.thaumcraft.materials.aspect.AspectCollection;
import net.archasmiel.thaumcraft.materials.aspect.ColorCollection;
import net.archasmiel.thaumcraft.recipe.VisCraftingRecipe;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.render.GameRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.recipe.Recipe;
import net.minecraft.text.LiteralText;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.world.World;

import java.util.Map;

import static net.archasmiel.thaumcraft.screen.arcane_workbench.ArcaneWorkbenchScreenHandler.lockedEntity;

public class ArcaneWorkbenchScreen extends HandledScreen<ArcaneWorkbenchScreenHandler> {

    private static final Identifier BACK_TEXTURE =
            new Identifier(Thaumcraft.MOD_ID, "textures/aspects/_back.png");
    private static final int iconSize = 16;

    private static final ColorCollection[] ASPECT_COLORS = {
            new ColorCollection(255f/255, 255f/255, 126f/255),
            new ColorCollection(255f/255,  90f/255,   1f/255),
            new ColorCollection( 57f/255, 134f/255, 104f/255),
            new ColorCollection( 86f/255, 192f/255,   0f/255),
            new ColorCollection(213f/255, 212f/255, 236f/255),
            new ColorCollection( 64f/255,  64f/255,  64f/255)
    };
    private static final Identifier[] ASPECT_TEXTURES = {
            new Identifier(Thaumcraft.MOD_ID, "textures/aspects/aer.png"),
            new Identifier(Thaumcraft.MOD_ID, "textures/aspects/ignis.png"),
            new Identifier(Thaumcraft.MOD_ID, "textures/aspects/aqua.png"),
            new Identifier(Thaumcraft.MOD_ID, "textures/aspects/terra.png"),
            new Identifier(Thaumcraft.MOD_ID, "textures/aspects/ordo.png"),
            new Identifier(Thaumcraft.MOD_ID, "textures/aspects/perditio.png")
    };

    private static final Identifier GUI_TEXTURE =
            new Identifier(Thaumcraft.MOD_ID, "textures/gui/arcane_workbench.png");
    private static final int sizeX = 200, sizeY = 240;


    public ArcaneWorkbenchScreen(ArcaneWorkbenchScreenHandler handler, PlayerInventory inventory, Text title) {
        super(handler, inventory, new LiteralText(""));

        // hitbox of gui
        backgroundWidth = sizeX;
        backgroundHeight = sizeY;
    }

    @Override
    protected void handledScreenTick() {

    }

    @Override
    protected void drawBackground(MatrixStack matrices, float delta, int mouseX, int mouseY) {
        RenderSystem.enableBlend();

        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.setShaderTexture(0, GUI_TEXTURE);
        int x = (width - backgroundWidth) / 2;
        int y = (height - backgroundHeight) / 2;
        drawTexture(matrices, x, y, 0, 0, backgroundWidth, backgroundHeight);


        DefaultedList<ItemStack> items = DefaultedList.of();
        for (int i = 0; i < 9; i++) {
            items.add(lockedEntity.getStack(i));
        }
        items.add(lockedEntity.getStack(10));

        World world = lockedEntity.getWorld();

        if (world != null) {
            VisCraftingRecipe res = null;
            for (Recipe<?> i: world.getRecipeManager().values()) {
                if (i instanceof VisCraftingRecipe j && j.matchesItems(() -> items, world)) {
                    res = j;
                }
            }

            if (res != null) {
                drawRecipeVis(matrices, res, lockedEntity.getStack(10));
            }
        }


    }

    private void drawRecipeVis(MatrixStack matrices, VisCraftingRecipe visRecipe, ItemStack wand) {
        NbtCompound nbt = null;
        AspectCollection aspect;
        ColorCollection color;

        double discount = 1.0f;
        if (!wand.isEmpty()){
            nbt = wand.getNbt();
            discount = ((WandAbstract) wand.getItem()).getDiscount();
        }

        NbtCompound nbtNull = new NbtCompound();
        for (String i: Thaumcraft.primaryAspects) {
            nbtNull.putFloat(i, 0);
        }
        if (nbt == null) nbt = nbtNull;

        for (Map.Entry<String, Float> entry : visRecipe.getRecipeVis().entrySet()) {
            aspect = getAspectCoordinates(entry.getKey());
            color = aspect.getColor();

            float transp = 1.0f;
            if (entry.getValue() * discount > nbt.getFloat(entry.getKey()))
                transp = Math.abs(System.currentTimeMillis() % 1000 - 500) / 500.0f;

            RenderSystem.enableBlend();
            RenderSystem.setShader(GameRenderer::getPositionTexShader);
            RenderSystem.setShaderColor(color.getR(), color.getG(), color.getB(), transp);
            RenderSystem.setShaderTexture(0, aspect.getId());
            drawTexture(matrices, aspect.getX(), aspect.getY(), 0, 0, iconSize, iconSize, iconSize, iconSize);
            // TODO draw text value
            RenderSystem.disableBlend();
            matrices.push();
            matrices.scale(0.5F, 0.5F, 0.5F);
            drawCenteredTextWithShadow(matrices, MinecraftClient.getInstance().textRenderer, new LiteralText(String.format("%.2f", entry.getValue() * discount)).asOrderedText(), 2*(aspect.getX()+8), 2*(aspect.getY()+18), 0xffffff);
            matrices.pop();
        }
    }

    private AspectCollection getAspectCoordinates(String name) {
        int centerX = (width - backgroundWidth) / 2 + 64;
        int centerY = (height - backgroundHeight) / 2 + 64;

        return switch (name) {
            case "aer"      -> new AspectCollection(ASPECT_TEXTURES[0], centerX - 48, centerY - 29, ASPECT_COLORS[0]);
            case "ignis"    -> new AspectCollection(ASPECT_TEXTURES[1], centerX, centerY - 51, ASPECT_COLORS[1]);
            case "aqua"     -> new AspectCollection(ASPECT_TEXTURES[2], centerX + 48, centerY - 29, ASPECT_COLORS[2]);
            case "terra"    -> new AspectCollection(ASPECT_TEXTURES[3], centerX - 48, centerY + 30, ASPECT_COLORS[3]);
            case "ordo"     -> new AspectCollection(ASPECT_TEXTURES[4], centerX, centerY + 51, ASPECT_COLORS[4]);
            case "perditio" -> new AspectCollection(ASPECT_TEXTURES[5], centerX + 48, centerY + 30, ASPECT_COLORS[5]);
            default -> null;
        };

    }

    @Override
    protected void drawForeground(MatrixStack matrices, int mouseX, int mouseY) {
        // renders unneeded titles
    }

    @Override
    public void render(MatrixStack matrices, int mouseX, int mouseY, float delta) {
        renderBackground(matrices);
        super.render(matrices, mouseX, mouseY, delta);
        drawMouseoverTooltip(matrices, mouseX, mouseY);
    }
}
