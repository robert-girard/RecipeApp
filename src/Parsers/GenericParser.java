package Parsers;

import Recipe.Directions;
import Recipe.Ingredient;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

abstract public class GenericParser {
    protected Document doc;
    protected String url;

    public GenericParser(String url, String parserDomain) throws IOException, IncorrectParserException {
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

    public GenericParser(String url) throws IOException{
        this.doc = Jsoup.connect(url).get();
    }

    public abstract List<Ingredient> parseIngredients() throws ParserFailedException;

    public abstract Directions parseDirections() throws ParserFailedException;

    public Ingredient parseUnits(String measurement) {
        return new Ingredient("Ingredient", 5,"Unit");
    }




}
