package christmas.domain.discounter;

import static org.assertj.core.api.Assertions.assertThat;

import christmas.domain.orderinfo.Benefit;
import christmas.domain.MenuReceiver;
import christmas.domain.orderinfo.UserOrder;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WeekendDiscounterTest {

    @Test
    @DisplayName("주말엔 메인메뉴 2023원 할인")
    void hasMainMenu() {
        Benefit benefit = new Benefit();
        MenuReceiver menuReceiver = new MenuReceiver(List.of("티본스테이크-1,아이스크림-1,타파스-1".split(",")));
        UserOrder userOrder = menuReceiver.receive();

        WeekendDiscounter weekendDiscounter = new WeekendDiscounter();
        assertThat(weekendDiscounter.discount(userOrder, benefit)).isEqualTo(2023);
        assertThat(benefit.toString()).isEqualTo("주말 할인: -2,023원\n");
    }
    @Test
    @DisplayName("메인메뉴를 주문하지 않으면 주말할인 0원")
    void noDiscount() {
        Benefit benefit = new Benefit();
        MenuReceiver menuReceiver = new MenuReceiver(List.of("아이스크림-1,타파스-1".split(",")));
        UserOrder userOrder = menuReceiver.receive();

        WeekendDiscounter weekendDiscounter = new WeekendDiscounter();
        assertThat(weekendDiscounter.discount(userOrder, benefit)).isEqualTo(0);
        assertThat(benefit.toString()).isEqualTo("");
    }
}
