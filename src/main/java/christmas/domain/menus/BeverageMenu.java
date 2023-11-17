package christmas.domain.menus;

import christmas.domain.MenuCategory;
import java.util.HashMap;
import java.util.List;

public enum BeverageMenu {
    ZERO_COKE("제로콜라", 3_000),
    RED_WINE("레드와인", 60_000),
    CHAMPAGNE("샴페인", 25_000);

    private static final HashMap<String, Integer> categoryMenu = new HashMap<>();
    private static final String MENU_TYPE = "음료";
    private static  MenuCategory category;
    private final int price;
    private final String menuName;

    BeverageMenu(String menuName, int price) {
        this.menuName = menuName;
        this.price = price;
    }

    private static void setCategoryMenu() {
        List<BeverageMenu> menus = List.of(BeverageMenu.values());
        menus.forEach(menu -> categoryMenu.put(menu.menuName, menu.price));
        category = new MenuCategory(categoryMenu, MENU_TYPE);
    }

    public static MenuCategory getMenuCategory() {
        if (categoryMenu.isEmpty()) {
            setCategoryMenu();
        }
        return category;
    }
}