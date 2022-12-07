package src.moves.moveLogic;

import src.pokemon.Stat;

public abstract class MovePhysical extends MoveDamaging {

    static Stat attack = Stat.ATK;
    static Stat defense = Stat.DEF;
    static Boolean makesContact = true;

    @Override
    public boolean isPhysical() {
        return true;
    }
}
