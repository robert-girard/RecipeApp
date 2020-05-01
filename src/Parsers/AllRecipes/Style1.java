package Parsers.AllRecipes;

import Parsers.Exceptions.ParserFailedException;
import Parsers.Styles;
import Recipe.Directions;
import Recipe.IngredientGroup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

public class Style1 implements Styles {


    public List<Element> getIngredientLists(Document doc, String url) throws ParserFailedException {
        List<Element> ingredientLists = new ArrayList<>(); //super.doc.select("ul[id^=]");
        int count = 1;
        Element e = doc.getElementById("lst_ingredients_" + count);
        while (e != null) {
            ingredientLists.add(e);
            count +=1;
            e = doc.getElementById("lst_ingredients_" + count);
        }
        if (ingredientLists.isEmpty()) {
            throw new ParserFailedException("No Ingredient Lists Found on webpage: " + url);
        }
        return ingredientLists;
    }

    public List<IngredientGroup> parseIngredientGroups (List<Element> ingredientList) {
        boolean firstGroup = true;
        String groupTitle = "";
        List<String> ingredients = new ArrayList<>();
        List<IngredientGroup> ingredientGroups = new ArrayList<>();

        Elements lstItem;
        for (Element lst: ingredientList) {
            for (Element item: lst.select("li")) {
                lstItem = item.select("input");
                if (!lstItem.hasAttr("disabled")) {
                    ingredients.add(item.text());
                } else if (!firstGroup) {
                    ingredientGroups.add(new IngredientGroup(groupTitle, ingredients));
                    groupTitle = item.text();
                    ingredients.clear();
                } else {
                    firstGroup = false;
                    groupTitle = item.text();
                }
            }
        }
        ingredientGroups.add(new IngredientGroup(groupTitle, ingredients));
        return ingredientGroups;
    }

    public Directions getDirections(Document doc) throws ParserFailedException {
        List<String> sInstuctions = new ArrayList<String>();
        Elements instructions = doc.select("ol[itemprop=recipeInstructions]");
        if (instructions.size() !=1) {
            throw new ParserFailedException("0 or more than one instructions sections");
        }
        for (Element instruction : instructions.first().select("li")) {
            sInstuctions.add(instruction.text());
        }

        Directions directions = new Directions(sInstuctions);
        return directions;
    }


}

