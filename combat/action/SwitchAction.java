package action;

import java.util.List;

import action.actionLogic.Action;
import action.actionLogic.MessageAction;
import field.Field;
import moves.moveLogic.Move;
import pokemon.Pokemon;
import prevent.MessagePrevent;

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
