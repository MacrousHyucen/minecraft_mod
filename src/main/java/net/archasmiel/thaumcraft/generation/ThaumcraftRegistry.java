package net.archasmiel.thaumcraft.generation;

import net.archasmiel.thaumcraft.generation.lang.GeneratedTranslations;
import net.archasmiel.thaumcraft.generation.lang.LanguageTranslations;
import net.archasmiel.thaumcraft.item.wandcraft.WandAbstract;
import net.devtech.arrp.json.blockstate.JBlockModel;
import net.devtech.arrp.json.blockstate.JState;
import net.devtech.arrp.json.blockstate.JVariant;
import net.devtech.arrp.json.loot.JCondition;
import net.devtech.arrp.json.loot.JEntry;
import net.devtech.arrp.json.loot.JLootTable;
import net.devtech.arrp.json.loot.JPool;
import net.devtech.arrp.json.models.*;
import net.minecraft.util.Identifier;

import static net.archasmiel.thaumcraft.Thaumcraft.*;

public class ThaumcraftRegistry {

    public static void simpleItemModel(String mod_id, String type, String modelName, String textureName) {
        RESOURCE_PACK.addModel(
                new JModel()
                    .parent("item/" + type)
                    .textures(
                            new JTextures().layer0(mod_id + ":item/" + textureName)
                    ),
                new Identifier(mod_id + ":item/" + modelName)
        );
    }

    public static void simpleBlockItemModel(String mod_id, String blockName) {
        RESOURCE_PACK.addModel(
                new JModel().parent(mod_id + ":block/" + blockName),

                new Identifier(mod_id + ":item/block/" + blockName)
        );
    }





    public static void simpleBlockModel(String mod_id, String blockName) {
        RESOURCE_PACK.addModel(
                new JModel()
                        .parent("block/cube_all")
                        .textures(
                                new JTextures().var("all", mod_id + ":block/" + blockName)
                        ),

                new Identifier(mod_id + ":block/" + blockName)
        );
    }

    public static void horizontalRotatableBlockState(String mod_id, String blockName) {
        RESOURCE_PACK.addBlockState(
                new JState().add(
                        new JVariant()
                                .put("facing=north", new JBlockModel(new Identifier(mod_id + ":block/" + blockName)).y(0))
                                .put("facing=east", new JBlockModel(new Identifier(mod_id + ":block/" + blockName)).y(90))
                                .put("facing=south", new JBlockModel(new Identifier(mod_id + ":block/" + blockName)).y(180))
                                .put("facing=west", new JBlockModel(new Identifier(mod_id + ":block/" + blockName)).y(270))
                ),

                new Identifier(mod_id + ":" + blockName)
        );
    }

    public static void simpleBlockLootTable(String mod_id, String blockName) {
        RESOURCE_PACK.addLootTable(
                new Identifier(mod_id + ":blocks/" + blockName),

                new JLootTable("minecraft:block")
                        .pool(
                                new JPool().rolls(1).entry(
                                        new JEntry()
                                                .type("minecraft:item")
                                                .name(mod_id + ":block/" + blockName)
                                )
                                .condition(new JCondition("minecraft:survives_explosion"))
                        )
        );
    }












    public static void wandcraftName(String mod_id, String[] supportedLanguages, LanguageTranslations INLANG, GeneratedTranslations OUTLANG, WandAbstract item) {
        for (String lang: supportedLanguages) {
            OUTLANG.addTranslation(
                    lang,
                    OUTLANG.getTranslation(lang).item(
                            new Identifier(mod_id, item.name()),
                            String.format(
                                    "§e%s %s %s",
                                    // get translation from json file
                                    INLANG.getTranslation(
                                            lang,
                                            // wand_cap.mod_id.name
                                            String.format("%s.%s.%s", "wand_cap", mod_id, item.getCap().getMaterialName())
                                    ),
                                    // get translation from json file
                                    INLANG.getTranslation(
                                            lang,
                                            // wand_rod.mod_id.name
                                            String.format("%s.%s.%s", "wand_rod", mod_id, item.getRod().getMaterialName())
                                    ),
                                    // get translation from json file
                                    INLANG.getTranslation(
                                            lang,
                                            // wand_type.mod_id.name
                                            String.format("%s.%s.%s", "wand_type", mod_id, item.getType())
                                    )
                            )
                    )
            );
        }
    }



