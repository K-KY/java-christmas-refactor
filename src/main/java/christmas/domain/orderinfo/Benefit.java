package christmas.domain.orderinfo;

import java.util.ArrayList;
import java.util.List;

public class Benefit {
    private static final String NEW_LINE = "\n";
    private static final String PRESENT_HISTORY = "증정 이벤트: -25,000원";
    private static final String NO_PRESENT = "없음";
    private static final String PRESENT = "샴페인 1개";
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

    public String present() {
        if (ownBenefit.contains(PRESENT_HISTORY)) {
            return PRESENT;
        }
        return NO_PRESENT;
    }
}
