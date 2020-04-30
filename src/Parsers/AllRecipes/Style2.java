package Parsers.AllRecipes;

import Parsers.Exceptions.ParserFailedException;
import Parsers.Styles;
import Recipe.IngredientGroup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

public class Style2 implements Styles {

    public List<Element> getIngredientLists(Document doc, String url) throws ParserFailedException {
        List<Element> ingredientLists = new ArrayList<>(); //super.doc.select("ul[id^=]");
        int count = 1;
        Elements e = doc.select("fieldset[class=ingredients-section__fieldset]");
        if (e == null) {
            throw new ParserFailedException("No Ingredient Lists Found on webpage: " + url);
        }
        return e;
    }

    public List<IngredientGroup> parseIngredientGroups (List<Element> ingredientList) {
        boolean firstGroup = true;
        String groupTitle = "";
        List<String> ingredients = new ArrayList<>();

        Elements lstItem;
        for (Element lst: ingredientList) {
            groupTitle = lst.select("legend").text();
            for (Element item: lst.select("li")) {
                ingredients.add(item.text());
            }
            System.out.println(groupTitle);
            System.out.println(ingredients);
            groupTitle = "";
            ingredients.clear();
        }
        return new ArrayList<>(); //todo make this the actual list
    }

    public List<String> getDirections(Document doc) throws ParserFailedException {
        List<String> sInstuctions = new ArrayList<String>();
        Elements instructions = doc.select("ul[class=instructions-section]");
        if (instructions.size() !=1) {
            throw new ParserFailedException("0 or more than one instructions sections");
        }
        for (Element instruction : instructions.first().select("li")) {
            Elements body = instruction.select("div.section-body");
            if (body.size() !=1) {
                throw new ParserFailedException("0 or more than one instruction bodies");
            }
            sInstuctions.add(body.text());
        }
        return sInstuctions;
    }

}
