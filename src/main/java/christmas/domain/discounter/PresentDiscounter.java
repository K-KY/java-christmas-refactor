package christmas.domain.discounter;

import christmas.domain.orderinfo.OrderedAmount;

public class PresentDiscounter {
    private static final String PRESENT = "샴페인 1개";
    private static final String DEFAULT = "";
    private static final int DISCOUNT = 25000;
    private final OrderedAmount orderedAmount;

    public PresentDiscounter(OrderedAmount orderedAmount) {
        this.orderedAmount = orderedAmount;
    }

    public String discount() {
        if (orderedAmount.present()) {
            orderedAmount.discount(DISCOUNT);
            return PRESENT;
        }
        return DEFAULT;
    }
}
