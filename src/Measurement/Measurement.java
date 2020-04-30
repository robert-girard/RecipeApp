package Measurement;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Measurement {
    String unit;
    String pattern;
    Pattern p;
    Matcher m;

    public Measurement() {
        unit = "(" + Metric.getAllPrefixRegex() + ")?(" + Units.getAllUnitsRegex() + ")?";
        pattern = "((\\d+[\\.\\/]?\\d*)|([\\u00BC-\\u00BE\\u2150-\\u215E])) ?" + unit + "(.+)";
        p = Pattern.compile(pattern);
    }

    public List<String> splitMeasurement(String ingredientString) {
        List<String> ingredientSeparated = new ArrayList<>();
        m = p.matcher(ingredientString);


        return ingredientSeparated;
    }
}


