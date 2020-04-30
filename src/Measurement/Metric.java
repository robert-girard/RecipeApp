package Measurement;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public enum Metric {
    MILLI("m", "milli"),
    KILO("k", "kilo");

    private double multiplier;
    private final List<String> prefixNames;
    private static final Map<String, Metric> lookup = new HashMap<>();

    //Populate the lookup table on loading time
    static
    {
        for(Metric m : Metric.values())
        {
            for (String prefix : m.getPrefixes())
                lookup.put(prefix, m);
        }
    }

    private List<String> getPrefixes() {
        return prefixNames;
    }

    private static Metric get(String url)
    {
        return lookup.get(url);
    }


    Metric(String... prefix){
        this.prefixNames = Arrays.asList(prefix);
    }

    public double getMultiplyer() {
        for (String s : this.prefixNames) {
            switch (Metric.get(s)) {
                case KILO:
                    this.multiplier = 10;
                    break;
                case MILLI:
                    this.multiplier = 0.1;
                    break;
            }
        }
        return this.multiplier;
    }

    public static String getAllPrefixRegex() {
        String all = "";
        for (Metric u : Metric.values()) {
            all += String.join("|", u.getPrefixes()) + "|";
        }

        if (all.length() >=1) {
            all = all.substring(0,all.length()-1);
        }
        return all;
    }

    public String getPrefixRegex() {
        return String.join("|", this.prefixNames);
    }
}


