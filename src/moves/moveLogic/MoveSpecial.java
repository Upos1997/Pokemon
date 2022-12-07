package src.moves.moveLogic;

import src.pokemon.Stat;

public abstract class MoveSpecial extends MoveDamaging {
    protected static Stat attack = Stat.SP_ATK;
    protected static Stat defense = Stat.SP_DEF;
    protected static boolean makesContact = false;

    @Override
    public boolean isSpecial() {
        return true;
    }
}
