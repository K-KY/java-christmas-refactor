package christmas.domain.validator;

import christmas.domain.MenuBoard;
import java.util.List;

public class OrderValidator {

    private static final String DIGIT = "[0-9]+";
    private static final MenuBoard menuBoard = new MenuBoard();
    private static final String ERROR_HEAD = "[ERROR]";
    private static final String INVALID_ORDER = ERROR_HEAD + " 유효하지 않은 주문입니다. 다시 입력해 주세요.";

    public static void isExist(String order) {
        if (checkMenu(order)) {
            return;
        }
        throw new IllegalArgumentException(INVALID_ORDER);
    }

    private static Boolean checkMenu(String order) {
       return menuBoard.find(order);
    }

    public static void isValidAmount(String amount) {
        if (amount.matches(DIGIT)) {
            return;
        }
        throw new IllegalArgumentException(INVALID_ORDER);
    }

    public static void isAmountInRange(int amount) {
        if (amount >= 21 || amount <= 0) {
            throw new IllegalArgumentException(INVALID_ORDER);
        }
    }

    public static void isOnlyBeverage(boolean onlyBeverage) {
        if (onlyBeverage) {
            throw new IllegalArgumentException(INVALID_ORDER);
        }
    }

    public static void menuForm(List<String> userOrder) {
        if (userOrder.size() != 2) {// "-"를 기준으로 나눈 리스트니까 {메뉴, 수량} 이렇게 되어 있음 만약 이 길이가 2가 아니라면 형식이 잘못됨
            throw new IllegalArgumentException(INVALID_ORDER);
        }
    }
}
