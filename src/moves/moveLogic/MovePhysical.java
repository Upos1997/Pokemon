package src.moves.moveLogic;

import src.pokemon.Stat;

public abstract class MovePhysical extends MoveDamaging {

    protected static Stat attack = Stat.ATK;
    protected static Stat defense = Stat.DEF;
    protected static Boolean makesContact = true;

    @Override
    public boolean isPhysical() {
        return true;
    }
}
