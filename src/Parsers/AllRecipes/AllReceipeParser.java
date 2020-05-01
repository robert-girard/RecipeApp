package Parsers.AllRecipes;

import Parsers.Parser;
import Parsers.Exceptions.IncorrectParserException;
import Parsers.Exceptions.ParserFailedException;
import Parsers.Styles;
import Recipe.Directions;
import Recipe.Ingredient;
import Recipe.IngredientGroup;
import org.jsoup.nodes.Element;

import java.io.IOException;

import java.util.List;

public class AllReceipeParser extends Parser {

    Styles style;

    public AllReceipeParser(String url) throws IOException, IncorrectParserException {
        super(url, "allrecipes.com");
        style = new Style1();
    }

    @Override
    public List<IngredientGroup> parseIngredients() throws ParserFailedException {
        try {
            List<Element> ingredientList = style.getIngredientLists(doc, url);
            return style.parseIngredientGroups(ingredientList);
        } catch (ParserFailedException e) {
            //todo change style and try again
            style = new Style2();
            List<Element> ingredientList = style.getIngredientLists(doc, url);
            return style.parseIngredientGroups(ingredientList);
        }
    }



    @Override
    public Directions parseDirections() throws ParserFailedException{
        Directions d = null;
        try {
            d = style.getDirections(doc);
        } catch (ParserFailedException e) {
            style = new Style2();
            d = style.getDirections(doc);
        }
        return d;
    }
}
