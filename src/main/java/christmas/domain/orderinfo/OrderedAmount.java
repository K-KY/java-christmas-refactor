package christmas.domain.orderinfo;

import christmas.domain.ChristmasBadge;
import java.text.DecimalFormat;

public class OrderedAmount {
    private static final String PRICE_FORMAT = "###,###원";
    private static final DecimalFormat MONEY_FORMAT = new DecimalFormat(PRICE_FORMAT);
    private static final int EVENT_CONDITION = 10000;
    private static final int PRESENT_CONDITION = 120000;

    private int totalAmount = 0;
    private int totalDiscount = 0;


    public boolean isOverTenThousand() {
        return totalAmount >= EVENT_CONDITION;
    }

    public boolean present() {
        return totalAmount >= PRESENT_CONDITION;
    }

    public void addTotalAmount(int amount) {
        totalAmount += amount;
    }
    public void discount(long discount) {
        totalDiscount -= discount;
    }

    public String totalAmount() {
        return MONEY_FORMAT.format(totalAmount);
    }

    public String totalDiscount() {
        return MONEY_FORMAT.format(totalDiscount);
    }

    public String afterDiscount() {
        return MONEY_FORMAT.format(totalAmount + totalDiscount);
    }

    public ChristmasBadge getBadge() {
        if (totalAmount < EVENT_CONDITION) {
            return ChristmasBadge.NO_BADGE;
        }
        return ChristmasBadge.getBadge(totalAmount);
    }
}
