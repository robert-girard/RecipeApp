package Parsers;

import Parsers.Exceptions.ParserFailedException;
import Recipe.IngredientGroup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.util.List;

public interface Styles {
    public List<Element> getIngredientLists(Document doc, String url) throws ParserFailedException;
    public List<IngredientGroup> parseIngredientGroups (List<Element> ingredientList);
    public List<String> getDirections(Document doc) throws ParserFailedException;
}
