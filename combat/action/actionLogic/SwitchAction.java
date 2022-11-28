package action.actionLogic;

import java.util.List;

import field.Field;
import moves.moveLogic.Move;
import pokemon.Pokemon;
import prevent.MessagePrevent;

public class SwitchAction extends MoveAction {
    SwitchAction(Pokemon user, Move move, Pokemon target) {
        super(user, move, target, List.of(MessagePrevent.SWITCH));
        this.target = target;
    }

    Pokemon target;

    @Override
    boolean action(Field field) {
        field.handleReactions(MessageAction.BEFORE_SWITCH);
        field.getSlot(user).switchOut(target);
        field.handleReactions(MessageAction.AFTER_SWITCH);
        return true;
    }

}
