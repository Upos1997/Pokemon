package action;

import java.util.List;

import action.actionLogic.Action;
import field.Field;
import moves.moveLogic.MoveDamaging;
import pokemon.Pokemon;

public class MoveActionDamaging extends MoveAction {

    public MoveActionDamaging(Field field, Pokemon user, MoveDamaging move, Pokemon target, List<Action> actions) {
        super(field, user, move, target, actions);
        this.actions.add(0, new ActionDamage(user, move, target));
    }
}