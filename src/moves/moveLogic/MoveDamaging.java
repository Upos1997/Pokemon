package src.moves.moveLogic;

import src.combat.action.MoveActionDamage;
import src.combat.action.MoveActionSingle;
import src.combat.action.MoveActionChangeHp;
import src.combat.field.Field;
import src.pokemon.Pokemon;
import src.pokemon.Stat;

public abstract class MoveDamaging extends Move {

    protected Stat attack;
    protected Stat defense;
    protected int power;

    public Stat getAttack() {
        return attack;
    }

    public Stat getDefense() {
        return defense;
    }

    public int getPower() {
        return power;
    }

    protected boolean secondaryEffect(Field field, MoveActionSingle action){
        return true;
    }

    @Override
    public boolean use(Field field, Pokemon user) {
        return true;
    }

    @Override
    public boolean singleTarget(Field field, MoveActionSingle action) {
        int damage = new MoveActionDamage(action).action(field);
        if (new MoveActionChangeHp(action, damage).action(field)){
            return secondaryEffect(field, action);
        } else return false;
    }
}
