package net.archasmiel.thaumcraft.materials.aspect;

import net.minecraft.util.Identifier;

public class AspectCollection {

    private Identifier id;
    private Integer x, y;
    private ColorCollection c;

    public AspectCollection(Identifier id, Integer x, Integer y, ColorCollection c) {
        this.id = id;
        this.x = x;
        this.y = y;
        this.c = c;
    }





    public Identifier getId() {
        return id;
    }

    public void setId(Identifier id) {
        this.id = id;
    }

    public Integer getX() {
        return x;
    }

    public void setX(Integer x) {
        this.x = x;
    }

    public Integer getY() {
        return y;
    }

    public void setY(Integer y) {
        this.y = y;
    }

    public void setXY(Integer x, Integer y) {
        this.x = x;
        this.y = y;
    }

    public ColorCollection getColor() {
        return c;
    }

    public void setColor(ColorCollection c) {
        this.c = c;
    }

}
