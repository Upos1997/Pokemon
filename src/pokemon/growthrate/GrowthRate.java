package src.pokemon.growthrate;

public interface GrowthRate {
    int xpToLevel(long xp);
    long levelToXp(int level);

    default long toNextLevel(int level, long xp)
    {
        long neededXp = levelToXp(level + 1);
        return neededXp - xp;
    }
}
