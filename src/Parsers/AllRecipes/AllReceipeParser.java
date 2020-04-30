package Parsers.AllRecipes;

import Parsers.GenericParser;
import Parsers.Exceptions.IncorrectParserException;
import Parsers.Exceptions.ParserFailedException;
import Parsers.Styles;
import Recipe.Directions;
import Recipe.Ingredient;
import org.jsoup.nodes.Element;

import java.io.IOException;

import java.util.List;

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
    public Directions parseDirections() throws ParserFailedException{
        List<String> steps = style.getDirections(doc);
        return new Directions(steps);
    }
}
