package Measurement;

import java.util.Arrays;
import java.util.List;

public enum Units {
    CUP("cup"),
    GRAM("gram", "kg"),
    LITRE("L", "litre", "liter"),
    OUNCE("ounce", "oz"),
    PINT("pint"),
    POUND("pound", "lb"),
    STICK("stick"),
    PINCH("pinch"),
    TABLESPOON("tbsp", "tablespoon"),
    TEASPOON("tbs", "teaspoon");

    private final List<String> units;

    Units(String... unit) {
        this.units = Arrays.asList(unit);
    }

    public List<String> getUnits() {
        return this.units;
    }

    public static String getAllUnitsRegex() {
        String all = "";
        for (Units u : Units.values()) {
            all += String.join("|", u.getUnits()) + "|";
        }

        if (all.length() >=1) {
            all = all.substring(0,all.length()-1);
        }
        return all;
    }

    public String getUnitRegex() {
        return String.join("|", getUnits());
    }
}
