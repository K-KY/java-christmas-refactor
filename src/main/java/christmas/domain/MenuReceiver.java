package christmas.domain;

import christmas.domain.orderinfo.UserOrder;
import christmas.domain.validator.OrderValidator;
import java.util.ArrayList;
import java.util.List;

public class MenuReceiver {
    private static final String DIVIDER = "-";
    private static final int MENU_INDEX = 0;
    private static final int AMOUNT_INDEX = 1;
    private final List<String> orders;

    public MenuReceiver(List<String> orders) {
        this.orders = orders;
    }

    public UserOrder receive() {
        List<Menu> menus = new ArrayList<>();
        orders.forEach(order -> {
            menus.add(order(order));
        });
        return new UserOrder(menus);
    }

    private int amountConverter(String amount) {
        OrderValidator.isValidAmount(amount);
        return Integer.parseInt(amount);
    }

    private Menu order(String order) {
        List<String> userOrder = List.of(order.split(DIVIDER));
        OrderValidator.menuForm(userOrder);
        return new Menu(userOrder.get(MENU_INDEX), amountConverter(userOrder.get(AMOUNT_INDEX)));
    }
}
