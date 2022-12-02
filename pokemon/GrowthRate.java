package pokemon;

import java.util.function.Function;

public enum GrowthRate {
    FAST(xp -> {
        return (int) Math.pow(xp * 5 / 4, 1 / 3);
    },
            level -> {
                return (long) Math.pow(level, 3) * 4 / 5;
            }),
    MEDIUM(xp -> {
        return (int) Math.pow(xp, 1 / 3);
    },
            level -> {
                return (long) Math.pow(level, 3);
            }),
    SLOW(xp -> {
        return (int) Math.pow(4 / 5 * xp, 1 / 3);
    },
            level -> {
                return (long) (5 / 4 * Math.pow(level, 3));
            });

    GrowthRate(Function<Long, Integer> xpToLevel, Function<Integer, Long> levelToXp) {
        this.xpToLevel = xpToLevel;
        this.levelToXp = levelToXp;
    }

    private Function<Integer, Long> levelToXp;
    private Function<Long, Integer> xpToLevel;

    public int calcLevel(long xp) {
        return xpToLevel.apply(xp);
    }

    public long toNextLevel(int level, long xp) {
        long nextLevel = levelToXp.apply(level + 1);
        return nextLevel - xp;
    }
}
