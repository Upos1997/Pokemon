package action.actionLogic;

import java.util.List;
import java.util.function.Predicate;

import field.Field;
import pokemon.Pokemon;
import prevent.MessagePrevent;

public abstract class Action {
    Action(Pokemon user) {
        this.user = user;
    }

    protected Pokemon user;
    protected List<MessagePrevent> messages;

    public Pokemon getUser() {
        return this.user;
    }

    protected boolean isAllowed(Field field) {
        Predicate<MessagePrevent> filter = message -> {
            return field.isAllowed(this, message);
        };
        return messages.stream().filter(filter).findAny().isPresent();
    }

    public boolean hasUser(Pokemon pokemon) {
        return user.equals(pokemon);
    }

    public boolean takeAction(Field field) {
        if (isAllowed(field)) {
            return action(field);
        } else
            return false;
    }

    abstract boolean action(Field field);
}
