package modifier;

import java.util.function.Function;

import field.Field;

public class ModifierMove extends Modifier {

    public ModifierMove(MessageModifier message, double modifier, Function<Field, Boolean> check) {
        super(message, modifier);
        this.moveCheck = check;
    }
}
