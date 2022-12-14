package src.moves.moveLogic;

import src.pokemon.Stat;

public abstract class MovePhysical extends MoveDamaging {
    protected MovePhysical(){
        attack = Stat.ATK;
        defense = Stat.DEF;
    }

    @Override
    public boolean makesContact(){
        return true;
    }

    @Override
    public boolean isPhysical() {
        return true;
    }
}
