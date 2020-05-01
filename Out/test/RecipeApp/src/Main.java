import Recipe.Recipe;
import RecipeBuilder.RecipeBuilder;

import RecipeBuilder.eRecipeSource;


public class Main {
    public static void main(String[] args) {
        /*try {
            Connect.connect();
        } catch (Exception e) {
            e.printStackTrace();
        }*/
        /*
        try {
            AllReceipeParser allReceipeParser = new AllReceipeParser("https://www.allrecipes.com/recipe/266351/steamed-barbecue-pork-buns/");
            allReceipeParser.parseIngredients();
            allReceipeParser.parseDirections();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(Units.getAllUnitsRegex());
        System.out.println(Units.LITRE.getUnitRegex());
        System.out.println(Metric.MILLI.getPrefixRegex());
        System.out.println(Metric.getAllPrefixRegex());

        try {
            AllReceipeParser allReceipeParser = new AllReceipeParser("https://www.allrecipes.com/recipe/276226/lazy-pork-dumplings/?internalSource=previously%20viewed&referringContentType=Homepage&clickId=cardslot%202");
            allReceipeParser.parseIngredients();
            allReceipeParser.parseDirections();
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("\n\n\n");
        try {
            AllReceipeParser allReceipeParser = new AllReceipeParser("https://www.allrecipes.com/recipe/61024/asian-orange-chicken/?internalSource=previously%20viewed&referringContentType=Homepage&clickId=cardslot%2043");
            allReceipeParser.parseIngredients();
            allReceipeParser.parseDirections();
        } catch (Exception e) {
            e.printStackTrace();
        }
        */
        String url1 = "https://www.allrecipes.com/recipe/266351/steamed-barbecue-pork-buns/";
        String url2 = "https://www.allrecipes.com/recipe/276226/lazy-pork-dumplings/?internalSource=previously%20viewed&referringContentType=Homepage&clickId=cardslot%202";
        String url3 = "https://www.allrecipes.com/recipe/61024/asian-orange-chicken/?internalSource=previously%20viewed&referringContentType=Homepage&clickId=cardslot%2043";

        RecipeBuilder builder = new RecipeBuilder(eRecipeSource.WEBSITE, url1);
        Recipe r1 = builder.getRecipe();
        System.out.println(r1);

        builder = new RecipeBuilder(eRecipeSource.WEBSITE, url2);
        Recipe r2 = builder.getRecipe();
        System.out.println(r2);

        builder = new RecipeBuilder(eRecipeSource.WEBSITE, url3);
        Recipe r3 = builder.getRecipe();
        System.out.println(r3);

    }
}


