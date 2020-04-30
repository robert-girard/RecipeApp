import Parsers.AllRecipes.AllReceipeParser;
import Measurement.Metric;
import Measurement.Units;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
         List<String> mtest = Arrays.asList("1 teaspoon Chinese five-spice powder", "1/2 teaspoon freshly ground black pepper",
                 "1/4 teaspoon cayenne pepper",
                 "1/8 teaspoon pink curing salt (optional)",
                 "1 (3 pound) boneless pork butt (shoulder)",
                 "1 pound raw shrimp, peeled and deveined",
                 "4 pounds ground beef",
                 "1 tablespoon minced fresh ginger root",
                 "1 shallot, minced",
                 "1 bunch green onions, chopped",
                 "3 leaves napa cabbage, chopped",
                 "2 tablespoons soy sauce",
                 "1 teaspoon Asian (toasted) sesame oil",
                 "salt and white pepper to taste",
                 "1 pinch white sugar",
                 "1 (10 ounce) package round gyoza/potsticker wrappers",
                 "vegetable oil",
                 "¼ cup water");




    }
}


