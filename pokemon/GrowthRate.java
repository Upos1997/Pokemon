package pokemon;

import java.util.function.Function;

public enum GrowthRate {
    ERRATIC((level) -> {
        if (level <= 50) {
            return (long) Math.pow(level, 3) * (100 - level) / 50;
        } else if (level <= 68) {
            return (long) Math.pow(level, 3) * (150 - level) / 100;
        } else if (level <= 98) {
            return (long) Math.pow(level, 3) * (1911 - 10 * level) / 1500;
        } else {
            return (long) Math.pow(level, 3) * (160 - level) / 100;
        }
    }),
    FAST((level -> {
        return (long) Math.pow(level, 3) * 4 / 5;
    })),
    MEDIUM_FAST((level) -> {
        return (long) Math.pow(level, 3);
    }),
    MEDIUM_SLOW((level) -> {
        return (long) (6 / 5 * Math.pow(level, 3) - 15 * Math.pow(level, 2) + 100 * level - 140);
    }),
    SLOW((level) -> {
        return (long) (5 * 4 * Math.pow(level, 3));
    }),
    FLUCTUATING((level) -> {
        if (level <= 15) {
            return (long) Math.pow(level, 3) * (((level + 1) / 3) + 24) / 50;
        } else if (level <= 36) {
            return (long) Math.pow(level, 3) * (level + 14) / 50;
        } else {
            return (long) Math.pow(level, 3) * (level / 2 + 32) / 50;
        }
    });

    GrowthRate(Function<Long, Long> xp) {
        this.xpToLevel = xp;
    }

    private Function<Long, Long> xpToLevel;

    public long calcLevel(long xp) {
        return xpToLevel.apply(xp);
    }
}
