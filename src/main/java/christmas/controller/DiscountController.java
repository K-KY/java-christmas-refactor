package christmas.controller;

import christmas.domain.orderinfo.Benefit;
import christmas.domain.orderinfo.Date;
import christmas.domain.orderinfo.OrderedAmount;
import christmas.domain.orderinfo.UserOrder;
import christmas.domain.discounter.ChristmasDiscounter;
import christmas.domain.discounter.SpecialDiscounter;
import christmas.domain.discounter.WeekDayDiscounter;
import christmas.domain.discounter.WeekendDiscounter;

public class DiscountController {

    private static final int ZERO = 0;
    private final OrderedAmount orderedAmount;
    private final Benefit benefit = new Benefit();

    public DiscountController(OrderedAmount orderedAmount) {
        this.orderedAmount = orderedAmount;
    }

    public Benefit calculateDiscount(Date date, UserOrder userOrder) {
        boolean weekend = date.isWeekend();
        orderedAmount.discount(
                weekDiscount(userOrder, weekend)
                        + specialDiscount(date)
                        + christmasDiscount(date));
        return benefit;
    }

    private int weekDiscount(UserOrder userOrder, boolean weekend) {
        if (orderedAmount.isOverTenThousand()) {
            return weekendDiscount(weekend, userOrder);
        }
        return ZERO;
    }

    private int weekendDiscount(boolean weekend, UserOrder userOrder) {
        if (weekend) {
            WeekendDiscounter weekendDiscounter = new WeekendDiscounter();
            return weekendDiscounter.discount(userOrder, benefit);
        }
        return weekDayDiscount(userOrder);
    }

    private int weekDayDiscount(UserOrder userOrder) {
        WeekDayDiscounter weekDayDiscounter = new WeekDayDiscounter();
        return weekDayDiscounter.discount(userOrder, benefit);
    }

    private int specialDiscount(Date date) {
        SpecialDiscounter specialDiscounter = new SpecialDiscounter(orderedAmount);
        return specialDiscounter.discount(date, benefit);
    }

    private int christmasDiscount(Date date) {
        ChristmasDiscounter christmasDiscounter = new ChristmasDiscounter(orderedAmount);
        return christmasDiscounter.discount(date, benefit);
    }
}
