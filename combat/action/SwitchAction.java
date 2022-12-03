package combat.action;

import java.util.List;

import combat.action.actionLogic.Action;
import combat.action.actionLogic.MessageAction;
import combat.field.Field;
import combat.prevent.MessagePrevent;
import moves.moveLogic.Move;
import pokemon.Pokemon;

public class SwitchAction extends Action {
    SwitchAction(Pokemon user, Move move, Pokemon target) {
        super(user, move, target);
        this.target = target;
    }

    List<MessagePrevent> messages = List.of(MessagePrevent.SWITCH);
    int priority = 10;
    Pokemon target;

    @Override
    protected boolean action(Field field) {
        field.handleReactions(MessageAction.BEFORE_SWITCH);
        field.getSlot(user).switchOut(target);
        field.handleReactions(MessageAction.AFTER_SWITCH);
        return true;
    }

}
