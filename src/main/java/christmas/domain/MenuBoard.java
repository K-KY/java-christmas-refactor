package christmas.domain;

import christmas.domain.menus.AppetizerMenu;
import christmas.domain.menus.BeverageMenu;
import christmas.domain.menus.DessertMenu;
import christmas.domain.menus.MainMenu;
import java.util.ArrayList;
import java.util.List;

public class MenuBoard {
    private static final List<MenuCategory> menuCategories = new ArrayList<>();
    private static final String NEW_LINE = "\n";
    private static final int DEFAULT = 0;

    public MenuBoard() {
        if (menuCategories.isEmpty()) {
            loadMenuCategory();
        }
    }

    private void loadMenuCategory() {
        menuCategories.add(AppetizerMenu.getMenuCategory());
        menuCategories.add(MainMenu.getMenuCategory());
        menuCategories.add(DessertMenu.getMenuCategory());
        menuCategories.add(BeverageMenu.getMenuCategory());
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        menuCategories.forEach(category -> stringBuilder
                .append(category.toString())
                .append(NEW_LINE));
        return stringBuilder.toString();
    }

    public boolean find(String order) {
        return menuCategories.stream()
                .map(menuCategory -> menuCategory.isExist(order))
                .filter(result -> result)
                .findFirst().orElse(false);
    }

    public int findPrice(String menuName) {
        return menuCategories.stream()
                .map(menuCategory -> menuCategory.findPrice(menuName))
                .filter(result -> result != DEFAULT)
                .findFirst().orElse(DEFAULT);
    }
}
