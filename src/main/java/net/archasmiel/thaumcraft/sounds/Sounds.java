package net.archasmiel.thaumcraft.sounds;

import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import static net.archasmiel.thaumcraft.Thaumcraft.MOD_ID;

public class Sounds {

    public static SoundEvent PAGE_FLIP = registerEvent("page");
    public static SoundEvent JAR_SOUND = registerEvent("jar");

    private static SoundEvent registerEvent(String name) {
        Identifier id = new Identifier(MOD_ID, name);
        return Registry.register(Registry.SOUND_EVENT, id, new SoundEvent(id));
    }

    public static void register() {

    }

}
