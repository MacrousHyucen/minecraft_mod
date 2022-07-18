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
import net.devtech.arrp.json.models.JModel;
import net.devtech.arrp.json.models.JTextures;
import net.minecraft.util.Identifier;

import static net.archasmiel.thaumcraft.Thaumcraft.RESOURCE_PACK;

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



    public static JModel wandcraftModel(String mod_id, String type, String rod, String cap) {
        return new JModel()
            .parent("thaumcraft:item/" + type)
            .textures(
                new JTextures()
                .var("0", mod_id + ":models/" + rod)
                .var("1", mod_id + ":models/" + cap)
                .var("particle", mod_id + ":models/" + rod)
            );
    }




}
