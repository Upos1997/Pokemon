package src.pokemon.enums;

import src.helper.Constants;

public class StatListEV extends StatList {

    public StatListEV(int hp, int attack, int defense, int specialAttack, int specialDefense, int speed) {
        super(hp, attack, defense, specialAttack, specialDefense, speed);
        this.MAX_VALUE = Constants.EV_MAX_STAT;
    }
    public StatListEV(){
        super(0, 0, 0, 0, 0, 0);
        this.MAX_VALUE = Constants.EV_MAX_STAT;
    }

    @Override
    public void modStat(Stat stat, int change) {
        int totalBuffer = sum()+change - Constants.EV_MAX_TOTAL;
        if (totalBuffer > 0) {
            change = totalBuffer;
        }
        super.modStat(stat, change);
    }
}
