package prevent;

import java.util.function.BiFunction;
import java.util.function.Predicate;

import field.Field;

public class Prevent {
    public Prevent(MessagePrevent message, Predicate<Field> check) {
        this.check = check;
        this.message = message;
    }

    MessagePrevent message;
    Predicate<Field> check;
    BiFunction<Field, Prevent, Boolean> preventCheck = (field, prevent) -> {
        return false;
    };

    public boolean check(Field field) {
        return check.test(field);
    }

    public boolean preventCheck(Field field, Prevent prevent) {
        return preventCheck.apply(field, prevent);
    }

    public MessagePrevent getMessage() {
        return null;
    }

}
