package christmas.domain.validator;

public class DateValidator {

    private static final String DIGIT = "[0-9]+";
    private static final String ERROR_HEAD = "[ERROR]";
    private static final String INVALID_DATE = ERROR_HEAD + " 유효하지 않은 날짜입니다. 다시 입력해 주세요.";

    public static void isNumber(String number) {
        if (number.matches(DIGIT)) {
            return;
        }
        throw new IllegalArgumentException(INVALID_DATE);
    }

    public static void isInRange(int date) {
        if (date <= 0 || date > 31) {
            throw new IllegalArgumentException(INVALID_DATE);
        }
    }
}
