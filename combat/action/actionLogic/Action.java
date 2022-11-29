package action.actionLogic;

import java.util.List;
import java.util.function.Predicate;

import field.Field;
import pokemon.Pokemon;
import prevent.MessagePrevent;

public abstract class Action {
    protected Action(Pokemon user, Object source, Pokemon target) {
        this.user = user;
        this.source = source;
        this.target = target;
    }

    protected Object source;
    protected Pokemon user;
    protected Pokemon target;
    protected List<MessagePrevent> messages;

    public Pokemon getUser() {
        return user;
    }

    public Object getSource() {
        return source;
    }

    public Pokemon getTarget() {
        return target;
    }

    protected boolean isAllowed(Field field) {
        Predicate<MessagePrevent> filter = message -> field.isAllowed(this, message);
        return !messages.stream().filter(filter).findAny().isPresent();
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

    abstract protected boolean action(Field field);
}
