package action;

import java.util.List;

import action.actionLogic.Action;
import action.actionLogic.MessageAction;
import field.Field;
import pokemon.Pokemon;
import prevent.MessagePrevent;

public class ActionStaticDamage extends Action {

    public ActionStaticDamage(Pokemon user, Object source, Pokemon target, int damage) {
        super(user, source, target);
        this.damage = damage;
    }

    List<MessagePrevent> messages = List.of(MessagePrevent.CHANGE_HP);
    int damage;

    @Override
    protected boolean action(Field field) {
        target.changeHp(damage);
        field.handleReactions(MessageAction.CHANGE_HP);
        return true;
    }

}
