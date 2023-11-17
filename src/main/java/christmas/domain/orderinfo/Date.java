package christmas.domain.orderinfo;

import christmas.domain.validator.DateValidator;
import christmas.domain.week.Week;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;

public class Date {
    private static final int YEAR = 2023;
    private static final int MONTH = 12;
    private static final int DAY = 1;
    private static final LocalDate eventStart = LocalDate.of(YEAR, MONTH, DAY);
    private static final int CHRISTMAS_DAY = 25;
    private static final int INCREASE = 100;
    private static final int DEFAULT_DISCOUNT = 1000;
    private static final int NO_DISCOUNT = 0;

    private final int date;

    public Date(int date) {
        DateValidator.isInRange(date);
        this.date = date;
    }

    public String orderedDate() {
        LocalDate orderedDate = eventStart.plusDays(date - DAY);
        DayOfWeek futureDayOfWeek = orderedDate.getDayOfWeek();

        return futureDayOfWeek.getDisplayName(TextStyle.FULL, Locale.KOREAN);
    }

    public boolean isBeforeChristmas() {
        return date <= CHRISTMAS_DAY;
    }

    public int christmasDiscount() {
        if (date > CHRISTMAS_DAY) {
            return NO_DISCOUNT;
        }
        return DEFAULT_DISCOUNT + ((date - DAY) * INCREASE);
    }

    public boolean christmasDay() {
        return date == CHRISTMAS_DAY;
    }

    public boolean isWeekend() {
        return Week.isWeekend(orderedDate());
    }
}
