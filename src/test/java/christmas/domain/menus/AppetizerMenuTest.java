package christmas.domain.menus;

import static org.assertj.core.api.Assertions.assertThat;

import christmas.domain.MenuCategory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class AppetizerMenuTest {

    @Test
    @DisplayName("애피타이저 메뉴가 들어있는 MenuCategory 객체를 리턴한다.")
    void returnMenuCategory() {
        assertThat(AppetizerMenu.getMenuCategory()).isInstanceOf(MenuCategory.class);
    }

    @Test
    @DisplayName("애피타이저 메뉴가 들어있는 MenuCategory 객체를 리턴한다.")
    void returnMenuCategoryContains() {
        assertThat(AppetizerMenu.getMenuCategory().toString().contains("애피타이저")).isTrue();
    }


}
