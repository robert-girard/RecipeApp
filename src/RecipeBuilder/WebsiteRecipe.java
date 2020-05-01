package RecipeBuilder;

import Parsers.AllRecipes.AllReceipeParser;
import Parsers.Exceptions.IncorrectParserException;
import Parsers.Exceptions.ParserFailedException;
import Parsers.Parser;
import Parsers.SupportedWebsites;
import Recipe.Directions;
import Recipe.IngredientGroup;

import java.io.IOException;
import java.util.List;

public class WebsiteRecipe implements RecipeSource {
    String url;
    Parser parser;

    public WebsiteRecipe(String url) {
        this.url = url;
        SupportedWebsites website = SupportedWebsites.ifContains(url);

        switch (website) {
            case ALLRECIPES:
                try {
                    parser = new AllReceipeParser(url);
                    break;
                } catch (IOException e) {
                    e.printStackTrace();
                    break;
                } catch (IncorrectParserException e) {
                    //let it go to the default case and try the generic parser
                }
            default:
                ////todo if it is null use the tbd generic parser
        }

    }

    @Override
    public List<IngredientGroup> getIngredientGroups() {
        List<IngredientGroup> ig = null;
        try {
            ig = parser.parseIngredients();
        } catch (ParserFailedException e) {
            //TODO change to generic parser and try again
        }

        return ig;
    }

    @Override
    public Directions getDirections() {
        Directions d = null;
        try {
            d = parser.parseDirections();
        } catch (ParserFailedException e) {
            //TODO change to generic parser and try again
        }

        return d;
    }
}
