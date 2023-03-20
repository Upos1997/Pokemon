package src.pokemon.growthrate;

public class GrowthRateFast implements GrowthRate {

    private GrowthRateFast(){}

    @Override
    public int xpToLevel(long xp)
    {
        return Math.toIntExact(Math.round(Math.pow(xp * 1.25f, 0.33f)));
    }

    @Override
    public long levelToXp(int level)
    {
        return Math.round(Math.pow(level, 3) * 4 / 5);
    }

    private static final GrowthRate instance = new GrowthRateFast();
    public static GrowthRate getInstance()
    {
        return instance;
    }
}
