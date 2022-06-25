package net.archasmiel.thaumcraft.lib.generation;

import net.devtech.arrp.json.models.*;

public class WandDataGeneration {

    public static JModel wandModel(String rod, String cap) {
        return new JModel()
                .textures(
                        new JTextures()
                                .var("0", "thaumcraft:models/" + rod)
                                .var("1", "thaumcraft:models/" + cap)
                                .var("particle", "thaumcraft:models/" + rod)
                )
                .element(
                        // top cap
                        new JElement()
                                .from(6.5f, 14.0f, 6.5f)
                                .to  (9.5f, 16.0f, 9.5f)
                                .faces(
                                        new JFaces()
                                                .north( new JFace("1").uv(2.0f, 3.5f, 4.0f, 4.5f) )
                                                .east ( new JFace("1").uv(0.0f, 3.5f, 2.0f, 4.5f) )
                                                .south( new JFace("1").uv(2.0f, 3.5f, 4.0f, 4.5f) )
                                                .west ( new JFace("1").uv(0.0f, 3.5f, 2.0f, 4.5f) )
                                                .up   ( new JFace("1").uv(2.0f, 0.0f, 3.0f, 1.0f) )
                                                .down ( new JFace("1").uv(1.0f, 0.0f, 2.0f, 1.0f) )
                                ),

                        // rod
                        new JElement()
                                .from (7.0f,  2.0f, 7.0f)
                                .to   (9.0f, 14.0f, 9.0f)
                                .faces(
                                        new JFaces()
                                                .north( new JFace("0").uv(2.0f, 5.0f, 4.0f, 14.0f) )
                                                .east ( new JFace("0").uv(0.0f, 5.0f, 2.0f, 14.0f) )
                                                .south( new JFace("0").uv(2.0f, 5.0f, 4.0f, 14.0f) )
                                                .west ( new JFace("0").uv(0.0f, 5.0f, 2.0f, 14.0f) )
                                                .up   ( new JFace("0").uv(1.0f, 4.0f, 2.0f,  5.0f) )
                                                .down ( new JFace("0").uv(2.0f, 4.0f, 3.0f,  5.0f) )
                                ),

                        // bot cap
                        new JElement()
                                .from(6.5f, 0.0f, 6.5f)
                                .to  (9.5f, 2.0f, 9.5f)
                                .faces(
                                        new JFaces()
                                                .north( new JFace("1").uv(0.0f, 1.0f, 2.0f, 2.0f) )
                                                .east ( new JFace("1").uv(2.0f, 1.0f, 4.0f, 2.0f) )
                                                .south( new JFace("1").uv(2.0f, 1.0f, 4.0f, 2.0f) )
                                                .west ( new JFace("1").uv(0.0f, 1.0f, 2.0f, 2.0f) )
                                                .up   ( new JFace("1").uv(1.0f, 0.0f, 3.0f, 1.0f) )
                                                .down ( new JFace("1").uv(2.0f, 0.0f, 2.0f, 1.0f) )
                                )
                )
                .display(
                        new JDisplay()
                                .setThirdperson_righthand( new JPosition().scale(0.6f, 0.6f, 0.6f) )
                                .setThirdperson_lefthand ( new JPosition().scale(0.6f, 0.6f, 0.6f) )
                                .setFirstperson_righthand( new JPosition().translation(0.0f, 1.0f, 0.0f).scale(0.6f, 0.6f, 0.6f) )
                                .setFirstperson_lefthand ( new JPosition().translation(0.0f, 1.0f, 0.0f).scale(0.6f, 0.6f, 0.6f) )
                                .setGround               ( new JPosition().scale(0.6f, 0.6f, 0.6f) )
                                .setGui                  ( new JPosition().scale(0.8f, 0.8f, 0.8f).rotation(-30.0f, -30.0f, -45.0f) )
                                .setHead                 ( new JPosition().translation(0.0f, 7.5f, -0.5f).rotation( 90.0f,   0.0f,  90.0f) )
                );
    }


}
