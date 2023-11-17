package christmas.domain.week;

import christmas.domain.orderinfo.Date;
import java.util.List;
import java.util.Objects;

public enum Week {
    MONDAY("월요일", false),
    TUESDAY("화요일", false),
    WEDNESDAY("수요일", false),
    THURSDAY("목요일", false),
    FRIDAY("금요일", true),
    SATURDAY("토요일", true),
    SUNDAY("일요일", false);

    private final String day;
    private final boolean weekend;

    Week(String day, boolean weekend) {
        this.day = day;
        this.weekend = weekend;
    }

    public static boolean isWeekend(String day) {
        List<Week> weeks = List.of(Week.values());
        return Objects.requireNonNull(weeks.stream()
                .filter(week -> week.day.equals(day))
                .findFirst().orElse(null)).weekend;
    }
    private static boolean isSunday(Date date) {
        String orderedDate = date.orderedDate();
        return SUNDAY.day.equals(orderedDate);
    }
    public static boolean isStared(Date date) {
        return date.christmasDay() || isSunday(date);
    }
}
