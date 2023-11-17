package christmas.domain.orderinfo;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import christmas.domain.Menu;
import java.util.List;
import org.junit.jupiter.api.Test;

public class UserOrderTest {

    @Test
    void userOrderAmount() {
        Menu menu = new Menu("아이스크림", 10);
        assertThatCode(() -> new UserOrder(List.of(menu)))
                .doesNotThrowAnyException();
    }

    @Test
    void userOrderBigAmount() {
        Menu menu = new Menu("아이스크림", 19);
        Menu menu2 = new Menu("초코케이크", 19);
        assertThatThrownBy(() -> new UserOrder(List.of(menu, menu2)))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @Test
    void userOrderOnlyBeverage() {
        Menu menu = new Menu("제로콜라", 19);
        assertThatThrownBy(() -> new UserOrder(List.of(menu)))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
