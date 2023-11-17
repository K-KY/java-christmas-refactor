package christmas.domain.discounter;

import static org.assertj.core.api.Assertions.assertThat;

import christmas.domain.orderinfo.OrderedAmount;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PresentDiscounterTest {
    private OrderedAmount orderedAmount;
    @BeforeEach
    void setUp() {
        orderedAmount = new OrderedAmount();

    }

    @Test
    @DisplayName("12만원 이상이면 샴페인 증정")
    void discountTest() {
        orderedAmount.addTotalAmount(120000);
        PresentDiscounter presentDiscounter = new PresentDiscounter(orderedAmount);
        assertThat(presentDiscounter.discount()).isEqualTo("샴페인 1개");

    }

    @Test
    @DisplayName("12만원 이하면 빈 문자열을 리턴")
    void amountUnder120000() {
        orderedAmount.addTotalAmount(110000);
        PresentDiscounter presentDiscounter = new PresentDiscounter(orderedAmount);
        assertThat(presentDiscounter.discount()).isEqualTo("");

    }
}
