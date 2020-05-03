package Parsers;

import Parsers.Exceptions.IncorrectParserException;
import Parsers.Exceptions.ParserFailedException;
import Recipe.Directions;
import Recipe.Ingredient;

import Recipe.IngredientGroup;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

abstract public class Parser {
    protected Document doc;
    protected String url;

    public Parser(String url, String parserDomain) throws IOException, IncorrectParserException {
        this.url = url;
        this.doc = Jsoup.connect(url).get();
        if (!url.contains(parserDomain)) {
            String pattern = "(https\\:\\/\\/)?(www\\.)?(.*?\\.[\\w]{2,3}).*$";
            Pattern r = Pattern.compile(pattern);
            Matcher m = r.matcher(url);
            String domain = "";

            if (m.find()) {
                domain = m.group(2);
            } else {
                domain = "Couldn't find Domain";
            }
            throw new IncorrectParserException("Parser handles allrecipes.com parsing. Domain input: " + domain);
        }
    }

    public Parser(String url) throws IOException{
        this.doc = Jsoup.connect(url).get();
    }

    public abstract List<IngredientGroup> parseIngredients() throws ParserFailedException;

    public abstract Directions parseDirections() throws ParserFailedException;

    public abstract String parseTitle() throws ParserFailedException;

    public abstract Duration parseTime() throws ParserFailedException;

    public Ingredient parseUnits(String measurement) {
        return new Ingredient("Ingredient", 5,"Unit");
    }




}
