package christmas.domain.menus;

import static org.assertj.core.api.Assertions.assertThat;

import christmas.domain.MenuCategory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DessertMenuTest {

    @Test
    @DisplayName("디저트 메뉴가 들어있는 MenuCategory 객체를 리턴한다.")
    void returnMenuCategory() {
        assertThat(DessertMenu.getMenuCategory()).isInstanceOf(MenuCategory.class);
    }

    @Test
    @DisplayName("디저트 메뉴가 들어있는 MenuCategory 객체를 리턴한다.")
    void returnMenuCategoryContains() {
        assertThat(DessertMenu.getMenuCategory().toString().contains("디저트")).isTrue();
    }
}