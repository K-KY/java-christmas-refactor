package christmas.view;

import christmas.domain.ChristmasBadge;
import christmas.domain.orderinfo.Date;
import christmas.domain.MenuBoard;
import christmas.domain.orderinfo.UserOrder;
import static christmas.view.SystemMessages.*;

public class OutputView {

    public static void startMessage() {
        System.out.println(GREETING);
        System.out.println(VISIT_DATE);
    }

    public static void menuAndAmount(MenuBoard menuBoard) {
        System.out.println(menuBoard);
        System.out.println(ORDER_MENU);
    }

    public static void badgeAnnouncement(ChristmasBadge badge) {
        if (badge != ChristmasBadge.NO_BADGE) {
            System.out.println();
            System.out.println(CUSTOMER + badge.getName() + GET_BADGE);
            System.out.println(PRESENT_NEXT_EVENT);
        }
    }

    public static void printWeekDiscountAnnouncement(boolean weekend) {
        if (weekend) {
            printWeekendDiscountAnnouncement();
            System.out.println();
            return;
        }
        printWeekDayDiscountAnnouncement();
    }

    public static void printWeekDayDiscountAnnouncement() {
        System.out.println(WEEKDAY_DISCOUNT);
        System.out.println(DESSERT_DISCOUNT);
        System.out.println();
    }

    public static void printWeekendDiscountAnnouncement() {
        System.out.println(WEEKEND_DISCOUNT);
        System.out.println(MAIN_MENU_DISCOUNT);
    }

    public static void printChristMasDiscountAnnouncement(Date date) {
        if (date.isBeforeChristmas()) {
            System.out.println(CHRISTMAS_DISCOUNT);
            System.out.println(IF_ORDER_TEN_THOUSAND + date.christmasDiscount() + DISCOUNT);
            System.out.println();
        }
    }

    public static void totalAmount(String totalAmount) {
        System.out.println(BEFORE_DISCOUNT);
        System.out.println(totalAmount);
        System.out.println();
    }

    public static void present(String present) {
        presentAnnouncement(present);
        System.out.println(PRESENT_MENU);
        if (present.length() != NO_DISCOUNT) {
            System.out.println(present);
            System.out.println();
            return;
        }
        System.out.println(NONE);
    }

    public static void totalDiscount(String totalDiscount) {
        System.out.println(TOTAL_BENEFIT);
        System.out.println(totalDiscount);
        System.out.println();
    }

    public static void printSpecialDiscountAnnouncement(boolean stared) {
        if (stared) {
            System.out.println(SPECIAL_DISCOUNT);
            System.out.println(DISCOUNT_THOUSAND);
            System.out.println();
        }
    }

    public static void orderContent(UserOrder userOrder) {
        System.out.println(BENEFIT_PREVIEW);
        System.out.println(ORDERED_MENU);
        System.out.println(userOrder);
    }

    public static void discountHistory(String discount) {
        System.out.println(DISCOUNT_HISTORY);
        if (discount.length() != NO_DISCOUNT) {
            System.out.println(discount);
            return;
        }
        System.out.println(NONE);
    }

    public static void afterDiscount(String afterDiscount) {
        System.out.println(AFTER_DISCOUNT);
        System.out.println(afterDiscount);
        System.out.println();
    }

    public static void grantedBadge(ChristmasBadge badge) {
        System.out.println(DECEMBER_EVENT_BADGE);
        if (badge.isBadge()) {
            System.out.println(NONE);
            return;
        }
        System.out.println(badge.getName());
        badgeAnnouncement(badge);
    }

    public static void presentAnnouncement(String present) {
        if (present.length() != 0) {
            System.out.println(PRESENT_MESSAGE);
        }
    }
}
