package prevent;

import java.util.function.BiFunction;

import field.Field;

public class PreventPrevent extends Prevent {
    PreventPrevent(BiFunction<Field, Prevent, Boolean> preventCheck) {
        super(MessagePrevent.PREVENT, (field) -> {
            return false;
        });
        this.preventCheck = preventCheck;
    }

}
