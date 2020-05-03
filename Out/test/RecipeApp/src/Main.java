import Database.CreateDB;
import Database.InsertRecipe;
import Recipe.Recipe;

import RecipeBuilder.RecipeBuilder;
import RecipeBuilder.RecipeSourceTypes;

import java.util.ArrayList;
import java.util.List;


public class Main {


    static private List<Recipe> testParsing() {
        String url1 = "https://www.allrecipes.com/recipe/266351/steamed-barbecue-pork-buns/";
        String url2 = "https://www.allrecipes.com/recipe/276226/lazy-pork-dumplings/?internalSource=previously%20viewed&referringContentType=Homepage&clickId=cardslot%202";
        String url3 = "https://www.allrecipes.com/recipe/61024/asian-orange-chicken/?internalSource=previously%20viewed&referringContentType=Homepage&clickId=cardslot%2043";

        RecipeBuilder builder = new RecipeBuilder(RecipeSourceTypes.WEBSITE, url1);
        Recipe r1 = builder.getRecipe();
        System.out.println(r1);

        builder = new RecipeBuilder(RecipeSourceTypes.WEBSITE, url2);
        Recipe r2 = builder.getRecipe();
        System.out.println(r2);

        builder = new RecipeBuilder(RecipeSourceTypes.WEBSITE, url3);
        Recipe r3 = builder.getRecipe();
        System.out.println(r3);

        List<Recipe> rs = new ArrayList<Recipe>();
        rs.add(r1);
        rs.add(r2);
        rs.add(r3);

        return rs;
    }

    /*
    static private void testConnection() {
        try {
            Connect.connect("testDB.db");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static private void testDBCreation() {
        try {
            Create.createNewDatabase("testDB.db");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

     */

    public static void main(String[] args) {
        List<Recipe> rs = testParsing();

        CreateDB create = new CreateDB("test1.db");

        InsertRecipe insertRecipe = new InsertRecipe("test1.db");

        insertRecipe.insert(rs.get(0));




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

        */

    }
}


