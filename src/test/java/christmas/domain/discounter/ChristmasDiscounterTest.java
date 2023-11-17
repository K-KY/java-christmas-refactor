package christmas.domain.discounter;

import static org.assertj.core.api.Assertions.assertThat;

import christmas.domain.orderinfo.Benefit;
import christmas.domain.orderinfo.Date;
import christmas.domain.orderinfo.OrderedAmount;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ChristmasDiscounterTest {
    private Date date;
    private OrderedAmount orderedAmount;
    @BeforeEach
    void setUp() {
        date = new Date(25);
        orderedAmount = new OrderedAmount();

    }

    @Test
    @DisplayName("3400원을 리턴한다.")
    void discountTest() {
        orderedAmount.addTotalAmount(100000);
        ChristmasDiscounter christmasDiscounter = new ChristmasDiscounter(orderedAmount);
        assertThat(christmasDiscounter.discount(date, new Benefit())).isEqualTo(3400);
    }

    @Test
    @DisplayName("만원을 넘지 않으면 0원을 리턴한다.")
    void discountTestReturn0() {
        orderedAmount.addTotalAmount(9999);
        ChristmasDiscounter christmasDiscounter = new ChristmasDiscounter(orderedAmount);
        System.out.println(orderedAmount.totalAmount());
        assertThat(christmasDiscounter.discount(date, new Benefit())).isEqualTo(0);
    }

    @Test
    @DisplayName("크리스마스가 지나면 0원을 리턴")
    void afterChristmas() {
        date = new Date(26);
        orderedAmount.addTotalAmount(100000);
        ChristmasDiscounter christmasDiscounter = new ChristmasDiscounter(orderedAmount);
        System.out.println(orderedAmount.totalAmount());
        assertThat(christmasDiscounter.discount(date, new Benefit())).isEqualTo(0);
    }
}
