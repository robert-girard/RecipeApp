package Recipe;

public class Ingredient {
    private final String ingredient;
    private double measurement;
    private String unit;

    public Ingredient(String ingredient, double measurement, String unit) {
        this.ingredient = ingredient;
        this.measurement = measurement;
        this.unit = unit;
    }

    public Ingredient(String ingredient) {
        this.ingredient = ingredient;
    }

    public String getIngredient() {
        return ingredient;
    }

    @Override
    public String toString() {
        return ingredient;
    }
}
