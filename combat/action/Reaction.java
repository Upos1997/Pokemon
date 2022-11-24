package action;

import java.util.function.Function;

import field.Field;
import pokemon.Pokemon;

public class Reaction extends Action {
    public Reaction(Pokemon user, Function<Field, Boolean> check, Function<Field, Void> action) {
        super(user);
        this.check = check;
        this.action = action;
    }

    MessageAction message;
    Function<Field, Boolean> check;
    Function<Field, Void> action;

    public MessageAction getMessage() {
        return message;
    }

    public Boolean check(Field field) {
        return check.apply(field);
    }

    @Override
    Void action(Field field) {
        action.apply(field);
        return null;
    }
}
