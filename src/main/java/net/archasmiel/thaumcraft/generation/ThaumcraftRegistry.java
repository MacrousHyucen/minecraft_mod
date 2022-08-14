package net.archasmiel.thaumcraft.generation;

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
import static net.archasmiel.thaumcraft.Thaumcraft.TRANSLATIONS;

public class ThaumcraftRegistry {

    private ThaumcraftRegistry() {

    }

    private static final String BLOCK_PATH = ":block/";
    private static final String MODELS_PATH = ":models/";
    private static final String WAND_ID_PATTERN = "%s.%s.%s";



    public static void simpleItemModel(String modId, String type, String modelName, String textureName) {
        RESOURCE_PACK.addModel(
                new JModel()
                    .parent("item/" + type)
                    .textures(
                            new JTextures().layer0(modId + ":item/" + textureName)
                    ),
                new Identifier(modId + ":item/" + modelName)
        );
    }

    public static void simpleBlockItemModel(String modId, String blockName) {
        RESOURCE_PACK.addModel(
                new JModel().parent(modId + BLOCK_PATH + blockName),

                new Identifier(modId + ":item/block/" + blockName)
        );
    }





    public static void simpleBlockModel(String modId, String blockName) {
        RESOURCE_PACK.addModel(
                new JModel()
                        .parent("block/cube_all")
                        .textures(
                                new JTextures().var("all", modId + BLOCK_PATH + blockName)
                        ),

                new Identifier(modId + BLOCK_PATH + blockName)
        );
    }

    public static void horizontalRotatableBlockState(String modId, String blockName) {
        RESOURCE_PACK.addBlockState(
                new JState().add(
                        new JVariant()
                                .put("facing=north", new JBlockModel(new Identifier(modId + BLOCK_PATH + blockName)).y(0))
                                .put("facing=east", new JBlockModel(new Identifier(modId + BLOCK_PATH + blockName)).y(90))
                                .put("facing=south", new JBlockModel(new Identifier(modId + BLOCK_PATH + blockName)).y(180))
                                .put("facing=west", new JBlockModel(new Identifier(modId + BLOCK_PATH + blockName)).y(270))
                ),

                new Identifier(modId + ":" + blockName)
        );
    }

    public static void simpleBlockLootTable(String modId, String blockName) {
        RESOURCE_PACK.addLootTable(
                new Identifier(modId + ":blocks/" + blockName),

                new JLootTable("minecraft:block")
                        .pool(
                                new JPool().rolls(1).entry(
                                        new JEntry()
                                                .type("minecraft:item")
                                                .name(modId + BLOCK_PATH + blockName)
                                )
                                .condition(new JCondition("minecraft:survives_explosion"))
                        )
        );
    }












    public static void wandcraftName(String modId, WandAbstract item) {
        for (String lang: TRANSLATIONS.getSupportedLanguages()) {
            TRANSLATIONS.getOutput().addTranslation(
                lang,
                TRANSLATIONS.getOutput().getTranslation(lang).item(
                    new Identifier(modId, item.name()),
                    String.format(
                            "§e%s %s %s",
                            // get translation from json file
                            TRANSLATIONS.getInput().getTranslation(
                                    lang,
                                    // wand_cap.mod_id.name
                                    String.format(WAND_ID_PATTERN, "wand_cap", modId, item.getCap().getMaterialName())
                            ),
                            // get translation from json file
                            TRANSLATIONS.getInput().getTranslation(
                                    lang,
                                    // wand_rod.mod_id.name
                                    String.format(WAND_ID_PATTERN, "wand_rod", modId, item.getRod().getMaterialName())
                            ),
                            // get translation from json file
                            TRANSLATIONS.getInput().getTranslation(
                                    lang,
                                    // wand_type.mod_id.name
                                    String.format(WAND_ID_PATTERN, "wand_type", modId, item.getType())
                            )
                    )
                )
            );
        }
    }



    public static JModel wandcraftModel(String modId, String type, String rod, String cap) {
        return new JModel()
            .parent("thaumcraft:item/" + type)
            .textures(
                new JTextures()
                .var("0", modId + MODELS_PATH + rod)
                .var("1", modId + MODELS_PATH + cap)
                .var("particle", modId + MODELS_PATH + rod)
            );
    }




}
