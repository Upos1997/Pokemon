package action;

import java.util.function.Function;

import action.actionLogic.Action;
import action.actionLogic.MessageAction;
import field.Field;
import pokemon.Pokemon;

public class Reaction extends Action {
    public Reaction(Pokemon user, Object source, Pokemon target, Function<Field, Boolean> check,
            Function<Field, Boolean> action) {
        super(user, source, target);
        this.check = check;
        this.action = action;
    }

    MessageAction message;
    Function<Field, Boolean> check;
    Function<Field, Boolean> action;
    public static Function<Field, Boolean> noCheck = (field) -> {
        return true;
    };

    public MessageAction getMessage() {
        return message;
    }

    public Boolean check(Field field) {
        return check.apply(field);
    }

    @Override
    protected boolean action(Field field) {
        return action.apply(field);
    }
}
