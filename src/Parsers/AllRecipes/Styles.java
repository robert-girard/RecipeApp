package Parsers.AllRecipes;

import Parsers.ParserFailedException;
import Recipe.IngredientGroup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.util.List;

public interface Styles {
    public List<Element> getIngredientLists(Document doc, String url) throws ParserFailedException;
    public List<IngredientGroup> parseIngredientGroups (List<Element> ingredientList);
}
