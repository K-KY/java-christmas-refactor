package christmas.domain.discounter;

import christmas.domain.orderinfo.Benefit;
import christmas.domain.orderinfo.Date;
import christmas.domain.orderinfo.OrderedAmount;
import christmas.domain.week.Week;
import java.text.DecimalFormat;

public class SpecialDiscounter {
    private static final String PRICE_FORMAT = "-###,###원";
    private static final DecimalFormat MONEY_FORMAT = new DecimalFormat(PRICE_FORMAT);
    private static final String SPECIAL_DISCOUNT = "특별 할인: ";
    private static final int DISCOUNT = 1000;
    private static final int DEFAULT = 0;
    private static final boolean conditionally = true; // true 일 때 총 금액이 만원 이상
    private final OrderedAmount orderedAmount;

    public SpecialDiscounter(OrderedAmount orderedAmount) {
        this.orderedAmount = orderedAmount;
    }

    public int discount(Date date, Benefit benefit) {
        if (sundayOrDay(date) && !conditionally) {
            benefit.addBenefit(SPECIAL_DISCOUNT + MONEY_FORMAT.format(DISCOUNT));
            return DISCOUNT;
        }
        if (sundayOrDay(date) && orderedAmount.isOverTenThousand()) {
            benefit.addBenefit(SPECIAL_DISCOUNT + MONEY_FORMAT.format(DISCOUNT));
            return DISCOUNT;
        }
        return DEFAULT;
    }

    public static boolean sundayOrDay(Date date) {
        return Week.isStared(date);
    }
}
