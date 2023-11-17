package christmas.domain.discounter;

import static org.assertj.core.api.Assertions.assertThat;

import christmas.domain.orderinfo.Benefit;
import christmas.domain.MenuReceiver;
import christmas.domain.orderinfo.UserOrder;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WeekDayDiscounterTest {
    Benefit benefit = new Benefit();

    @Test
    @DisplayName("평일엔 디저트메뉴 2023원 할인")
    void hasDessert() {

        MenuReceiver menuReceiver = new MenuReceiver(List.of("티본스테이크-1,아이스크림-1,타파스-1".split(",")));
        UserOrder userOrder = menuReceiver.receive();

        WeekDayDiscounter weekDayDiscounter = new WeekDayDiscounter();
        benefit = new Benefit();
        assertThat(weekDayDiscounter.discount(userOrder, benefit)).isEqualTo(2023);
        assertThat(benefit.toString()).isEqualTo("평일 할인: -2,023원\n");
    }

    @Test
    @DisplayName("디저트메뉴가 없으면 평일 할인 0원")
    void noDiscount() {

        MenuReceiver menuReceiver = new MenuReceiver(List.of("티본스테이크-1,타파스-1".split(",")));
        UserOrder userOrder = menuReceiver.receive();

        WeekDayDiscounter weekDayDiscounter = new WeekDayDiscounter();
        benefit = new Benefit();

        assertThat(weekDayDiscounter.discount(userOrder, benefit)).isEqualTo(0);
        assertThat(benefit.toString()).isEqualTo("");
    }
}