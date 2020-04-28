package Recipe;

import java.util.List;

public class Recipe {
    private Directions directions;
    private List<Ingredient> ingredients;
    private String course;


    public Recipe(Directions directions, List<Ingredient> ingredients, String course) {
        this.directions = directions;
        this.ingredients = ingredients;
        this.course = course;
    }

    @Override
    public String toString() {
        return "Recipe{" +
                "directions=" + directions +
                ", ingredients=" + ingredients +
                ", course='" + course + '\'' +
                '}';
    }
}
