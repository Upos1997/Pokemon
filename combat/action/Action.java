package action;

import java.util.function.BiFunction;
import java.util.function.Function;

import field.Field;
import pokemon.Pokemon;

public abstract class Action {

    public Pokemon user;
    protected Function<Field, Void> action;
    public Pokemon target;
    public final static Function<Field, Void> noAction = (field) -> {
        return null;
    };

    public Void takeAction(Field field, BiFunction<Field, Action, Void> beforeAction,
            BiFunction<Field, Action, Void> afterAction) {
        if (field.isAllowed(this)) {
            beforeAction.apply(field, this);
            action.apply(field);
            afterAction.apply(field, this);
        }
        return null;
    }
}
