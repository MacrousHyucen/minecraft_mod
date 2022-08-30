package net.archasmiel.thaumcraft.util.thaumonomicon;

import net.archasmiel.thaumcraft.util.server.IEntityDataSaver;
import net.archasmiel.thaumcraft.util.collections.Pair;
import net.minecraft.nbt.NbtCompound;

public class ThaumonomiconPosData {

    public static final Pair<Float, Float> DEF_POS = new Pair<>(0f, 0f);



    private ThaumonomiconPosData() {

    }





    public static String getTabPosXTag(String tabId) {
        return tabId + "_posx";
    }

    public static String getTabPosYTag(String tabId) {
        return tabId + "_posy";
    }





    public static void setTabPos(IEntityDataSaver player, String tabId, Float posX, Float posY) {
        NbtCompound nbt = player.getPersistentData();
        nbt.putFloat(getTabPosXTag(tabId), posX);
        nbt.putFloat(getTabPosYTag(tabId), posY);
    }

    public static void setTabPos(IEntityDataSaver player, String tabId, Pair<Float, Float> pos) {
        setTabPos(player, tabId, pos.getLeft(), pos.getRight());
    }





    public static Pair<Float, Float> getTabPos(IEntityDataSaver player, String tabId) {
        NbtCompound nbt = player.getPersistentData();
        if (!nbt.contains(getTabPosXTag(tabId)) || !nbt.contains(getTabPosYTag(tabId))) {
            setTabPos(player, tabId, DEF_POS);
            return DEF_POS;
        }

        return new Pair<>(nbt.getFloat(getTabPosXTag(tabId)), nbt.getFloat(getTabPosYTag(tabId)));
    }

}
