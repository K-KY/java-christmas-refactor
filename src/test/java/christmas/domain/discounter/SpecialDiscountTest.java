package christmas.domain.discounter;

import static org.assertj.core.api.Assertions.assertThat;

import christmas.domain.orderinfo.Benefit;
import christmas.domain.orderinfo.Date;
import christmas.domain.orderinfo.OrderedAmount;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SpecialDiscountTest {
    private Date date;
    private OrderedAmount orderedAmount;
    @BeforeEach
    void setUp() {
        date = new Date(25);
        orderedAmount = new OrderedAmount();
    }

    @Test
    @DisplayName("만원 조건이 없을 때 1000")
    void staredDate() {
        SpecialDiscounter specialDiscounter =  new SpecialDiscounter(orderedAmount);
        assertThat(specialDiscounter.discount(date, new Benefit())).isEqualTo(0);
    }

    @Test
    @DisplayName("만원 조건이 없을 때 0")
    void notStaredDate() {
        date = new Date(26);
        SpecialDiscounter specialDiscounter =  new SpecialDiscounter(orderedAmount);
        assertThat(specialDiscounter.discount(date, new Benefit())).isEqualTo(0);
    }

    @Test
    @DisplayName("만원 조건이 있을 때 1000")
    void staredDateConditional() {
        orderedAmount = new OrderedAmount();
        orderedAmount.addTotalAmount(20000);
        SpecialDiscounter specialDiscounter =  new SpecialDiscounter(orderedAmount);
        assertThat(specialDiscounter.discount(date, new Benefit())).isEqualTo(1000);
    }

    @Test
    @DisplayName("만원 조건이 있을 때 0")
    void notStaredDateConditional() {
        orderedAmount = new OrderedAmount();
        orderedAmount.addTotalAmount(20000);
        date = new Date(26);
        SpecialDiscounter specialDiscounter =  new SpecialDiscounter(orderedAmount);
        assertThat(specialDiscounter.discount(date, new Benefit())).isEqualTo(0);
    }

}