    public static JModel wandModel(String mod_id, String rod, String cap) {
        return new JModel()
                .textures(
                        new JTextures()
                                .var("0", mod_id + ":models/" + rod)
                                .var("1", mod_id + ":models/" + cap)
                                .var("particle", mod_id + ":models/" + rod)
                )
                .element(
                        // top cap
                        new JElement()
                                .from(6.75f, 14.0f, 6.75f)
                                .to  (9.25f, 16.0f, 9.25f)
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
                                .from(6.75f, 0.0f, 6.75f)
                                .to  (9.25f, 2.0f, 9.25f)
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
                                .setGround               ( new JPosition().scale(0.5f, 0.5f, 0.5f) )
                                .setGui                  ( new JPosition().scale(0.9f, 0.9f, 0.9f).rotation(38.25f, 29.52f, -56.58f) )
                                .setHead                 ( new JPosition().translation(0.0f, 7.5f, -0.5f).rotation( 90.0f,   0.0f,  90.0f) )
                );
    }



    public static JModel scepterModel(String mod_id, String rod, String cap) {
        return new JModel()
                .textures(
                        new JTextures()
                                .var("0", mod_id + ":models/" + rod)
                                .var("1", mod_id + ":models/" + cap)
                                .var("particle", mod_id + ":models/" + rod)
                )
                .element(
                        // top cap
                        new JElement()
                                .from(6.5f, 19.0f, 6.5f)
                                .to  (9.5f, 22.0f, 9.5f)
                                .faces(
                                        new JFaces()
                                                .north( new JFace("1").uv(2.0f, 3.5f, 4.0f, 4.5f) )
                                                .east ( new JFace("1").uv(0.0f, 3.5f, 2.0f, 4.5f) )
                                                .south( new JFace("1").uv(2.0f, 3.5f, 4.0f, 4.5f) )
                                                .west ( new JFace("1").uv(0.0f, 3.5f, 2.0f, 4.5f) )
                                                .up   ( new JFace("1").uv(2.0f, 0.0f, 3.0f, 1.0f) )
                                                .down ( new JFace("1").uv(1.0f, 0.0f, 2.0f, 1.0f) )
                                ),

                        // mid cap
                        new JElement()
                                .from(6.75f, 14.0f, 6.75f)
                                .to  (9.25f, 16.0f, 9.25f)
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
                                .to   (9.0f, 21.0f, 9.0f)
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
                                .from(6.75f, 0.0f, 6.75f)
                                .to  (9.25f, 2.0f, 9.25f)
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
                                .setGround               ( new JPosition().scale(0.5f, 0.5f, 0.5f) )
                                .setGui                  ( new JPosition().translation(-1.5f, -1.5f, 0.0f).scale(0.8f, 0.8f, 0.8f).rotation(38.25f, 29.52f, -56.58f) )
                                .setHead                 ( new JPosition().translation(0.0f, 7.5f, -0.5f).rotation( 90.0f,   0.0f,  90.0f) )
                );
    }



    public static JModel staffModel(String mod_id, String rod, String cap) {
        return new JModel()
                .textures(
                        new JTextures()
                                .var("0", mod_id + ":models/" + rod)
                                .var("1", mod_id + ":models/" + cap)
                                .var("particle", mod_id + ":models/" + rod)
                )
                .element(
                        // top cap
                        new JElement()
                                .from(6.75f, 23.0f, 6.75f)
                                .to  (9.25f, 25.0f, 9.25f)
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
                                .from (7.0f, -8.0f, 7.0f)
                                .to   (9.0f, 24.0f, 9.0f)
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
                                .from(6.75f, -9.0f, 6.75f)
                                .to  (9.25f, -7.0f, 9.25f)
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
                                .setFirstperson_righthand( new JPosition().translation(0.0f, 3.0f, 0.0f).scale(0.6f, 0.6f, 0.6f) )
                                .setFirstperson_lefthand ( new JPosition().translation(0.0f, 3.0f, 0.0f).scale(0.6f, 0.6f, 0.6f) )
                                .setGround               ( new JPosition().scale(0.5f, 0.5f, 0.5f) )
                                .setGui                  ( new JPosition().scale(0.55f, 0.55f, 0.55f).rotation(38.25f, 29.52f, -56.58f) )
                                .setHead                 ( new JPosition().translation(0.0f, 7.5f, -0.5f).rotation(90.0f, 0.0f, 90.0f) )
                                .setFixed                ( new JPosition().scale(0.66f, 0.66f, 0.66f).rotation(0, 0, 45.0f) )
                );
    }


}
