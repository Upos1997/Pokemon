package action;

import java.util.List;
import java.util.function.Function;

import field.Field;
import pokemon.Pokemon;

public abstract class Action {
    Action(Pokemon user, Function<Field, Void> action) {
        this.user = user;
        this.action = action;
    }

    protected Pokemon user;
    protected Function<Field, Void> action;
    private List<MessageAction> messages;
    public final static Function<Field, Void> noAction = (field) -> {
        return null;
    };

    public Pokemon getUser() {
        return this.user;
    }

    protected Void takeAction(Field field, Runnable beforeAction, Runnable afterAction) {
        if (field.isAllowed(this, messages)) {
            beforeAction.run();
            action.apply(field);
            afterAction.run();
        }
        return null;
    }
}
