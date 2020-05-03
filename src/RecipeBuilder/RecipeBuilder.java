package RecipeBuilder;

import Recipe.Recipe;
import Recipe.RecipeCreationException;

public class RecipeBuilder {

    RecipeSourceTypes sourceType;
    String source;
    RecipeSource recipeSource;

    public RecipeBuilder(RecipeSourceTypes sourceType, String source) {
         this.sourceType = sourceType;
         this.source = source;
         switch (sourceType) {
             case WEBSITE:
                 recipeSource = new WebsiteSource(source);
         }
     }

     public Recipe getRecipe() {
        Recipe r = null;

        try {
            r = recipeSource.getRecipe();
        } catch (RecipeCreationException e) {
            e.printStackTrace();
        }
        return r;
     }


}
