package christmas.domain.validator;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

public class OrderValidateTest {

    @Test
    void notExistMenu() {
        assertThatThrownBy(() -> OrderValidator.isExist("개나리"))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @Test
    void existMenu() {
        assertThatCode(() -> OrderValidator.isExist("티본스테이크"))
                .doesNotThrowAnyException();
    }

    @Test
    void inValidAmount() {
        assertThatThrownBy(() -> OrderValidator.isValidAmount("q"))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @Test
    void validAmount() {
        assertThatCode(() -> OrderValidator.isValidAmount("20"))
                .doesNotThrowAnyException();
    }

    @Test
    void isAmountInRange() {
        assertThatCode(() -> OrderValidator.isAmountInRange(20))
                .doesNotThrowAnyException();
    }
    @Test
    void isNotAmountInRange() {
        assertThatThrownBy(() -> OrderValidator.isAmountInRange(21))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
