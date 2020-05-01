package Recipe;

import java.util.List;

public class Recipe {
    private Directions directions;
    private List<IngredientGroup> ingredientGroups;
    private String course;


    public Recipe(Directions directions, List<IngredientGroup> ingredientGroups) {
        this.directions = directions;
        this.ingredientGroups = ingredientGroups;
    }

    @Override
    public String toString() {
        return "Recipe{\n" +
                "ingredients:\n" + ingredientGroups + "\n" +
                "directions:\n" + directions + "\n" +
                "}\n";
    }
}
