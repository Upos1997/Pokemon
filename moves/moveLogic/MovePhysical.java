package moves.moveLogic;

import pokemon.Stat;

public abstract class MovePhysical extends MoveDamaging {

    static Stat attack = Stat.ATTACK;
    static Stat defense = Stat.DEFENSE;
    static Boolean makesContact = true;

    @Override
    public boolean isPhysical() {
        return true;
    }
}
