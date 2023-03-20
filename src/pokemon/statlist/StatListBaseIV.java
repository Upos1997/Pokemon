package src.pokemon.statlist;

import src.helper.Constants;
import src.helper.Rng;
import src.pokemon.enums.Stat;

import java.util.Arrays;

public class StatListBaseIV extends StatListBase {
    public StatListBaseIV(int hp, int attack, int defense, int specialAttack, int specialDefense, int speed)
    {
        super(hp, attack, defense, specialAttack, specialDefense, speed);
        this.MAX_VALUE = Constants.IV_MAX_STAT;
    }
    public StatListBaseIV()
    {
        super(0, 0, 0, 0, 0, 0);
        this.MAX_VALUE = Constants.IV_MAX_STAT;
        randomIV();
    }

    @Override
    public void modStatAdd(Stat stat, int change)
    {
        int newStat = calcNewStat(getStat(stat) + change);
        setStat(stat, newStat);
    }
    @Override
    public void modStatMul(Stat stat, float change)
    {
        int newStat = calcNewStat(Math.round(getStat(stat)*change));
        setStat(stat, newStat);
    }

    private int calcNewStat(int newStat)
    {
        int totalBuffer = newStat - Constants.IV_MAX_TOTAL;
        if (totalBuffer > 0)
            newStat -= totalBuffer;
        return newStat;
    }

    private void randomIV()
    {
        int[] vals = randomValues();
        int error = Arrays.stream(vals).sum() - Constants.IV_MAX_TOTAL;
        if (error != 0)
        {
            int[] adjust = randomAdjust(error);
            if (error > 0)
                for(int i = 0; i < 6; i++)
                    vals[i] = vals[i] - adjust[i];
            else
                for(int i = 0; i < 6; i++)
                    vals[i] = vals[i] + adjust[i];
        }
        this.hp = vals[0];
        this.attack = vals[1];
        this.defense = vals[2];
        this.specialAttack = vals[3];
        this.specialDefense = vals[4];
        this.speed = vals[5];
    }

    private int[] randomValues()
    {
        int[] vals = new int[6];
        for(int i = 0; i < 6; i++)
            vals[i] = Rng.nextInt(MAX_VALUE);
        return vals;
    }

    private int[] randomAdjust(int sum)
    {
        int[] adjust = new int[6];
        for(int i = 0; i < 5; i++)
            adjust[i] = Rng.nextInt(sum);
        adjust[5] = sum;
        Arrays.sort(adjust);
        for (int i = 5; i > 0; --i)
            adjust[i] -= adjust[i-1];
        return adjust;
    }
}
