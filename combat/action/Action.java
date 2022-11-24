package action;

import field.Field;
import pokemon.Pokemon;
import prevent.MessagePrevent;

public abstract class Action {
    Action(Pokemon user) {
        this.user = user;
    }

    protected Pokemon user;
    private MessagePrevent message;

    public Pokemon getUser() {
        return this.user;
    }

    public boolean hasUser(Pokemon pokemon) {
        return user == pokemon;
    }

    public Void takeAction(Field field) {
        if (field.isAllowed(this, message)) {
            action(field);
        }
        return null;
    }

    abstract Void action(Field field);
}
