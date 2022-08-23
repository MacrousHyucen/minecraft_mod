package net.archasmiel.thaumcraft.screen.thaumonomicon.research.basic;

public enum ForbiddenLevel {

    SAFE(0),
    MOSTLY_HARMLESS(10),
    MINOR(25),
    MODERATE(50),
    TABOO(100);


    private int warpAmount;

    ForbiddenLevel(int warpAmount) {
        this.warpAmount = warpAmount;
    }

    public int getWarpAmount() {
        return warpAmount;
    }
}
