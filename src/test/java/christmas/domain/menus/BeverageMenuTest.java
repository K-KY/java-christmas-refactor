package christmas.domain.menus;

import static org.assertj.core.api.Assertions.assertThat;

import christmas.domain.MenuCategory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BeverageMenuTest {

    @Test
    @DisplayName("음료 메뉴가 들어있는 MenuCategory 객체를 리턴한다.")
    void returnMenuCategory() {
        assertThat(BeverageMenu.getMenuCategory()).isInstanceOf(MenuCategory.class);
    }

    @Test
    @DisplayName("음료 메뉴가 들어있는 MenuCategory 객체를 리턴한다.")
    void returnMenuCategoryContains() {
        assertThat(BeverageMenu.getMenuCategory().toString().contains("음료")).isTrue();
    }
}