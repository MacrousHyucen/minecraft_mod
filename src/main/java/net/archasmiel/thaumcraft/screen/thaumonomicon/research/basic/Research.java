package net.archasmiel.thaumcraft.screen.thaumonomicon.research.basic;

import io.github.cottonmc.cotton.gui.widget.data.Texture;
import net.archasmiel.thaumcraft.screen.thaumonomicon.research.bookview.BookView;
import net.minecraft.text.TranslatableText;

public class Research {

    public static final String RESEARCH_NAME = "gui.thaumcraft.research_name.";
    public static final String RESEARCH_DESC = "gui.thaumcraft.research_desc.";

    public static class Builder {

        private final Research research;



        public Builder() {
            research = new Research();
        }



        public Builder id(String id) {
            research.id = id;
            return this;
        }



        public Builder name() {
            if (research.id == null || research.id.equals("")) throw new IllegalStateException("No id found for research description");
            research.name = new TranslatableText(RESEARCH_NAME + research.id);
            return this;
        }

        public Builder name(TranslatableText name) {
            research.name = name;
            return this;
        }

        public Builder name(String key) {
            research.name = new TranslatableText(key);
            return this;
        }



        public Builder description() {
            if (research.id == null || research.id.equals(""))
                throw new IllegalStateException("No id found for research description");
            research.description = new TranslatableText(RESEARCH_DESC + research.id);
            return this;
        }

        public Builder description(TranslatableText description) {
            research.description = description;
            return this;
        }

        public Builder description(String key) {
            research.description = new TranslatableText(key);
            return this;
        }



        public Builder icon(Texture icon) {
            research.icon = icon;
            return this;
        }

        public Builder author(String author) {
            research.author = author;
            return this;
        }



        public Builder forbiddenLevel(ForbiddenLevel forbiddenLevel) {
            research.forbiddenLevel = forbiddenLevel;
            return this;
        }









        public Research build() {
            if (research.id == null || research.id.equals(""))
                throw new IllegalStateException("Research id not found");
            if (research.name == null)
                throw new IllegalStateException("Research name not found");
            if (research.description == null)
                throw new IllegalStateException("Research description not found");
            if (research.icon == null)
                throw new IllegalStateException("Research icon not found");
            if (research.author == null)
                research.author = "";

            if (research.forbiddenLevel == null)
                throw new IllegalStateException("Research forbidden level not found");
            research.isForbidden = research.forbiddenLevel != ForbiddenLevel.SAFE;

            return research;
        }

    }



    private String id;
    private TranslatableText name;
    private TranslatableText description;
    private Texture icon;
    private String author;

    private BookView bookView;

    private ForbiddenLevel forbiddenLevel;
    private boolean isForbidden = false;





    private Research() {

    }





    public String getId() {
        return id;
    }

    public TranslatableText getName() {
        return name;
    }

    public Texture getIcon() {
        return icon;
    }

    public BookView getBookView() {
        return bookView;
    }

    public boolean isForbidden() {
        return isForbidden;
    }

    public TranslatableText getDescription() {
        return description;
    }

    public String getAuthor() {
        return author;
    }

    public ForbiddenLevel getForbiddenLevel() {
        return forbiddenLevel;
    }
}
