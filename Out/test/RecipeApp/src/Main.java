import Database.Connect;
import Parsers.Metric;
import Parsers.Units;

public class Main {
    public static void main(String[] args) {
        /*try {
            Connect.connect();
        } catch (Exception e) {
            e.printStackTrace();
        }*/


        System.out.println(Units.getAllUnitsRegex());
        System.out.println(Units.LITRE.getUnitRegex());
        System.out.println(Metric.MILLI.getPrefixRegex());
        System.out.println(Metric.getAllPrefixRegex());
    }
}
