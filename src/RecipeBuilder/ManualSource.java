package RecipeBuilder;

import Recipe.RecipeCreationException;
import Recipe.Recipe;

public class ManualSource implements RecipeSource {

    @Override
    public Recipe getRecipe() throws RecipeCreationException {
        return null;
    }
}
