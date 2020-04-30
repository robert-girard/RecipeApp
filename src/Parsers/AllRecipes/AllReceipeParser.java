package Parsers.AllRecipes;

import Parsers.GenericParser;
import Parsers.IncorrectParserException;
import Parsers.ParserFailedException;
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

    Styles style;

    public AllReceipeParser(String url) throws IOException, IncorrectParserException {
        super(url, "allrecipes.com");
        style = new Style1();
    }

    @Override
    public List<Ingredient> parseIngredients() throws ParserFailedException {
        try {
            List<Element> ingredientList = style.getIngredientLists(doc, url);
            style.parseIngredientGroups(ingredientList);
        } catch (ParserFailedException e) {
            //todo change style and try again
            style = new Style2();
            List<Element> ingredientList = style.getIngredientLists(doc, url);
            style.parseIngredientGroups(ingredientList);
        }

        return null; // label[class^=checkList__item]
    }



    @Override
    public Directions parseDirections() {
        return null;
    }
}
