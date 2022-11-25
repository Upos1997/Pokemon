package moves.moveLogic;

import pokemon.Stat;

public abstract class MoveSpecial extends MoveDamaging {
    protected static Stat attack = Stat.SPECIAL_ATTACK;
    protected static Stat defense = Stat.SPECIAL_DEFENSE;
    protected static boolean makesContact = false;

    @Override
    public boolean isSpecial() {
        return true;
    }
}
