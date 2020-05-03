package RecipeBuilder;

import Recipe.Recipe;
import Recipe.RecipeCreationException;

import java.util.List;

public interface RecipeSource {
    public Recipe getRecipe() throws RecipeCreationException;
}
