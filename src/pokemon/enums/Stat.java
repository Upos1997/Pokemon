package src.pokemon.enums;

import src.helper.Constants;

public enum Stat {
    HP,
    ATK,
    DEF,
    SP_ATK,
    SP_DEF,
    SPE,
    ACC,
    EVA,
    CRIT;

    static private float calcMod(int stage, float stepSize)
    {
        if (stage < 0)
            return stepSize / (stepSize - stage);
        else
            return (stepSize + stage) / stepSize;
    }

    static public float getMod(int stage)
    {
        return calcMod(stage, Constants.STAGE_STEP);
    }

    static public float getMod(int acc, int eva)
    {
        int totalStage = acc - eva;
        return calcMod(totalStage, Constants.ACC_STEP);
    }

    static public float getCritChance(int stage)
    {
        int stepSize = Math.ceilDiv(Constants.CRIT_ODDS, 6);
        return (float) Math.pow(Constants.CRIT_ODDS - (stage * stepSize), -1);
    }
}
