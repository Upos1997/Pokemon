package src.pokemon.growthrate;

public class GrowthRateSlow implements GrowthRate {

    private GrowthRateSlow(){}

    @Override
    public int xpToLevel(long xp)
    {
        return Math.toIntExact(Math.round(Math.pow(0.8 * xp, 0.33)));
    }

    @Override
    public long levelToXp(int level)
    {
        return Math.round((5 / 4f * Math.pow(level, 3)));
    }

    private static final GrowthRate instance = new GrowthRateSlow();
    public static GrowthRate getInstance()
    {
        return instance;
    }
}
