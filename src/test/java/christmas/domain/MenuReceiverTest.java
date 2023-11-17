package christmas.domain;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import christmas.domain.MenuReceiver;
import java.util.List;
import org.junit.jupiter.api.Test;

public class MenuReceiverTest {

    @Test
    void normalCase() {
        List<String> orders = List.of("티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1".split(","));
        MenuReceiver menuReceiver = new MenuReceiver(orders);
        assertThatCode(menuReceiver::receive)
                .doesNotThrowAnyException();
    }

    @Test
    void onlyBeverage() {
        List<String> orders = List.of("제로콜라-1".split(","));
        MenuReceiver menuReceiver = new MenuReceiver(orders);
        assertThatThrownBy(menuReceiver::receive)
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void overOrdered() {
        List<String> orders = List.of("티본스테이크-21".split(","));
        MenuReceiver menuReceiver = new MenuReceiver(orders);
        assertThatThrownBy(menuReceiver::receive)
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void overOrdered_case2() {
        List<String> orders = List.of("티본스테이크-10,아이스크림-11".split(","));
        MenuReceiver menuReceiver = new MenuReceiver(orders);
        assertThatThrownBy(menuReceiver::receive)
                .isInstanceOf(IllegalArgumentException.class);
    }
    @Test
    void amountNotNumber() {
        List<String> orders = List.of("티본스테이크-10,아이스크림-a".split(","));
        MenuReceiver menuReceiver = new MenuReceiver(orders);
        assertThatThrownBy(menuReceiver::receive)
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void menuNotExist() {
        List<String> orders = List.of("고등어-10".split(","));
        MenuReceiver menuReceiver = new MenuReceiver(orders);
        assertThatThrownBy(menuReceiver::receive)
                .isInstanceOf(IllegalArgumentException.class);
    }
}
