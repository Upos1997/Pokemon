package moves.moveLogic;

import java.util.Collections;
import java.util.List;

import combat.action.ActionDamage;
import combat.action.MoveAction;
import combat.action.MoveActionDamaging;
import combat.action.actionLogic.Action;
import combat.field.Field;
import pokemon.Pokemon;
import pokemon.Stat;

public class MoveDamaging extends Move {

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

    public ActionDamage dealDamage(Pokemon user, Pokemon target) {
        return new ActionDamage(user, this, target);
    }

    @Override
    protected MoveAction makeMoveAction(Field field, Pokemon user, Pokemon target) {
        return new MoveActionDamaging(field, target, this, target, makeActions(user, target));
    }

    @Override
    protected List<Action> makeActions(Pokemon user, Pokemon target) {
        return Collections.emptyList();
    }
}
