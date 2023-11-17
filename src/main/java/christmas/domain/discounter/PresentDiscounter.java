package christmas.domain.discounter;

import christmas.domain.orderinfo.Benefit;
import christmas.domain.orderinfo.OrderedAmount;
import java.text.DecimalFormat;

public class PresentDiscounter {
    private static final String PRICE_FORMAT = "-###,###원";
    private static final DecimalFormat MONEY_FORMAT = new DecimalFormat(PRICE_FORMAT);
    private static final int DISCOUNT = 25000;
    private static final int NO_DISCOUNT = 0;
    private final OrderedAmount orderedAmount;

    public PresentDiscounter(OrderedAmount orderedAmount) {
        this.orderedAmount = orderedAmount;
    }

    public int discount(Benefit benefit) {
        if (orderedAmount.present()) {
            benefit.addBenefit("증정 이벤트: " + MONEY_FORMAT.format(DISCOUNT));
            return DISCOUNT;
        }
        return NO_DISCOUNT;
    }
}
