package christmas.domain.orderinfo;

import christmas.domain.Menu;
import christmas.domain.MenuCategory;
import christmas.domain.menus.BeverageMenu;
import christmas.domain.validator.OrderValidator;
import java.util.ArrayList;
import java.util.List;

public class UserOrder {
    public final List<Menu> orders;

    public UserOrder(List<Menu> orders) {
        this.orders = orders;
        OrderValidator.isAmountInRange(checkAmount());
        OrderValidator.isOnlyBeverage(onlyBeverage());
    }

    public void addMenuPrice(OrderedAmount orderedAmount) {
        orders.forEach(order -> orderedAmount.addTotalAmount(order.getPrice()));
    }

    private int checkAmount() {
        List<Integer> amounts = new ArrayList<>();
        orders.forEach(menu -> menu.addAmount(amounts));

        return amounts.stream().mapToInt(Integer::intValue).sum();
    }


    private boolean onlyBeverage() {
        MenuCategory beverageCategory = BeverageMenu.getMenuCategory();

        return orders.stream().
                map(order -> order.isBeverage(beverageCategory))
                .filter(result -> !result)
                .findFirst().orElse(true);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        orders.forEach(order -> stringBuilder.append(order.toString()));
        return stringBuilder.toString();
    }
}
