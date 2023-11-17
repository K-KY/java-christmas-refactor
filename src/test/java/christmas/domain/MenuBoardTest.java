package christmas.domain;

import static org.assertj.core.api.Assertions.assertThat;

import christmas.domain.MenuBoard;
import org.junit.jupiter.api.Test;

public class MenuBoardTest {

    @Test
    void menuBoardToString() {
        MenuBoard menuBoard = new MenuBoard();
        assertThat(menuBoard.toString())
                .contains("<애피타이저>")
                .contains("<메인>")
                .contains("<디저트>")
                .contains("<음료>");

    }
}
