package prevent;

import java.util.function.BiFunction;
import java.util.function.Function;

import field.Field;

public abstract class Prevent {
    Prevent(Function<Field, Boolean> check) {
        this.check = check;
    }

    Function<Field, Boolean> check;
    BiFunction<Field, Prevent, Boolean> preventCheck = (field, prevent) -> {
        return false;
    };

    public boolean check(Field field) {
        return check.apply(field);
    }

    public boolean preventCheck(Field field, Prevent prevent) {
        return preventCheck.apply(field, prevent);
    }

    public MessagePrevent getMessage() {
        return null;
    }

}
