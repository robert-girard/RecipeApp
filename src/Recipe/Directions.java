package Recipe;

import java.util.List;

public class Directions {
    protected List<String> steps;

    public Directions(List<String> steps) {
        this.steps = steps;
    }

    @Override
    public String toString() {
        String str = "Directions:\n";
        for (String step: steps) {
            str += step + "\n";
        }
        return str;
    }
}
