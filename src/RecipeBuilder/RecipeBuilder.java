package RecipeBuilder;

import Recipe.Recipe;
import Recipe.Directions;
import Recipe.IngredientGroup;

import java.util.List;

public class RecipeBuilder {

    eRecipeSource sourceType;
    String source;
    RecipeSource recipeSource;

    public RecipeBuilder(eRecipeSource sourceType, String source) {
         this.sourceType = sourceType;
         this.source = source;
         switch (sourceType) {
             case WEBSITE:
                 recipeSource = new WebsiteRecipe(source);
         }
     }

     public Recipe getRecipe() {
        Directions d = recipeSource.getDirections();
        List<IngredientGroup> ig = recipeSource.getIngredientGroups();

        return new Recipe(d,ig);
     }


}
