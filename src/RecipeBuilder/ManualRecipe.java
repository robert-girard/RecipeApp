package RecipeBuilder;

import Recipe.Directions;
import Recipe.IngredientGroup;

import java.util.List;

public class ManualRecipe implements RecipeSource {
    @Override
    public List<IngredientGroup> getIngredientGroups() {
        return null;
    }

    @Override
    public Directions getDirections() {
        return null;
    }

    @Override
    public String getTitle() {
        return null;
    }
}
