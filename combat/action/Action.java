package action;

import java.util.List;
import java.util.function.Function;

import field.Field;
import pokemon.Pokemon;

public abstract class Action {
    Action(Pokemon user) {
        this.user = user;
    }

    protected Pokemon user;
    private List<MessageAction> messages;

    public Pokemon getUser() {
        return this.user;
    }

    protected Void takeAction(Field field) {
        if (field.isAllowed(this, messages)) {
            action(field);
        }
        return null;
    }

    abstract Void action(Field field);
}
