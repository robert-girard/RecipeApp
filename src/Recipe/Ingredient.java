package Recipe;

public class Ingredient {
    protected String ingredient;
    protected double measurement;
    protected String unit;

    public Ingredient(String ingredient, double measurement, String unit) {
        this.ingredient = ingredient;
        this.measurement = measurement;
        this.unit = unit;
    }
}
