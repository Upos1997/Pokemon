package src.pokemon.statlist;

import src.pokemon.enums.Stat;

public class StatListStages implements StatList {
    private static final int MAX_VALUE = 6;
    private static final int MIN_VALUE = -6;

    private int attack = 0;
    private int defence = 0;
    private int specialAttack = 0;
    private int specialDefence = 0;
    private int speed = 0;
    private int accuracy = 0;
    private int evasion = 0;
    private int criticalChance = 0;


    @Override
    public int getStat(Stat stat) {
        return switch (stat)
                {
                    case HP -> 0;
                    case ATK -> attack;
                    case DEF -> defence;
                    case SP_ATK -> specialAttack;
                    case SP_DEF -> specialDefence;
                    case SPE -> speed;
                    case ACC -> accuracy;
                    case EVA -> evasion;
                    case CRIT -> criticalChance;
                };
    }

    @Override
    public void setStat(Stat stat, int newStat)
    {
        if (newStat > MAX_VALUE)
            newStat = MAX_VALUE;
        else if (newStat < MIN_VALUE)
            newStat = MIN_VALUE;
        switch (stat)
        {
            case ATK -> attack = newStat;
            case DEF -> defence = newStat;
            case SP_ATK -> specialAttack = newStat;
            case SP_DEF -> specialDefence = newStat;
            case SPE -> speed = newStat;
            case ACC -> accuracy = newStat;
            case EVA -> evasion = newStat;
            case CRIT -> criticalChance = newStat;
        }
    }

    @Override
    public void modStatAdd(Stat stat, int change)
    {
        setStat(stat, getStat(stat) + change);
    }

    @Override
    public void modStatMul(Stat stat, float change)
    {
        setStat(stat, Math.round(getStat(stat)*change));
    }
}
