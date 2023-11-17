package christmas.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ChristmasBadgeTest {

    @Test
    @DisplayName("2만원 이상이면 산타")
    void getBadge_SANTA() {
        assertThat(ChristmasBadge.getBadge(30000).getName()).isEqualTo("산타");
    }
    @Test
    @DisplayName("만원 이상이면 트리")
    void getBadge_TREE() {
        assertThat(ChristmasBadge.getBadge(19999).getName()).isEqualTo("트리");
    }
    @Test
    @DisplayName("5천원 이상이면 별")
    void getBadge_STAR() {
        assertThat(ChristmasBadge.getBadge(5999).getName()).isEqualTo("별");
    }
}