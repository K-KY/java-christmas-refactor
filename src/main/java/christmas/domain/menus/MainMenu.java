package christmas.domain.menus;

import christmas.domain.MenuCategory;
import java.util.HashMap;
import java.util.List;

public enum MainMenu {
    T_BONE_STAKE("티본스테이크", 55_000),
    BARBEQUE_RIP("바비큐립", 54_000),
    SEA_FOOD_PASTA("해산물파스타", 35_000),
    CHRISTMAS_PASTA("크리스마스파스타", 25_000);

    private final static HashMap<String, Integer> categoryMenu = new HashMap<>();
    private static final String MENU_TYPE = "메인";
    private final String menuName;
    private final int price;

    MainMenu(String menuName, int price) {
        this.menuName = menuName;
        this.price = price;
    }

    private static void setCategoryMenu() {
        List<MainMenu> menus = List.of(MainMenu.values());
        menus.forEach(menu -> MainMenu.categoryMenu.put(menu.menuName, menu.price));
    }

    public static MenuCategory getMenuCategory() {
        if (categoryMenu.isEmpty()) {
            setCategoryMenu();
        }
        return new MenuCategory(categoryMenu, MENU_TYPE);
    }
}
