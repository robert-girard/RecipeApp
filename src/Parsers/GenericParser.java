package Parsers;

import Recipe.Directions;
import Recipe.Ingredient;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.List;

abstract public class GenericParser {
    Document doc;

    public GenericParser(String url) throws IOException {
        this.doc = Jsoup.connect(url).get();
    }

    public abstract List<Ingredient> parseIngredients();

    public abstract Directions parseDirections();

    public Ingredient parseUnits(String measurement) {
        return new Ingredient("Ingredient", 5,"Unit");
    }




}
