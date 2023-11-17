package christmas.domain.menus;

import christmas.domain.MenuCategory;
import java.util.HashMap;
import java.util.List;

public enum AppetizerMenu {
    MUSHROOM_SOUP("양송이수프", 6_000),
    TAPAS("타파스", 5_500),
    CAESAR_SALAD("시저샐러드", 8_000);


    private static final String MENU_TYPE = "애피타이저";
    private static final HashMap<String, Integer> categoryMenu = new HashMap<>();
    private final String menuName;
    private final int price;

    AppetizerMenu(String menuName, int price) {
        this.menuName = menuName;
        this.price = price;
    }

    private static void setMenuCategory() {
        List<AppetizerMenu> menus = List.of(AppetizerMenu.values());
        menus.forEach(menu -> categoryMenu.put(menu.menuName, menu.price));
    }

    public static MenuCategory getMenuCategory() {
        if (categoryMenu.isEmpty()) {
            setMenuCategory();
        }
        return new MenuCategory(categoryMenu, MENU_TYPE);
    }
}
