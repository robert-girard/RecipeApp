package Parsers.AllRecipes;

import Parsers.Exceptions.ParserFailedException;
import Parsers.Styles;
import Recipe.Directions;
import Recipe.IngredientGroup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Style2 implements Styles {

    public List<Element> getIngredientLists(Document doc, String url) throws ParserFailedException {
        List<Element> ingredientLists = new ArrayList<>(); //super.doc.select("ul[id^=]");
        int count = 1;
        Elements e = doc.select("fieldset[class=ingredients-section__fieldset]");
        if (e == null) {
            throw new ParserFailedException("No Ingredient Lists Found on webpage: " + url);
        }
        return e;
    }

    public List<IngredientGroup> parseIngredientGroups (List<Element> ingredientList) {
        List<IngredientGroup> ingredientGroups = new ArrayList<>();
        String groupTitle = "";
        List<String> ingredients = new ArrayList<>();

        for (Element lst: ingredientList) {
            groupTitle = lst.select("legend").text();
            for (Element item: lst.select("li")) {
                ingredients.add(item.text());
            }
            ingredientGroups.add(new IngredientGroup(groupTitle, ingredients));
            groupTitle = "";
            ingredients.clear();
        }
        return ingredientGroups; //todo make this the actual list
    }

    public Directions getDirections(Document doc) throws ParserFailedException {
        List<String> sInstuctions = new ArrayList<String>();
        Elements instructions = doc.select("ul[class=instructions-section]");
        if (instructions.size() !=1) {
            throw new ParserFailedException("0 or more than one instructions sections");
        }
        for (Element instruction : instructions.first().select("li")) {
            Elements body = instruction.select("div.section-body");
            if (body.size() !=1) {
                throw new ParserFailedException("0 or more than one instruction bodies");
            }
            sInstuctions.add(body.text());
        }
        return new Directions(sInstuctions);
    }

    public String getTitle(Document doc) throws ParserFailedException {
        Elements heading = doc.select("h1.heading-content");
        if (heading.size() != 1) {
            throw new ParserFailedException("0 or more than 1 headings.");
        }
        return heading.text();
    }

    public Duration getTime(Document doc) throws ParserFailedException {
        String rawsTime = "";
        Elements span = doc.select("span.ready-in-time");

        if (span.size() != 1) {
            throw new ParserFailedException("0 or more than 1 times found");
        }

        String pattern = "((\\d+) (h ?)|((\\d+) m ?))+";
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(rawsTime);

        int mins = 0, hours = 0;
        String sMins = m.group(4);
        String sHours = m.group(1);

        if (sMins == null && sHours == null) {
            throw new ParserFailedException("Could not parse prep time");
        }

        if (sMins != null) {
            mins = Integer.parseInt(sMins);
        }
        if (sHours != null) {
            hours = Integer.parseInt(sHours);
        }

        Duration dur = Duration.ofMinutes(60*hours + mins);

        return dur;
    }

}
