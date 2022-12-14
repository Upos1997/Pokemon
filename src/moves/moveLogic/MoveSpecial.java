package src.moves.moveLogic;

import src.pokemon.Stat;

public abstract class MoveSpecial extends MoveDamaging {
    MoveSpecial(){
        attack = Stat.SP_ATK;
        defense = Stat.SP_DEF;
    }

    @Override
    public boolean makesContact(){
        return false;
    }

    @Override
    public boolean isSpecial() {
        return true;
    }
}
