package RecipeBuilder;

import Parsers.AllRecipes.AllReceipeParser;
import Parsers.Exceptions.IncorrectParserException;
import Parsers.Exceptions.ParserFailedException;
import Parsers.Parser;
import Parsers.SupportedWebsites;

import Recipe.Directions;
import Recipe.IngredientGroup;
import Recipe.Recipe;
import Recipe.RecipeCreationException;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

public class WebsiteSource implements RecipeSource { //todo This should be turned into a builder where it returns the recipe after it used the parser to get the infor
    String url;
    Parser parser;

    public WebsiteSource(String url) {
        this.url = url;
        SupportedWebsites website = SupportedWebsites.ifContains(url);

        switch (website) {
            case ALLRECIPES:
                try {
                    parser = new AllReceipeParser(url);
                    break;
                } catch (IOException e) {
                    System.err.println("Problem connecting to website");
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
    public Recipe getRecipe() throws RecipeCreationException {
        List<IngredientGroup> ig = null;
        Directions d = null;
        String title = null;

        try {                                               //critical parameters for recipe
            ig = parser.parseIngredients();
            d = parser.parseDirections();
            title = parser.parseTitle();
        } catch (ParserFailedException e) {
            throw new RecipeCreationException(e.getMessage());//todo try a generic parser first
        }

        Duration dur = null;
        try {
            dur = parser.parseTime();
        } catch (ParserFailedException e) {
            // not critcal but maybe try generic parser instead?
        }

        Recipe recipe = new Recipe(title, d, ig);

        recipe.setPrepTime(dur);

        return recipe;
    }
}
