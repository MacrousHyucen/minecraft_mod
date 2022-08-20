package net.archasmiel.thaumcraft.screen.arcane_workbench;

import com.mojang.blaze3d.systems.RenderSystem;
import net.archasmiel.thaumcraft.Thaumcraft;
import net.archasmiel.thaumcraft.item.wandcraft.WandAbstract;
import net.archasmiel.thaumcraft.materials.aspect.AspectDraw;
import net.archasmiel.thaumcraft.materials.aspect.ColorCollection;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.render.GameRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.text.LiteralText;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import static net.archasmiel.thaumcraft.materials.aspect.Aspect.primaryAspects;

public class ArcaneWorkbenchScreen extends HandledScreen<ArcaneWorkbenchScreenHandler> {

    private static final Map<String, Float> currRecipeVis = new ConcurrentHashMap<>();
    public static final int ANIMATION_TIME = 1500;
    public static final int ANIMATION_TIME_HALF = ANIMATION_TIME / 2;

    private static final NbtCompound nbtNull = new NbtCompound();
    static {
        for (String i: primaryAspects) nbtNull.putFloat(i, 0);
    }

    private static final Identifier BACK_TEXTURE =
            new Identifier(Thaumcraft.MOD_ID, "textures/aspects/_back.png");
    private static final int ICON_SIZE = 16;
    private static final int SHADOW_SIZE = ICON_SIZE + 8;

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
    private static final int SIZE_X = 200;
    private static final int SIZE_Y = 240;


    public ArcaneWorkbenchScreen(ArcaneWorkbenchScreenHandler handler, PlayerInventory inventory, Text title) {
        super(handler, inventory, title);

        // hit box of gui
        backgroundWidth = SIZE_X;
        backgroundHeight = SIZE_Y;
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
        drawRecipeVis(matrices, handler.slots.get(1).getStack());
    }

    private void drawRecipeVis(MatrixStack matrices, ItemStack wand) {
        NbtCompound nbt = nbtNull.copy();
        AspectDraw aspect;
        double discount = 1.0f;

        if (!wand.isEmpty()){
            nbt = wand.getNbt();
            discount = ((WandAbstract) wand.getItem()).getDiscount();
        }

        for (Map.Entry<String, Float> entry: currRecipeVis.entrySet()) {
            if ((aspect = getAspect(entry.getKey())) != null) {
                float transparency = 1.0f;
                if (nbt != null && entry.getValue() * discount > nbt.getFloat(entry.getKey()))
                    transparency = Math.abs(System.currentTimeMillis() % ANIMATION_TIME - ANIMATION_TIME_HALF) / (float) ANIMATION_TIME_HALF;


                // drawing aspect icon+shadow on position
                RenderSystem.enableBlend();

                RenderSystem.setShader(GameRenderer::getPositionTexShader);
                RenderSystem.setShaderColor(1.0f, 1.0f, 1.0f, 0.5f);
                RenderSystem.setShaderTexture(0, BACK_TEXTURE);
                drawTexture(matrices, aspect.getX() - 4, aspect.getY() - 4, 0, 0, SHADOW_SIZE, SHADOW_SIZE, SHADOW_SIZE, SHADOW_SIZE);

                RenderSystem.setShader(GameRenderer::getPositionTexShader);
                RenderSystem.setShaderColor(aspect.getColor().getR(), aspect.getColor().getG(), aspect.getColor().getB(), transparency);
                RenderSystem.setShaderTexture(0, aspect.getId());
                drawTexture(matrices, aspect.getX(), aspect.getY(), 0, 0, ICON_SIZE, ICON_SIZE, ICON_SIZE, ICON_SIZE);


                // blend disable for text correct rendering
                RenderSystem.disableBlend();
                matrices.push();
                matrices.scale(0.5F, 0.5F, 0.5F);
                drawCenteredTextWithShadow(
                        matrices,
                        textRenderer,
                        new LiteralText(String.format("%.2f", entry.getValue() * discount)).asOrderedText(),
                        2*(aspect.getX()+8),
                        2*(aspect.getY()+18),
                        0xffffff
                );
                matrices.pop();
            }
        }
    }

    private AspectDraw getAspect(String name) {
        int centerX = (width - backgroundWidth) / 2 + 64;
        int centerY = (height - backgroundHeight) / 2 + 64;

        return switch (name) {
            case "aer"      -> new AspectDraw(ASPECT_TEXTURES[0], centerX - 48, centerY - 29, ASPECT_COLORS[0]);
            case "ignis"    -> new AspectDraw(ASPECT_TEXTURES[1], centerX, centerY - 51, ASPECT_COLORS[1]);
            case "aqua"     -> new AspectDraw(ASPECT_TEXTURES[2], centerX + 48, centerY - 29, ASPECT_COLORS[2]);
            case "terra"    -> new AspectDraw(ASPECT_TEXTURES[3], centerX - 48, centerY + 30, ASPECT_COLORS[3]);
            case "ordo"     -> new AspectDraw(ASPECT_TEXTURES[4], centerX, centerY + 51, ASPECT_COLORS[4]);
            case "perditio" -> new AspectDraw(ASPECT_TEXTURES[5], centerX + 48, centerY + 30, ASPECT_COLORS[5]);
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

    public static void clearCurrRecipeVis() {
        currRecipeVis.clear();
    }

    public static void addCurrRecipeVis(String key, Float value) {
        currRecipeVis.put(key, value);
    }

}
