package christmas.domain.discounter;

import christmas.domain.orderinfo.Benefit;
import christmas.domain.Menu;
import christmas.domain.MenuCategory;
import christmas.domain.orderinfo.UserOrder;
import christmas.domain.menus.MainMenu;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class WeekendDiscounter {
    private static final String PRICE_FORMAT = "-###,###원";
    private static final DecimalFormat MONEY_FORMAT = new DecimalFormat(PRICE_FORMAT);
    public static final MenuCategory mainCategory = MainMenu.getMenuCategory();
    private static final String WEEKEND_DISCOUNT = "주말 할인: ";
    private static final int DISCOUNT = 2023;

    public int discount(UserOrder userOrder, Benefit benefit) {
        List<Menu> orders = userOrder.orders;
        long mainCount = mainCount(orders);
        if (mainCount == 0) {
            return 0;
        }
        benefit.addBenefit(WEEKEND_DISCOUNT + MONEY_FORMAT.format(DISCOUNT * mainCount));
        return (int) mainCount * DISCOUNT;
    }

    private static long mainCount(List<Menu> orders) {
        List<Integer> amount = new ArrayList<>();
        orders.stream()
                .filter(order -> order.isMain(mainCategory))
                .forEach(menu -> menu.addAmount(amount));
        return amount.stream().mapToInt(Integer::intValue).sum();
    }
}
