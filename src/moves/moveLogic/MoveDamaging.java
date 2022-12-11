package src.moves.moveLogic;

import src.combat.action.ActionMoveDamaging;
import src.combat.action.ActionMoveStatus;
import src.combat.action.MoveAction.MoveActionChangeHp;
import src.combat.action.MoveAction.MoveActionDamage;
import src.combat.field.Field;
import src.pokemon.Pokemon;
import src.pokemon.Stat;

import java.util.List;

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

    protected boolean singleTarget(Field field, ActionMoveDamaging action, Pokemon target) {
        if(super.singleTarget(field, action, target)){
            int damage = new MoveActionDamage(action, target).action(field);
            new MoveActionChangeHp(action, target, damage);
            secondaryEffect(field, action, target);
            return true;
        } else return false;
    }
}
