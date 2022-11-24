package action;

import java.util.function.BiFunction;
import java.util.function.Function;

import field.Field;
import pokemon.Pokemon;

public class Reaction extends Action {
    public Reaction(Pokemon user, Function<Field, Boolean> check, BiFunction<Field, Action, Void> action) {
        super(user);
        this.check = check;
        this.action = action;
    }

    MessageAction message;
    Function<Field, Boolean> check;
    static BiFunction<Field, Action, Boolean> noCheck = (field, action) -> {
        return true;
    };

    public MessageAction getMessage() {
        return message;
    }

    public Boolean check(Field field) {
        return check.apply(field);
    }

    public void makeSingleUse(Field field, MessageAction message) {
        action = action.andThen((Function<Void, Void>) arg -> {
            field.removeReaction(message, this);
            return null;
        });
    }

    @Override
    Void action(Field field) {
        action.apply(field);
    }
}
