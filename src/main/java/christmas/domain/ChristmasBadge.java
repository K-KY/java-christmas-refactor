package christmas.domain;

import java.util.List;

public enum ChristmasBadge {
    SANTA(20000, "산타"),
    TREE(10000, "트리"),
    STAR(5000, "별"),
    NO_BADGE(0, "");

    private final int point;
    private final String badgeName;

    ChristmasBadge(int point, String badgeName) {
        this.point = point;
        this.badgeName = badgeName;
    }

    public static ChristmasBadge getBadge(int amount) {
        List<ChristmasBadge> badges = List.of(ChristmasBadge.values());
        return badges.stream()
                .filter(badge -> badge.point <= amount)
                .findFirst()
                .orElse(NO_BADGE);
    }


    public String getName() {
        return badgeName;
    }

    public boolean isBadge() {
        return this == NO_BADGE;
    }
}
