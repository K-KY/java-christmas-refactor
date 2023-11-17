package christmas.domain.menus;

import static org.assertj.core.api.Assertions.assertThat;

import christmas.domain.MenuCategory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MainMenuTest {

    @Test
    @DisplayName("메인 메뉴가 들어있는 MenuCategory 객체를 리턴한다.")
    void returnMenuCategory() {
        assertThat(MainMenu.getMenuCategory()).isInstanceOf(MenuCategory.class);
    }

    @Test
    @DisplayName("메인 메뉴가 들어있는 MenuCategory 객체를 리턴한다.")
    void returnMenuCategoryContains() {
        assertThat(MainMenu.getMenuCategory().toString().contains("메인")).isTrue();
    }
}