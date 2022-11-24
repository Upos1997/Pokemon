package modifier;

import java.util.function.BiFunction;

import field.Field;
import pokemon.Pokemon;

public class ModifierStat extends Modifier {

    public ModifierStat(MessageModifier message, Float modifier, BiFunction<Field, Pokemon, Boolean> check) {
        super(message, modifier);
        this.statCheck = check;
    }

}
