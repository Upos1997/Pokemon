package combat.prevent;

import combat.field.Field;

import java.util.function.BiFunction;

public class PreventPrevent extends Prevent {
    PreventPrevent(BiFunction<Field, Prevent, Boolean> preventCheck) {
        super(MessagePrevent.PREVENT, (field) -> false);
        this.preventCheck = preventCheck;
    }

}
