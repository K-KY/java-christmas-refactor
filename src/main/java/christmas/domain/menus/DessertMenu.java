package christmas.domain.menus;

import christmas.domain.MenuCategory;
import java.util.HashMap;
import java.util.List;

public enum DessertMenu {
    CHOCOLATE_CAKE("초코케이크", 15_000),
    ICE_CREAM("아이스크림", 5_000);

    private static final HashMap<String, Integer> categoryMenu = new HashMap<>();
    private static final String MENU_TYPE = "디저트";
    private final String menuName;
    private final int price;

    DessertMenu(String menuName, int price) {
        this.menuName = menuName;
        this.price = price;
    }

    private static void setCategoryMenu() {
        List<DessertMenu> menus = List.of(DessertMenu.values());
        menus.forEach(menu -> DessertMenu.categoryMenu.put(menu.menuName, menu.price));
    }

    public static MenuCategory getMenuCategory() {
        if (categoryMenu.isEmpty()) {
            setCategoryMenu();
        }
        return new MenuCategory(categoryMenu, MENU_TYPE);
    }
}
