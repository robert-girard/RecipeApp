package RecipeBuilder;

import Recipe.Directions;
import Recipe.IngredientGroup;

import java.util.List;

public interface RecipeSource {
    public List<IngredientGroup> getIngredientGroups();
    public Directions getDirections();
}
