package src.pokemon.statlist;

import src.helper.Constants;
import src.pokemon.enums.Stat;

public class StatListBaseEV extends StatListBase {

    public StatListBaseEV(int hp, int attack, int defense, int specialAttack, int specialDefense, int speed) {
        super(hp, attack, defense, specialAttack, specialDefense, speed);
        this.MAX_VALUE = Constants.EV_MAX_STAT;
    }
    public StatListBaseEV(){
        super(0, 0, 0, 0, 0, 0);
        this.MAX_VALUE = Constants.EV_MAX_STAT;
    }

    @Override
    public void modStatAdd(Stat stat, int change) {
        int newStat = calcNewStat(getStat(stat)+change);
        setStat(stat, newStat);
    }
    @Override
    public void modStatMul(Stat stat, float change) {
        int newStat = calcNewStat(Math.round(getStat(stat)*change));
        setStat(stat, newStat);
    }

    private int calcNewStat(int newStat){
        int totalBuffer = newStat - Constants.EV_MAX_TOTAL;
        if (totalBuffer > 0) {
            newStat -= totalBuffer;
        }
        return newStat;
    }
}
