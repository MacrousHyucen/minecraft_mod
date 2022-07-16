package net.archasmiel.thaumcraft.screen;

import net.archasmiel.thaumcraft.Thaumcraft;
import net.archasmiel.thaumcraft.screen.arcane_workbench.ArcaneWorkbenchScreenHandler;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;


public class ScreenHandlers {

    public static ScreenHandlerType<ArcaneWorkbenchScreenHandler> ARCANE_WORKBENCH_SCREEN_HANDLER;

    public static void register() {
        ARCANE_WORKBENCH_SCREEN_HANDLER =
            Registry.register(
                    Registry.SCREEN_HANDLER,
                    new Identifier(Thaumcraft.MOD_ID, "arcane_workbench"),
                    new ScreenHandlerType<>(ArcaneWorkbenchScreenHandler::new)
            );
    }
}
