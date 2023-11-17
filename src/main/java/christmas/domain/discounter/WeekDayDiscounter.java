package christmas.domain.discounter;

import christmas.domain.orderinfo.Benefit;
import christmas.domain.Menu;
import christmas.domain.MenuCategory;
import christmas.domain.orderinfo.UserOrder;
import christmas.domain.menus.DessertMenu;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class WeekDayDiscounter {
    private static final String PRICE_FORMAT = "-###,###원";
    private static final DecimalFormat MONEY_FORMAT = new DecimalFormat(PRICE_FORMAT);
    private static final MenuCategory dessertCategory = DessertMenu.getMenuCategory();
    private static final String WEEK_DAY_DISCOUNT = "평일 할인: ";
    private static final int DISCOUNT = 2023;

    public int discount(UserOrder userOrder, Benefit benefit) {
        List<Menu> orders = userOrder.orders;
        long dessertCount = dessertCount(orders);
        if (dessertCount == 0) {
            return 0;
        }
        benefit.addBenefit(WEEK_DAY_DISCOUNT + MONEY_FORMAT.format(DISCOUNT * dessertCount));
        return (int) dessertCount * DISCOUNT;
    }

    private static long dessertCount(List<Menu> orders) {
        List<Integer> amount = new ArrayList<>();
        orders.stream()
                .filter(order -> order.isDessert(dessertCategory))
                .forEach(menu -> menu.addAmount(amount));
        return amount.stream().mapToInt(Integer::intValue).sum();
    }

}
