package Recipe;

import java.util.ArrayList;
import java.util.List;

public class IngredientGroup {
    private List<Ingredient> ingredients;
    private String groupName;

    public IngredientGroup() {
        ingredients = new ArrayList<Ingredient>();
    }

    public IngredientGroup(String groupName, List<String> ingredients) {
        this.groupName = groupName;
        this.ingredients = new ArrayList<>();
        for (String i : ingredients) {
            this.ingredients.add(new Ingredient(i));
        }
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public String getGroupName() {
        return groupName;
    }

    public void addIngredients(Ingredient ingredients) {
        this.ingredients.add(ingredients);
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    @Override
    public String toString() {
        String ident = groupName + "\n";
        for (Ingredient i : ingredients) {
            ident += i.getIngredient() + "\n";
        }

        return ident;
    }
}
