package src.moves.moveLogic;

import src.combat.action.ActionMoveDamaging;
import src.combat.action.ActionMoveStatus;
import src.combat.action.MoveAction.MoveActionChangeHp;
import src.combat.action.MoveAction.MoveActionDamage;
import src.combat.field.Field;
import src.pokemon.Pokemon;
import src.pokemon.enums.Stat;

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

    @Override
    protected boolean singleTarget(Field field, ActionMoveStatus action, Pokemon target) {
        if(super.singleTarget(field, action, target) && action instanceof ActionMoveDamaging actionDam){
            int damage = new MoveActionDamage(actionDam, target).action(field);
            new MoveActionChangeHp(actionDam, target, damage);
            secondaryEffect(field, actionDam, target);
            return true;
        } else return false;
    }
}
