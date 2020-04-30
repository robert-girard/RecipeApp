import Parsers.AllRecipes.AllReceipeParser;
import Parsers.Metric;
import Parsers.Units;

public class Main {
    public static void main(String[] args) {
        /*try {
            Connect.connect();
        } catch (Exception e) {
            e.printStackTrace();
        }*/
        try {
            AllReceipeParser allReceipeParser = new AllReceipeParser("https://www.allrecipes.com/recipe/266351/steamed-barbecue-pork-buns/");
            allReceipeParser.parseIngredients();
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
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("\n\n\n");
        try {
            AllReceipeParser allReceipeParser = new AllReceipeParser("https://www.allrecipes.com/recipe/61024/asian-orange-chicken/?internalSource=previously%20viewed&referringContentType=Homepage&clickId=cardslot%2043");
            allReceipeParser.parseIngredients();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}


