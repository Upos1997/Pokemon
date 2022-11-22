package action;

import java.util.function.BiFunction;
import java.util.function.Function;

import field.Field;
import pokemon.Pokemon;

public class Reaction extends Action {
    public Reaction(Pokemon user, BiFunction<Field, Action, Boolean> check, BiFunction<Field, Action, Void> action) {
        super(user, action);
        this.check = check;
    }

    BiFunction<Field, Action, Boolean> check;
    static BiFunction<Field, Action, Boolean> noCheck = (field, action) -> {
        return true;
    };

    public Boolean check(Field field, Action action) {
        return check.apply(field, action);
    }

    public Void takeAction(Field field) {
        return super.takeAction(field, noAction, noAction);
    }

    public void makeSingleUse(Field field, MessageReaction message) {
        action = action.andThen((Function<Void, Void>) arg -> {
            field.removeReaction(message, this);
            return null;
        });
    }
}
