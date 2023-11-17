package christmas.domain.week;

import static org.assertj.core.api.Assertions.assertThat;

import christmas.domain.orderinfo.Date;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WeekTest {

    @Test
    @DisplayName("금-토 는 주말")
    void isWeekend() {
        assertThat(Week.isWeekend("토요일")).isTrue();
    }

    @Test
    @DisplayName("일-목은 평일")
    void isNotWeekend() {
        assertThat(Week.isWeekend("일요일")).isFalse();
    }

    @Test
    @DisplayName("별이 있는 날")
    void isStared() {
        assertThat(Week.isStared(new Date(25))).isTrue();
    }

    @Test
    @DisplayName("별이 없는 날")
    void isNotStared() {
        assertThat(Week.isStared(new Date(26))).isFalse();
    }
}