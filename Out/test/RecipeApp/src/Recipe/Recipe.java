package Recipe;

import java.time.temporal.Temporal;
import java.time.temporal.TemporalAmount;
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
    private TemporalAmount prepTime;
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

    public TemporalAmount getPrepTime() {
        return prepTime;
    }

    public void setPrepTime(TemporalAmount prepTime) {
        this.prepTime = prepTime;
    }


    public Recipe(String title, Directions directions, List<IngredientGroup> ingredientGroups) {
        this.title = title;
        this.directions = directions;
        this.ingredientGroups = ingredientGroups;
    }

    @Override
    public String toString() {
        return "Recipe{" + title + "\n" +
                "ingredients:\n" + ingredientGroups + "\n" +
                "directions:\n" + directions + "\n" +
                "}\n";
    }
}
