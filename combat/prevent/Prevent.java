package prevent;

import java.util.function.BiFunction;

import action.Action;
import field.Field;

public abstract class Prevent {

    BiFunction<Field, Action, Boolean> check = (action) ->;
    BiFunction<Field, Prevent, Boolean> preventCheck = (field, prevent) -> {
        return false;
    };

    public boolean check(Field field, Action action) {
        return check.apply(field, action);
    }

    public boolean preventCheck(Field field, Prevent prevent) {
        return preventCheck.apply(field, prevent);
    }

}
