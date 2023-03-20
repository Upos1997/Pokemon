package src.pokemon.growthrate;

public class GrowthRateMedium implements GrowthRate {

    private GrowthRateMedium(){}

    @Override
    public int xpToLevel(long xp)
    {
        return Math.toIntExact(Math.round(Math.pow(xp, 0.33)));
    }

    @Override
    public long levelToXp(int level)
    {
        return Math.round(Math.pow(level, 3));
    }

    private static final GrowthRate instance = new GrowthRateMedium();
    public static GrowthRate getInstance()
    {
        return instance;
    }

}
