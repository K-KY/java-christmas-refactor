package christmas.domain;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import christmas.domain.Menu;
import org.junit.jupiter.api.Test;

public class MenuTest {

    @Test
    void notExistMenu() {
        assertThatThrownBy(() -> new Menu("고등어", 1))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void existMenu() {
        assertThatCode(() -> new Menu("아이스크림", 1))
                .doesNotThrowAnyException();
    }

    @Test
    void bigAmount() {
        assertThatThrownBy(() -> new Menu("아이스크림", 99))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
