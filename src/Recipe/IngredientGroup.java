package Recipe;

import java.util.List;

public class IngredientGroup {
    private List<Ingredient> ingredients;
    private String groupName;

    public IngredientGroup(String groupName, List<String> ingredientStringList) {

    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

}
