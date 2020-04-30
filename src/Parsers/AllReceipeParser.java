package Parsers;

import Recipe.Directions;
import Recipe.Ingredient;
import Recipe.IngredientGroup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AllReceipeParser extends GenericParser {

    public AllReceipeParser(String url) throws IOException, IncorrectParserException {
        super(url, "allrecipes.com");
    }

    @Override
    public List<Ingredient> parseIngredients() throws ParserFailedException {
        List<Element> ingredientList = getIngredientLists();
        parseIngredientGroups(ingredientList);

        return null; // label[class^=checkList__item]
    }

    private List<Element> getIngredientLists() throws ParserFailedException {
        List<Element> ingredientLists = new ArrayList<>(); //super.doc.select("ul[id^=]");
        int count = 1;
        Element e = doc.getElementById("lst_ingredients_" + count);
        while (e != null) {
            ingredientLists.add(e);
            count +=1;
            e = doc.getElementById("lst_ingredients_" + count);
        }
        if (ingredientLists == null) {
            throw new ParserFailedException("No Ingredient Lists Found on webpage: " + url);
        }
        return ingredientLists;
    }

    private List<IngredientGroup> parseIngredientGroups (List<Element> ingredientList) {
       boolean firstGroup = true;
        String groupTitle = "";
        List<String> ingredients = new ArrayList<>();

        Elements lstItem;
        for (Element lst: ingredientList) {
            for (Element item: lst.select("li")) {
                lstItem = item.select("input");
                if (!lstItem.hasAttr("disabled")) {
                    ingredients.add(item.text());
                } else if (!firstGroup) {
                    //Todo ship the old by adding to an IngredientGroup
                    System.out.println(groupTitle);
                    System.out.println(ingredients);
                    groupTitle = item.text();
                    ingredients.clear();
                } else {
                    firstGroup = false;
                    groupTitle = item.text();
                }
            }
        }
        System.out.println(groupTitle);
        System.out.println(ingredients);
        return new ArrayList<>(); //todo make this the actual list
    }

    @Override
    public Directions parseDirections() {
        return null;
    }
}
