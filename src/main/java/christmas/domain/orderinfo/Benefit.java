package christmas.domain.orderinfo;

import java.util.ArrayList;
import java.util.List;

public class Benefit {
    private static final String NEW_LINE = "\n";
    private final List<String> ownBenefit = new ArrayList<>();

    public void addBenefit(String benefit) {
        ownBenefit.add(benefit);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        ownBenefit.forEach(benefits -> stringBuilder.append(benefits).append(NEW_LINE));
        return stringBuilder.toString();
    }
}
