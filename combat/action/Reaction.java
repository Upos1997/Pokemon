package action;

import java.util.function.Predicate;

import action.actionLogic.Action;
import action.actionLogic.MessageAction;
import field.Field;
import pokemon.Pokemon;

public class Reaction extends Action {
    public Reaction(MessageAction message, Pokemon user, Object source, Pokemon target, Predicate<Field> check,
            Predicate<Field> action) {
        super(user, source, target);
        this.check = check;
        this.action = action;
    }

    MessageAction message;
    Predicate<Field> check;
    Predicate<Field> action;
    public static Predicate<Field> noCheck = field -> true;

    public MessageAction getMessage() {
        return message;
    }

    public boolean check(Field field) {
        return check.test(field);
    }

    @Override
    protected boolean action(Field field) {
        return action.test(field);
    }
}
