package Recipe;

import RecipeBuilder.RecipeBuildException;

import java.time.Duration;
import java.util.List;

public class Recipe {
    private Directions directions;
    private List<IngredientGroup> ingredientGroups;
    private String course;
    private String type;
    private String title;
    private String nutrition;
    private int yield;
    private int servings;
    private Duration prepTime;
    private String image; //todo images man images

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYield() {
        return yield;
    }

    public void setYield(int yield) {
        this.yield = yield;
    }

    public int getServings() {
        return servings;
    }

    public void setServings(int servings) {
        this.servings = servings;
    }

    public Duration getPrepTime() {
        return prepTime;
    }

    public void setPrepTime(Duration prepTime) {
        this.prepTime = prepTime;
    }


    public Recipe(String title, Directions directions, List<IngredientGroup> ingredientGroups) throws RecipeCreationException {
        if (title == null || title == "") {
            throw new RecipeCreationException("Recipe title null or empty");
        } else if (directions == null || directions.isEmpty()) {
            throw new RecipeCreationException("Recipe Directions null or empty");
        } else if (ingredientGroups.isEmpty() || ingredientGroups == null) {
            throw new RecipeCreationException("Recipe Ingredients null or empty");
        }
        this.title = title;
        this.directions = directions;
        this.ingredientGroups = ingredientGroups;
    }

    @Override
    public String toString() {
        return "Recipe{" + title + "\n" +
                "Ingredients:\n" + ingredientGroups + "\n" +
                "directions:\n" + directions + "\n" +
                "Prep Time:\n" + prepTime +
                "\n}\n";
    }
}
