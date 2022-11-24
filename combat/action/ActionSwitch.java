package action;

import field.Field;
import pokemon.Pokemon;

public class ActionSwitch extends Action {
    ActionSwitch(Pokemon user, Pokemon target) {
        super(user);
        this.target = target;
    }

    Pokemon target;

    @Override
    Void action(Field field) {
        field.handleReactions(MessageAction.BEFORE_ATTACK);
        field.getSlot(user).switchOut(target);
        field.handleReactions(MessageAction.AFTER_ATTACK);
        return null;
    }

}
