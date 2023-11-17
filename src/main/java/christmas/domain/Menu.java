package christmas.domain;

import christmas.domain.validator.OrderValidator;
import java.util.List;

public class Menu {
    private static final String SPACE = " ";
    private static final String MENU_AMOUNT = "개";
    private static final String NEW_LINE = "\n";
    private final String menuName;
    private final int amount;

    public Menu(String menuName, int amount) {
        OrderValidator.isExist(menuName);
        OrderValidator.isAmountInRange(amount);

        this.menuName = menuName;
        this.amount = amount;
    }

    public int getPrice() {
        return menuPrice() * amount;
    }

    public void addAmount(List<Integer> amounts) {
        amounts.add(amount);
    }

    public boolean isBeverage(MenuCategory beverageCategory) {
        return beverageCategory.isExist(menuName);
    }

    private int menuPrice() {
        return new MenuBoard().findPrice(menuName);
    }

    public boolean isDessert(MenuCategory dessertCategory) {
        return dessertCategory.isExist(menuName);
    }

    public boolean isMain(MenuCategory mainCategory) {
        return mainCategory.isExist(menuName);
    }

    @Override
    public String toString() {
        return menuName + SPACE + amount + MENU_AMOUNT + NEW_LINE;
    }
}
