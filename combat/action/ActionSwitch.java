package action;

import field.Field;
import pokemon.Pokemon;
import enums.MessageReaction;

public class ActionSwitch extends Action {
    ActionSwitch(Pokemon user, Pokemon target) {
        super(user, (field, action) -> {
            field.getSlot(user).switch_out(target);
            return null;
        });
        this.target = target;
    }

    Pokemon target;

    public void takeAction(Field field) {
        super.takeAction(field, (aField, action) -> {
            return aField.handleReactions(MessageReaction.BSWITCH, action);
        }, (aField, action) -> {
            return aField.handleReactions(MessageReaction.ASWITCH, action);
        });
    }

}
