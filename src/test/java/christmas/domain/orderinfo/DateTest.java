package christmas.domain.orderinfo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class DateTest {

    @Test
    @DisplayName("1~31 사이의 값이 입력되면 통과")
    void date_true() {
        assertThatCode(() -> new Date(10)).doesNotThrowAnyException();
    }

    @Test
    @DisplayName("1~31 외 의 값이 입력되면 예외")
    void date_false() {
        assertThatThrownBy(() -> new Date(32)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("입력된 날짜의 요일을 리턴")
    void returnSunday() {
        Date date = new Date(24);
        assertThat(date.orderedDate()).isEqualTo("일요일");
    }

    @Test
    @DisplayName("크리스마스 이전이면 true")
    void beforeChristmas() {
        Date date = new Date(24);
        assertThat(date.isBeforeChristmas()).isTrue();
    }

    @Test
    @DisplayName("크리스마스 이전이면 false")
    void beforeChristmas_false() {
        Date date = new Date(26);
        assertThat(date.isBeforeChristmas()).isFalse();
    }

    @Test
    @DisplayName("크리스마스 당일이면 true")
    void christmasDay() {
        Date date = new Date(25);
        assertThat(date.christmasDay()).isTrue();
    }

    @Test
    @DisplayName("크리스마스 이전이거나 이후면 false")
    void christmasDay_false() {
        Date date = new Date(24);
        assertThat(date.christmasDay()).isFalse();
        date = new Date(26);
        assertThat(date.christmasDay()).isFalse();
    }

    @Test
    @DisplayName("입력된 날짜가 주말이면 true")
    void isWeekend() {
        Date date = new Date(23);
        assertThat(date.isWeekend()).isTrue();
    }

    @Test
    @DisplayName("입력된 날짜가 주말이면 true")
    void isWeekend_false() {
        Date date = new Date(25);
        assertThat(date.isWeekend()).isFalse();
    }
}
