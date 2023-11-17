package christmas.domain;

import static org.assertj.core.api.Assertions.assertThat;

import christmas.domain.MenuCategory;
import christmas.domain.menus.AppetizerMenu;
import christmas.domain.menus.BeverageMenu;
import christmas.domain.menus.DessertMenu;
import christmas.domain.menus.MainMenu;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MenuCategoryTest {

    @Test
    @DisplayName("애피타이저 메뉴를 MenuBoard 클래스에 넣어 리턴한다")
    void menuBoardTest_APPETIZER() {
        assertThat(AppetizerMenu.getMenuCategory())
                .isInstanceOf(MenuCategory.class);
    }

    @Test
    @DisplayName("음료 메뉴를 MenuBoard 클래스에 넣어 리턴한다")
    void menuBoardTest_BEVERAGE() {
        assertThat(BeverageMenu.getMenuCategory())
                .isInstanceOf(MenuCategory.class);
    }

    @Test
    @DisplayName("메인메뉴를 MenuBoard 클래스에 넣어 리턴한다")
    void menuBoardTest_MAIN() {
        assertThat(MainMenu.getMenuCategory())
                .isInstanceOf(MenuCategory.class);
    }

    @Test
    @DisplayName("디저트메뉴를 MenuBoard 클래스에 넣어 리턴한다")
    void menuBoardTest_DESSERT() {
        assertThat(DessertMenu.getMenuCategory())
                .isInstanceOf(MenuCategory.class);
    }

    @Test
    @DisplayName("메인 메뉴를 리턴한다")
    void printMainMenuTest() {
        System.out.println(MainMenu.getMenuCategory());
        assertThat(MainMenu.getMenuCategory().toString())
                .isEqualTo("<메인>\n"
                        + "티본스테이크(55,000), 해산물파스타(35,000), 크리스마스파스타(25,000), 바비큐립(54,000)");
    }

    @Test
    @DisplayName("애피타이저 메뉴를 리턴한다")
    void printAppetizerMenuTest() {
        System.out.println(AppetizerMenu.getMenuCategory());
        assertThat(AppetizerMenu.getMenuCategory().toString())
                .isEqualTo("<애피타이저>\n"
                        + "타파스(5,500), 양송이수프(6,000), 시저샐러드(8,000)");
    }

    @Test
    @DisplayName("음료 메뉴를 리턴한다")
    void printBeverageMenuTest() {
        System.out.println(BeverageMenu.getMenuCategory());
        assertThat(BeverageMenu.getMenuCategory().toString())
                .isEqualTo("<음료>\n"
                        + "제로콜라(3,000), 샴페인(25,000), 레드와인(60,000)");
    }

    @Test
    @DisplayName("디저트 메뉴를 리턴한다")
    void printDessertMenuTest() {
        System.out.println(DessertMenu.getMenuCategory());
        assertThat(DessertMenu.getMenuCategory().toString())
                .isEqualTo("<디저트>\n"
                        + "아이스크림(5,000), 초코케이크(15,000)");
    }
}
