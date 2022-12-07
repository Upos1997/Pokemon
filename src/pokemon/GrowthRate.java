package src.pokemon;

import java.util.function.Function;

public enum GrowthRate {
    FAST(xp -> (int) Math.pow(xp * 1.25, 0.33),
            level -> (long) Math.pow(level, 3) * 4 / 5),
    MEDIUM(xp -> (int) Math.pow(xp, 0.33),
            level -> (long) Math.pow(level, 3)),
    SLOW(xp -> (int) Math.pow(0.8 * xp, 0.33),
            level -> (long) (5 / 4 * Math.pow(level, 3)));

    GrowthRate(Function<Long, Integer> xpToLevel, Function<Integer, Long> levelToXp) {
        this.xpToLevel = xpToLevel;
        this.levelToXp = levelToXp;
    }

    private final Function<Integer, Long> levelToXp;
    private final Function<Long, Integer> xpToLevel;

    public int calcLevel(long xp) {
        return xpToLevel.apply(xp);
    }

    public long toNextLevel(int level, long xp) {
        long nextLevel = levelToXp.apply(level + 1);
        return nextLevel - xp;
    }
}
