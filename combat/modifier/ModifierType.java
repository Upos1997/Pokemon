package modifier;

import java.util.function.Predicate;

import field.Field;
import pokemon.Type;

public class ModifierType extends Modifier {

    public ModifierType(MessageModifier message, Type modifier, Predicate<Field> check) {
        super(message, 1, check);
        this.modifier = modifier;
    }

    Type modifier;

    public Type getModifier() {
        return modifier;
    }

}
